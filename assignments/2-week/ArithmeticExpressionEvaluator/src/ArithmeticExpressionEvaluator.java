// The input arithmetic expression can be separated by spaces so it can just be a string like "( 14 + 8 )"
// i.e. ( 14 + 8 ) * ( 8 - 4 ) / ( ( 6 - 2 * 2 ) * ( 1 + 2 ) )
// Convert it to a postfix expression like "14 8 +"
// then evaluate it

public class ArithmeticExpressionEvaluator {
    public static void evaluate(String infix) {
        System.out.println(infix);
    }

    public static void main(String[] args) {
        evaluate("( 14 + 8 ) * ( 8 - 4 ) / ( ( 6 - 2 * 2 ) * ( 1 + 2 ) )");
    }
}
