//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tc = scanner.nextInt();
        
        while (tc-- > 0) {
            int V = scanner.nextInt();
            int E = scanner.nextInt();
            
            List<Integer>[] adj = new ArrayList[V];
            for (int i = 0; i < V; i++) {
                adj[i] = new ArrayList<>();
            }
            
            for (int i = 0; i < E; i++) {
                int u = scanner.nextInt();
                int v = scanner.nextInt();
                adj[u].add(v);
                adj[v].add(u);
            }
            
            // String x=scanner.nextLine();
            // scanner.nextLine();
            
            Solution obj = new Solution();
            int ans = obj.isEulerCircuit(V, adj);
            System.out.println(ans);
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


class Solution{
    public int isEulerCircuit(int v, List<Integer>[] adj) 
    {
        // code here// Code here
        boolean visited[]=new boolean[v];
        dfs(0,visited,adj);
        for(int i=0;i<v;i++){
            if(adj[i].size() > 0 &&!visited[i])return 0;
        }
        int odd=0;
        for(int i=0;i<v;i++){
            if(adj[i].size()%2!=0){
               odd++;
            }
            if(odd>2)return 0;
        }
        return odd==2 ?1:2;
    }
    public static void dfs(int node,boolean[] visited,List<Integer>[] adj){
        visited[node]=true;
        for(int adjnode:adj[node]){
            if(!visited[adjnode]){
                dfs(adjnode,visited,adj);
            }
        }
    
    }
}