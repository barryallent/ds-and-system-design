package org.example.DataStructuresAndAlgorithm.LeetCode.Heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

//https://leetcode.com/problems/reorganize-string/description/
public class ReorganizeString {
        public String reorganizeString(String s) {

            //idea is to first put the chars with more frequency first, this is same as
            //task scheduler

            //get frequency of all chars
            int[] sFrequency = new int[26];
            for(char c:s.toCharArray()) {
                sFrequency[c-'a']++;
            }

            //queue contains (char, frequency)
            PriorityQueue<int[]> p1 = new PriorityQueue<>((a, b)->Integer.compare(b[1],a[1]));

            //add initial frequencies to queue
            for(int i=0;i<26;i++) {
                if(sFrequency[i]>0) {
                    p1.add(new int[]{i, sFrequency[i]});
                }
            }

            //this will make the rearranged string
            StringBuilder rearrangedS = new StringBuilder();

            while(rearrangedS.length()<s.length()) {

                int currentLength=rearrangedS.length();

                //will be used to add back the character, will be of size 1 always
                List<int[]> charsToAddBack = new ArrayList<>();

                //check if we get char same as last char then poll, no while loop needed as
                //queue contains all distinct keys a,b,c
                if(!p1.isEmpty() && currentLength>0 && (char) (p1.peek()[0]+'a')==rearrangedS.charAt(currentLength-1)) {
                    charsToAddBack.add(p1.poll());
                }

                //if no char remain that means all char are same in queue so we cant rearrange anymore
                if(p1.isEmpty()) {
                    return "";
                }

                //otherwise use to char in rearranging
                int[] charsToUse = p1.poll();

                char currentChar = (char) (charsToUse[0]+'a');
                int currentFrequency = charsToUse[1];
                rearrangedS.append(currentChar);

                //put back if still frequency left
                if(currentFrequency-1>0) {
                    p1.add(new int[]{charsToUse[0], currentFrequency-1});
                }

                //add back the char which was polled, will be of size 1
                for(int[] i:charsToAddBack) {
                    p1.add(i);
                }

            }
            return rearrangedS.toString();
        }
}
