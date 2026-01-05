package org.example.DataStructuresAndAlgorithm.LeetCode.SlidingWindow;

//https://leetcode.com/problems/minimum-window-substring/description/
public class MinimumWindowSubstring {

        //check if string t is included fully in substring of s
        boolean isSubstringContainsString(int[] sFrequency, int[] tFrequency) {
            for(int i=0;i<sFrequency.length;i++) {
                if(sFrequency[i]<tFrequency[i]) {
                    return false;
                }
            }
            return true;
        }

        public String minWindow(String s, String t) {


            int[] tFrequency = new int[128];
            for(char c:t.toCharArray()) {
                tFrequency[c]++;
            }

            int[] sFrequency = new int[128];

            int l=0,r=0;
            int n = s.length();
            int minLength=n;

            //idea is to increase r till window is valid
            //once window is valid, we can decrease l till window is valid to find out
            //how much minLength we can get, once we have minLength we apply sliding window again
            //for that length to find valid substring
            while(r<n) {
                sFrequency[s.charAt(r)]++;

                //till window is valid, shrink it and update minLength
                while(isSubstringContainsString(sFrequency, tFrequency)) {
                    minLength=Math.min(minLength, r-l+1);
                    sFrequency[s.charAt(l)]--;
                    l++;
                }
                r++;
            }

            //once we get minLength, we need to find valid substring of that length
            //we will use sliding window again
            sFrequency = new int[128];

            r=0;
            l=0;

            while(r<n) {
                sFrequency[s.charAt(r)]++;

                //window invalid
                while(r-l+1>minLength) {
                    sFrequency[s.charAt(l)]--;
                    l++;
                }

                //valid string then return, answer is unique
                if(isSubstringContainsString(sFrequency, tFrequency)) {
                    return s.substring(l,r+1);
                }
                r++;
            }
            return "";


        }
}
