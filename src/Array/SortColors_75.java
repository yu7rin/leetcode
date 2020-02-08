package Array;

/**
 * Created by yu7rin on 7/26/2018.
 */
public class SortColors_75 {
    ////这道题可用简单bucket sort解决 许亚萍
    /*
    重点在于这个
    Follow up:
    A rather straight forward solution is a two-pass algorithm using counting sort.
    First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
    Could you come up with a one-pass algorithm using only constant space?
    只遍历一遍那就需要进行swap而不是bucket的两遍了
    难点在于第一个 考虑start = index && num[index] = 0时的情况，第二点是当index超越end点时应结束循环 在一个就是当nums[index] = 1时的i++策略
    在有loop的操作中一定注意pointer 或者循环条件的变化是否写明 防止死循环
         */
    public void sortColors(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        for(int i = 0; i < nums.length;) {
            if(nums[i] == 0) {
                if( i == start ) {
                    i++;
                    start++;
                }
                else{
                    swap(nums, start++, i);
                }
            } else if(nums[i] == 2) {
                if( i > end ) {
                    break;
                }
                else{
                    swap(nums, end--, i);
                }
            } else {
                i++;
            }

        }
    }
    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
