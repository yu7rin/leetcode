package BackTracking;

/**
 * Created by yu7rin on 8/6/2018.
 * 于上一题的区别主要在于选择下一个数字的时候如何避免选择重读的值
 * 判断是由于使用了for循环 从前往后找 第一不能选前面list有个index的element
 * 并且当判断是否选择了于上一位element重复值的时候，看这个重复的值是不是被选择了
 */
public class PermutationsII_47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        List<Integer> list = new ArrayList();
        List<Integer> chosenIndex = new ArrayList();
        Arrays.sort(nums);
        helper(nums, result, list, chosenIndex);
        return result;

    }
    public void helper(int[] nums ,  List<List<Integer>> result, List<Integer>          list,List<Integer> chosenIndex) {
        if(list.size() == nums.length) {
            result.add(new ArrayList(list));
            return;
        }
        for(int i = 0 ; i < nums.length ; i++) {
            if((i > 0 && nums[i] == nums[i - 1]) && !chosenIndex.contains(i - 1)|| chosenIndex.contains(i)) {
                continue;
            }else {
                list.add(nums[i]);
                chosenIndex.add(i);
                helper(nums, result, list, chosenIndex);
                list.remove(list.size() - 1);
                chosenIndex.remove(chosenIndex.size() - 1);
            }
        }

    }
}
