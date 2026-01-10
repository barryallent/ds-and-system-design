package org.example.DataStructuresAndAlgorithm.LeetCode.Heap;

import java.util.*;

//https://leetcode.com/problems/smallest-range-covering-elements-from-k-lists/description/
public class SmallestRangeCoveringElementsFromKLists {
        //crux is that first we will merge these k sorted lists while maintaining the number which tell
        //which k lists this list belongs
        //then we will use sliding window technique to check if the window contains elements from all lists
        //so if its a valid window then we will shrink till when window is valid.
        //A map will be used to check if its a valid window.
        public int[] smallestRange(List<List<Integer>> nums) {

            int k = nums.size();

            //merge k sorted lists
            PriorityQueue<int[]> p1 = new PriorityQueue<>((a, b)->Integer.compare(a[0],b[0]));

            for(int i=0;i<nums.size();i++) {
                p1.add(new int[]{nums.get(i).get(0), i, 0});
            }

            //[0] contains number
            //[1] contains the list number to which this element belongs to
            List<int[]> mergedList = new ArrayList<>();

            //logic is same as merge k sorted lists
            while(!p1.isEmpty()) {
                int[] topElement = p1.poll();

                int number = topElement[0];
                int listNumber = topElement[1];
                int listIndex=topElement[2];

                mergedList.add(new int[]{number,listNumber});

                //push the next index if this exists
                if(listIndex+1<nums.get(listNumber).size()) {
                    p1.add(new int[]{nums.get(listNumber).get(listIndex+1), listNumber, listIndex+1});
                }

            }

            //now we got merged k sorted lists with listnumber also for each element,
            //now we will apply sliding window technique
            int r=0;
            int l=0;
            int n=mergedList.size();
            int minRange=Integer.MAX_VALUE;
            int lowerBound=Integer.MIN_VALUE;
            int upperBound=Integer.MAX_VALUE;

            //map has key that which nums list and value will be frequency of elements from that list
            //so we want this map size to be k so that we have elements from all the lists
            Map<Integer,Integer> kListsMap = new HashMap<>();

            while(r<n) {

                //keep putting list numbers in the map and tracking their frequency
                int currentFrequency = kListsMap.getOrDefault(mergedList.get(r)[1],0);
                kListsMap.put(mergedList.get(r)[1], currentFrequency+1);

                //valid window, we shrinking on valid because by increasing window size
                //our chances of valid window increases.
                while(kListsMap.size()==k) {

                    //update the range and upper bound lower bound
                    if(mergedList.get(r)[0]-mergedList.get(l)[0]<minRange) {
                        minRange=mergedList.get(r)[0]-mergedList.get(l)[0];
                        lowerBound=mergedList.get(l)[0];
                        upperBound=mergedList.get(r)[0];
                    }

                    //remove the l index
                    currentFrequency = kListsMap.getOrDefault(mergedList.get(l)[1],0);
                    kListsMap.put(mergedList.get(l)[1], currentFrequency-1);
                    if(kListsMap.get(mergedList.get(l)[1])==0) {
                        kListsMap.remove(mergedList.get(l)[1]);
                    }
                    l++;
                }

                //increase window
                r++;
            }

            return new int[]{lowerBound,upperBound};
        }
}
