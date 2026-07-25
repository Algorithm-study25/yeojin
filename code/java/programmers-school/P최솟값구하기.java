import java.util.*;
class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);
        
        for(int i = 0; i < A.length; i++){
            answer += A[i] * B[A.length - i - 1];
        }

        return answer;
    }
}

// 1 2 4 / 4 4 5
//     -> 1 * 5 + 2 * 4 + 4 * 4 = 5+8+16 = 29