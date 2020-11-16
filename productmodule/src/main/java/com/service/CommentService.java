package com.service;

import com.mapper.CommentMapper;
import com.po.Comment;
import com.po.User;
import com.to.CommentTo;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class CommentService {
    @Resource
    CommentMapper commentMapper;

    public List<CommentTo> loadCommentByProduct(Integer id) {
        List<CommentTo> list=new ArrayList<>();
        List<Comment> entities = commentMapper.getEntities(new Comment(null, id, null, null));
        for(Comment comment:entities){
            Integer userid = comment.getUserid();

            RestTemplate  restTemplate=new RestTemplate();
            User user = restTemplate.getForObject("http://localhost:8080/getUser?id=" + userid, User.class);
            CommentTo commentTo=new CommentTo();
            commentTo.setUsername(user.getUsername());
            commentTo.setPhotoname(user.getPhotoname());
            commentTo.setComment(comment.getContent());
            list.add(commentTo);

        }
        return list;
    }
}
