package com.controller;

import com.mapper.ShopCarMapper;
import com.po.Shopcar;
import com.service.ShopCarService;
import com.sun.org.apache.bcel.internal.generic.PUSH;
import com.sun.org.apache.bcel.internal.generic.RET;
import com.to.ShopCarTo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class ShopCarController {

    @Resource
    ShopCarService shopCarService;

    @RequestMapping("/getShopCars")
    public Map getShopCars(Integer userid){
        Map map=new HashMap();

        List<ShopCarTo>  shopCarTos= shopCarService.getShopCars(userid);
        map.put("status",200);
        map.put("shopCarTos",shopCarTos);
        return  map;
    }

    @RequestMapping("/addShopCar")
    public Boolean addShopCar(Integer id,Integer userid,Integer number){
        Shopcar shopcar = new Shopcar();
        shopcar.setNumber(number);
        shopcar.setProductid(id);
        shopcar.setUserid(userid);
        Boolean b=shopCarService.add(shopcar);
        return b;
    }

    @RequestMapping("/getProductidByshopcar")
    public Integer getProductidByshopcar(Integer shopcarid){

        return shopCarService.getProductidByshopcar(shopcarid);
    }

    @RequestMapping("/deleteshopcar")
    public Boolean deleteshopcar( Integer shopcarid){
        return shopCarService.deleteshopcar(shopcarid);
    }

}
