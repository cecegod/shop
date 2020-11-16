package com.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

public interface UserMapper {
    @Select("select * from emp where empno= 1")
    public Map getMap() ;

    @Insert("insert into emp values(4,'qka')")
    public void add();
}
