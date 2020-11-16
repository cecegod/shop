package com.service;

import com.mapper.CategoryMapper;
import com.mapper.FollowMapper;
import com.mapper.ProductMapper;
import com.po.Category;
import com.po.Follow;
import com.po.Product;
import com.to.ProductTo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class FollowService {
    @Resource
    FollowMapper followMapper;
    @Resource
    ProductMapper productMapper;
    @Resource
    CategoryMapper categoryMapper;

    public Boolean isfolllow(Integer id, Integer userId) {
        Follow follow = new Follow();
        follow.setProductid(id);
        follow.setUserid(userId);
        Follow entity = followMapper.getEntity(follow);
       return (entity!=null);


    }

    public Boolean add(Integer id, Integer userId) {
        Follow follow = new Follow();
        follow.setProductid(id);
        follow.setUserid(userId);
        Boolean aBoolean = followMapper.addEntity(follow);
        return aBoolean;

    }


    public Boolean delete(Integer id, Integer userId) {
        Follow follow = new Follow();
        follow.setProductid(id);
        follow.setUserid(userId);
        Boolean aBoolean = followMapper.deleteEntity(follow);

        return aBoolean;

    }

    public List<ProductTo> collectProduct(Integer id) {
        List<ProductTo> productTos=new ArrayList<>();
        Integer pagesize=4;
        List<Follow> follows = followMapper.getEntities(new Follow(null, id, null));
        for(Follow follow:follows){
            ProductTo productTo = new ProductTo();
            Integer productid = follow.getProductid();
            Product product= productMapper.getEntity(new Product(productid, null, null, null, null, null,null));

                ProductTo pto = new ProductTo();
                pto.setId(product.getId());
                pto.setPrice(product.getPrice());
                pto.setProductphotoname(product.getProductphotoname());
                pto.setProductname(product.getProductname());
                pto.setStock(product.getStock());
                Category category = categoryMapper.getEntity(new Category(product.getCategoryid(),null,null));
                pto.setCategoryname(category.getCategoryname());
                productTos.add(pto);



        }
        return productTos;

    }
}
