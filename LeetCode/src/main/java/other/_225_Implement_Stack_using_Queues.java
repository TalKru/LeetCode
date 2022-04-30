package other;

import java.util.LinkedList;
import java.util.Queue;

/*
Implement a last-in-first-out (LIFO) stack using only two queues. The implemented stack should support all the functions of a normal stack (push, top, pop, and empty).

Implement the MyStack class:

void push(int x) Pushes element x to the top of the stack.
int pop() Removes the element on the top of the stack and returns it.
int top() Returns the element on the top of the stack.
boolean empty() Returns true if the stack is empty, false otherwise.
Notes:

You must use only standard operations of a queue, which means that only push to back, peek/pop from front, size and is empty operations are valid.
Depending on your language, the queue may not be supported natively. You may simulate a queue using a list or deque (double-ended queue) as long as you use only a queue's standard operations.
 

Example 1:

Input
["MyStack", "push", "push", "top", "pop", "empty"]
[[], [1], [2], [], [], []]
Output
[null, null, null, 2, 2, false]

Explanation
MyStack myStack = new MyStack();
myStack.push(1);
myStack.push(2);
myStack.top(); // return 2
myStack.pop(); // return 2
myStack.empty(); // return False
 

Constraints:

1 <= x <= 9
At most 100 calls will be made to push, pop, top, and empty.
All the calls to pop and top are valid.
*/
public class _225_Implement_Stack_using_Queues {

	public static void main(String[] args) {
		
		MyStack obj = new MyStack();
		obj.push(1);
		obj.push(2);
		//obj.push(3);
		//obj.push(4);
		
		System.out.println(obj.pop());
		System.out.println(obj.top());
		
		
	}

}




class MyStack {
	
	private Queue<Integer> q1; 
	private Queue<Integer> q2; 
	private int top;
	private boolean inQ1 = true;
	
    public MyStack() {
        this.q1 = new LinkedList<>();
        this.q2 = new LinkedList<>();
        this.inQ1 = true;
    }
    
    public void push(int x) {
    	
    	this.top = x;
    	
        if(inQ1 == true) {
        	q1.add(x);
        }
        else { // q2 is empty
        	q2.add(x);
        }
    }
    
    public int pop() {
    	
    	if(inQ1 == false) {
    		while(q2.size() > 1) {
    			this.top = q2.poll();
    			q1.add(top);
    		}
    		// 1 element left, its what we need to retrieve
    		inQ1 = true; // flip to work with other queue
    		return q2.poll();
    	}
    	else {// q2 is empty
    		while(q1.size() > 1) {
    			this.top = q1.poll();
    			q2.add(top);
    		}
    		inQ1 = false;
    		return q1.poll();
    	}
    }
    
    public int top() {
    	
    	return this.top;
    }
    
    public boolean empty() {
        if(q1.isEmpty() && q2.isEmpty()) {
        	return true;
        }
        return false;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */























