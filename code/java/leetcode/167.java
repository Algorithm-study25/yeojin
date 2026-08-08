/**
         * numbers는 이미 오름차순으로 정렬된 정수 배열임
         * 두 수를 더해서 target이 되는 두 요소를 찾아서, 두 인덱스를 1을 더한 상태로, 길이가 2인 정수 배열에 담아 return
         * answer = 길이가 2인 정수 배열
         * 
         * 예) numbers = [2,7,11,15], target = 9
         * 출력 : [1,2]
         * 2 + 7 = 9니까, index1 = 1, index2 = 2
         * 앞 문제(1.java)랑 다른 점은, numbers가 이미 오름차순정렬된상태이다.
         * 뭐가 다르지?
         */
        
// import java.util.Map;
// import java.util.HashMap;
// class Solution {
//     public int[] twoSum(int[] numbers, int target) {
//         int[] answer = new int[2];

        
//         Map<Integer, Integer> map = new HashMap<>();

//         for(int i = 0; i < numbers.length / 2; i++){ // 근데 for문을 썼을때, 이게 지금 이미 o(n)인데 문제에서 요구하는 o(1)이 의심됨
//             int num = target - numbers[i];
            
//             if(map.containsKey(num)){
//                 answer[0] = map.get(num);
//                 answer[1] = i;
//             }
//             map.put(numbers[i], i);
//         }
    
//         return answer;
//     }
// }

/** two pointers 를 사용한다. */

class Solution{
	public int[] twoSum(int[] numbers, int target){
		int left = 0;
		int right = numbers.length - 1;
		
		while(left < right){
			int currentSum = numbers[left] + numbers[right];
			
			if(currentSum == target){
				return new int[]{left + 1, right + 1};
			}else if(currentSum < target){
				left++;
			}else{
			right--;
		}
		return new int[]{};
	}
}