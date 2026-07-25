import java.util.*;
class Solution{
    public int solution(int[] nums) {

        HashSet<Integer> set = new HashSet<>();
        int N = nums.length / 2;
        
        for(int n : nums){
            set.add(n);
        }
        
        // 최대 N/2마리만 선택할 수 있는데, 최대한 많은 종류를 선택하라고 했으니까,
        // 종류의 갯수와, 최대 선택 가능한 갯수가 중요하고, 그 중 작은 값이 맞지..
        return Math.min(set.size(), N);
        
    }
}