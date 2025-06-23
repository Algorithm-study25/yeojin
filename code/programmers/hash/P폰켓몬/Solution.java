package programmers.hash.P폰켓몬;

import java.util.Map;
import java.util.HashMap;

class Solution {
    public int solution(int[] nums) {

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for(int i = 0; i< nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        int pickCount = nums.length / 2; // N/2마리 선택이 가능.
        int count = 0; // 실제로 고른 종류의 수

        // 종류별로 하나씩 선택해봄.
        for(Integer key : map.keySet()){
            count++;
            if(count == pickCount){
                break; // N/2마리 다 골랐으면 종료
            }
        }


        return count;
    }
}

/**
 가장 다양하게 뽑을 수 있을 때, 그 갯수를 return

 [3 3 3 2 2 4] - 3
 (3,3,3) - 3개가 같을 경우
 (3,3,2) - 2개가 같을 경우
 (3,2,4) - 1개가 같을 경우
 6C3 = 654/321 = 20
 근데 그 중에 조합의 수


 3 1 2 3라면
 4C2=43/21=6
 이 중 조합의 수

 (31)(32)(12)(13)(23) - 2
 (33) - 두가지 같은

 [3,3,3,2,2,2] - 2
 (3,3,3) - 3개가 같을 경우
 (3,3,2) - 2개가 같을 경우
 (3,2,2) - 이거 역시 2개가 같을 경우

 아이디어 - n개중 n/2개 선택할건데 그중에서 다 다를수록 좋고
 nums배열을 map에 두고나서 똑같이 count를 해 그러면
 map에서 (3,2),(1,1),(2,1)이 들어갈거고
 for문돌면서 i가 0부터 n/2까지 map.put()으로 빼오는데, 대신 count가 1인것부터 쭉 빼오고 만약 for문 다 돌기전에 map이 끝나면 count가 2인거 빼오고 1인거빼왓을떄 값을 return
 */
