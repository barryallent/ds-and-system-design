package org.example.DataStructuresAndAlgorithm.LeetCode.Recursion;

import java.util.Stack;

//https://leetcode.com/problems/decode-string/description/
public class DecodeString {
    public String decodeString(String s) {
        Stack<Character> s1 = new Stack<>();

        StringBuilder finalAnswer = new StringBuilder();

        //iterate the string and keep appending once you get a closing bracket. once you
        //get a closing bracket, pop elements till you find opening bracket to complete that particular
        //part. This is the crux
        for(char c:s.toCharArray()) {

            //add to stack till we have closing bracket
            if(c!=']') {
                s1.add(c);
            }

            //if we get closing bracket
            else {

                //keep popping till we get opening bracket
                StringBuilder substring = new StringBuilder();
                while(s1.peek()!='[') {
                    substring.append(s1.pop());
                }

                //pop opening bracket as its not needed
                s1.pop();

                //now get the number
                StringBuilder number = new StringBuilder();
                while(!s1.isEmpty() && Character.isDigit(s1.peek())) {
                    number.append(s1.pop());
                }

                //now make the string with number * (part inside bracket)
                StringBuilder combinedSubstring = new StringBuilder();
                substring.reverse();
                int num = Integer.parseInt(number.reverse().toString());
                for(int i=0;i<num;i++) {
                    combinedSubstring.append(substring);
                }

                //now push this part to the stack back so that it can be appended to other parts
                for(int i=0;i<combinedSubstring.length();i++) {
                    s1.add(combinedSubstring.charAt(i));
                }
            }
        }

        //final answer in stack just pop and reverse it
        while(!s1.isEmpty()) {
            finalAnswer.append(s1.pop());
        }
        return finalAnswer.reverse().toString();
    }
}
