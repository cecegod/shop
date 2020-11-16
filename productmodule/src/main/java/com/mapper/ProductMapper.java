package com.mapper;

import com.po.Product;
import mapper.ISqlMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ProductMapper extends ISqlMapper<Product> {
    @Select("select count(id) from product")
    public Integer getRows();

    @Select("select count(id) from product where categoryid = #{categoryid}")
    public Integer getRowsBy(Integer categoryid);

    @Select("select id,productname,categoryid,price,productphotoname from product where categoryid in (${leafid}) limit #{star},#{pagesize} ")
    List<Product> getEntitiesbyleft(@Param("leafid") String leafid, @Param("star")Integer star, @Param("pagesize")Integer pagesize);


    @Select("select count(id) from product where categoryid in (${leafid})")
    public Integer getRowsByleaf(@Param("leafid") String leafid);
}

