public class L125 {
    public boolean isPalindrome(String s) {
        
        boolean answer = true;

        s = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        
        int left = 0;
        int right = s.length() - 1;

        char[] array = new char[s.length()];

        for(int i = 0; i < s.length(); i++){
            array[i] = s.charAt(i);
        }

        while(left < right){
            if(array[left] == array[right]){
                left++;
                right--;
                continue;
            }else {return false;}
        }



        return answer;

    }
}
