package Array;

/**
 * Created by yu7rin on 7/26/2018.
 */
public class   RemoveDuplicatesfromSortedArrayII_80 {
    //第一版解法 采用了mark标记前位置value 用firstCount判断是否为第一次插入 太过复杂
    //没有充分利用sort的数组和数组的小标标识位置
    public int removeDuplicates(int[] nums) {
        if(nums.length < 3) return nums.length;
        int position = 0;
        int mark = -1;
        boolean firstCount = true;;
        for(int i = 0 ; i < nums.length; i++) {
            if(nums[i] != mark) {
                nums[position++] = nums[i];
                mark = nums[i];
                firstCount = true;;
            } else if (nums[i] == mark && firstCount) {
                nums[position++] = nums[i];
                firstCount = false;
            }

        }
        return position ;
    }
    ////解法2 通过利用数组角标和sortarray的大小判断n是否和两个位置之前 的数相等 停驶确定了是否为新的目标同时也求得了是否时第二个重复元素
    public int removeDuplicates2(int[] nums) {
        if (nums == null) {
            return -1;
        }
        if (nums.length < 3) {
            return nums.length;
        }
        int i = 0;
        for (int n : nums)
            if (i < 2 || n > nums[i - 2])
                nums[i++] = n;
        return i;
    }
    ////解法3 利用sortarray的特性 判断n是否和2个前的value值相同 值得注意的是的当value的值相等后不要直接利用i-2进行对比，关于pre的取值应参照新生成的数组进行计算，应为有可能新的数组会覆盖老的数组从而当使用i-2进行判断时产生错误
    public int removeDuplicates(int[] nums) {
        if(nums == null) return 0;
        if(nums.length < 3) return nums.length;
        int pre = 0;
        int index = 1;
        for(int i = 2 ; i < nums.length ; i++) {
            if(nums[i] != nums[pre]) {
                index ++;
                nums[index] = nums[i];
                pre++;
            }
        }
        return index + 1;


    }
}
