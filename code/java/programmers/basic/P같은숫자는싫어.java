import java.util.*;
public class P같은숫자는싫어 {

    public int[] solution(int []arr) {
        
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < arr.length; i++){
            if(stack.empty()){
                stack.push(arr[i]);
            }else if(stack.peek() != arr[i]){
                stack.push(arr[i]);
            }
        }

        int[] answer = new int[stack.size()];

        for(int i = answer.length - 1; i >= 0; i--){ // 그리고 여기서 answer.length 대신에 stack.size()를 하면 안된다. answer.length는 고정길이이지만, stack.size()는 pop을 하면서 반복문을 돌 때마다 감소함
            answer[i] = stack.pop();
        } // 뒤에서부터 넣어야 원래순으로 가져갈 수 있지. stack이니까.

        return answer;
    }
}
