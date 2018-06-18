class Solution {
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        if (height.length <=1) {
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < height.length; i++) {
            while (!stack.empty() && height[i] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.empty()) {
                    break;
                }
                sum += (Math.min(height[stack.peek()], height[i]) - height[top])*(i - stack.peek() - 1);
            }
            stack.push(i);
        }
        return sum;
    }
}
