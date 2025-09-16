import java.util.*;
class Solution8 {
    public List<Integer> replaceNonCoprimes(int[] nums){
        Stack<Integer> stack = new Stack<>();
        for(int num : nums){
            while(!stack.isEmpty()){
                int x = gcd(stack.peek(),num);
                if(x == 1) 
                    break;
                num *= stack.pop() / x;
            }
            stack.push(num);
        }
        return new ArrayList<>(stack);
    }
    public int gcd(int a,int b){
        return b == 0 ? a : gcd(b,a % b);
    }
}