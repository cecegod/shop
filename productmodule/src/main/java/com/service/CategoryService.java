package com.service;

import com.mapper.CategoryMapper;
import com.mapper.ProductMapper;
import com.po.Category;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {
    @Resource
    ProductMapper productMapper;


    @Resource
    CategoryMapper categoryMapper;





    public List<Category> getCategoryByparent() {
        return categoryMapper.getCategoryByparent();

    }

    public List<Category> getCategoryBychild(Integer parentid) {
        return categoryMapper.getCategoryBychild(parentid);
    }



    public void getEntities(Integer parentid,List<Integer> ids) {
        Category category=new Category();
        category.setParentid(parentid);
        List<Category> childs = categoryMapper.getEntities(category);
        if(childs.size()>0){
            for(Category child:childs){
                Integer id = child.getId();
                getEntities(id,ids);
            }
        }
        else {
        ids.add(parentid);

            }

        }




}
