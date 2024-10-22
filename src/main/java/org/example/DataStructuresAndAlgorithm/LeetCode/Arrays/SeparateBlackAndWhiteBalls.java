package org.example.DataStructuresAndAlgorithm.LeetCode.Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//https://leetcode.com/problems/separate-black-and-white-balls/description/
public class SeparateBlackAndWhiteBalls {
    public long minimumSteps(String s) {
        int n = s.length();

        //store all the ones index
        List<Integer> onesIndex = new ArrayList<>();

        for(int i=0;i<n;i++) {
            if(s.charAt(i)=='1') {
                onesIndex.add(i);
            }
        }

        long operationsNeeded=0L;
        int lastOneIndex=n-1;

        //at each ones index we have to place, it to the end, so operations needed will be
        //lastOneIndex-currentOneIndex;
        //sorting is not needed as we are only adding lastOneIndex-currentOneIndex to answer each time
        for(int currentOneIndex:onesIndex) {
            operationsNeeded+=lastOneIndex-currentOneIndex;
            lastOneIndex--;
        }

        return operationsNeeded;
    }
}
