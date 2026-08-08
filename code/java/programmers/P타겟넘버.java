// public class P타겟넘버 {
//     int count = 0;
    
//     public int solution(int[] numbers, int target) {
//         dfs(numbers, target, 0, 0);
        
//         return count;
//     }
//     void dfs(int[] numbers, int target, int index, int sum){
//         if(index == numbers.length){
//             if(sum == target){
//                 count++;
//             }
//             return;
//         }

//         dfs(numbers, target, index + 1, sum + numbers[index]);

//         dfs(numbers, target, index + 1, sum - numbers[index]);
//     }
// }

// // 가능한 모든 방법의 수 -> dfs -> 재귀를 이용
public class P타겟넘버 {
    int count = 0;
    public int solution(int[] numbers, int target) {
    
        dfs(numbers, target, 0, 0);
        return count;
    }
    void dfs(int[] numbers, int target, int index, int sum){
        if(index == numbers.length){
            if(sum == target){
                count++;
            }
            return;
        }

        dfs(numbers, target, index + 1, sum + numbers[index]);
        dfs(numbers, target, index + 1, sum - numbers[index]);
    }
}
