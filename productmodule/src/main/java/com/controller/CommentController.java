package com.controller;

import com.service.CommentService;
import com.to.CommentTo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class CommentController {
    @Resource
    CommentService commentService;

    @RequestMapping("/loadCommentByProduct")
    public Map loadCommentByProduct(Integer id){
        List<CommentTo> commentTos=commentService.loadCommentByProduct(id);
        Map map=new HashMap();
        map.put("commentTos",commentTos);
        map.put("status",200);
        return map;
    }

}
