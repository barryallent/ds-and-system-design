package org.example.DataStructuresAndAlgorithm.LeetCode.Greedy;

import java.util.Arrays;

public class BoatsToSavePeople {
    public int numRescueBoats(int[] people, int limit) {

        //sort the array. Idea is that we will have 2 pointers one at lightest and one at heaviest.
        //Best option is that we sit the heaviest person with lightest, because we anyways have to sit
        //2 people. So if we are able to sit the lightest with heaviest then we move both pointers
        //otherwise if sum of both weights is greater than limit that means we cannot have one more
        //person so move only the right pointer
        Arrays.sort(people);

        int n = people.length;

        int r=n-1,l=0;

        int numberOfBoats=0;

        while(r>=l) {
            //check heaviest and lightest person weights
            int weight1=people[r];
            int weight2=people[l];

            //able to sit them together
            if(weight1+weight2<=limit) {
                l++;
                r--;
                numberOfBoats++;
            }

            //not able to sit them together so sit only heaviest
            else {
                r--;
                numberOfBoats++;
            }
        }

        return numberOfBoats;

    }
}
