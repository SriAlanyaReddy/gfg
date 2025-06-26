class Solution {
    public ArrayList<Integer> nextLargerElement(int[] a) {
        // code here
        int n=a.length;
        ArrayList<Integer>ans=new ArrayList<>();
        Stack<Integer>st=new Stack<>();
        for(int i=n-1;i>=0;i--){
           
           
            while(!st.isEmpty() && a[i]>=st.peek() ){
                    st.pop();
            }
                    
            if(st.isEmpty()){
                ans.add(-1);
            }
            else if(a[i]<st.peek()){
                ans.add(st.peek());
               
            }
             st.push(a[i]);
        }
        Collections.reverse(ans);
        
        return ans;
        
    }
}