package com.service;

import com.mapper.CategoryMapper;
import com.mapper.ProductMapper;
import com.po.Category;
import com.po.Product;
import com.to.ProductTo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Resource
    ProductMapper productMapper;
    @Resource
    CategoryMapper categoryMapper;
    @Resource
    CategoryService categoryService;

    public List<ProductTo> getProductTos(Product product) {
        List<ProductTo> productTos = new ArrayList<>();
        List<Product> entities = productMapper.getEntities(product);
        for (Product p : entities) {
            ProductTo productTo = new ProductTo();
            Category category = new Category();
            category.setId(p.getCategoryid());
            Category categoryMapperEntity = categoryMapper.getEntity(category);
            productTo.setId(p.getId());
            productTo.setProductname(p.getProductphotoname());
            productTo.setCategoryname(categoryMapperEntity.getCategoryname());
            productTo.setProductphotoname(p.getProductphotoname());
            productTo.setPrice(p.getPrice());
            productTos.add(productTo);
        }
        return productTos;
    }

    public List<ProductTo> getProductTosBy(Integer categoryid,Integer pageNow,int[] pagecount) {
        List<ProductTo> productTos = new ArrayList<>();
        final Integer pagesize = 4;
        Category category = new Category();
        category.setId(categoryid);
        Category entity = categoryMapper.getEntity(category);

        Integer id = entity.getId();
        List<Product> entities = productMapper.getEntitiesbypages(new Product(null, null, id, null, null, null,null),pageNow,pagesize);
        for (Product p : entities) {
            ProductTo pto = new ProductTo();
            pto.setId(p.getId());
            pto.setPrice(p.getPrice());
            pto.setStock(p.getStock());
            pto.setProductphotoname(p.getProductphotoname());
            pto.setProductname(p.getProductname());
            pto.setCategoryname(entity.getCategoryname());
            productTos.add(pto);

        }
        Integer rows = productMapper.getRowsBy(categoryid);
        if(rows%pagesize==0){
            pagecount[0] = rows/pagesize;
        }else {
            pagecount[0] = rows/pagesize + 1;
        }
        return productTos;
    }
    public List<ProductTo> getProductTosPages(Product product,Integer pagenow, int[] pagecount) {
        List<ProductTo> productTos=new ArrayList<>();
        final Integer pagesize = 4;
        List<Product> products = productMapper.getEntitiesbypages(product, pagenow, pagesize);
        for (Product p : products) {
            ProductTo productTo = new ProductTo();
            Category category = new Category();
            category.setId(p.getCategoryid());
            Category categoryMapperEntity = categoryMapper.getEntity(category);
            productTo.setId(p.getId());
            productTo.setProductname(p.getProductname());
            productTo.setCategoryname(categoryMapperEntity.getCategoryname());
            productTo.setProductphotoname(p.getProductphotoname());
            productTo.setPrice(p.getPrice());
            productTo.setStock(p.getStock());
            productTos.add(productTo);
        }
        Integer rows = productMapper.getRows();
        if(rows%pagesize==0){
            pagecount[0] = rows/pagesize;
        }else {
            pagecount[0] = rows/pagesize + 1;
        }
        return productTos;


    }

    public List<ProductTo> getProductTosByleaf(Integer categoryid, Integer pageNow, int[] pagecount) {
        List<ProductTo> productTos = new ArrayList<>();
        final Integer pagesize = 4;
        String leafid="";
        List<Integer> ids=new ArrayList<>();
        categoryService.getEntities(categoryid,ids);
        for (Integer id:ids){
            leafid += id+",";
        }
        leafid = leafid.substring(0,leafid.lastIndexOf(","));
        Integer star=(pageNow-1)*pagesize;

        List<Product> products = productMapper.getEntitiesbyleft(leafid,star,pagesize);
        for (Product p : products) {
            ProductTo pto = new ProductTo();
            pto.setId(p.getId());
            pto.setPrice(p.getPrice());
            pto.setProductphotoname(p.getProductphotoname());
            pto.setProductname(p.getProductname());

            Category category = new Category();
            category.setId(p.getCategoryid());
            Category categoryMapperEntity = categoryMapper.getEntity(category);
            pto.setCategoryname(categoryMapperEntity.getCategoryname());
            productTos.add(pto);

        }
        Integer rows = productMapper.getRowsByleaf(leafid);
        if(rows%pagesize==0){
            pagecount[0] = rows/pagesize;
        }else {
            pagecount[0] = rows/pagesize + 1;
        }
        return  productTos;
    }

    public ProductTo getProducto(Integer id) {
        ProductTo productto = new ProductTo();
        Product entity = productMapper.getEntity(new Product(id, null, null, null, null, null,null
        ));
        productto.setId(entity.getId());
        productto.setProductname(entity.getProductname());
        productto.setProductphotoname(entity.getProductphotoname());
        productto.setPrice(entity.getPrice());
        productto.setStock(entity.getStock());

        Category category = categoryMapper.getEntity(new Category(entity.getCategoryid(), null, null));
        productto.setCategoryname(category.getCategoryname());

        return  productto;
    }


    public Product getProduct(Integer id) {

        Product entity = productMapper.getEntity(new Product(id, null, null, null, null, null,null
        ));
        return entity;
    }

    public List<ProductTo> getStoryProducts(Integer userid,Integer pagenow, int[] pagecount) {
        List<ProductTo> productTos=new ArrayList<>();
        final Integer pagesize = 4;
        List<Product> products = productMapper.getEntitiesbypages(new Product(null,null,null,null,userid,null,null), pagenow, pagesize);
        for (Product p : products) {
            ProductTo productTo = new ProductTo();
            productTo.setId(p.getId());
            productTo.setProductname(p.getProductname());
            productTo.setProductphotoname(p.getProductphotoname());
            productTo.setPrice(p.getPrice());
            productTo.setStock(p.getStock());
            productTos.add(productTo);
        }
        Integer rows = productMapper.getRows();
        if(rows%pagesize==0){
            pagecount[0] = rows/pagesize;
        }else {
            pagecount[0] = rows/pagesize + 1;
        }
        return productTos;
    }
}