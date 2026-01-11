package org.example.DataStructuresAndAlgorithm.LeetCode.Heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeSet;

//https://leetcode.com/problems/find-servers-that-handled-most-number-of-requests/
public class FindServersThatHandledMostNumberOfRequests {
        public List<Integer> busiestServers(int k, int[] arrival, int[] load) {

            //TreeSet for availableservers, important to remove complexity of O(n*k) to O(nlogk)
            //initially make all k servers available
            TreeSet<Integer> availableServers = new TreeSet<>();
            for(int i=0;i<k;i++) {
                availableServers.add(i);
            }

            //count requests per server
            int[] countRequestsPerServer = new int[k];

            //queue to track running requests (endTime, server)
            PriorityQueue<int[]> runningRequests = new PriorityQueue<>((a, b)->Integer.compare(a[0],b[0]));

            for(int i=0;i<arrival.length;i++) {

                //before arrival check what all servers got free
                while(!runningRequests.isEmpty() && runningRequests.peek()[0]<=arrival[i]) {
                    int[] completedRequests = runningRequests.poll();
                    int server = completedRequests[1];
                    availableServers.add(server);
                }

                //no available server
                if(availableServers.size()==0) continue;


                //get next available server from TreeSet
                //ceiling gives next bigger number than target,
                //if no bigger number then we take 0 because available servers is not empty
                int targetServer = i%k;

                Integer server = availableServers.ceiling(targetServer);

                if(server==null) {
                    server=availableServers.first();
                }

                //add requests to queue and update availableServers
                runningRequests.add(new int[] {arrival[i]+load[i], server});
                countRequestsPerServer[server]++;
                availableServers.remove(server);

            }

            //Find busiest servers
            List<Integer> busiestServers = new ArrayList<>();

            //first find maxrequest among all servers
            int maxRequests=0;
            for (int i = 0; i < k; i++) {
                maxRequests = Math.max(maxRequests,countRequestsPerServer[i]);
            }

            //check how many servers have this max request, those are busiest.
            for(int i=0;i<k;i++) {
                if(countRequestsPerServer[i]==maxRequests) {
                    busiestServers.add(i);
                }
            }

            return busiestServers;
        }
}
