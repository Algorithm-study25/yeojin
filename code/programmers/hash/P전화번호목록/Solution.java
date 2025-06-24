package programmers.hash.P전화번호목록;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;

        Set<String> set = new HashSet<String>();

        for(String number : phone_book){
            set.add(number);
        } // add 하기

        // for문 돌면서
        for(String number : phone_book){
            for(int i = 1; i < number.length(); i++){
                String prefix = number.substring(0, i); // 0번부터 i-1을 포함하는 부분까지 prefix 추출
                if(set.contains(prefix)){
                    return false;
                }
            }
        }

        return answer;
    }
}

// prefix가 자기자신이 되는 경우는 애초에 loop에서 i < number.lengt// () 조건 때문에 발생하지 않는다.