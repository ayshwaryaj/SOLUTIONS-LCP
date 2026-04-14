class MyQueue {
    private Stack<Integer> stack;
    private Stack<Integer> QStack; 
    int y,z;
    public MyQueue() {
        stack = new Stack<>();
        QStack = new Stack<>();
    }
    
    public void push(int x) {
        stack.push(x);
    }
    
    public int pop() {
        while(stack.isEmpty() == false)
        {
            z = stack.pop();
            QStack.push(z);
        }
        if(!QStack.isEmpty())
            y= QStack.pop();
        while(QStack.isEmpty() == false)
        {
            z = QStack.pop();
            stack.push(z);
        }
        return y;
    }
    
    public int peek() {
        while(stack.isEmpty() == false)
        {
            z = stack.pop();
            QStack.push(z);
        }
        if(!QStack.isEmpty())
            y = QStack.peek(); 
        while(QStack.isEmpty() == false)
        {
            z = QStack.pop();
            stack.push(z);
        } 
        return y;
    }
    
    public boolean empty() {
        if(stack.isEmpty() && QStack.isEmpty())
            return true;    
        return false;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */