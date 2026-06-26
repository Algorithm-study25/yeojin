/**
 *  2025-03-21
 *  문제016_백준 1377번 (다시풀기)
 * */
package day4.B1377;

public class mData implements Comparable<mData> {
    protected int value;
    protected int index;

    protected mData(int value, int index) {
        this.value = value;
        this.index = index;
    }

    // compareTo 메서드를 구현해서 정렬 기준을 정의
    @Override
    public int compareTo(mData other) {
        return Integer.compare(this.value, other.value);  // value 기준으로 오름차순 정렬
    }
}
