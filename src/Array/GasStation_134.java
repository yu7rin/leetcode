package Array;

import java.util.ArrayList;
import java.util.List;

public class GasStation_134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        for(int i = 0 ; i < gas.length ; i++) {
            int gasInTank = 0;
            for(int a = i; a < gas.length ; a++) {
                gasInTank += gas[a];
                if(gasInTank < 0) {
                    break;
                }
            }
            if(gasInTank >= 0) {
                for(int b = 0; b < i ; b++) {
                    gasInTank += gas[b];
                    gasInTank -= cost[b];
                    if(gasInTank < 0) {
                        break;
                    }
                }
            }if(gasInTank >= 0) {
                return i;
            }
        }
        return -1;

    }
    //高级思路 通过计算目前所有gas与cost的插值 计算是否可以到达下一站 类似单调递增栈
    public int canCompleteCircuit2(int[] gas, int[] cost) {
        int[] diff = new int[gas.length];
        int sum = 0;
        for(int i = 0; i<gas.length; i++) {
            diff[i] = gas[i] - cost[i];
            sum += diff[i];
        }
        if(sum < 0) {
            return -1;
        }

        int start = 0;
        sum = 0;
        for(int i = 0; i<diff.length; i++) {
            if(sum < 0) {
                start = i;
                sum = diff[i];
            }
            else {
                sum += diff[i];
            }
        }
        return start;
    }
}



public List<String> listOfSubString (String str , int length) {
    List<String> result = new ArrayList<String>();
    helper(str, length, 0,1,"", result);
    return result;
}
public void helper(String str, int length, int start, int layer, String tmpString, List<String> result) {
    for(int i = start; i < str.length() ; i++) {
        if(layer == length) {
            result.add(tmpString + str.charAt(i));
            return;
        } else {
            helper(str, length, i + 1, layer + 1, tmpString + str.charAt(i), result);

        }
    }


}
