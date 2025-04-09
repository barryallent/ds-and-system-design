package org.example.DataStructuresAndAlgorithm.LeetCode.DynamicProgramming;

//https://leetcode.com/problems/frog-jump/description/
public class FrogJump {
    Boolean[][] canJumpMemo;

    //we have 3 options here to jump. So state is basically what's the prev jump we took and where we are currenlty.
    boolean canCross(int prevJump, int currentStone, int[] stones) {

        //if frog reach end stone then it can cross the rever
        if (currentStone == stones.length - 1) {
            return true;
        }

        //frog not reaching end stone, we are setting currentState to stones.length in case it can't reach further
        if (currentStone >= stones.length) {
            return false;
        }

        if (canJumpMemo[prevJump][currentStone] != null) {
            return canJumpMemo[prevJump][currentStone];
        }


        //option 1 is to take prevJump, so now we have to find out which stone can we reach by taking this jump
        //Since the array is increasing we can break as soon as we reach some element
        int jump1 = prevJump;

        //if we can't reach further stone then nextIndex1 is reaching the out of bounds and we will return false
        int nextIndex1 = stones.length;
        for (int i = currentStone + 1; i < stones.length; i++) {

            //eg [0,1,3,6,10,13,15,18], we are at stone[currentStone]=3 then jump1 should be 3 to reach 6
            if (jump1 + stones[currentStone] == stones[i]) {
                nextIndex1 = i;
                break;
            }
        }

        //option 2 is to take prevJump-1
        int jump2 = prevJump - 1;
        int nextIndex2 = stones.length;
        for (int i = currentStone + 1; i < stones.length; i++) {
            if (jump2 + stones[currentStone] == stones[i]) {
                nextIndex2 = i;
                break;
            }
        }

        //option 3 is to take prevJump+1
        int jump3 = prevJump + 1;
        int nextIndex3 = stones.length;
        for (int i = currentStone + 1; i < stones.length; i++) {
            if (jump3 + stones[currentStone] == stones[i]) {
                nextIndex3 = i;
                break;
            }
        }

        //we can reach end by either of the 3 options
        return canJumpMemo[prevJump][currentStone] = canCross(prevJump, nextIndex1, stones)
                || canCross(prevJump - 1, nextIndex2, stones)
                || canCross(prevJump + 1, nextIndex3, stones);

    }

    public boolean canCross(int[] stones) {
        int n = stones.length;
        canJumpMemo = new Boolean[n][n];
        return stones[1] == 1 ? canCross(1, 1, stones) : false;
    }
}

class Solution {
    public static void main(String[] args) {
        FrogJump frogJump = new FrogJump();
        int[] stones = new int[2000];
        for (int i = 0; i < 2000; i++) {
            stones[i] = i * 1; // Uniformly spaced, 1 unit apart
        }

        // Measure execution time
        long startTime = System.nanoTime();
        
        boolean result = frogJump.canCross(stones);
        
        long endTime = System.nanoTime();
        double durationMillis = (endTime - startTime) / 1_000_000.0;
        
        System.out.println("Result: " + result);
        System.out.println("Execution time: " + durationMillis + " ms");
    }
}
