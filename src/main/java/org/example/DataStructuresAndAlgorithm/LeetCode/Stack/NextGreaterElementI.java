package org.example.DataStructuresAndAlgorithm.LeetCode.Stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//https://leetcode.com/problems/next-greater-element-i/description/
public class NextGreaterElementI {

        //we will find next greater elements in nums2 and using the map we will make the answer for nums1
        public int[] nextGreaterElement(int[] nums1, int[] nums2) {

            //put all indices of num2 in map, it will be useful to find which index num1 element belongs
            //in nums2 in constant time
            Map<Integer,Integer> nums2Map = new HashMap<>();
            for(int i=0;i<nums2.length;i++) {
                nums2Map.put(nums2[i], i);
            }

            //find next greater element for nums2
            Stack<int[]> s1 = new Stack<>();
            int[] greaterElementNums2 = new int[nums2.length];
            Arrays.fill(greaterElementNums2,-1);

            for(int i=0;i<nums2.length;i++) {
                while(!s1.isEmpty() && nums2[i]>s1.peek()[0]) {
                    int[] topElement = s1.pop();
                    greaterElementNums2[topElement[1]]=nums2[i];
                }
                s1.add(new int[]{nums2[i],i});
            }

            //find next greater element for nums1 in nums2
            int[] greaterElementNums1 = new int[nums1.length];

            for(int i=0;i<greaterElementNums1.length;i++) {
                //here we are using map to find at which index nums1[i] belong in nums2 array
                //and find greaterElementNums2 for that index, this is expected as per question
                greaterElementNums1[i]=greaterElementNums2[nums2Map.get(nums1[i])];
            }

            return greaterElementNums1;
        }
}
