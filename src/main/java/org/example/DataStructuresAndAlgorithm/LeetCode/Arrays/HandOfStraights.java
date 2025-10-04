package org.example.DataStructuresAndAlgorithm.LeetCode.Arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/hand-of-straights/description/
public class HandOfStraights {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;

        //if number of groups cannot be integer then just return false here itself
        if(n%groupSize!=0) {
            return false;
        }

        //sort array so that we process in order
        Arrays.sort(hand);


        //map to store frequencies of each element
        Map<Integer,Integer> handsFrequency = new HashMap<>();

        //put all array elements in map with frequency
        for(int i:hand) {
            handsFrequency.put(i, handsFrequency.getOrDefault(i,0)+1);
        }

        //idea is to iterate array and for a element reduce frequencies element, element+1...element+k
        //from map to confirm that pair is formed and we remove the values from map if the frequency
        //becomes zero, and while starting also we check the frequency of element, if its already used in
        //pair then we just move forward
        for(int i=0;i<hand.length;i++) {
            int element = hand[i];

            //if element is already used to move forward
            if(handsFrequency.getOrDefault(element,0)==0) {
                continue;
            }

            //form group with element as starting number and k more elements
            for(int k=0;k<groupSize;k++) {

                //if consecutive elements are not found then return false
                if(!handsFrequency.containsKey(element+k)) {
                    return false;
                }

                //reduce frequency of elements since they are used, and removed from map if needed
                handsFrequency.put(element+k,handsFrequency.getOrDefault(element+k,0)-1);
                if(handsFrequency.get(element+k)==0) {
                    handsFrequency.remove(element+k);
                }
            }
        }

        //if map is empty that means all groups are formed
        return handsFrequency.size()==0 ? true: false;
    }
}
