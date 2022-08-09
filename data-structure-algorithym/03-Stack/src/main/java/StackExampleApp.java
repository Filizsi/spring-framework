public class StackExampleApp {
    public static void main(String[] args) {
        var myStack  = new MyStack<Integer>();
        myStack.push(3);
        myStack.push(8);
        myStack.push(5);
        System.out.println(myStack.size());
        //prints the last item I've inserted-->5 and also remove it from the stack
        System.out.println(myStack.pop());
        //prints the second last one also remove it from the stack
        System.out.println(myStack.pop());
        System.out.println(myStack.size());
    }

}
