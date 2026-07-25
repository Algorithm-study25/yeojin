package leetcode;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        
        List<Integer> temp;
        List<List<Integer>> list = new ArrayList<>();

        for(int i = 0; i < numRows; i++){

            temp = new ArrayList<>();
            temp.add(1);

            for(int j = 1; j <= i - 1; j++){
                List<Integer> prev = list.get(i - 1);
                temp.add(prev.get(j - 1) + prev.get(j));
            }

            if(i > 0){
                temp.add(1);
            }

            list.add(temp);
        }

        return list;
    }
}
