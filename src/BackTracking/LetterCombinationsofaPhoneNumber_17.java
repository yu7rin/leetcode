package BackTracking;

/**
 * Created by yu7rin on 8/8/2018.
 * ///次题目运用非常巧妙地双参数循环相组合的方式拼出了所有组合】
 * 要注意result要初始化成{“”} 否者再自函数里for（s ： list）是不循环的
 */
public class LetterCombinationsofaPhoneNumber_17 {
    public List<String> letterCombinations(String digits) {
        String[] str = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> result = new ArrayList();
        if(digits == null || digits.length() < 1) return result;
        result.add("");
        for(int i = 0 ; i < digits.length() ; i++) {
            System.out.print(digits.charAt(i) - '0');
            result = mix(result , str[digits.charAt(i) - '0']);
        }
        return result;
    }
    public List<String> mix(List<String> list ,  String s) {
        List<String> result = new ArrayList();
        for(String a : list) {
            for(int i = 0 ; i < s.length() ; i++) {
                result.add(a + s.charAt(i));
            }
        }
        return result;
    }
}
