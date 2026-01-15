class Stack{
    private int maxSize;
    private long [] stackArray;
    private int top;

    // Constructor untuk inisialisasi stack
    public Stack(int size ){
        this.maxSize=size;
        this.stackArray=new long[maxSize];
        this.top=-1;
    }
    public void push(long item){
        if(top < maxSize - 1){
            stackArray[++top] = item;
        }
    }
    public long pop() { 
        return stackArray[top--]; 
    } 
    public long peek() { 
        return stackArray[top];
    } 
    public boolean isEmpty() { 
        return (top == -1);
    } 
    public boolean isFull() { 
        return (top == maxSize - 1); 
    } 
}
class StackApp { 
    public static void main(String[] args) { 
        Stack theStack = new Stack(10);
        theStack.push(20);
        theStack.push(40);
        theStack.push(60);
        theStack.push(80);
        while (!theStack.isEmpty()) {
        long value = theStack.pop(); 
        System.out.print(value + " "); 
        } 
    } 
}