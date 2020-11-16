package com.service;

import com.mapper.OrderTableDetailMapper;
import com.mapper.OrderTableMapper;
import com.po.Address;
import com.po.Ordertable;
import com.po.Ordertabledetail;
import com.po.Product;
import com.to.OrderdetailDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrderTableDetailService {
    @Resource
    OrderTableDetailMapper orderTableDetailMapper;
    @Resource
    OrderTableMapper orderTableMapper;

    public Boolean addOrder(Integer userid, String selectIds, String numbers, Integer addressId, Float totalPrice, String ordernumber) {
        Ordertable entity = orderTableMapper.getEntity(new Ordertable(ordernumber, null, null, null, null));
        String[] shopcarids= selectIds.split(",");
        String[] snumber = numbers.split(",");


        Boolean b=null;
        Date date=new Date();
        long time = date.getTime();

        for(int i=0;i<shopcarids.length;i++){
            int shopcarid = Integer.parseInt(shopcarids[i]);
            int number = Integer.parseInt(snumber[i]);
            String id=i+"_"+time;

            RestTemplate restTemplate = new RestTemplate();
            Integer productid= restTemplate.getForObject("http://localhost:8080/getProductidByshopcar?shopcarid=" + shopcarid, Integer.class);

            Ordertabledetail ordertabledetail = new Ordertabledetail();
            ordertabledetail.setId(id);
            ordertabledetail.setNumber(number);
            ordertabledetail.setProductid(productid);
            ordertabledetail.setUserid(userid);
            ordertabledetail.setTime(entity.getOrdertime());
            ordertabledetail.setStatus(entity.getStatus());
            ordertabledetail.setOrdernumber(ordernumber);
             b= orderTableDetailMapper.addEntity(ordertabledetail);
        }

        return b ;
    }

    public List<OrderdetailDTO> getorders(Integer userid,String ordernumber) {
        List<OrderdetailDTO> list=new ArrayList<>();

        Ordertabledetail ordertabledetail = new Ordertabledetail();
        ordertabledetail.setUserid(userid);
        ordertabledetail.setOrdernumber(ordernumber);
        List<Ordertabledetail> entities = orderTableDetailMapper.getEntities(ordertabledetail);

        for(Ordertabledetail entity:entities){
            OrderdetailDTO orderDTO = new OrderdetailDTO();

            orderDTO.setId(entity.getId());
            orderDTO.setUserid(userid);
            orderDTO.setTime(entity.getTime());
            orderDTO.setNumber(entity.getNumber());

            RestTemplate restTemplate=new RestTemplate();
            Product product = restTemplate.getForObject("http://localhost:8081/getProduct?id=" + entity.getProductid(), Product.class);
            orderDTO.setProductname(product.getProductname());
            orderDTO.setProductphotoname(product.getProductphotoname());
            orderDTO.setTotalprice(product.getPrice());

            Ordertable ordertable = orderTableMapper.getEntity(new Ordertable(entity.getOrdernumber(), null, null, null, null));
            Integer addressid = ordertable.getAddressid();

            Address forObject = restTemplate.getForObject("http://localhost:8080/getAdd?addressid=" + addressid, Address.class);
            orderDTO.setAddress(forObject.getAddress());
            list.add(orderDTO);

        }

        return list;
    }
}
