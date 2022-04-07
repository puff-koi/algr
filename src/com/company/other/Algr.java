package com.company.other;

import java.util.ArrayList;
import java.util.List;

public class Algr {

    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ans = new ArrayList<>();
        for (int i = left; i <=right ; i++) {
            boolean isTrue = false;
            if (digui(i,i,isTrue)){ans.add(i,i);}
        }
        return ans;
    }

    public boolean digui(int all,int i,boolean isTrue){
        if (i>10){
            digui(all,i%10,isTrue);
        }else {
            isTrue = all % i ==0;
        }

        return isTrue;
    }
}
