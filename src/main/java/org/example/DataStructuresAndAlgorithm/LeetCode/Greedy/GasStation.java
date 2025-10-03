package org.example.DataStructuresAndAlgorithm.LeetCode.Greedy;

//https://leetcode.com/problems/gas-station/
public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int n=gas.length;

        int[] fuelDifference = new int[n];

        //calculate difference of fuel and cost, that means this much fuel will be added or removed
        //at each station
        for(int i=0;i<n;i++) {
            fuelDifference[i]=gas[i]-cost[i];
        }

        //check if total fuel is less than 0 then we can never reach circular trip
        //and if its greater than 0 then we can always complete circular trip
        int totalFuelDiff=0;

        for(int i:fuelDifference) {
            totalFuelDiff+=i;
        }

        //cannot complete circular trip
        if(totalFuelDiff<0) {
            return -1;
        }

        //track fuel at each point and if it becomes negative that means we cannot reach from current
        //start to this index, and not just the current start — no station between start
        // and i could ever work because you would have less gas if you excdule start and b/w index
        //so we reset it and our starting point can be next index
        int currentGas=0;
        int start=0;

        for(int i=0;i<n;i++) {
            currentGas+=fuelDifference[i];

            //this is kinda like kadane's also
            if(currentGas<0) {
                currentGas=0;
                start=i+1;
            }
        }


        return start;



    }
}
