package org.example.DataStructuresAndAlgorithm.LeetCode.Greedy;

//https://leetcode.com/problems/jump-game-ii/description/
public class JumpGameII {
    public int jump(int[] nums) {
        int r = 0;
        int l = 0;
        int n = nums.length;
        int jumps = 0;

        //at r=n-1 we reach end
        while (r < n - 1) {

            //range is till start and end
            int start = l;
            int end = r;

            //check the farthest we can go in this range and update r to that
            for (int i = start; i <= end; i++) {
                r = Math.max(r, i + nums[i]);
            }

            //increment l and jumps
            l++;
            jumps++;

        }
        return jumps ;
    }
}
