package com.springmvc1.springmvc1.web.frontcontroller.v3.controller;

import com.springmvc1.springmvc1.web.frontcontroller.ModelView;
import com.springmvc1.springmvc1.web.frontcontroller.v3.ControllerV3;

import java.util.Map;

public class MemberFromControllerV3 implements ControllerV3 {

    @Override
    public ModelView process(Map<String, String> paramMap) {
        return new ModelView("new-form");
    }
}
