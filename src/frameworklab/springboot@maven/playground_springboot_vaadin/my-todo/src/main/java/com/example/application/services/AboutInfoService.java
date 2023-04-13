package com.example.application.services;

import org.springframework.stereotype.Service;

@Service
public class AboutInfoService {

    /*
     一个 Java Bean 需要满足的条件:
      有一个公开且不带参数的构造函数。
      通过一系列 getter 和 setter 方法访问其属性。
      可序列化（即实现了 java.io.Serializable 接口）。
     */

    public AboutInfoService(){
        introText = "This is a demo of Java techstack, including Vaadin and Springboot.";
    }

    private String introText;

    public void setintroText(String value){
        introText = value;
    }

    public String getIntroText(){
        return introText;
    }
}
