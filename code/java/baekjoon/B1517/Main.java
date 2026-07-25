package day4.B1517;

import java.io.*;
import java.util.*;
/*
public class Main {
    //세그먼트 트리 구현할 배열
    static long[] tree;
    //수열 A의 저장 배열
    static Info[] values;
    public static void main(String[] args) throws IOException {
        //입력값 처리하는 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //결과값 출력하는 BufferedWriter
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        values = new Info[N];
        //수열 A에대한 입력값 저장
        for(int i=0;i<N;i++){
            values[i] = new Info(i, Integer.parseInt(st.nextToken()));
        }
        long result = 0;
        //오름차순 정렬
        Arrays.sort(values);
        //세그먼트 트리 관련 배열 초기화
        tree = new long[getTreeSize(N)];
        int pre = Integer.MAX_VALUE;
        List<Integer> idxs = new ArrayList<>();
        //Swap 개수 구하기 시작!(작은 값부터 탐색)
        for(Info val  : values){
            //같은 값이 아닌 더 큰 값이 들어왔을 때
            if(pre != val.val){
                //이전 같은 값들 세그먼트 트리에 저장
                for(int idx : idxs){
                    update(0, N-1, 1, idx);
                }
                //같은 값들 초기화
                idxs.clear();
                pre = val.val;
            }
            //현재 세그먼트 트리에서 Swap 개수 구하기
            result += search(0, N-1, 1, val.idx+1, N-1);
            //같은 값 Index정보 저장
            idxs.add(val.idx);
        }
        //Swap 개수 BufferedWriter 저장
        bw.write(String.valueOf(result));
        bw.flush();		//결과 출력
        bw.close();
        br.close();
    }
    //세그먼트 트리에서 Swap개수 구하는 함수(범위에 합)
    static long search(int start, int end, int node, int left, int right){
        //구하는 범위를 벗어났을 때
        if(left > end || right < start) {
            return 0L;
        }
        //구하는 범위에 속했을 때
        if(left <= start && end <= right){
            return tree[node];
        }
        //하위 노드 탐색
        int mid = (start + end) / 2;
        return search(start, mid, node*2, left, right) + search(mid+1, end, node*2 + 1, left, right);
    }
    //세그먼트 트리에 현재 값 저장 및 최신화
    static void update(int start, int end, int node, int idx){
        //리프 노드일 때
        if(idx == start && idx == end){
            tree[node] = 1L;
            return;
        }
        //하위 노드 탐색
        int mid = (start + end) / 2;
        if(idx <= mid){
            update(start, mid, node * 2, idx);
        }else{
            update(mid + 1, end, node * 2 + 1, idx);
        }
        //세그먼트 트리 노드 값 최신화
        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }
    //세그먼트 트리의 노드 개수 구하는 함수
    static int getTreeSize(int n) {
        int h = (int)Math.ceil(Math.log(n)/Math.log(2))+1;
        return (int)Math.pow(2, h)-1;
    }
}
*/
import java.io.*;

public class Main {
    static int[] A, tmp;
    static long count = 0;

    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        A = new int[N];
        tmp = new int[N];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(input[i]);
        }

        // 병합 정렬
        mergeSort(0, N - 1);

        // 출력
        System.out.println(count);
    }

    static void mergeSort(int start, int end) {
        if (start >= end) return;
        int mid = (start + end) / 2;
        mergeSort(start, mid);
        mergeSort(mid + 1, end);
        merge(start, mid, end);
    }

    static void merge(int start, int mid, int end) {
        int i = start;
        int j = mid + 1;
        int k = start;

        while (i <= mid && j <= end) {
            if (A[i] <= A[j]) {
                tmp[k++] = A[i++];
            } else {
                tmp[k++] = A[j++];
                // 역전쌍 발생: 왼쪽에 있는 i~mid까지 모두 A[j]보다 크다.
                count += (mid - i + 1);
            }
        }

        // 남은 값 복사해야해
        while (i <= mid) tmp[k++] = A[i++];
        while (j <= end) tmp[k++] = A[j++];

        // tmp 를 a로 복사.
        for (int t = start; t <= end; t++) {
            A[t] = tmp[t];
        }
    }
}
