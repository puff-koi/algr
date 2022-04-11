package com.company.other;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Algr {

    //229. 求众数 II
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer, Integer> cnt = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            if (cnt.containsKey(nums[i])) {
                cnt.put(nums[i], cnt.get(nums[i]) + 1);
            } else {
                cnt.put(nums[i], 1);
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int x : cnt.keySet()) {
            if (cnt.get(x) > nums.length / 3) {
                ans.add(x);
            }
        }

        return ans;
    }


    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ans = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            boolean isTrue = false;
            if (digui(i, i, isTrue)) {
                ans.add(i, i);
            }
        }
        return ans;
    }

    public boolean digui(int all, int i, boolean isTrue) {
        if (i > 10) {
            digui(all, i % 10, isTrue);
        } else {
            isTrue = all % i == 0;
        }

        return isTrue;
    }
}
