package com.controller;

import com.po.Address;
import com.service.AddressService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class AddressController {
    @Resource
    AddressService addressService;

    @RequestMapping("/getAddress")
    public Map getAddress(Integer userid){
      List<Address> addresses= addressService.getAddress(userid);
        Map map=new HashMap();
        map.put("status",200);
        map.put("addresses",addresses);
        return map;
    }

    @RequestMapping("/getAdd")
    public Address getAdd(Integer addressid){
        Address add = addressService.getAdd(addressid);
        return add;
    }
}
