package com.service;

import com.mapper.ShopCarMapper;
import com.po.Product;
import com.po.Shopcar;
import com.to.ShopCarTo;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class ShopCarService {
    @Resource
    ShopCarMapper shopCarMapper;

    public  Boolean deleteshopcar(Integer shopcarids) {
            Shopcar shopcar = new Shopcar();
            shopcar.setId(shopcarids);
             Boolean b = shopCarMapper.deleteEntity(shopcar);

        return b;
    }

    public Boolean add(Shopcar shopcar) {

        Shopcar entity = shopCarMapper.getEntity(new Shopcar(null,shopcar.getProductid(),null,shopcar.getUserid()));
        if(entity!=null){
           Integer newNumbere= shopcar.getNumber()+entity.getNumber();
            Shopcar shopcar1 = new Shopcar();
            shopcar1.setId(entity.getId());
            shopcar1.setUserid(entity.getUserid());
            shopcar1.setProductid(entity.getProductid());
            shopcar1.setNumber(newNumbere);
            Boolean aBoolean = shopCarMapper.updateEntity(shopcar1, entity);
            return aBoolean;
        }
        else {
            return shopCarMapper.addEntity(shopcar);
        }
    }

    public List<ShopCarTo> getShopCars(Integer userid) {
        List<ShopCarTo> shopCarTos=new ArrayList<>();
        List<Shopcar> shopcars = shopCarMapper.getEntities(new Shopcar(null, null, null, userid));

        for(Shopcar shopCar:shopcars){
            RestTemplate restTemplate = new RestTemplate();
            Product product = restTemplate.getForObject("http://localhost:8081/getProduct?id=" + shopCar.getProductid(), Product.class);
            ShopCarTo shopCarTo=new  ShopCarTo();
            shopCarTo.setId(shopCar.getId());
            shopCarTo.setNumber(shopCar.getNumber());
            shopCarTo.setProductname(product.getProductname());
            shopCarTo.setProductphotoname(product.getProductphotoname());
            shopCarTo.setPrice(product.getPrice());
            shopCarTo.setStock(product.getStock());
            shopCarTos.add(shopCarTo);
        }

        return  shopCarTos;
    }

    public Integer getProductidByshopcar(Integer shopcarid) {
        Shopcar entity = shopCarMapper.getEntity(new Shopcar(shopcarid, null, null, null));
        return entity.getProductid();
    }
}
