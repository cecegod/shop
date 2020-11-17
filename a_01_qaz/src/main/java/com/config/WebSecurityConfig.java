package com.config;

import com.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


import javax.annotation.Resource;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)


public class WebSecurityConfig  extends WebSecurityConfigurerAdapter {
    //如果是内存用户就用这个 否则直接把它去掉直接换成自己编写的就可以了
//    @Override
//    @Bean
//    public UserDetailsService userDetailsServiceBean() {
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//        manager.createUser(User.withUsername("name1").password(passwordEncoder().encode("123456")).authorities("name1").build());
//        manager.createUser(User.withUsername("name2").password(passwordEncoder().encode("123456")).authorities("name2").build());
//        manager.createUser(User.withUsername("name3").password(passwordEncoder().encode("123456")).authorities("name1","name2","name3").build());
//        return manager;
//    }
    @Resource
    UserService userService;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        // 将 check_token 暴露出去，否则资源服务器访问时报 403 错误
        web.ignoring().antMatchers("/oauth/check_token");
    }


//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//
//        http.formLogin()
//                // 定义当需要用户登录时候，转到的登录页面。
//                .loginPage("/login.html")
//                // 自定义登录页面必须有这一项否则会登录失败，这个地址是框架提供好的 这里就这么写就可以了
//                .loginProcessingUrl("/login")
//                // 这个是登录成功时候的地址，必须是controller地址不能是页面地址否则会报405错误如果不写这个会跳到初始拦截时候的页面
////                .successForwardUrl("/success")
//                //登录失败的页面 必须是controller地址不能是页面地址否则会报405错误 如果不写会跳到登录页面再去登录
//                .failureForwardUrl("/failure")
//                .and()
//                // 定义哪些URL需要被保护、哪些不需要被保护
//                .authorizeRequests()
//
//                .antMatchers("/name1/**").hasAuthority("name1")
//                .antMatchers("/name2/**").hasAuthority("name2")
//
//                .antMatchers("/name3/**").hasAuthority("name3")
//                .antMatchers("/name4/**").hasAuthority("name4")
//            .and().csrf().disable();//自定义页面一定要关闭csrf，否则会导致登录不成功
//    }

}

