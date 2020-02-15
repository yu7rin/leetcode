package Stack;

public class BasicCalculator_224 {
    public int calculate(String s) {
        //每次使用stack记录（前的数值和符号 然后计算（）内部的数值 最后在加在一起
        Stack<Integer> stack = new Stack();
        int res = 0 , sign = 1;
        for(int i = 0 ; i < s.length() ; i++) {
            if(Character.isDigit(s.charAt(i))) {
                int num = s.charAt(i) - '0';
                while(i < s.length() - 1 && Character.isDigit(s.charAt(i + 1))) {
                    num = num * 10 + s.charAt(i + 1) - '0';
                    i++;
                }
                res += num * sign;
            }
            else if(s.charAt(i) == '-') sign = -1;
            else if(s.charAt(i) == '+') sign = 1;
            else if(s.charAt(i) == '(') {
                stack.push(res);
                stack.push(sign);
                res = 0;
                sign = 1;
            }
            else if(s.charAt(i) == ')') {
                res = res * stack.pop() + stack.pop();
            }
        }
        return res;
    }
}
