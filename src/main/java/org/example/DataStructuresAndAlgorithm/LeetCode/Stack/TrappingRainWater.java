package org.example.DataStructuresAndAlgorithm.LeetCode.Stack;

import java.util.Stack;

//https://leetcode.com/problems/trapping-rain-water/description/
public class TrappingRainWater {
        public int trap(int[] height) {

            //monotonic decreasing stack because as soon as we have greater element we get the right boundary
            //and since its decreasing we have left boundary as previous element always
            Stack<int[]> s1 = new Stack<>();

            int totalWater = 0;

            for (int i = 0; i < height.length; i++) {

                while (!s1.isEmpty() && s1.peek()[0] < height[i]) {
                    int[] topElement = s1.pop();

                    //basically water is trapped b/w two height so we are calculating left and right heights
                    //eg 10, 3 , 2, 7. so water with height 3 will have extra 4 height (7-3)
                    //and its width will be 2 index of 7-index of 10 -1

                    int rightHeight = height[i];

                    //no left height, so all water will not be trapped
                    if (s1.isEmpty()) {
                        break;
                    }

                    int leftHeight = s1.peek()[0];
                    int heightWater = Math.min(rightHeight, leftHeight) - topElement[0];

                    //since heights are decreasing order so we will check how much width this water
                    //will cover
                    int widthWater = i - s1.peek()[1] - 1;
                    totalWater += heightWater * widthWater;
                }

                s1.add(new int[] { height[i], i });
            }

            return totalWater;

        }
}
