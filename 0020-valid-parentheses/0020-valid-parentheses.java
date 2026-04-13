class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] ch = s.toCharArray();
        stack.push(ch[0]);
        for(int i =1; i<ch.length; i++)
        {
            if(!stack.isEmpty() && ch[i] == ')' && stack.peek() == '(' || !stack.isEmpty() &&
                ch[i] == '}' && stack.peek() == '{'|| !stack.isEmpty() &&
                ch[i] == ']' && stack.peek() == '['
                )
                    stack.pop();
                else
                    stack.push(ch[i]);   
        }
        if (stack.isEmpty())
            return true;
        else
            return false;
    }
}