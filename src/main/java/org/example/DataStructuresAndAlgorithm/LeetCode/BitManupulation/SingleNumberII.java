package org.example.DataStructuresAndAlgorithm.LeetCode.BitManupulation;

//https://leetcode.com/problems/single-number-ii/description/
public class SingleNumberII {
    class Solution {
        public int singleNumber(int[] nums) {
            //lets say we take 2 buckets, if number comes 1st time we store in ones
            //if number comes 2nd time we store in twos, if number comes 3rd time
            //so both ones and twos will be zero and it will go to 3rd bucket
            //but we dont need the third buckets since the number coming 3 times will be gone
            //and we are interested in the number coming 1 time and that we will get from ones


            //eg 1,1,1,3,3,3,4-> here ans is 4
            //when 1 comes 1st time it goes to ones. when one comes 2nd time, it makes ones as 0 because
            // 1 ^ 1 is zero so since ones is 0 it goes to 2s. When it come 3rd time since ones is 0
            //it goes to twos again and since twos already has one occurance of it so 1^1 is 0 so basically 1
            //disappers, and since we are playing with bits so order dont matter

            int ones=0,twos=0;
            int n = nums.length;

            for(int i=0;i<n;i++) {

                //put in ones if it is not in twos
                ones = (ones ^ nums[i]) & (~twos);

                //put in twos if it is not in ones
                twos = (twos ^ nums[i]) & (~ones);
            }

            return ones;
        }

//        public int singleNumber(int[] nums) {
//            int ans=0;
//
//            //check bit by bit, if a number occur 3 times then its total contribution
//            //in the bits will be multiple of 3.
//            for(int i=0;i<32;i++) {
//                int sum=0;
//                //check ith bit in how many numbers
//                for(int num:nums) {
//                    if(((1<<i) & num) != 0) {
//                        sum+=1;
//                    }
//                }
//
//                //if ith bit is not multiple of 3 that means its coming from extra element
//                //so include that in answer
//                if(sum%3!=0) {
//                    ans |= 1<<i;
//                }
//            }
//            return ans;
//        }

//        public int singleNumber(int[] nums) {
//
//            //sort the array and keep looking every 3rd element
//            Arrays.sort(nums);
//            int n = nums.length;
//
//            //i+=3 to jump 3 elements
//            for(int i=1;i<n;i+=3) {
//
//                //this should always be equal if not then i-1 is the single number
//                if(nums[i]!=nums[i-1]) {
//                    return nums[i-1];
//                }
//            }
//
//            //if we didnt found the single number that means it is coming at end
//            return nums[n-1];
//        }

    }
}
