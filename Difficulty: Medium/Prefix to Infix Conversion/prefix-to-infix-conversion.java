// User function Template for Java

class Solution {
    static String preToInfix(String s) {
        int n = s.length();
        int i = n - 1;
        Stack<String> st = new Stack<>();

        while (i >= 0) {
            char ch = s.charAt(i);

            if (Character.isLetterOrDigit(ch)) {
                st.push(String.valueOf(ch));
            } else {
                // Operator case
                String first = st.pop();
                String second = st.pop();
                String req = "(" + first + ch + second + ")";
                st.push(req);
            }
            i--;
        }

        return st.pop();
    }

    
}
