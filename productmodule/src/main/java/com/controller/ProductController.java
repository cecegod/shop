package com.controller;

import com.po.Product;
import com.service.ProductService;
import com.to.ProductTo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class ProductController {
    @Resource
    ProductService productService;

    @RequestMapping("/getProductTos")
    public List<ProductTo> getProductTos(){
        Product product = new Product();

        List<ProductTo> productTos= productService.getProductTos(product);
        return productTos;
    }
    @RequestMapping("/getProductTosBy")
    public Map getProductTosBy(Integer  categoryid,Integer pageNow) {
        int[] pagecount= new int[1];
        Map map=new HashMap();
        List<ProductTo> productTos = productService.getProductTosBy(categoryid,pageNow,pagecount);
        map.put("productTos",productTos);
        map.put("pagecount",pagecount[0]);
        map.put("status",200);
        return map;
    }

    @RequestMapping("/getProductTosPages")
    public Map getProductTosPages(Integer pageNow){
        int[] it= new int[1];
        Product product = new Product();
        List<ProductTo> productTos=productService.getProductTosPages(product,pageNow,it);
        Map map=new HashMap();
        map.put("productTos",productTos);
        map.put("pagecount",it[0]);
        map.put("status",200);
            return map;

    }
    @RequestMapping("/getProductTosByleaf")
    public Map getProductTosByleaf(Integer categoryid,Integer pageNow){
        int[] pagecount= new int[1];
        Map map=new HashMap();
        List<ProductTo> productTos = productService.getProductTosByleaf(categoryid,pageNow,pagecount);
        map.put("productTos",productTos);
        map.put("pagecount",pagecount[0]);
        map.put("status",200);
        return map;

    }
    @RequestMapping("/getProducto")
    public ProductTo getProducto(Integer id){
        ProductTo producto=productService.getProducto(id);
        return producto;
    }

    @RequestMapping("/getProduct")
    public Product getProduct(Integer id){
        Product product = productService.getProduct(id);
        return product;
    }

    @RequestMapping("/getStoryProducts")
    public Map getStoryProducts(Integer userid,Integer pageNow) {
        int[] it= new int[1];
        List<ProductTo> productTos=productService.getStoryProducts(userid,pageNow,it);
        Map map=new HashMap();
        map.put("productTos",productTos);
        map.put("pagecount",it[0]);
        map.put("status",200);
        return map;
    }
}
