/*
 * 2025-06-26
 * 문제56_백준 1753번
 * */

package day8.B1753;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        int start = Integer.parseInt(br.readLine());

        List<List<Edge>> graph = new ArrayList<>();

        for(int i = 0; i < V; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            Edge edge = new Edge(v,w);
            graph.get(u).add(edge);
        } // 아 근데 앞문제처럼 edge에 to와 weight만 줘도 되나 이게.
        // -> 당연히 가능하지.

        int dist[] = new int[V + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0));

        while(!pq.isEmpty()){
            Edge current = pq.poll();
            int now = current.to;

            if(current.weight > dist[now]){

            } // 이게 뭔 소리야?

            for(Edge next : graph.get(now)){
                if(dist[next.to] > dist[now] + next.weight){
                    dist[next.to] = dist[now] + next.weight;
                    pq.offer(new Edge(next.to, dist[next.to]));
                }
            }
        }

        br.close();
    }
}








