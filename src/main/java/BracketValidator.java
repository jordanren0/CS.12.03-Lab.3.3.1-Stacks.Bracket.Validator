import java.util.Stack;

public class BracketValidator {

    // Method called checkValidParentheses that returns a boolean indicating whether a string of brackets is valid or not.
    public static boolean checkValidParentheses(String expression) {

        // Obtain an array of the brackets (each element is a single bracket).

        // Create a stack.
        Stack<Character> stack = new Stack<>();

        // Iterate over the array of brackets.
        for (int i = 0; i < expression.length(); i++) {
            // Obtain the reversed version of bracket.
            // Check if the bracket is an opening bracket. If it is, push it onto the stack.
            // If the stack is empty or if the popped bracket is not equal to the reverse bracket of the current bracket, return false as this must mean that the expression is invalid.
            char c = expression.charAt(i);
            if (isLeftBracket(Character.toString(c))) {
                stack.push(c);
            }
            else {
                if (stack.isEmpty() || !getReversedBracket(Character.toString(stack.pop())).equals(Character.toString(c))) {
                    return false;
                }
            }
        }
        // If the stack is empty after we have finished iterating over the array of brackets, then return true as this must mean that the expression is valid. If the stack is not empty, this must mean that the expression is invalid.
        return stack.isEmpty();
    }

    // Private helper method called isLeftBracket that returns a boolean value to indicate whether the bracket is a left (opening) bracket.
    private static boolean isLeftBracket(String bracket) {
        return bracket.charAt(0) == '(' || bracket.charAt(0) == '[' || bracket.charAt(0) == '{';

    }

    // Private helper method called getReversedBracket that returns a String which is the reverse version of the bracket passed to the method.
    private static String getReversedBracket(String bracket) {
        if (bracket.equals("(")) return ")";
        else if (bracket.equals("[")) return "]";
        else return "}";
    }
}
