package org.example.DataStructuresAndAlgorithm.LeetCode.String;

//https://leetcode.com/problems/complex-number-multiplication/description/
public class ComplexNumberMultiplication {
    public String complexNumberMultiply(String num1, String num2) {

        //split complex number
        String[] complex1 = num1.split("\\+");
        String[] complex2 = num2.split("\\+");

        //extract real and imaginary part from complex number1
        int realPart1=0,realPart2=0,imaginaryPart1=0,imaginaryPart2=0;
        try{
            realPart1 = Integer.parseInt(complex1[0]);
            imaginaryPart1 = Integer.parseInt(complex1[1].substring(0,complex1[1].length()-1));
        }

        catch (NumberFormatException e) {
            System.out.println("Invalid integer: ");
        }

        //extract real and imaginary part from complex number2
        try{
            realPart2 = Integer.parseInt(complex2[0]);
            imaginaryPart2 = Integer.parseInt(complex2[1].substring(0,complex2[1].length()-1));
        }

        catch (NumberFormatException e) {
            System.out.println("Invalid integer: ");
        }

        // System.out.println("realPart1="+realPart1+"realPart2="+realPart2);
        // System.out.println("imaginaryPart1="+imaginaryPart1+"imaginaryPart2="+imaginaryPart2);


        //multiply complex numbers
        int answerRealPart = realPart1*realPart2+imaginaryPart1*imaginaryPart2*(-1);
        int answerImaginaryPart = realPart1*imaginaryPart2+imaginaryPart1*realPart2;

        return answerRealPart+"+"+answerImaginaryPart+"i";
    }
}
