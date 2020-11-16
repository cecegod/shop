package com.mapper;

import com.po.Tb_permission;
import mapper.ISqlMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PermissionMapper extends ISqlMapper<Tb_permission> {
    @Select("select id,name,ename,url,created,updated from tb_permission where parent_id is null")
    List<Tb_permission> getPermissionByparent();

    @Select("select id,name,ename,url,created,updated from tb_permission where parentid =#{parentid}")
    List<Tb_permission> getPermissionBychild(Integer parentid);
}
