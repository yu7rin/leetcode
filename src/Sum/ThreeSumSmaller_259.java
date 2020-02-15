package Sum; /**
 * Created by yu7rin on 4/24/2018.
 */

import java.util.*;
public class ThreeSumSmaller_259 {


    /*Given an array of n integers nums and a target, find the number of index triplets i, j, k with 0 <= i < j < k < n that satisfy the condition nums[i] + nums[j] + nums[k] < target.

    For example, given nums = [-2, 0, 1, 3], and target = 2.

    Return 2. Because there are two triplets which sums are less than 2:

    [-2, 0, 1]
    [-2, 0, 3]*/

    ///注意!!!!注意题意 无需去重复 if(nums[i] + nums[low] + nums[high] < target)时
    // high指针的--动向是肯定符合条件的，不用考虑 直接加入就好
    public int threeSumSmaller(int[] nums, int target) {
        int result = 0;
        if(nums.length < 3) return result;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++) {
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            int low = i + 1, high = nums.length - 1;
            while(low < high) {
                if(nums[i] + nums[low] + nums[high] < target) {
                    result += high - low;// ！！！！high指针的--动向是肯定符合条件的，不用考虑 直接加入就好
                    low++;
                }else if(nums[i] + nums[low] + nums[high] >= target) {
                    high--;
                }
            }
        }
        return result;
    }
}
