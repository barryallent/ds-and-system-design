package org.example.DataStructuresAndAlgorithm.LeetCode.Stack;

import java.util.Stack;

class Node {
    char nodeChar;
    int index;
    Node(char nodeChar, int index) {
        this.nodeChar=nodeChar;
        this.index=index;
    }
}

//https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/description/
public class MinimumRemoveToMakeValidParentheses {

        public String minRemoveToMakeValid(String s) {

            //idea is to store character and index also for ( in stack
            //because we should only add ( to final answer when its matched with )
            //so at time of matching only we will insert ( to answer but for that we will need the index
            //so we are storing it
            //we will add only open bracket to stack and other chars directly
            Stack<Node> s1 = new Stack<>();

            StringBuilder sb = new StringBuilder();

            //index for sb, will be used to insert index of ( to stack
            int index=0;

            for(int i=0;i<s.length();i++) {
                char c = s.charAt(i);

                //open bracked, just add to stack
                if(c=='(') {
                    s1.add(new Node(c,index));
                }

                //closed bracket
                else if(c==')') {

                    //if matched then insert the open and closed both bracket to sb
                    if(!s1.isEmpty() && s1.peek().nodeChar=='(') {
                        Node topElement = s1.pop();

                        //insert open bracket at the index which it should be
                        //after both inserts just increase index
                        sb.insert(topElement.index, '(');
                        index++;

                        //insert close bracket at current pos
                        sb.append(')');
                        index++;
                    }
                }

                //other elements just add increase index
                else {
                    sb.append(c);
                    index++;
                }
            }



            return sb.toString();
        }
}
