package org.example.DataStructuresAndAlgorithm.LeetCode.Heap;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

//https://leetcode.com/problems/task-scheduler/description/
public class TaskScheduler {
        public int leastInterval(char[] tasks, int n) {

            //calculate frequency of each task
            int[] taskFrequency = new int[26];
            for (char c : tasks) {
                taskFrequency[c - 'A']++;
            }


            //priority queue to store frequency of each task and last completed time
            //we are taking pq because we want to pick the tasks with maximum frequency first
            //because that needs to spread over eg if we have 3A, B, C, D and n=4 then if we place
            //BCD first then As have to wait so its better to place A whenever possible so its spread out
            //this is the whole crux

            //heap contains all the tasks that can be completed, if element is in heap then it can be
            //completed so no extra checks
            PriorityQueue<Integer> p1 = new PriorityQueue<>((a, b)->Integer.compare(b,a));


            //keep tasks in queue until cooldown
            //contains task frequency and availableTime for the task
            Queue<int[]> cooldownTasks = new LinkedList<>();

            //initialize pq with frequency, basically initially no cooldown check so adding all tasks
            for(int i=0;i<taskFrequency.length;i++) {
                //add only task that are present
                if(taskFrequency[i]>0) {
                    int currentTaskFrequency=taskFrequency[i];
                    p1.add(currentTaskFrequency);
                }
            }


            int taskCompleted = 0;
            int currentTime = 1;

            //till all tasks are not completed
            //so at each time we will check what all tasks can be completed
            while (taskCompleted < tasks.length) {

                //if task is cooled down then we can add back tasks to heap to consider again
                while(!cooldownTasks.isEmpty() && cooldownTasks.peek()[1]<=currentTime) {
                    p1.add(cooldownTasks.poll()[0]);
                }

                //complete te tasks in the heap
                if(!p1.isEmpty()) {
                    int frequencyOfTask = p1.poll();
                    taskCompleted++;

                    //complete the task and add in queue for cooldown.
                    if (frequencyOfTask - 1 > 0) {
                        cooldownTasks.add(
                                new int[]{frequencyOfTask - 1, currentTime + n + 1}
                        );
                    }

                }

                if (taskCompleted == tasks.length) {
                    return currentTime;
                }

                //increase the time
                currentTime++;
            }

            return currentTime;
        }
}
