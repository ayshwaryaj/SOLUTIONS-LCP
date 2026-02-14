class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>(); 
        for (String token:tokens){
            if(token.equals("+") || token.equals("-") || token.equals("*")|| token.equals("/"))
            {
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                switch(token){
                    case "+":
                        stack.push(Integer.toString(num1+num2));
                        break;
                    case "-":
                        stack.push(Integer.toString(num1-num2));
                        break;
                    case "*":
                        stack.push(Integer.toString(num1*num2));
                        break;
                    case "/":
                        stack.push(Integer.toString(num1/num2));
                        break;
                }
            }
            else
                stack.push(token);
        }
    return Integer.parseInt(stack.peek());
}
}