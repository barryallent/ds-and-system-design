package org.example.LeetCode.DynamicProgramming;

import java.util.*;

//https://leetcode.com/problems/minimum-jumps-to-reach-home/
class Jump {
    int currentPosition;
    int totalJumps;
    boolean isBackwardJump;

    Jump(int currentPosition, int totalJumps, boolean isBackwardJump) {
        this.currentPosition = currentPosition;
        this.totalJumps = totalJumps;
        this.isBackwardJump = isBackwardJump;
    }
}

public class MinimumJumpsToReachHome {
    public int minimumJumps(int[] forbidden, int a, int b, int x) {

        //add all forbidden in set so that we can look up in O(1) time
        Set<Integer> forbiddentSet = new HashSet<>();
        for (int i : forbidden) forbiddentSet.add(i);

        Queue<Jump> q1 = new LinkedList<>();

        //we need to track visited positions for both forward and backward jumps
        //this can be missed easlily if not careful
        boolean[][] visited = new boolean[6001][2];

        q1.offer(new Jump(0, 0, false));
        visited[0][0] = true;

        while (!q1.isEmpty()) {
            Jump topElement = q1.poll();
            int currentPosition = topElement.currentPosition;

            if (currentPosition == x) {
                return topElement.totalJumps;
            }

            int forwardPos = currentPosition + a;

            // Forward jump
            if (forwardPos <= 6000 && !forbiddentSet.contains(forwardPos) && !visited[forwardPos][0]) {
                q1.offer(new Jump(forwardPos, topElement.totalJumps + 1, false));
                visited[forwardPos][0] = true;
            }

            int backwardPos = currentPosition - b;

            //backward jump only when previous jump was not backward
            if (backwardPos >= 0  && !topElement.isBackwardJump &&  !visited[backwardPos][1] && !forbiddentSet.contains(backwardPos)) {
                q1.offer(new Jump(currentPosition - b, topElement.totalJumps + 1, true));
                visited[backwardPos][1] = true;
            }
        }
        return -1;
    }
}
