import java.util.Map;
import java.util.HashMap;

public class P의상 {
    public int solution(String[][] clothes) {
    
        int answer = 1;
        Map<String, Integer> map = new HashMap<>();

        for(String[] c : clothes){
            String type = c[1];
            map.put(type, map.getOrDefault(type, 0) + 1);
        }

        for(int count : map.values()){
            answer += (count + 1);
        }

        answer = answer - 1;

        return answer;
    }
}

