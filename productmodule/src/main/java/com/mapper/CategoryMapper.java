package com.mapper;

import com.po.Category;
import mapper.ISqlMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CategoryMapper extends ISqlMapper<Category> {
    @Select("select id,categoryname from category where parentid is null")
    List<Category> getCategoryByparent();

    @Select("select id,categoryname from category where parentid =#{parentid}")
    List<Category> getCategoryBychild(Integer parentid);
}

