// class Solution {
//     public String[] solution(String[] quiz) {
//         String[] answer = new String[quiz.length];
        
//         for(int i = 0; i < quiz.length; i++){
//             String q = quiz[i];
//             String[] arr = q.split(" ");
            
//             int num1 = Integer.parseInt(arr[0]);
//             String op = arr[1];
//             int num2 = Integer.parseInt(arr[2]);
//             int num3 = Integer.parseInt(arr[4]);
            
//             switch(op){
//                 case "+":
//                     if(num3 == num1 + num2){
//                         answer[i] = "O";
//                     }else{
//                         answer[i] = "X";
//                     }
//                     break;
                
//                 case "-":
//                     if(num3 == num1 - num2){
//                         answer[i] = "O";
//                     }else{
//                         answer[i] = "X";
//                     }
//                 break;
//             }
//         }
        
//         return answer;
//     }
// }

// 2026-07-07 재풀이
class Solution{
    public String[] solution(String[] quiz){
        String[] answer = new String[quiz.length];

        for(int i = 0; i < quiz.length; i++){
            String q = quiz[i]; // "3 - 4"
            String[] arr = q.split(" "); //3-4

            int num1 = Integer.parseInt(arr[0]);
            int num2 = Integer.parseInt(arr[2]);
            char op = arr[1].charAt(0);
            int num3 = Integer.parseInt(arr[4]);

            switch(op){
                case "+":
                    if(num3 == num1 + num2){
                        answer[i] = "O";
                    }else{
                        answer[i] = "X";
                    }
                break;
                case "-":
                    if(num3 == num1 - num2){
                        answer[i] = "O";
                    }else{
                        answer[i] = "X";
                    }
                break;
            }
        }
        return answer;
    }
}