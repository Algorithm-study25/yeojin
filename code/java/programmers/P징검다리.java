import java.util.Arrays;
class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        
        int start = 0;
        int end = distance;
        Arrays.sort(rocks);
        
        // int[] new_rocks = new int[rocks.length - n];
        
        while(start <= end){
            
            int mid = (start + end) / 2; // 최소 거리를 mid 이상으로 만들 수 있는가?
            
            // 바위를 제거하지 않는다 즉, new_rocks라는 배열을 따로 두지 않는다
            // 배열을 바꾸지 않고, 변수로 따진다.
            // prev = 마지막으로 남긴 바위
            // remove = 제거한 갯수
            
            
            /*
            for(int i = 0; i < rocks.length - 1; i++){
                if(rocks[i+1]-rocks[i] > mid){ // 이렇게 계산하면 안되는게, rocks[i+1] - rocks[i]는 안되는 이유가
                제거한 바위는 거리 계산에서 제외되어야 하므로, 
                rocks[i] - prev 이거를 따져야 한다.
                    // 냅두고
                    continue;
                }else{
                    // rocks[i] = new_rocks[i];
                    // 원본 배열에서 제거한다
                    // 그리고 mid는 다시.. 
                }
            }
            
            if(mid >= n){
                // 만약 n보다 크다면, 
            }
            */
            
            int prev = 0; // 마지막으로 남긴 바위
            int remove = 0; // 제거한 바위 갯수
            
            for(int rock : rocks){
                if(rock - prev < mid){
                    remove++;
                }else{
                    // 남긴다.
                    prev = rock;
                }
            }
            
            if(distance - prev < mid){ // for문에서 안도는 마지막 rock과 바위사이의 거리도 따져봐야 한다.
                remove++;
            }
            if(remove <= n){
                answer = mid;
                start = mid + 1;
            }else{
                end = mid - 1;
            }
            
        }
        return answer;
    }
}

// 0 ...            25
//  2 11 14 17 21
// 바위 2개를 제거 [21,17] -> 바위 사이의 거리 [2 9 3 11] 중 min
// 구하는 것 : 최소 거리의 최댓값. 즉 최소 거리를 X이상으로 만들 수 있는지가 궁금
// -> mid : 바위 사이의 최소 거리 후보