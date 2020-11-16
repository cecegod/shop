package com.controller;

import com.po.Product;
import com.po.Story;
import com.service.StoryService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
public class StroyController {
    @Resource
    StoryService stroyService;

    @RequestMapping("/getStroy")
    public Map getStroy(Integer userid){
        Map map=new HashMap();
        Story story=stroyService.getStroy(userid);
        map.put("story",story);
        map.put("status",200);
        return map;
    }

    @RequestMapping("/getStoryProducts")
    public Map getStoryProducts(Integer userid,Integer pageNow){
     Map map= stroyService.getStoryProducts(userid,pageNow);
        return map;
    }



    @RequestMapping("/addProduct")
    public Boolean addProduct(@RequestParam("file") MultipartFile file, Integer userid, String productname, Float price, Integer stock, Integer categoryid, HttpServletRequest request){
        Product product = new Product();
        product.setCategoryid(categoryid);
        product.setPrice(price);
        product.setProductname(productname);
        product.setStock(stock);
        product.setUserid(userid);
        Boolean b=  stroyService.addproduct(product,file,request);
      return b;
    }
    @RequestMapping("/deleteProduct")
    public Boolean deleeteProduct(Integer productid){
        Boolean b=  stroyService.deleeteProduct(productid);
        return b;
    }
    @RequestMapping("/getStoryProduct")
    public Product getStoryProduct(Integer productid){
        Product product = stroyService.getStoryProduct(productid);
        return product;
    }
    @RequestMapping("/updateStoryProduct")
    public Boolean updateStoryProduct(Product product){
        Boolean b=  stroyService.updateStoryProduct(product);
        return b;
    }
}
