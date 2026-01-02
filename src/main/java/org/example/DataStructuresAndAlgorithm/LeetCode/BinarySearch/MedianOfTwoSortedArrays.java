package org.example.DataStructuresAndAlgorithm.LeetCode.BinarySearch;

//https://leetcode.com/problems/median-of-two-sorted-arrays/
public class MedianOfTwoSortedArrays {
        //we will try to partition the combined array in 2 equal parts. Lets say total elements in num1
        //and nums2 are n so when we make 2 parts, left part will contain n/2 elements. Now out of these
        //elements some will be from nums1 lets say x and remaining n/2-x will be from nums2.
        //Both x and n/2-x will be first elements from nums1 and nums2 respectivelt.
        //Now whats the catch here, its that we can pick 0 elements from nums1, 1 element from nums1...
        //n/2-x elements from nums1. So we can do this linearly but wait why we need to do this linearly
        //we can apply binary search on this. Yes binary search on how many elements to take from nums1
        // and then we will take remaining elements from nums2 then we will have the left and right side
        //ready and we check if this is a valid partition.
        //Now to to reduce search space, we can do that by this. If nums1 greatest element is larger than
        //nums2 smallest on right side that means we have taken some elements extra so make end=mid-1 to
        //take less elements and if nums2 greatest element is greater than nums1 smallest element on right
        //partition that means we have taken more elements in nums2 so we need to dec that so inc
        // number of elements taken in nums1 so make start=mid+1
        //and once partition is done we can easily calculate median based on even and odd elements
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {

            int n1 = nums1.length;
            int n2 = nums2.length;

            //for this logic num1 must be the smaller array
            //because totalElementsToTake-mid should be greater than 0
            //if nums1=[1,2,3,4,5,6] nums[2]=[]
            //then totalElementsToTake-mid will not be valid
            if(n1>n2) {
                return findMedianSortedArrays(nums2,nums1);
            }

            int totalElements = n1+n2;
            int totalElementsToTake=(n1+n2)/2;

            //total elements we can take from nums1 is b/w 0 and total size of nums1
            //but if total elements to take is less than n1 then that will be end
            //so we take min of both
            int start = 0;
            int end = Math.min(n1, totalElementsToTake);

            while (start <= end) {
                int mid = start + (end - start) / 2;

                //if we take mid elements then nums1 left partition will have mid elements
                //so largest element in the partition has mid-1 index
                //similarly nums2 left will have totalElementsToTake-mid elements and index of last would
                //be totalElementsToTake-mid-1
                double nums1LeftLargest = mid-1>=0 ? nums1[mid-1] : Double.NEGATIVE_INFINITY;
                double nums2LeftLargest = totalElementsToTake-mid-1>=0
                        ? nums2[totalElementsToTake-mid-1] : Double.NEGATIVE_INFINITY;

                //right index would be the left partition index + 1
                double nums1RightSmallest = mid<n1 ? nums1[mid] : Double.MAX_VALUE ;
                double nums2RightSmallest =totalElementsToTake-mid<n2
                        ? nums2[totalElementsToTake-mid] : Double.MAX_VALUE;

                //if nums1 left partition is bigger than nums2 right that means we have more elements
                //this means mid should reduce
                if(nums1LeftLargest>nums2RightSmallest) {
                    end=mid-1;
                }

                //take less elements
                else if(nums2LeftLargest>nums1RightSmallest) {
                    start=mid+1;
                }

                //we have valid partitions so find median
                else {

                    //if odd elements, left partition will have less elements because if element=7
                    //then mid is 3 so right side will have more always. And we want just the bigger
                    //element so min of both elements on right
                    if(totalElements%2!=0) {
                        return Math.min(nums1RightSmallest, nums2RightSmallest);
                    }

                    //if even then we need the rightmost from left partition and leftmost from
                    //right partition and take average of them
                    else {
                        double rightMostElementPartition1=Math.max(nums1LeftLargest, nums2LeftLargest);
                        double leftMostElementPartition2=Math.min(nums1RightSmallest, nums2RightSmallest);
                        return  (rightMostElementPartition1+leftMostElementPartition2)/2;
                    }
                }
            }
            return 0;
        }
}
