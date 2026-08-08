class Solution {
    public boolean solution(String s) {
        
        if (s.length() != 4 && s.length() != 6){
            return false;
        }
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (c < '0' || c > '9'){
                return false;
            } // 이거 아래와 같이 바꿀 수 있음
            
            /*
            if (!Character.isDigit(c)){
                return false;
            }
            */
        }
        
        return true;
    }
}