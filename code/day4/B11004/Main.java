/**
 *  2025-03-28
 *  문제019_백준 11004번
 * */
package day4.B11004;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(quickSelect(arr, 0, N-1, K-1));

        br.close();
    }

    static int quickSelect(int[] arr, int left, int right, int K) {
        if(left <= right) {
            int pivot = partition(arr, left, right);
            if(pivot == K) return arr[K];
            else if(pivot < K) return quickSelect(arr, pivot+1, right, K);
            else return quickSelect(arr, left, pivot-1, K);
        }
        return -1;
    }

    static int partition(int[] arr, int left, int right) {

        int pivotIdx = left + (right -left) / 2;

        int pivot = arr[pivotIdx];
        int i = right;

        for(int j=left; j<right; j++){
            if(arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i, right);
        return i;
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}


