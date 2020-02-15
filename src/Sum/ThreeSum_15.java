package Sum;

import java.util.*;

/**
 * Created by yu7rin on 4/23/2018.
 */
public class ThreeSum_15 {
    //while 版本 注意三次去重
    public List<List<Integer>> threeSum (int[] nums) {
        List<List<Integer>> result = new ArrayList();
        if (nums.length < 3) return result;
        Arrays.sort(nums);
        for (int i = 0 ; i < nums.length - 2; i++) {
            if (i > 1 && nums[i] == nums[i - 1]) continue;
            int low = i + 1, high = nums.length - 1, sum = - nums[i];
            while (low < high) {
                if (nums[low] + nums[high] == sum) {
                    result.add(Arrays.asList(nums[i], nums[low], nums[high]));
                    while (low < high && nums[low] == nums[low + 1]) {
                        low++;
                    }
                    while (high > low && nums[high] == nums[high - 1]) {
                        high--;
                    }
                    low++;
                    high--;
                }

                if (nums[high] + nums[low] > sum){
                    high--;
                }
                else {
                    low++;
                }
            }
        }
        return result;
    }

    //hashMap 版本 注意2次去重
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        Arrays.sort(nums);
        for(int i = 0 ; i < nums.length - 2; i++) {
            Map<Integer, Integer> map = new HashMap();
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            for(int j = i + 1 ; j < nums.length; j ++) {
                if(map.containsKey(nums[j])) {
                    map.remove(nums[j]);
                    //System.out.println("i = "+i+", j = "+ j);
                    ArrayList<Integer> list = new ArrayList();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(- nums[i]  - nums[j]);
                    result.add(list);
                } else {
                    //   System.out.println((-(nums[i] + nums[j]))+"$ ,numi" + nums[i] + "nums[j]" + nums[j]);
                    map.put(-(nums[i] + nums[j]) ,j);
                }
            }
        }return result;
    }
}
