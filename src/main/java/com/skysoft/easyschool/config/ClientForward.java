package com.skysoft.easyschool.config;

import com.skysoft.easyschool.utils.SecurityUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientForward {

    @GetMapping("/api/test")
    public String forward() {
        return SecurityUtils.getCurrentUserLogin().toString();
    }
}
