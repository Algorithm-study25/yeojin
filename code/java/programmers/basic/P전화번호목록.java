// import java.util.HashSet;
// public class P전화번호목록 {
//     public boolean solution(String[] phone_book){

//         HashSet<String> set = new HashSet<>();

//         for(String p : phone_book){
//             set.add(p);
//         }

//         for(String phone : phone_book){
//             for(int i = 1; i < phone.length(); i++){
//                 if(set.contains(phone.substring(0,i))){
//                     return false;
//                 }
//             }
//         }
//         return true;
//     }
// }
/**
 * 방법 2번
 * 
 */

import java.util.Arrays;
public class P전화번호목록 {
    public boolean solution(String[] phone_book){

        Arrays.sort(phone_book);

        for(int i = 0; i < phone_book.length - 1; i++){
            if(phone_book[i+1].startsWith(phone_book[i])){
                return false;
            }
        }
        return true;
    }
}