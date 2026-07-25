class Solution {
    public String solution(String my_string, String letter) {
        String answer = "";
        
        StringBuilder sb = new StringBuilder();
        
        int len = my_string.length();
        int letterlen = letter.length();
        
        for(int i = 0; i < len; i++){
            if(i <= len-letterlen){
                String c = my_string.substring(i, i+letterlen);   
            }
            
            if(c.equals(letter)){
                i = i + (letterlen - 1);
                continue;
            }
            
            sb.append(my_string.charAt(i));
        }
        return sb.toString();
    }
}

// class Solution {
//     public String solution(String my_string, String letter) {
//         return my_string.replace(letter, "");
//     }
// }



