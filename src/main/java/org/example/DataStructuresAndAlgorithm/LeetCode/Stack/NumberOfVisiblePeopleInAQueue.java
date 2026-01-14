package org.example.DataStructuresAndAlgorithm.LeetCode.Stack;

import java.util.Stack;

//https://leetcode.com/problems/number-of-visible-people-in-a-queue/description/
public class NumberOfVisiblePeopleInAQueue {
     public int[] canSeePersonsCount(int[] heights) {

        // Number of people in the queue
        int n = heights.length;

        // Monotonic decreasing stack
        // Each element is: [height, index]
        //
        // Why stack?
        // We process people from left to right.
        // Stack helps us efficiently track "who is still blocking the view"
        // for people on the left.
        Stack<int[]> s1 = new Stack<>();

        // Result array:
        // heightsCanSee[i] = number of people person i can see to their right
        int[] heightsCanSee = new int[n];

        // Iterate through each person from left to right
        for (int i = 0; i < n; i++) {

            /*
             * CASE 1: Current person is taller than people in stack
             *
             * If heights[i] > stack top height:
             *   - Current person blocks the view for the shorter person
             *   - That shorter person can see the current person
             *   - But cannot see anyone beyond this
             *
             * Hence:
             *   - Pop the shorter person
             *   - Increment their visible count by 1
             *
             * Keep popping until:
             *   - Stack is empty OR
             *   - We find someone taller than current person
             */
            while (!s1.isEmpty() && heights[i] > s1.peek()[0]) {
                int[] topElement = s1.pop();
                heightsCanSee[topElement[1]]++;
            }

            /*
             * CASE 2: There is still someone in stack
             *
             * That person is taller than current person.
             * They can see the current person, but the view stops here.
             *
             * So we increment their count by 1.
             */
            if (!s1.isEmpty()) {
                heightsCanSee[s1.peek()[1]]++;
            }

            /*
             * Push current person onto stack
             *
             * This person may block the view for future people
             */
            s1.add(new int[]{heights[i], i});
        }

        // Return result
        return heightsCanSee;
    }
}
