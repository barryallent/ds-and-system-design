package org.example.DataStructuresAndAlgorithm.LeetCode.Greedy;

//https://leetcode.com/problems/minimum-moves-to-reach-target-score/description/
public class MinimumMovestoReachTargetScore {
    public int minMoves(int target, int maxDoubles) {
        int totalMoves=0;

        //start from target and go till 1
        while(target>1) {

            //if maxDouble is left and allowed then do that only
            //because it will just reduce to half
            if(maxDoubles>0) {

                //if divide allowed that means its a multiple of 2 then divide by 2
                if(target%2==0) {
                    target=target/2;
                    maxDoubles--;
                }

                //if not allowed then decrease by 1
                else {
                    target--;
                }
            }

            //if no double moves left then reduce by 1 only, and instead of doing 1 by 1 just return
            //answer from here only
            else {
                return totalMoves+target-1;
            }
            totalMoves++;
        }
        return totalMoves;
    }
}
