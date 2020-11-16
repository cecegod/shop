package mapper;

import org.apache.ibatis.annotations.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

public interface ISqlMapper<T> {

    @SelectProvider(type = SqlType.class,method = "getEntitySql")
    public List<T> getEntitiesbypages(@Param("param1") T entity, @Param("param2") Integer pagenow, @Param("param3") Integer pagesize);

    @SelectProvider(type = SqlType.class,method = "getEntitySql")
    public List<T> getEntities(@Param("param1") T entity);

    @SelectProvider(type = SqlType.class,method = "getEntitySql")
    public T getEntity(@Param("param1") T entity);

    @InsertProvider(type = SqlType.class,method = "addEntitySql")
    public Boolean addEntity(@Param("param2") T entity);

    @DeleteProvider(type = SqlType.class,method = "deleteEntitySql")
    public Boolean deleteEntity(@Param("param3") T entity);

    @UpdateProvider(type = SqlType.class,method = "updateEntitySql")
    /*
    param4 new entity
    param5 old entity
     */
    public Boolean updateEntity(@Param("param4") T entity, @Param("param5") T entity2);
    class SqlType{
        public String getEntitySql(Map map){
            String columns="";
            String where=" ";
            Object entity = map.get("param1");
            Class<?> entityClass = entity.getClass();
            String simpleName = entityClass.getSimpleName();
            Method[] declaredMethods = entityClass.getDeclaredMethods();

            for(Method method:declaredMethods){
                String name = method.getName();
                if(name.startsWith("get")){
                    Character c = name.charAt(3);
                    String column=c.toString().toLowerCase()+name.substring(4);
                    columns += column+",";
                    if(invokMethod(method,entity)!=null){
                        where +=column+"= #{param1."+column+"} and ";
                    }
                }
            }
            columns= columns.substring(0,columns.length()-1);
            String sql =   "select "+columns+" from "+simpleName;
            if(!where.equals(" ")){
                where =" where "+ where.substring(0,where.lastIndexOf("and"));
                sql +=where;
            }




            Object pagenow1 = map.getOrDefault("param2", null);
            Object pagesize1 = map.getOrDefault("param3", null);
            if(pagenow1!=null && pagesize1!=null) {
                Integer intpagenow = Integer.parseInt(pagenow1.toString());
                Integer intpagesize = Integer.parseInt(pagesize1.toString());
                Integer starindex = (intpagenow - 1)*intpagesize;
               sql+= " limit "+starindex+","+intpagesize;
            }
            return sql;


        }

        public String addEntitySql(Map map){
            String columns="";
            String values="";
            Object entity = map.get("param2");
            Class<?> aClass = entity.getClass();
            String simpleName = aClass.getSimpleName();
            Method[] declaredMethods = aClass.getDeclaredMethods();
            for(Method method:declaredMethods){
                String name = method.getName();
                if(name.startsWith("get")){
                    Character c = name.charAt(3);
                    String column=c.toString().toLowerCase()+name.substring(4);
                    String value="#{param2."+column+"},";
                    columns += column+",";
                    values += value;

                }
            }
            columns= columns.substring(0,columns.length()-1);
            values=values.substring(0,values.lastIndexOf(","));

            return " insert into "+simpleName+" ("+columns+") values("+values+")";
        }

        public String deleteEntitySql(Map map){
            String conditions="";
            Object entity = map.get("param3");
            Class<?> aClass = entity.getClass();
            String simpleName = aClass.getSimpleName();
            Method[] declaredMethods = aClass.getDeclaredMethods();
            for(Method method:declaredMethods){
                String name = method.getName();
                if(name.startsWith("get")){
                    Character c = name.charAt(3);
                    String column=c.toString().toLowerCase()+name.substring(4);
                    String value="#{param3."+column+"} and ";
                  String condition=column+"="+value;
                    if(invokMethod(method,entity)!=null){
                        conditions +=condition;
                    }

                }
            }
            conditions=conditions.substring(0,conditions.lastIndexOf("and"));
            return "delete from "+simpleName+" where "+conditions;
        }

        public String updateEntitySql(Map map){
            String cvs="";
            String conditions="";
            Object entity = map.get("param4");
            Object entity2 = map.get("param5");
            Class<?> aClass = entity.getClass();
            String simpleName = aClass.getSimpleName();
            Method[] declaredMethods = aClass.getDeclaredMethods();
            for(Method method:declaredMethods){
                String name = method.getName();
                if(name.startsWith("get")){
                    Character c = name.charAt(3);
                    String column=c.toString().toLowerCase()+name.substring(4);
                    String value1="#{param4."+column+"},";
                    String cv=column+"="+value1;

                    String value2="#{param5."+column+"} and ";
                    String condition=column+"="+value2;
                    if(invokMethod(method,entity)!=null){
                        cvs +=cv;

                    }
                    if(invokMethod(method,entity2)!=null){
                        conditions += condition;

                    }
                }
            }
            cvs=cvs.substring(0,cvs.lastIndexOf(","));
            conditions=conditions.substring(0,conditions.lastIndexOf("and"));
            return "update "+simpleName+" set "+cvs+"  where "+conditions;
        }
        public Object invokMethod(Method method,Object entity) {
            Object invoke=null;
            try {
                invoke = method.invoke(entity);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            return  invoke;

        }
    }



}
