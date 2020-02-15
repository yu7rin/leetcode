package Sum; /**
 * Created by yu7rin on 4/24/2018.
 */
import java.util.*;
///复杂度n3 时间太高tle
public class FourSumII_454 {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int count = 0;
        Arrays.sort(C);
        Arrays.sort(D);
        for(int i = 0 ; i < A.length ; i++) {
            //if(i > 0 && A[i] == A[i + 1]) continue;
            for(int j = 0 ; j < B.length ; j++) {
                //if(j > 0 && B[j] == B[j + 1]) continue;
                int low = 0, high = D.length - 1;
                while(low < C.length && high >= 0) {
                    int sum = A[i] + B[j] + C[low] + D[high];
                    if(sum == 0) {
                        count++;
                        low ++;
                        high--;
                    } if(sum > 0) {
                        high--;
                    } else {
                        low++;
                    }
                }
                while (low < C.length) {
                    int sum = A[i] + B[j] + C[low] + D[high + 1];
                    if(sum == 0) {
                        count++;
                        low ++;
                    }
                    if(sum > 0){
                        break;
                    }
                }
                while (high >= 0) {
                    int sum = A[i] + B[j] + C[low - 1] + D[high];
                    if(sum == 0) {
                        count++;
                        high--;
                    }
                    if(sum < 0){
                        break;
                    }
                }
            }
        }
        return count;
    }
/////HashMap 解法 复杂度n2 可以使用两两分组hashmap的原因是这个题目不需要返回具体
//   的index是多少，也不需要返回具体的四个数值的val
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int count = 0;
        Map<Integer ,Integer> map = new HashMap();
        for (int a : A) {
            for (int b : B) {
                int sum = a + b;
                map.put(-sum ,map.getOrDefault(-sum , 0) + 1);
            }
        }
        for (int c : C) {
            for (int d : D) {
                int sum = d + c;
                if(map.containsKey(sum)) {
                    //System.out.println("c= "+c+"  d = "+d);
                    count += map.get(sum);
                }
            }
        }
        return count;
    }

}
