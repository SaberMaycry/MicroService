package com.annet.user;

import org.junit.jupiter.api.Test;

/**
 * Copyright © 2016 深圳安泰创新科技股份有限公司 版权所有 All Right Reserved
 *
 * @author: Saber
 * 包名：com.annet.user
 * 时间：2019/10/23 19:53
 * 说明：
 */
public class Saber {
    // [0,1,0,2,1,0,1,3,2,1,2,1]

    private int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};

    @Test
    public void trap() {

        int l = 0, r = height.length - 1, h = 0, ans = 0;
        while (l < r)
            if (height[l] < height[r]) {
                if (height[l] >= h){
                    h = height[l++];
                }else {
                    ans += h - height[l++];
                }
            } else {
                if (height[r] >= h){
                    h= height[r--];
                }else {
                    ans += h - height[r--];
                }
            }
        System.out.println(ans);

//
//        for (int i = 0; i < height.length; i++) {
//            if (height[i] - 2 >= 0) {
//                System.out.println(height[i]-2);
//            } else {
//                System.out.println(height[i]-2);
//            }
//        }
    }
}
