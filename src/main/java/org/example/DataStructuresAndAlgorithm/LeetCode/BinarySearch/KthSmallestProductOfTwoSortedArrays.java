package org.example.DataStructuresAndAlgorithm.LeetCode.BinarySearch;

//https://leetcode.com/problems/kth-smallest-product-of-two-sorted-arrays/description/
public class KthSmallestProductOfTwoSortedArrays {
    class Solution {

        // upper bound: first index where nums[idx] > target
        int upperBound(int[] nums, long target) {
            int start = 0;
            int end = nums.length;
            while (start < end) {
                int mid = start + (end - start) / 2;
                if ((long) nums[mid] > target) {
                    end = mid;
                } else {
                    start = mid + 1;
                }
            }
            return end;
        }

        // lower bound: first index where nums[idx] >= target
        int lowerBound(int[] nums, long target) {
            int start = 0;
            int end = nums.length;
            while (start < end) {
                int mid = start + (end - start) / 2;
                if ((long) nums[mid] >= target) {
                    end = mid;
                } else {
                    start = mid + 1;
                }
            }

            return end;
        }

        /*
         * Counts how many pairs (a, b) exist such that:
         *      a ∈ nums1, b ∈ nums2
         *      and a * b <= x
         *
         * IMPORTANT:
         * - nums1 and nums2 are sorted
         * - This function MUST be monotonic in x
         *   (i.e., as x increases, count never decreases)
         *
         * This monotonicity is what allows us to binary search on the answer.
         */
        long countProductsLessThanOrEqualX(int[] nums1, int[] nums2, long x) {
            long count = 0;

            // Pick one element from nums1 and count valid partners in nums2
            for (int a : nums1) {

                /*
                 * CASE 1: a == 0
                 *
                 * 0 * b = 0 for any b
                 * - If x >= 0, then ALL nums2 elements form valid products
                 * - If x < 0, then NONE are valid
                 */
                if (a == 0) {
                    if (x >= 0) {
                        count += nums2.length;
                    }
                }

                /*
                 * CASE 2: a > 0
                 *
                 * We want:
                 *      a * b <= x
                 *  =>  b <= x / a
                 *
                 * Since nums2 is sorted, we can binary search
                 * the first index where nums2[idx] > (x / a)
                 *
                 * upperBound(nums2, limit) gives:
                 * - number of elements <= limit
                 */
                else if (a > 0) {
                    long limit = Math.floorDiv(x, a);
                    count += upperBound(nums2, limit);
                }

                /*
                 * CASE 3: a < 0
                 *
                 * Inequality flips when dividing by a negative number:
                 *
                 *      a * b <= x
                 *  =>  b >= x / a
                 *
                 * lowerBound(nums2, limit) gives:
                 * - first index where nums2[idx] >= limit
                 *
                 * So all elements from that index to the end are valid
                 */
                else if (a < 0) {
                    long limit = Math.floorDiv(x + a + 1, a);
                    int index = lowerBound(nums2, limit);
                    count += nums2.length - index;
                }
            }

            return count;
        }


        // We are NOT generating all n1 * n2 products (too slow).
        // Instead, we binary search on the VALUE of the answer (the product itself).
        //
        // Let f(x) = number of pairs (i, j) such that
        //            nums1[i] * nums2[j] <= x
        //
        // Observation:
        // f(x) is MONOTONIC:
        // - If f(x) >= k, then for any y > x, f(y) will also be >= k
        // - If f(x) < k, then for any y < x, f(y) will also be < k
        //
        // Because of this monotonicity, we can binary search on x.
        public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
            int n1 = nums1.length;
            int n2 = nums2.length;
            long start = Math.min(Math.min((long) nums1[0] * nums2[n2 - 1], (long) nums1[n1 - 1] * nums2[0]),
                    Math.min((long) nums1[n1 - 1] * (long) nums2[n2 - 1], nums1[0] * nums2[0]));
            long end = Math.max(Math.max((long) nums1[0] * nums2[n2 - 1], (long) nums1[n1 - 1] * nums2[0]),
                    Math.max((long) nums1[n1 - 1] * nums2[n2 - 1], (long) nums1[0] * nums2[0]));

            while (start < end) {
                long mid = start + (end - start) / 2;

                // Count how many products are <= mid
                // mid is large enough to include at least k products
                // So the answer could be mid or something smaller
                if (countProductsLessThanOrEqualX(nums1, nums2, mid) >= k) {
                    end = mid;
                }
                // mid is too small, fewer than k products are <= mid
                // So the answer must be larger
                else {
                    start = mid + 1;
                }
            }

            return end;
        }
    }
}
