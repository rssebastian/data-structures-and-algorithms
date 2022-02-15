public class ArithmeticExpressionEvaluator {
    public static void main(String[] args) {
        String testCase1 = "( 14 + 8 ) * ( 8 - 4 ) / ( ( 6 - 2 * 2 ) * ( 1 + 2 ) )";
        evaluate(testCase1);
        System.out.println("Test Case 1 should equal: " + Double.valueOf((double) 88 / 6));

        String testCase2 = "( 6 - 9 ) * ( 4 + 1 ) + 2 * ( 5 + 4 ) - 9 / 3 * 4 ";
        evaluate(testCase2);
        System.out.println("Test Case 2 should equal: " + (-9.0));

        String testCase3 = "( 1 * 2 ) * 2 ^ 4 + 2 / ( 2 + 6 ) - 0 / 3 + 4 ";
        evaluate(testCase3);
        System.out.println(
                "Test Case 3 should equal: " + Double.valueOf(36 + ((double) 2 / 8)));
    }

    public static void evaluate(String infix) {
        System.out.println(infix);
        ArithmeticExpressionEvaluator evaluator = new ArithmeticExpressionEvaluator();
        InfixToPostfix postfix = evaluator.new InfixToPostfix(infix);
        System.out.println(postfix.postfixStr);
        EvaluatePostfix value = evaluator.new EvaluatePostfix(postfix.postfixStr);
        System.out.println(value.expressionValue);

    }

    private class InfixToPostfix {
        private Node stackHead;
        private String postfixStr = "";

        private InfixToPostfix(String infix) {

            for (String item : infix.split(" ")) {
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
        }

        private void pop() {
            String item = stackHead.item;
            stackHead = stackHead.next;
            if (!item.equals("(")) {
                postfixStr += item + " ";
            }
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

    private class EvaluatePostfix {
        private Node stackHead;
        private double expressionValue;

        private EvaluatePostfix(String postfix) {
            for (String item : postfix.split(" ")) {
                switch (item) {
                    case "^", "*", "/", "+", "-":
                        double operand2 = pop();
                        double operand1 = pop();
                        switch (item) {
                            case "^":
                                push(String.valueOf(Math.pow(operand1, operand2)));
                                break;
                            case "*":
                                push(String.valueOf(operand1 * operand2));
                                break;
                            case "/":
                                push(String.valueOf(operand1 / operand2));
                                break;
                            case "+":
                                push(String.valueOf(operand1 + operand2));
                                break;
                            case "-":
                                push(String.valueOf(operand1 - operand2));
                                break;
                        }
                        break;
                    default:
                        push(item);
                }
            }
            expressionValue = pop();
        }

        private void push(String item) {
            Node newNode = new Node(item);
            if (stackHead == null) {
                stackHead = newNode;
            } else {
                newNode.next = stackHead;
                stackHead = newNode;
            }
        }

        private double pop() {
            double item = stackHead.item;
            stackHead = stackHead.next;
            return item;
        }

        private class Node {
            private double item;
            private Node next;

            private Node(String item) {
                this.item = Double.valueOf(item);
            }
        }

    }
}

// TEST CASE OUTPUT
// ( 14 + 8 ) * ( 8 - 4 ) / ( ( 6 - 2 * 2 ) * ( 1 + 2 ) )
// 14 8 + 8 4 - * 6 2 2 * - 1 2 + * /
// 14.666666666666666
// Test Case 1 should equal: 14.666666666666666
// ( 6 - 9 ) * ( 4 + 1 ) + 2 * ( 5 + 4 ) - 9 / 3 * 4
// 6 9 - 4 1 + * 2 5 4 + * + 9 3 / 4 * -
// -9.0
// Test Case 2 should equal: -9.0
// ( 1 * 2 ) * 2 ^ 4 + 2 / ( 2 + 6 ) - 0 / 3 + 4
// 1 2 * 2 4 ^ * 2 2 6 + / + 0 3 / - 4 +
// 36.25
// Test Case 3 should equal: 36.25