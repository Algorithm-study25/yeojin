// import java.util.List;
// import java.util.ArrayList;
// class Solution {
//     private final String[] KEYPAD = {
//         "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
//     };

//     public List<String> letterCombinations(String digits) {
        
//         List<String> list = new ArrayList<>();

//         for(int i = 0; i < digits.length(); i++){
//             char c = digits.charAt(i);
//             keypadMapping(c);
//         }

//         return list;
//     }
//     public void keypadMapping(char c){
//         switch (c) {
//             case 2:
//                 // a, b, c가 가능하고
//                 dfs(a);
//                 // break;
//             case 3:
//                 // d e f가 가능하고
        
//             default:
//                 break;
//         }
//     }
//     public void dfs(int now){
//         visited[now] = true;


//     }
// }
import java.util.List;
import java.util.ArrayList;

class Solution {
    // 1. 키패드 매핑을 배열로 미리 정의 (0, 1은 빈 문자열)
    private final String[] KEYPAD = {
        "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        // 예외 처리: 입력이 비어있으면 빈 리스트 반환
        if (digits == null || digits.length() == 0) {
            return result;
        }

        // 백트래킹 시작 (0번 인덱스부터, 빈 문자열로 시작)
        dfs(digits, 0, new StringBuilder(), result);

        return result;
    }

    private void dfs(String digits, int index, StringBuilder current, List<String> result) {
        // [기저 조건] digits의 끝까지 탐색했으면 완성된 문자열을 결과에 추가
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        // 현재 숫자에 해당하는 문자열 가져오기 (예: '2' -> "abc")
        int digitNum = digits.charAt(index) - '0';
        String letters = KEYPAD[digitNum];

        // 가능한 모든 문자에 대해 재귀 호출
        for (int i = 0; i < letters.length(); i++) {
            current.append(letters.charAt(i));       // 1. 문자 선택
            dfs(digits, index + 1, current, result); // 2. 다음 숫자(index + 1)로 이동
            current.deleteCharAt(current.length() - 1); // 3. 백트래킹 (원상복구)
        }
    }
}