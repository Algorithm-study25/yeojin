// 반드시 다시 풀어봐야해..
class Solution {
    public String solution(String new_id) {
        String answer = "";
        
        // 1단계
        new_id = new_id.toLowerCase();
        
        // 2단계
        // new_id = new_id.replaceAll("[^a-z0-9-_.]", "");
        // [^ ] 는, ~아닌것
        /*
        모든다면 직접 구현
        */
        StringBuilder sb = new StringBuilder();
        
        for(char c : new_id.toCharArray()){
            if(Character.isLowerCase(c)
                || Character.isDigit(c)
                || c == '-'
                || c == '_'
                || c == '.'){
                sb.append(c);
            }
        }
        new_id = sb.toString();
        
        // 3단계
        // 정규식으로 풀기
        // new_id = new_id.replaceAll("[.]+", ".");
        /*
        직접 구현하기
        */
        StringBuilder sb2 = new StringBuilder();
        
        for(char c : new_id.toCharArray()){
            if(sb2.length() == 0){
                sb2.append(c);
            }else{
                if(sb2.length() > 0 && sb2.charAt(sb2.length()-1) == '.' && c =='.'){
                    continue;
                }
                sb2.append(c);
            }
        }
        new_id = sb2.toString();
        
        // 4단계
        
        new_id = new_id.replaceAll("^\\.|\\.$", "");
    
        
        // 5단계
        if(new_id.equals("")){
            new_id = "a";
        }
            
        // 6단계
        if(new_id.length() >= 16){
            new_id = new_id.substring(0,15);
            
            while(new_id.endsWith(".")){
                new_id = new_id.substring(0, new_id.length()-1);
            }
        }
            
        
        // 7단계
        while(new_id.length() < 3){
            new_id+= new_id.charAt(new_id.length()-1);
        }
        
        return new_id;
    }
}