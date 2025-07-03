/*
 * 2025-07-03
 * 문제52_백준 B1043번
 * */

package day8.B1043;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        // 입력받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<Integer> truthNum= new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        int truthCnt = Integer.parseInt(st.nextToken());
        if(truthCnt != 0){
            for(int i = 0; i < truthCnt; i++){
                truthNum.add(Integer.parseInt(st.nextToken()));
            }
        } // 이게 진실을 아는 사람이자 루트 -> 근데 루트가 여러개..

        ArrayList[] array = new ArrayList[m];

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int partyCnt = Integer.parseInt(st.nextToken());

            array[i] = new ArrayList<>();
            for(int j = 0; j < partyCnt; j++){
                array[i].add(Integer.parseInt(st.nextToken()));
            }
        } // 입력 받기

        parent = new int[n + 1];
        for(int i = 0; i <= n; i++){
            parent[i] = i;
        }

        // 음 arrayList의 길이가 2이상이라면 union
        for(ArrayList<Integer> party : array){
            if(party.size() >= 2){
                for(int i = 0; i < party.size() - 1; i++) {
                    union(party.get(i), party.get(i + 1));
                }
            }
        }
        // 그리고 find( ) 가 딱 하나인것만 count해서 출력
        // -? 이건 어케하지?
        // boolean type을 고려

        int rslt = 0;
        for(ArrayList<Integer> party : array){
            boolean canLie = true;
            for(int person : party){
                for(int truthPerson : truthNum){
                    if(find(person) == find(truthPerson)){
                        canLie = false;
                        break;
                    }
                }
                if(!canLie){ // canLie == false;
                    break; // 진실을 아는 사람과 연결된 사람을 발견하면, 중단한다.
                }
            }
            if(canLie){ // 진실 아는 사람과 연결된 사람이 아무도 없을 때.
                rslt++;
            }
        }

        System.out.println(rslt);
        br.close();
    }

    /**
     * union-find
     * */
    static int find(int x){
        if(parent[x] != x){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    /**
     * find
     * */
    static void union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);

        if(rootA != rootB){
            parent[rootB] = rootA;
        }
    }
}
