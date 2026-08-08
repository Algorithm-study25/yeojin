package programmers.hash.P완주하지못한선수;

import java.util.Map;
import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        Map<String, Integer> map = new HashMap<String, Integer>();

        // map에 일단 (k,v) 형태로 넣기
        for(int i = 0; i < participant.length; i++){
            map.put(participant[i], map.getOrDefault(participant[i],0) + 1);
        }

        // map 값을 누적할때는 getOrDefault

        for(int i = 0; i < completion.length; i++){
            map.put(completion[i], map.get(completion[i]) -1);
        }

        // 그다음 map에 남은 하나 출력
        for(String key : map.keySet()){
            if(map.get(key) != 0){
                answer = key;
            }
        }


        return answer;
    }
}

/*
순서 : hashmap<String, Integer>를 만들어서
participant 배열의 각 이름을 key로, 등장 횟수를 value로 저장
그 다음 completion 배열을 순회하면서 해당 이름의 등장 횟수 1감소시킴
만약 감소했을 때 0이 되면, 그 이름은 삭제 가능
마지막에 map에 남아있는 key 하나가 완주하지 못한 사람의 이름이다


map객체의 내용을 출력하기 위한 방법
entrySet() -> (k,v)를 같이 출력함
keySet() -> (v)를 가져옴(k 이용해서)


사용 예) for(String key : map.keySet()){
    String value = map.get(key);
    SOUT(keyvalue);
}

이 문제에서 hashMap을 쓴 이유 : "mislav"이 2명 있을 수 있으므로 이름마다 등장 횟수 체크
빠른 조회 필요 O(1)
배열 정렬로도 풀 수 있는데 시간복잡도 O(NlogN)
*/