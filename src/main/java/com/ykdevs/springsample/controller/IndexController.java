package com.ykdevs.springsample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

@Controller
public class IndexController {

    @GetMapping("/")
    public ModelAndView index(ModelAndView modelview,
                              HttpServletRequest request,
                              @RequestHeader(name="Authorization",required=false) String authorization) {

        Enumeration<String> headerNames = request.getHeaderNames();

        String buff = "";
        while (headerNames.hasMoreElements()) {

            // ヘッダ名と値を取得
            String headerName = (String) headerNames.nextElement();
            String headerValue = request.getHeader(headerName);
            buff += headerName + " : " + headerValue;
        }

        modelview.setViewName("index");
        modelview.addObject("token", authorization);
        modelview.addObject("header", buff);
        return modelview;
    }
}
