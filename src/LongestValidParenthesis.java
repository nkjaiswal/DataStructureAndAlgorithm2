import java.util.Stack;

public class LongestValidParenthesis {
    public static int longestValidParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        int max = 0;
        int localMax = 0;
        for(Character c : s.toCharArray()) {

            if(c == ')') {
                if(!stack.isEmpty()) {
                    stack.pop();
                    localMax++;
                } else {
                    max = Math.max(localMax, max);
                    localMax = 0;
                }
            } else {
                stack.push(c);
            }
        }
        return Math.max(localMax, max);
    }

    public static void main(String[] args) {
        System.out.println(longestValidParentheses("(())"));
        System.out.println(longestValidParentheses("()()"));
        System.out.println(longestValidParentheses("))(("));
        System.out.println(longestValidParentheses(")()("));
        System.out.println(longestValidParentheses(")())"));
    }
}
