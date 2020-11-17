package com.service;

import com.mapper.Usermapper;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService implements UserDetailsService {
    @Resource
    private BCryptPasswordEncoder passwordEncoder ;
    @Resource
    Usermapper usermapper;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.po.User user1 = new com.po.User();
        user1.setUsername(username);
        com.po.User entity = usermapper.getEntity(user1);
        if(entity!=null){
            String password = entity.getPassword();
            //通过username到真实数据库里面查询此用户
            User user =  new User(username, passwordEncoder.encode(password),
                    AuthorityUtils.commaSeparatedStringToAuthorityList("name1,name2,name3"));
            return user;
        }

        return null;
    }
}
