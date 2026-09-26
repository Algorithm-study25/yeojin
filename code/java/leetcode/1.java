import java.util.Map;
import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] answer = new int[2];

        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(target - nums[i])){
                answer[0] = map.get(target - nums[i]);
                answer[1] = i;
            }

            map.put(nums[i], i);
        }

        return answer;
    }
}

// 그냥 푸는 법
class 1{
    public int[] twoSum(int[] nums, int target) {
        int[] answer = new int[2];
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                if(nums[i] + nums[j] == target){
                    answer[0] = i;
                    answer[1] = j;
                    return answer;
                }
            }
        }
        return answer;
    }
}

class 1{
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> hashmap = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int need = target - nums[i];

            if(hashmap.containsKey(need)){
                return new int[]{hashmap.get(need), i};
            }

            hashmap.put(nums[i], i);
        }
        return new int[]{};
    }
}