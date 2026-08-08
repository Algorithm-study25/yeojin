class Solution {
    public String solution(String s) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            
            if(Character.isWhitespace(c)){
                sb.append(c); // 공백도 그대로 추가
                idx = 0;
            }else{
            
            if (idx % 2 == 0){
                c = Character.toUpperCase(c);
            }else{
                c = Character.toLowerCase(c);
            }
            
            
            sb.append(c);
            idx++;
            }
        }
        return sb.toString();
    }
}