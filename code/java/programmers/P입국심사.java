// import java.util.Arrays;
// class Solution {
//     public long solution(int n, int[] times) {
        
//         Arrays.sort(times);
        
//         long left = 1; // 최소 시간은 1분
//         long right = (long)times[times.length-1] * n; // 가장 최악의 경우는, 느린 심사관이 혼자 n명을 처리하는 시간
//         long answer = right;
        
//         while(left <= right){
//             long mid = (left + right) / 2; // mid 분 안에 끝낼 수 있을까? 를 검사하는 시간
            
//             long count = 0; 
//             for(int time: times){ 
//                 count += mid / time;
//             }
            
//             if(count >= n){ // 필요 인원 n명인데, count는 시간 내, 처리 가능한 인원 수니까, 이건 가능하다는 것이고, 하지만 이보다 더 짧은 시간도 가능할 수도 있다.
//                 answer = mid; // 일단, 지금까지 찾은 가장 좋은 답은 26인데,
//                 right = mid - 1; // 일단 이분탐색 한번 더 돌고, 
//             }else{ // 만약 아니라면, 이분탐색을 뒷쪽으로 돈다.
//                 left = mid + 1;
//             }
//         }
        
//         return answer;
//     }
// }
// // 해당 문제에서 int가 아니라, long을 쓰는 이유?
// // n이 최대 10억
// // times[i]가 최대 10억
// // right 계산 시, right = times[] * n이니까, 10의 18승
// // int는 약 21억까지만 가능하므로 long을 써야 함
import java.util.Arrays;
class Solution{
    public long Solution(int n, int[] times){
        // [7, 10], 6이면 return 38
        // 전체 시간을 T로 둔다.
        // 이분탐색으로
        int answer = 0;
        Arrays.sort(times);
        
        long start = 1;
        long end = n * times[times.length - 1];

        while(start <= end){
            long mid = (start + end) / 2; // 이건 시간이니까.

            int count = 0; // count는 mid분 동안 모든 심사관이 처리할 수 있는 사람의 수 
            for(int time: times){
                count += mid / time;
            }

            if(count >= n){
                answer = n;
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }

        return answer;
    }
}