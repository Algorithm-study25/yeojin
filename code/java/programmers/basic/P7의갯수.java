public class P7의갯수 {
    public int solution(int[] array) {
        int answer = 0;
        
        String s = "";
        
        for (int i = 0; i < array.length; i++){
            s += String.valueOf(array[i]);
        }
        
        for(int i = 0; i < s.length(); i++){
            if (s.charAt(i) =='7'){
                answer++;
            }
        }
        
        return answer;
    }
}
