//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isEularCircuitExist(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public boolean isEularCircuitExist(int v, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean visited[]=new boolean[v];
        dfs(0,visited,adj);
        for(int i=0;i<v;i++){
            if(adj.get(i).size() > 0 &&!visited[i])return false;
        }
        for(int i=0;i<v;i++){
            if(adj.get(i).size()%2!=0){
                return false;
            }
        }
        return true;
    }
    public static void dfs(int node,boolean[] visited,ArrayList<ArrayList<Integer>> adj){
        visited[node]=true;
        for(int adjnode:adj.get(node)){
            if(!visited[adjnode]){
                dfs(adjnode,visited,adj);
            }
        }
    }
}