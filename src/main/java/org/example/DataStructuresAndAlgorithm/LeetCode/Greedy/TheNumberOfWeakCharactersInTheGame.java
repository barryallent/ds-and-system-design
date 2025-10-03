package org.example.DataStructuresAndAlgorithm.LeetCode.Greedy;

import java.util.Arrays;
import java.util.Comparator;

public class TheNumberOfWeakCharactersInTheGame {
    //Here we will sort the array in inc order of attacks and if attack is same, we will sort by dec
    //order of defence. Then we will iterate from the end and keep track of the maxDefence seen so far.
    //If current element’s defence is less than maxDefence, then that player is weak because there exists
    //a player on the right side with strictly greater attack (guaranteed by sorting) and also greater defence.
    // Sorting defence in DESC order for equal attacks is crucial: it ensures that within a
    // group of the same attack, higher-defence characters appear to the left and lower-defence
    // ones to the right. Thus when scanning right→left, the running maxDefence only reflects
    // defences of characters with strictly greater attack, not those with equal attack.
    // Example:
    //   Input: [1,2], [1,1], [2,2], [2,1]
    //   After sort (attack asc, defence desc): [1,2], [1,1], [2,2], [2,1]
    //   Scan right→left:
    //     see [2,1] -> maxDef = 1
    //     see [2,2] -> maxDef = 2
    //     see [1,1] -> 1 < 2 -> weak (correct, count = 1)
    //     see [1,2] -> 2 < 2 -> not weak
    //
    // If we had used defence ASC for equal attacks, order would be:
    //   [1,1], [1,2], [2,1], [2,2]
    // Scanning right→left then would incorrectly count [2,1] as weak because [2,2]
    // (same attack but higher defence) would be to its right and inflate maxDef,
    // producing an overcount (2 instead of 1). That’s why defence DESC + right→left scan
    //This is the main crux (keep track of max defence and iterate from end).
    public int numberOfWeakCharacters(int[][] properties) {

        Arrays.sort(properties, new CustomComparator());

        int n = properties.length;
        int maxDefence=properties[n-1][1];
        int weakPlayers=0;

        //sorting ensures that we get less attack first, and same attacks are not counted
        for(int i=1;i<n;i++) {
            if (properties[n-i-1][1] < maxDefence) {
                weakPlayers++;
            }
            maxDefence = Math.max(maxDefence, properties[n-i-1][1]);
        }
        return weakPlayers;
    }

    class CustomComparator implements Comparator<int[]> {
        @Override
        public int compare(int[] a, int[] b) {
            //decrease order of defence in case of equal attacks so that we don't overcount
            if(a[0]==b[0]) {
                return Integer.compare(b[1],a[1]);
            }
            else {
                return Integer.compare(a[0],b[0]);
            }
        }
    }
}
