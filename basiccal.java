class Solution {
    public int calculate(String s) {
        int i = 0;
        int num = 0;
        int res = 0;
        char sign = '+';
        if(s==null || s.length()==0) return 0;
        Stack<Integer> stack = new Stack<>();
        while (i < s.length()) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                num = num*10 + c - '0';
            }
            if ((c != ' ' && (c<'0' || c > '9' ))|| i == s.length() - 1) {
                if (sign == '+') {
                    stack.push(num);
                } else if (sign == '-') {
                    stack.push(-num);
                } else if (sign == '*') {
                    stack.push(stack.pop() * num);
                } else if (sign == '/') {
                    stack.push(stack.pop() / num);
                }
                num = 0;
                sign = c;
            }
            i++;
        }
        for (int j : stack) {
            res += j;
        }
        return res;
    }
}
