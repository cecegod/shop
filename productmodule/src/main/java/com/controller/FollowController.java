package com.controller;

import com.service.FollowService;
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
public class FollowController {

    @Resource
    FollowService followService;

    @RequestMapping("/isfollow")
    public Boolean isfollow(Integer id,Integer userId){
        return followService.isfolllow(id,userId);

    }

    @RequestMapping("/add")
    public Map add(Integer id,Integer userId) {
        Map map = new HashMap();
        Boolean add = followService.add(id, userId);
        if (add) {
            map.put("status", 200);
        } else {
            map.put("status", 500);
        }
        return map;
    }

    @RequestMapping("/delete")
    public Map delete(Integer id,Integer userId){
        Map map=new HashMap();
        Boolean del=followService.delete(id,userId );
        if (del) {
            map.put("status", 200);
        } else {
            map.put("status", 500);
        }
        return map;
    }

    @RequestMapping("/collectProduct")
    public Map collectProduct(Integer userid){
        int[] pagecount= new int[1];
        Map map=new HashMap();
        List<ProductTo> productTos = followService.collectProduct(userid);
        map.put("productTos",productTos);
        map.put("pagecount",pagecount[0]);
        map.put("status",200);
        return map;
    }
}
