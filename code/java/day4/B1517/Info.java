package day4.B1517;

public class Info implements Comparable<Info>{
    //수열의 index와 숫자를 저장
    int idx, val;
    Info( int idx, int val){
        this.idx = idx;
        this.val = val;
    }
    //숫자 기준 오름차순 정렬
    @Override
    public int compareTo (Info o){
        return this.val - o.val;
    }
}
