import java.util.*;
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        dfs(nums, list, temp, 0);

        return list;
    }
    void dfs(int[] nums, List<List<Integer>> list, List<Integer> temp, int start){

        list.add(new ArrayList<>(temp));

        for(int i = start; i < nums.length; i++){
            temp.add(nums[i]);
            dfs(nums, list, temp, i + 1);
            temp.remove(temp.size()-1);
        }
    }
}