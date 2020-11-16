package com.service;

import com.mapper.Role_MenuMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class Role_MenuService {
    @Resource
    Role_MenuMapper rmm;
}
