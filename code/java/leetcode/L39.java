import java.util.*;
class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        int n = candidates.length;

        dfs(list, temp, candidates, target, 0);

        return list;
    }
    void dfs(List<List<Integer>> list, List<Integer> temp, int[] candidates, int target, int start){
        // 빠져나갈 조건 한 개 있어야하는데 == temp의 전체 합산이 target과 같으면 끝내라.
        int sum = 0;
        for(int i = 0; i < temp.size(); i++){
            sum += temp.get(i);
        }

        if(target == sum){
            list.add(new ArrayList<>(temp));
            return;
        }
        
        if (sum > target) {
            return;
        }

        for(int i = start; i < candidates.length; i++){
            
            temp.add(candidates[i]);
            
            dfs(list, temp, candidates, target, i);

            temp.remove(temp.size()-1);
        }
    }
}