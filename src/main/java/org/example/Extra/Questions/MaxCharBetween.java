package org.example.Extra.Questions;

//https://www.geeksforgeeks.org/problems/maximum-number-of-characters-between-any-two-same-character4552/1
public class MaxCharBetween {
    public int maxChars(String s)
    {
        int[] characters = new int[256];
        for(int i=0;i<256;i++) {
            characters[i]=-1;
        }
        int maxDistance=-1;
        for(int i=0;i<s.length();i++) {
            int firstIndex = characters[s.charAt(i)-'0'];
            if(firstIndex==-1) {
                characters[s.charAt(i)-'0']=i;
            }
            else {
                maxDistance=Math.max(maxDistance,i-firstIndex-1);
            }
        }
        return maxDistance;
    }
}
