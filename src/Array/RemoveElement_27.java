package Array;

public class RemoveElement_27 {
    public int removeElement(int[] nums, int val) {
        int length = 0;
        for(int i = 0 ; i < nums.length ; i++) {
            if(nums[i] != val) {
                nums[length] = nums[i];
                length ++;
            }
        }
        return length - 1;
    }
}
