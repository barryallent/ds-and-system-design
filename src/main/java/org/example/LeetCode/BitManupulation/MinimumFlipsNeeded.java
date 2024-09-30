package org.example.LeetCode.BitManupulation;

public class MinimumFlipsNeeded {
    //convert binary to decimal
    public static int[] decimalToBinary(int n) {
        int powerOfTwo = 1;

        int[] binary=new int[32];
        int i=0;

        while(n>0) {
            binary[i++]=(n%2);
            n=n/2;
        }

        return binary;
    }

    public int minFlips(int a, int b, int c) {

        //calculate the diseried and current also a and b in binary
        int[] desired = decimalToBinary(c);
        int[] current = decimalToBinary(a|b);
        int[] aBinary = decimalToBinary(a);
        int[] bBinary = decimalToBinary(b);

        int operationsNeeded=0;

        for(int i=0;i<32;i++) {

            //if current and expected are not equal
            if(desired[i]!=current[i]) {

                //if we want 1 and we have 0 that means both are 0 and we can make any one of them as 1
                //so only one operation needed
                if(desired[i]==1 && current[i]==0) {
                    operationsNeeded+=1;
                }

                //if desired is 0 and current is 1
                if(desired[i]==0 && current[i]==1) {

                    //if both are one then we need to make both as 0
                    if(aBinary[i]==1 && bBinary[i]==1) {
                        operationsNeeded+=2;
                    }

                    //else we only need to make one of them as 0
                    else {
                        operationsNeeded+=1;
                    }
                }
            }
        }

        return operationsNeeded;
    }
}
