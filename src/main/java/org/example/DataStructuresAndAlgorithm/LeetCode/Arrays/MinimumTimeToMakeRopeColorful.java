package org.example.DataStructuresAndAlgorithm.LeetCode.Arrays;

import java.util.*;

//https://leetcode.com/problems/minimum-time-to-make-rope-colorful/description/
public class MinimumTimeToMakeRopeColorful {
    public int minCost(String colors, int[] neededTime) {

        //make map of character for its consecutive occurance, if character repeat x times
        //at 3 different places then we will have 3 lists
        //eg for colors = aabaa and neededTime=[1,2,3,4,5]
        //the map key a would be 0=[[1, 2], [4, 1]] because we are putting neededTime for those indices
        Map<Integer,List<List<Integer>>> consecutiveCharsMap = new HashMap<>();

        //only lower case english characters so size of map is fixed
        for(int i=0;i<26;i++) {
            consecutiveCharsMap.put(i,new ArrayList<>());
        }

        int i=1;

        while(i<colors.length()) {
            List<Integer> listToAdd = new ArrayList<>();
            boolean firstMatch=true;
            boolean anyMatch=false;
            char matchedCharacter='-';

            //when consecutive chars are same then we need to put in map,
            //we are putting neededTime
            while( i<colors.length() && colors.charAt(i-1)==colors.charAt(i)) {
                matchedCharacter=colors.charAt(i);
                anyMatch=true;
                //if first character match then we put i-1 also in map
                if(firstMatch) {
                    listToAdd.add(neededTime[i-1]);
                    firstMatch=false;
                }
                listToAdd.add(neededTime[i]);
                i++;
            }

            //put this list into the map for matchedCharacter
            if(anyMatch) {
                consecutiveCharsMap.get(matchedCharacter-'a').add(listToAdd);
                i--;
            }
            i++;

        }

        int minimumTime=0;

        //now we have all consecutive occurance in map, we now need to remove all the consecutive
        //occurance except one, we should keep the one that takes max time to remove
        for(Map.Entry<Integer,List<List<Integer>>> entry:consecutiveCharsMap.entrySet()) {
            List<List<Integer>> consecutiveList = entry.getValue();
            if(consecutiveList.size()==0) {
                continue;
            }
            for(List<Integer> list :consecutiveList ) {

                //totaltime that we remove will be total consecutive element - max
                //because we can leave one element and that should be one that takes longest time
                //to remove
                int total = list.stream().mapToInt(Integer::intValue).sum();
                int maximum = Collections.max(list);
                minimumTime+=total-maximum;
            }
        }
        return minimumTime;
    }
}
