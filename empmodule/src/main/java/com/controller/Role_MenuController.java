package com.controller;

import com.service.Role_MenuService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@CrossOrigin
public class Role_MenuController {
    @Resource
    Role_MenuService rms;
}
