package stack;

public class StackImpl {
    int top = -1;
    int[] stack =  new int[10];

    public void push(int item) {
        if(top < stack.length-1) {
            stack[++top] = item;
        }
        else {
            System.out.println("Stack is overflowed");
        }
    }

    public void pop() {
        if(isEmpty()){
            System.out.println("Stack underflow");
        }
        else{
            System.out.println("Removed element form the stack is "+stack[top]);
            top--;
        }
    }

    private boolean isEmpty() {
        return top == -1;
    }
    public void peek() {
        if(isEmpty()) {
            System.out.println("Stack underflow");
            return;
        }
        System.out.println("Element at the top of the stack is "+stack[top]);
    }

    public void print() {
        if(isEmpty()) {
            System.out.println("There is no element in the stack");
            return;
        }
        System.out.print("Element in stacks are: ");
        for( int i = 0 ; i<= top; i++) {
            System.out.print(stack[i]+ " " );
        }
        System.out.println();
    }
}
