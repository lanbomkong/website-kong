package com.biosh.owner.web;

import java.util.Date;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * @description
 * @date 2019/7/4
 */
public class JavapClass {

    @CrossOrigin
    public static void main(String[] argsp) {

        // 输出日志
        System.out.println(new Date());

        System.out.println(34 >> 1);
        // 注释都能搞起live template
        try {
            throw  new Exception();
        } catch (Exception e) {
            System.out.println("this is exception in catch");
        }
    }
}
