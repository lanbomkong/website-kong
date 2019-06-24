package com.biosh.owner.web;

import org.junit.Test;

/**
 * @description
 * @date 2019/6/22
 */
public class WebControllerTest {

    @Test
    public void testUnknow() {

        int j = 0;
        for (int i = 0; i < 100; i++) {
            j = j++;
//            j++;
        }
        System.out.println(j);
    }

}
