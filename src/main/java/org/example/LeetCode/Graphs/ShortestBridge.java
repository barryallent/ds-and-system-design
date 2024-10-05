package org.example.LeetCode.Graphs;

import java.util.*;

//https://leetcode.com/problems/shortest-bridge/
public class ShortestBridge {
    int m, n;

    //function to mark all 1s as 2 for an island and push to queue
    void markFistIsland(int i, int j, int[][] grid, boolean[][] visited, Queue<int[]> q1) {
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || grid[i][j] == 0) {
            return;
        }

        grid[i][j] = 2;
        q1.add(new int[]{i,j});
        visited[i][j]=true;

        markFistIsland(i + 1, j, grid, visited, q1);
        markFistIsland(i - 1, j, grid, visited, q1);
        markFistIsland(i, j + 1, grid, visited, q1);
        markFistIsland(i, j - 1, grid, visited, q1);
    }

    public int shortestBridge(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        Queue<int[]> q1 = new LinkedList<>();

        boolean found = false;

        //mark 1st island as all 2s so that we can distinguish b/w first and second
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    found=true;
                    markFistIsland(i, j, grid, new boolean[m][n],q1);
                    break;
                }
            }
            if(found) break;
        }

        int minBridgeDistance = 0;

        boolean[][] visited = new boolean[m][n];

        //for each point in queue go level by level and when you got a 1 that means
        //you reached second island
        while(!q1.isEmpty()) {
            int size = q1.size();
            for(int i=0;i<size;i++) {
                int[] topElement = q1.poll();
                int x = topElement[0]; int y=topElement[1];

                if(visited[x][y]) {
                    continue;
                }

                visited[x][y]=true;

                if(grid[x][y]==1) {
                    return minBridgeDistance-1;
                }

                if(x+1<m) {
                    q1.offer(new int[]{x+1,y});
                }
                if(x-1>=0) {
                    q1.offer(new int[]{x-1,y});
                }
                if(y-1>=0) {
                    q1.offer(new int[]{x,y-1});
                }
                if(y+1<n) {
                    q1.offer(new int[]{x,y+1});
                }
            }
            minBridgeDistance++;
        }

        return -1;

    }
}
