package org.example.DataStructuresAndAlgorithm.LeetCode.String;

//https://leetcode.com/problems/minimum-number-of-frogs-croaking/description/

public class MinimumNumberOfFrogsCroaking {
    public int minNumberOfFrogs(String croakOfFrogs) {

        int[] croakArray = new int[5];

        int minFrogs = 0;

        //here we only can have 5 chars possible and if we think about it the order is important
        //we can keep adding the chars to array and while adding we need to check before adding that if i have sound
        //then prev sound should be greater than sound otherwise order 'croak' order is not maintained and we return -1
        //eg- if we want to add 'c' then we just add it because its 1st, but if we want to add 'r' then c freq should be
        //greater than r. Also once we find 'k' then we can reduce all elements by 1 because 1 sequence is complete.
        // we will also count the frogs needed at this point that will be the frequency of c currently. and we take max
        //of that because those are the frogs need to present currenly because there are those many c sounds currently
        // we can also calculate this c frequency anywhere else in the loop
        for (char currentChar : croakOfFrogs.toCharArray()) {
            if (currentChar == 'c') {
                croakArray[0]++;
            } else if (currentChar == 'r') {
                if (croakArray[0] > croakArray[1]) {
                    croakArray[1]++;
                } else {
                    return -1;
                }
            } else if (currentChar == 'o') {
                if (croakArray[1] > croakArray[2]) {
                    croakArray[2]++;
                } else {
                    return -1;
                }
            } else if (currentChar == 'a') {
                if (croakArray[2] > croakArray[3]) {
                    croakArray[3]++;
                } else {
                    return -1;
                }
            } else if (currentChar == 'k') {
                if (croakArray[3] > croakArray[4]) {
                    croakArray[4]++;
                } else {
                    return -1;
                }
                minFrogs = Math.max(minFrogs, croakArray[0]);
                for (int i = 0; i < 5; i++) {
                    croakArray[i]--;
                }
            }

        }

        //if all frequencies are not equal that means we have some missing sound at the end. eg croakcro,
        //so 'a' and 'k' are missing so there freq will be 0 and rest all will be 1 (because we reduce after getting k)
        for(int i=0;i<4;i++) {
            if(croakArray[i]!=croakArray[i+1]) {
                return -1;
            }
        }

        return minFrogs;

    }
}
