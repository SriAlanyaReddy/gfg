//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestkSubstr(String s, int k) {
        // code here
        int r=0;
        int l=0;
        int max=-1;
        HashMap<Character,Integer>mp=new HashMap<>();
        int n=s.length();
        while(r<n){
            mp.put(s.charAt(r),mp.getOrDefault(s.charAt(r),0)+1);
            if(mp.size()>k){
                mp.put(s.charAt(l),mp.get(s.charAt(l))-1);
                if(mp.get(s.charAt(l))==0)mp.remove(s.charAt(l));
                l++;
            }
            if(mp.size()==k)
            max=Math.max(r-l+1,max);
            r++;
        }
        return max;
    }
}