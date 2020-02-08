package BackTracking;

/**
 * Created by yu7rin on 11/8/2018.
 */
class CombinationSumII_40{
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList();

        if(candidates == null || candidates.length < 1) return result;
        Arrays.sort(candidates);
        helper(candidates, target, new ArrayList<Integer>(), result, 0, new HashSet());
        return result;
    }
    private void helper(int[] nums, int target, List<Integer> list, List<List<Integer>> result, int index, Set<Integer> set) {
        if(target == 0) {
            result.add(new ArrayList(list));
            return;
        }
        if(target < 0) return;
        for(int start = index ;start < nums.length ; start++) {
            if(start != index && nums[start] == nums[start - 1]) continue;
            if(target == 0) result.add(new ArrayList(list));
            list.add(nums[start]);
            helper(nums, target - nums[start], list, result, start + 1, set);
            set.add(list.size() - 1);
            list.remove(list.size() - 1);
        }
    }
}