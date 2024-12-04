//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Gfg
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            // arraylist of arraylist to represent graph
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            int V = Integer.parseInt(sc.next());
            int E = Integer.parseInt(sc.next());
            
            for(int i =0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
                
            for(int i = 1; i <= E; i++)
            {    int u = Integer.parseInt(sc.next());
                 int v = Integer.parseInt(sc.next());
                 
                 // adding directed edgese between 
                 // vertex 'u' and 'v'
                 adj.get(u).add(v);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.kosaraju(V, adj));
		
System.out.println("~");
}
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution

{  
    public void dfs(int node,Stack<Integer>st,boolean[] visited,ArrayList<ArrayList<Integer>> adj)
    {
        visited[node]=true;
        for(Integer adjnode:adj.get(node)){
            if(visited[adjnode]==false){
                dfs(adjnode,st,visited,adj);
            }
        }
        st.add(node);
    }
    public void dfs2(int node,boolean[] visited,ArrayList<ArrayList<Integer>> adj)
    {
        visited[node]=true;
        for(Integer adjnode:adj.get(node)){
            if(visited[adjnode]==false){
                dfs2(adjnode,visited,adj);
            }
        }
        
    }
    
    
    
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        //code here
        Stack<Integer>st=new Stack<>();
        boolean visited[]=new boolean[V];
        for(int i=0;i<V;i++){
            if(!visited[i]){
                dfs(i,st,visited,adj);
            }
        }
        ArrayList<ArrayList<Integer>>reverseGraph=new ArrayList<>();
        for(int i=0;i<V;i++){
            reverseGraph.add(new ArrayList<>());
        }
        for(int i=0;i<V;i++){
            visited[i]=false;
            for(Integer it:adj.get(i)){
                reverseGraph.get(it).add(i);
            }
        }
        int sc=0;
        while(!st.isEmpty()){
            int node=st.pop();
            if(visited[node]==false){
                sc++;
                dfs2(node,visited,reverseGraph);
            }
        }
        return sc;
    }
}
