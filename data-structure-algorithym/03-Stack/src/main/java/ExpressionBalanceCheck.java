import java.util.Scanner;

public class ExpressionBalanceCheck {
    public static void main(String[] args) {
        System.out.println("Enter expression : ");
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.next();
        System.out.println(balance(expression));

    }
    //O(n)
    public static boolean balance(String expression) {
        var myStack = new MyStack<Character>();
        for (int i = 0; i < expression.length(); i++) {
            Character ch = expression.charAt(i);
            if (ch != '(' && ch != '[' && ch != '{' && ch != ')' && ch != ']' && ch != '}') {
                continue;
            }
            if (ch == '(' || ch == '[' || ch == '{') {
                //push opening symbol to stack
                myStack.push(ch);
                continue;
            }
            //at this point the stack shouldn't be empty
            if (myStack.isEmpty()) return false;
            else {
                Character match;
                switch (ch) {
                    case ')':
                        match = myStack.pop();
                        if (match != '(') return false;
                        break;
                    case ']':
                        match = myStack.pop();
                        if (match != '[') return false;
                        break;
                    case '}':
                        match = myStack.pop();
                        if (match != '{') return false;
                        break;
                }
            }
        }


        return myStack.isEmpty();
    }
}
