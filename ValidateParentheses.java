/*
    not nested parentheses..
 */
public class Solution {
    public boolean isValid(String s) {
        if (s.length()<1) return true;
        LinkedList<Character> stack = new LinkedList<Character>();
        for (int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if (c=='{' || c=='[' || c=='(')
                stack.push(c);
            else {
                if (stack.isEmpty())  return false;
                switch (stack.pop()) {
                    case '{':
                        if (c!='}') return false;
                        break;
                    case '[':
                        if (c!=']') return false;
                        break;
                    case '(':
                        if (c!=')') return false;
                        break;
                }
            }
        }
        return stack.isEmpty();   // in case '()('
    }
}
