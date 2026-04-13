class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        //String result = "";
        char[] ch = s.toCharArray();
        stack.push(ch[0]);
        for(int i =1; i<ch.length; i++)
        {
            if (!stack.isEmpty() && ch[i] == stack.peek())
                stack.pop();
            else
                stack.push(ch[i]);
        }
        char[] ch1 = new char[stack.size()];
        for(int i =stack.size()-1; i>=0; i--)
        {
            ch1[i] = stack.pop();
        }
        String result = String.valueOf(ch1);
        return result;        
    }
}