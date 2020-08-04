package com.bo.demo.service.impl;

import com.bo.demo.service.TestService;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {
    public String testService01() {
        return "2";
    }
}
