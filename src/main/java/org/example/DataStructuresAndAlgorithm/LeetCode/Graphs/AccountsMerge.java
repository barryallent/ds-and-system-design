package org.example.DataStructuresAndAlgorithm.LeetCode.Graphs;

import java.util.*;

public class AccountsMerge {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();

        DisjointSet ds = new DisjointSet(n);

        //map to store email and which node it belongs to
        Map<String,Integer> mailMap = new HashMap<>();

        //we will iterate on each email and if we get same email again that means
        //the person this second email belongs to is the same person as the first person this email
        //belongs to
        for(int i=0;i<n;i++) {
            for(int j=1;j<accounts.get(i).size();j++) {
                String mail = accounts.get(i).get(j);

                //if mail is received 1st time then add it to map
                if(!mailMap.containsKey(mail)) {
                    mailMap.put(mail,i);
                }

                //if already present in map that means its seen second time and is part of some
                //other node so we can union these 2 nodes, node we can get from map
                else {
                    ds.unionBySize(i,mailMap.get(mail));
                }
            }
        }

        //create this mergedaccount list and add all the map values to this
        List<List<String>> mergedAccounts = new ArrayList<>();

        for(int i=0;i<n;i++) {
            mergedAccounts.add(new ArrayList<>());
        }

        for(Map.Entry<String,Integer> entry: mailMap.entrySet()) {

            //key will be the string
            String mail = entry.getKey();
            //and now where to add this email, we will know from disjoint set. Basically since
            //required nodes are merged we can get which node this email belongs to by getting
            //the ultimate parent
            int node = ds.findUltimateParent(entry.getValue());

            //once we know where to add this email, we add it to that list
            mergedAccounts.get(node).add(mail);
        }


        //now we have to create mergedlist with name and also sorted
        List<List<String>> mergedAccountsWithName = new ArrayList<>();

        for(int i=0;i<n;i++) {

            //if merged list is empty that means this index was merged with parent so skip it
            if(mergedAccounts.get(i).size()!=0) {

                //create temp list and add name to it from the original list
                List<String> temp = new ArrayList<>();
                String name = accounts.get(i).get(0);
                temp.add(name);

                //sort the list as asked in question and add to temp
                Collections.sort(mergedAccounts.get(i));
                for(String j:mergedAccounts.get(i)) {
                    temp.add(j);
                }

                //add this temp list to list of list
                mergedAccountsWithName.add(temp);
            }
        }

        return mergedAccountsWithName;

    }
}
