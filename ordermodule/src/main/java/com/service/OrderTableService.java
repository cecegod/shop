package com.service;

import com.mapper.OrderTableDetailMapper;
import com.mapper.OrderTableMapper;
import com.po.Address;
import com.po.Ordertable;
import com.po.Ordertabledetail;
import com.to.OrderTo;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class OrderTableService {
    @Resource
    OrderTableMapper orderTableMapper;
    @Resource
    OrderTableDetailMapper orderTableDetailMapper;

    public String  addOrder(Integer userid,String selectIds, String numbers,Integer addressId,Float totalprice) {
        Integer number=0;
        String[] ns = numbers.split(",");
        for(String snu:ns){
            int inu = Integer.parseInt(snu);
            number += inu;
        }
        Date date=new Date();
        long time = date.getTime();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = df.format(time);
        long id=date.getTime();
        String orderid=userid+"_"+id;

        Ordertable ordertable = new Ordertable();
        ordertable.setAddressid(addressId);
        ordertable.setTotalprice(totalprice);
        ordertable.setOrdernumber(orderid);
        ordertable.setOrdertime(format);
        ordertable.setStatus("未发货");
        orderTableMapper.addEntity(ordertable);


        return orderid;
    }

    public List<OrderTo> getordertables(Integer userid) {
        List<OrderTo> list=new ArrayList<>();
        List<Ordertabledetail> entities = orderTableDetailMapper.getEntities(new Ordertabledetail(null, null, null, userid, null, null, null));
        List<String> getordernumber = orderTableMapper.getordernumber(userid);
        for(String set:getordernumber){
            OrderTo orderTo = new OrderTo();

            Ordertable ordertable = orderTableMapper.getEntity(new Ordertable(set, null, null, null, null));
            Integer addressid = ordertable.getAddressid();
            RestTemplate restTemplate=new RestTemplate();
            Address add = restTemplate.getForObject("http://localhost:8080/getAdd?addressid="+addressid, Address.class);

           orderTo.setOrdernumber(ordertable.getOrdernumber());
           orderTo.setOrdertime(ordertable.getOrdertime());
           orderTo.setTotalprice(ordertable.getTotalprice());
           orderTo.setStatus(ordertable.getStatus());
            Integer Onumber = orderTableDetailMapper.getnumber(ordertable.getOrdernumber());
            orderTo.setNumber(Onumber);
            orderTo.setAdress(add.getAddress());
            
            
            list.add(orderTo);

        }
            return list;
    }
}
