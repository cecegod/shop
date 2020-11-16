package com.controller;

import com.po.Category;
import com.service.CategoryService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class CategoryController {
    @Resource
    CategoryService categoryService;

    @RequestMapping("/getCategoryByparent")
    public List<Category> getCategoryByparent(){
        List<Category> categories=categoryService.getCategoryByparent();
        return categories;
    }
    @RequestMapping("/getCategoryBychild")
    public List<Category> getCategoryBychild(Integer parentid){
//        List<Integer> ids=new ArrayList<>( );
//        List<Category> categories =categoryService.getEntities(parentid,ids);
        List<Category> categories=categoryService.getCategoryBychild(parentid);
        return categories;
    }
}
