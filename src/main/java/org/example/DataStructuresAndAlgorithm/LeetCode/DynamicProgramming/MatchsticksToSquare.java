package org.example.DataStructuresAndAlgorithm.LeetCode.DynamicProgramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MatchsticksToSquare {
    class Solution {
        Map<String, Boolean> isSquareMemo;

        //idea is that each element has 4 choices, it can go to either of the 4 sides
        boolean makeSquare(int i, int[] matchsticks, int side1, int side2, int side3, int side4, int target) {
            if(i>=matchsticks.length) {
                return side1==side2 && side3==side4 && side1==side3;
            }

            if(side1>target || side2>target  || side3>target || side4>target) {
                return false;
            }

            String key = i+","+side1+","+side2+","+side3+","+side4;

            int matchstick = matchsticks[i];

            // Try placing the matchstick in each side
            // We will return true as soon as we get it, no need to check other options
            if (side1 + matchstick <= target && makeSquare(i + 1, matchsticks, side1 + matchstick, side2, side3, side4, target)) {
                isSquareMemo.put(key, true);
                return true;
            }
            if (side2 + matchstick <= target && makeSquare(i + 1, matchsticks, side1, side2 + matchstick, side3, side4, target)) {
                isSquareMemo.put(key, true);
                return true;
            }
            if (side3 + matchstick <= target && makeSquare(i + 1, matchsticks, side1, side2, side3 + matchstick, side4, target)) {
                isSquareMemo.put(key, true);
                return true;
            }
            if (side4 + matchstick <= target && makeSquare(i + 1, matchsticks, side1, side2, side3, side4 + matchstick, target)) {
                isSquareMemo.put(key, true);
                return true;
            }

            isSquareMemo.put(key,false);

            return false;

        }
        public boolean makesquare(int[] matchsticks) {

            isSquareMemo = new HashMap<>();

            int sum = Arrays.stream(matchsticks).sum();
            if (sum % 4 != 0) return false;

            Arrays.sort(matchsticks); // Sorting helps in pruning branches earlier
            reverseArray(matchsticks); // Sorting in descending order improves performance

            return makeSquare(0, matchsticks, 0,0,0,0,sum/4);
        }

        private void reverseArray(int[] arr) {
            int left = 0, right = arr.length - 1;
            while (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }

    }
}
