package com.service;

import com.mapper.OrderTableDetailMapper;
import com.mapper.OrderTableMapper;
import com.po.Ordertable;
import com.po.Ordertabledetail;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class TotalService {
    @Resource
    OrderTableMapper orderTableMapper;
    @Resource
    OrderTableDetailMapper orderTableDetailMapper;

    public Boolean  addOrder(Integer userid,String selectIds, String numbers,Integer addressId,Float totalprice) {
        //添加ordertable
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

    //添加ordertabledetail
        Ordertable entity = orderTableMapper.getEntity(new Ordertable(orderid, null, null, null, null));
        String[] shopcarids = selectIds.split(",");
        String[] snumber = numbers.split(",");


        Boolean b=null;

        long time2 = date.getTime();

        for(int i=0;i<shopcarids.length;i++){
            int shopcarid = Integer.parseInt(shopcarids[i]);
            int delnumber = Integer.parseInt(snumber[i]);
            String detailid=i+"_"+time2;

            RestTemplate restTemplate1 = new RestTemplate();
            Integer productid= restTemplate1.getForObject("http://localhost:8080/getProductidByshopcar?shopcarid=" + shopcarid, Integer.class);

            Ordertabledetail ordertabledetail = new Ordertabledetail();
            ordertabledetail.setId(detailid);
            ordertabledetail.setNumber(delnumber);
            ordertabledetail.setProductid(productid);
            ordertabledetail.setUserid(userid);
            ordertabledetail.setTime(entity.getOrdertime());
            ordertabledetail.setStatus(entity.getStatus());
            ordertabledetail.setOrdernumber(orderid);
            b= orderTableDetailMapper.addEntity(ordertabledetail);

            RestTemplate restTemplate2 = new RestTemplate();
            Boolean b2 = restTemplate2.getForObject("http://localhost:8080/deleteshopcar?shopcarid=" + shopcarid, Boolean.class);
        }


        return b;
    }
}
