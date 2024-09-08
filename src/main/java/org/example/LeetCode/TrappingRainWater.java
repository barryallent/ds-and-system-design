package org.example.LeetCode;

public class TrappingRainWater {

    //we will go building by building and see how much water can be stored on top of it
    // the water that can be stored on top depends on left max height and right max height because they
    //will trap the water. so water stored will be Math.min(leftMax,rightMax)-height[i]
    //to calculate left and right max at any point we use prefixmax and suffixmax
    public static int trap(int[] height) {
        int n=height.length;

        //the prefixmax stores left max sum
        //if arr=[1,2,3,4,-1], so prefixMax=[1,2,3,4,4]
        int[] prefixMax = new int[n];

        //suffixmax stores max right sum
        //if arr=[1,2,3,4,-1], so prefixMax=[4,4,4,4,-1]
        int[] suffixMax = new int[n];

        //calculate prefixMax, keep comparing i-1 to current height, if get a bigger current height
        //then update
        prefixMax[0]=height[0];
        for(int i=1;i<n;i++) {
            prefixMax[i]=Math.max(prefixMax[i-1],height[i]);
        }

        //calculate suffixMax, start from end keep comparing i+1 with i if get bigger then update
        suffixMax[n-1]=height[n-1];
        for(int i=1;i<n;i++) {
            suffixMax[n-i-1]=Math.max(suffixMax[n-i],height[n-i-1]);
        }
        int totalWaterStored=0;


        //iterate heights to calculate water trapped at each i
        for(int i=0;i<n;i++) {

            //get right max and leftmax at current point
            int leftMax=prefixMax[i];
            int rightMax=suffixMax[i];

            int currentWaterStored=0;
            if(Math.min(leftMax,rightMax)>height[i]) {
                //current water stored at ith index
                currentWaterStored=Math.min(leftMax,rightMax)-height[i];
            }
            //add to total
            totalWaterStored+=currentWaterStored;
        }
        return totalWaterStored;
    }

    public static void main(String[] args) {
        int[] height = new int[] {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
    }
}
