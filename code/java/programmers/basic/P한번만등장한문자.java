// import java.util.*;
// class Solution {
//     public String solution(String s) {
//         String answer = "";
        
//         for (int i = 0; i < s.length(); i++){
//             char compare = s.charAt(i);
//             int count = 0;
            
//             for (int j = 0; j < s.length(); j++){
//                 if(compare == s.charAt(j)){
//                     count++;
//                 }
//             }
            
//             if (count == 1){
//                 answer += compare;
//             }
//         }
        
//         char[] arr = answer.toCharArray();
//         Arrays.sort(arr);
//         answer = new String(arr);
//         return answer;
//     }
// }

import java.util.Arrays;

class Solution {
    public String solution(String s) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {

            char compare = s.charAt(i);
            int count = 0;

            for (int j = 0; j < s.length(); j++) {
                if (compare == s.charAt(j)) {
                    count++;
                }
            }

            if (count == 1) {
                sb.append(compare);
            }
        }

        char[] arr = sb.toString().toCharArray();
        Arrays.sort(arr);

        return new String(arr);
    }
}