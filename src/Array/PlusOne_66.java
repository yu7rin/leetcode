package Array;

/**
 * Created by yu7rin on 7/24/2018.
 */

///简单的一道题 注意数组的单个未知scope 1 - 10 所以当digits位置为9时即可判断进位
    //并且该位置置0
public class PlusOne_66 {
    ////版本1 复杂版 可直接条用在不为加一的题目上
    public int[] plusOne(int[] digits) {
        if(digits == null) return digits;
        int ten = 1;
        int d = digits.length - 1;
        while(d >= 0 && ten != 0){
            int temp = (digits[d] + ten) / 10;
            digits[d] = (digits[d] + ten) % 10;
            d--;
            ten = temp;
        }
        if(ten != 0) {
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            for(int i = 0; i < digits.length; i++) {
                result[i + 1] = digits[i];
            }
            return result;
        }
        return digits;

    }
    ///简化版
    public int[] plusOne2(int[] digits) {
        int len = digits.length;
        for (int i = len - 1; i > -1; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i] += 1;
                return digits;
            }
        }

        int[] newArray = new int[len + 1];
        newArray[0] = 1;
        return newArray;
    }
}
