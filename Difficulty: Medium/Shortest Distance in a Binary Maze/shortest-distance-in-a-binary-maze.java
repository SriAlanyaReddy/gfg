//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }
            int[] source = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                source[i] = x;
            }
            int[] dest = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                dest[i] = x;
            }
            Solution ob = new Solution();
            int ans = ob.shortestPath(grid, source, dest);
            System.out.println(ans);
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    int shortestPath(int[][] grid, int[] source, int[] dest) {

        // Your code here
        int n=grid.length;
        int m=grid[0].length;
        int INF=Integer.MAX_VALUE;
        if(source[0]==dest[0] && dest[1]==source[1])return 0;
        int dirx[]={1,-1,0,0};
        int diry[]={0,0,1,-1};
        int distance[][]=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                distance[i][j]=INF;
            }
        }
        distance[source[0]][source[1]]=0;
        Queue<int[]>q=new LinkedList<>();
        q.add(new int[]{0,source[0],source[1]});
        while(!q.isEmpty()){
            int dist=q.peek()[0];
            int x=q.peek()[1];
            int y=q.peek()[2];
            q.remove();
            for(int i=0;i<4;i++){
                int nx=x+dirx[i];
                int ny=y+diry[i];
                
                if(nx<n && ny<m && nx>=0 && ny>=0 && grid[nx][ny]==1 && 1+dist<distance[nx][ny]){
                    distance[nx][ny]=1+dist;
                    if(nx==dest[0] && ny==dest[1]) return dist+1;
                    q.add(new int[]{dist+1,nx,ny});
                    
                }
            }
        }
        return -1;
        
    }
}
