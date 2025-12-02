/*
class Node {
    int data;
    Node left, right;

    Node(int val)
    {
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    public static int floor(Node root, int k) {
        // code here
        int floor=-1;
        while(root!=null){
            if(root.data==k){
                return k;
            }
            else if(root.data>k){
                root=root.left;
                
            }
            else{
                floor=root.data;
                root=root.right;
            }
        }
        return floor;
    }
}