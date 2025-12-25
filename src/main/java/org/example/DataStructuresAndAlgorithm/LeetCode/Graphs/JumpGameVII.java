package org.example.DataStructuresAndAlgorithm.LeetCode.Graphs;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/jump-game-vii/
public class JumpGameVII {
    public boolean canReach(String s, int minJump, int maxJump) {

        //if last char is itself one then we can never reach it
        if(s.charAt(s.length()-1)=='1') {
            return false;
        }

        //take queue for BFS, we will be visiting all possible ranges for the index
        //but think about it, if we just do that, then all ranges we are checking again and again
        //for all elements so time complexity O(n × J)
        //basically we can track the farthest we have check, so that we don't end up checking the
        //values again

        //we will be putting indices in the queue
        Queue<Integer> q1 = new LinkedList<>();
        q1.add(0);

        int farthest=0;

        while(!q1.isEmpty()) {
            int i = q1.poll();

            //reach end so return
            if(i==s.length()-1) {
                return true;
            }

            //check from min jump to max jump, but here included the farthest logic
            for(int j=Math.max(i+minJump, farthest);j<=Math.min(s.length()-1,i+maxJump);j++) {

                //add all neighbours we can visit to queue so that we check from them
                if(s.charAt(j)=='0') {
                    q1.add(j);
                    farthest=Math.max(farthest,j+1);
                }

                //update farthest, till where we have already checked + 1, can remove +1 also
                farthest = Math.max(farthest, Math.min(s.length()-1,i+maxJump)+1);
            }
        }

        return false;

    }
}
