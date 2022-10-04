package com.workspace.tuling01.ums.controller;

import com.workspace.tuling01.service.UmsMemberLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/memberLevel")
public class UmsMemberLevelController {

    @Autowired
    UmsMemberLevelService memberLevelService;
}
