package org.example.DataStructuresAndAlgorithm.LeetCode.Stack;

//https://leetcode.com/problems/next-greater-element-iii/description/
public class NextGreaterElementIII {
        public int nextGreaterElement(int n) {

            //convert number to array
            String s = n + "";
            int p = s.length();
            int[] greaterArray = new int[p];
            for (int i = 0; i < p; i++) {
                greaterArray[i] = s.charAt(i) - '0';
            }

            //next permutation can also be done like this
            //find till where we have decreasing order
            //so no need to do anything in this part
            int pivot = -1;
            for (int i = p - 2; i >= 0; i--) {
                if (greaterArray[i] < greaterArray[i + 1]) {
                    pivot = i;
                    break;
                }
            }

            //if array already decreasing order i.e max then no pivot
            if (pivot == -1) {
                return -1;
            }

            //now that we got the 1st element which we can change. we will start from right
            //because that part is sorted so rightmost side have chances of smaller elements
            //as soon as we find the element greater than pivot that will be smallest possible so swap it
            for (int i = p - 1; i > pivot; i--) {
                if (greaterArray[i] > greaterArray[pivot]) {
                    int temp = greaterArray[i];
                    greaterArray[i] = greaterArray[pivot];
                    greaterArray[pivot] = temp;
                    break;
                }
            }

            // reverse the remaining part, sort is not needed here, because after pivot
            // array is already in decreasing order so if we sort it we get inc order i.e smaller value
            int l = pivot + 1, r = p - 1;
            while (l < r) {
                int temp = greaterArray[l];
                greaterArray[l++] = greaterArray[r];
                greaterArray[r--] = temp;
            }

            //make number from array
            //overflow cases handle using long
            long nextGreaterNum = 0;

            for (int i = 0; i < p; i++) {
                nextGreaterNum = nextGreaterNum * 10 + greaterArray[i];
            }

            //if no next permutation then return -1
            if ((int) nextGreaterNum == n) {
                return -1;
            }

            //if overflow then return -1
            return nextGreaterNum > Integer.MAX_VALUE ? -1 : (int) nextGreaterNum;
        }
}
