class Solution {
    public int[] solution(int[] num_list) {
        int length = num_list.length;
        
        int[] answer = new int[length];
        
        for (int i = 0; i < length; i++){
            answer[i] = num_list[i];
        }
        
        for(int i = 0; i < length/2; i++){
            int temp = answer[i];
            answer[i] = answer[length-1-i];
            answer[length-1-i] = temp;
        }
        
        return answer;
    }
}