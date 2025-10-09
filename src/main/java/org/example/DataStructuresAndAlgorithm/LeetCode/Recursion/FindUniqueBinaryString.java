package org.example.DataStructuresAndAlgorithm.LeetCode.Recursion;


import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/find-unique-binary-string/description/
public class FindUniqueBinaryString {
    int n;
    String generateAllBinaries(Set<String> numsSet, String s) {
        if(s.length()>n || numsSet.contains(s)) {
            return "exit";
        }
        if(s.length()==n && !numsSet.contains(s)) {
            return s;
        }

        String op1 = generateAllBinaries(numsSet, s+"0");
        String op2 = generateAllBinaries(numsSet, s+"1");

        if(!op1.equals("exit")) {
            return op1;
        }
        return op2;

    }
    public String findDifferentBinaryString(String[] nums) {
        n = nums.length;
        Set<String> numsSet = new HashSet<>();
        for(String s:nums) {
            numsSet.add(s);
        }

        return generateAllBinaries(numsSet, "");
    }


    //optimized way
//    public String findDifferentBinaryString(String[] nums) {
//        StringBuilder missingBinary = new StringBuilder();
//
//
//        //we iterate and make answer different for 1 bit for each string, so the answer
//        //will be different from all string in nums
//        for(int i=0;i<nums.length;i++) {
//            char toAppend = nums[i].charAt(i)=='0' ? '1' : '0';
//            missingBinary.append(toAppend);
//        }
//
//        return missingBinary.toString();
//    }
}
