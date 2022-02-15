// The input arithmetic expression can be separated by spaces so it can just be a string like "( 14 + 8 )"
// i.e. ( 14 + 8 ) * ( 8 - 4 ) / ( ( 6 - 2 * 2 ) * ( 1 + 2 ) )
// Create a linked-list stack that can hold all the elements of the infix expression
// Iterate over infix.split(" ")
// If char == (, push it in stack
// If char == ), pop until ( is popped
// If char == #, push it in stack
// If char == operator, pop until element of lower precedence is reached
// Convert it to a postfix expression like "14 8 + 8 4 - * 6 2 2 * – 1 2 + * /"
// then evaluate it

public class ArithmeticExpressionEvaluator {
    public static void main(String[] args) {
        evaluate("( 14 + 8 ) * ( 8 - 4 ) / ( ( 6 - 2 * 2 ) * ( 1 + 2 ) )");
    }

    public static void evaluate(String infix) {
        System.out.println(infix);
        ArithmeticExpressionEvaluator evaluator = new ArithmeticExpressionEvaluator();
        InfixToPostfix postfix = evaluator.new InfixToPostfix(infix);
        System.out.println(postfix.postfixStr);

    }

    private class InfixToPostfix {
        private int stackSize;
        private String[] infixArr;
        private Node stackHead;
        private String postfixStr = "";

        private InfixToPostfix(String infix) {
            infixArr = infix.split(" ");

            for (String item : infixArr) {
                switch (item) {
                    case "(":
                        push(item);
                        break;
                    case ")":
                        while (!stackHead.item.equals("(")) {
                            pop();
                        }
                        pop();
                        break;
                    case "^", "*", "/", "+", "-":
                        if (isEmpty() || stackHead.item.equals("("))
                            push(item);
                        else {
                            while (stackHead != null && (assignPriority(item) <= assignPriority(stackHead.item))) {
                                pop();
                            }
                            push(item);
                        }
                        break;
                    default:
                        postfixStr += item + " ";

                }
            }
            while (stackHead != null) {
                pop();
            }
        }

        private void push(String item) {
            Node newNode = new Node(item);
            if (isEmpty()) {
                stackHead = newNode;
            } else {
                Node oldHead = stackHead;
                stackHead = newNode;
                newNode.next = oldHead;
            }
            stackSize++;
        }

        private void pop() {
            String item = stackHead.item;
            stackHead = stackHead.next;
            if (!item.equals("(")) {
                postfixStr += item + " ";
            }
            stackSize--;
        }

        private boolean isEmpty() {
            return stackHead == null;
        }

        private class Node {
            String item;
            Node next;

            private Node(String item) {
                this.item = item;
            }
        }

        private int assignPriority(String operator) {
            switch (operator) {
                case "^":
                    return 3;
                case "*":
                case "/":
                    return 2;
                case "+":
                case "-":
                    return 1;
                default:
                    return 0;
            }
        }
    }
}
