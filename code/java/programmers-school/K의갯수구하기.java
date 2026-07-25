// class Solution {
//     public int solution(int i, int j, int k) {
//         int answer = 0;
//         String string_k = String.valueOf(k); // k를 문자열로 변환, k = 1
        
//         for(int l = i; l <= j; l++){
//             String current = String.valueOf(l); // 현재 숫자를 문자열로 변환 14
            
//             if(current.contains(string_k)){ // 14가 들어있는지 확인한다. 14 contains 1 -> 14 contains 1
//                 for(char c : current.toCharArray()){ // 현재 숫자 12345678 등을 문자열로 변환하는데, 14다 만약 , 아 이게 toCharArray는, 14면, 1, 4가 된다, 
//                     if (c == string_k.charAt(0)){ // c == 1, c == 4, 
//                         answer++;
//                     }
//                 }
//             }
//         }
        
//         return answer;
//     }
// }

class Solution{
    public int Solution(int i, int j, int k){
        int answer = 0;
        String target = String.valueOf(k);
        
        for (int l = i; l <= j; l++){
            String current = String.valueOf(l);
            
            int idx = 0;
            
            while((idx = current.indexOf(target, idx)) != -1){
                answer ++;
                idx += target.length();
            }
        }
        
        return answer;
    }
}