//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m=sc.nextInt();
            int[][] edge = new int[m][2];
            for(int i=0;i<m;i++){
                edge[i][0]=sc.nextInt();
                edge[i][1]=sc.nextInt();
            }
            int src=sc.nextInt();
            Solution obj = new Solution();
            int res[] = obj.shortestPath(edge,n,m,src);
            for(int i=0;i<n;i++){
                System.out.print(res[i]+" ");
            }
            System.out.println();
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


class Solution {
    
    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        // Code here
        List<List<Integer>>adj=new ArrayList<>();
       
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<m;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int INF=Integer.MAX_VALUE;
        int[] distance=new int[n];
        Arrays.fill(distance,-1);
        distance[src]=0;
        Queue<Integer>q=new LinkedList<>();
        q.add(src);
        while(!q.isEmpty()){
            int current=q.poll();
            for(int adjnode:adj.get(current)){
                if(distance[adjnode]==-1){
                    distance[adjnode]=distance[current]+1;
                    q.add(adjnode);
                }
            }
        }
       
        return distance;
        
    }
}