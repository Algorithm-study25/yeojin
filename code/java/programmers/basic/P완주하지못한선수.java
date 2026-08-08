// import java.util.HashMap;
// class Solution {
//     public String solution(String[] participant, String[] completion) {
//         String answer = "";
        
//         HashMap<String, Integer> map = new HashMap<>();

//         for(String p : participant){
//             map.put(p, map.getOrDefault(p,0)+1);
//         }

//         for(String c : completion){
//             map.put(c, map.get(c)-1);
//         }

//         for(String key : map.keySet()){
//             if(map.get(key) != 0){
//                 return key;
//             }
//         }
        
//         return "";
//     }
// }

/**
 * 이 문제에서 HashMap을 쓴 이유는, 당연히 문제의 조건 중
 * 마라톤 경기에 참여한 선수 수가 100,000명인데
 * 이거 for문돌리면 10^12승이니까, o(n)일 수 있는 HashMap을 쓰는 것이 맞아.
 */
import java.util.*;
class Solution{
    public String solution(String[] participant, String[] completion){
        String answer = "";

        HashMap<String, Integer> map = new HashMap<>();

        for(String p : participant){
            map.put(p, map.getOrDefault(p,0)+1);
        }

        for(String c : completion){
            map.put(c, map.get(c)-1);
        }

        for(String key : map.keySet()){
            if(map.get(key)!=0){
                return key;
            }
        }


        return answer;
    }
}