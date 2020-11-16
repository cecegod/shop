package com.controller;

import com.service.OrderTableDetailService;
import com.service.OrderTableService;
import com.service.TotalService;
import com.to.OrderTo;
import com.to.OrderdetailDTO;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class OoderTableContrller {
    @Resource
    OrderTableService orderTableService;
    @Resource
    OrderTableDetailService orderTableDetailService;
    @Resource
    TotalService totalService;

    @RequestMapping("/addOrder")
    public Map addOrder(Integer userid, String selectIds, String numbers, Integer addressId, Float totalPrice){
//        String  ordernumber=orderTableService.addOrder(userid,selectIds,numbers,addressId,totalPrice);
//       Boolean b= orderTableDetailService.addOrder(userid,selectIds,numbers,addressId,totalPrice,ordernumber);
        Boolean b = totalService.addOrder(userid, selectIds, numbers, addressId, totalPrice);
        Map map=new HashMap();
       map.put("b",b);
       map.put("status",200);
        return map;
    }

    @RequestMapping("/getordertables")
    public Map getordertables(Integer userid){
        List<OrderTo> list=orderTableService.getordertables(userid);
        Map map=new HashMap();
        map.put("ordertables",list);
        map.put("status",200);
        return map;
    }

    @RequestMapping("/getordertabledetails")
    public  Map getordertabledetails(Integer userid,String ordernumber){
        List<OrderdetailDTO> list=orderTableDetailService.getorders(userid,ordernumber);
        Map map=new HashMap();
        map.put("ordertabledails",list);
        map.put("status",200);
        return map;
    }
}
