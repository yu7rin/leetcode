package Array;

public class RemoveDuplicatesfromSortedArray_26 {
    public int removeDuplicates(int[] nums) {
        int length = 0;
        for(int i = 0 ; i < nums.length ; i++) {
            if(nums[i] != nums[length]) {
                length++;
                nums[length] = nums[i];
            }
        }
        return length + 1;
    }
}
