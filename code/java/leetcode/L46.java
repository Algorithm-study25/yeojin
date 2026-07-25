import java.util.List;
import java.util.ArrayList;
class Solution {
    boolean[] visited;
    public List<List<Integer>> permute(int[] nums) {
        visited = new boolean[nums.length];
        List<List<Integer>> list = new ArrayList<>();

        // temp는 현재 경로를 담는 path
        List<Integer> temp = new ArrayList<>();
        dfs(nums, temp, list);
        
        return list;
    }
    /* 
    순열 문제에서 dfs에서 now를 쓰지 않는 이유
    "현재 몇 개의 숫자를 골랐는가? 가 더 중요하기 때문"
    "몇 번 인덱스에 방문했는가는 중요하지 않음"

    그래프 탐색이나 조합 문제에서는 now나 start같은, 시작 위치 값을 넘긴다. 
    하지만 순열은 [1,2,3]을 만들 때, 2->1 순도 가능하다.
    따라서 매 단계에서 0 ~ nums.length - 1까지의 모든 인덱스를 살피는데, 이때
    이미 쓴 숫자는 건너뛰어야 한다.

    따라서, 특정 위치 now를 고정해서 넘길 필요가 없고, 대신 nums 배열 전체와, 선택 여부 visited만가지고 계속 반복문을 돌리는 것

    void dfs(int now, int[] nums, List<Integer> temp, List<List<Integer>> list){
        
        if(temp.size() == nums.length){
            list.add(new ArrayList<>(temp));
            return;
        }
        
        for(int i = 0; i < nums.length; i++){

            if(visited[i]){
                continue;
            }

            visited[i] = true;
            temp.add(nums[i]);

            dfs(i, nums);
            visited[i] = false;
        }
    }
    */
    void dfs(int[] nums, List<Integer> temp, List<List<Integer>> list){
        if(temp.size() == nums.length){
            list.add(new ArrayList<>(temp));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(visited[i]){
                continue;
            }

            // 1. 선택
            visited[i] = true;
            temp.add(nums[i]);

            // 2. 다음 단계로 이동
            dfs(nums, temp, list);

            // 3. 원상복구 (백트랙킹이니까)
            temp.remove(temp.size()-1);
            visited[i] = false;
        }
    }
}
