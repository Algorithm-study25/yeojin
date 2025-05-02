package day5.B12023;

import java.io.*;
import java.util.*;

public class Main {
    static class State {
        int node, depth;
        public State(int node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 사람 수
        int M = Integer.parseInt(br.readLine()); // 친구 관계 수

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < N; i++) graph.add(new ArrayList<>());

        // 양방향 그래프 구성
        for (int i = 0; i < M; i++) {
            String[] line = br.readLine().split(" ");
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        boolean found = false;

        for (int start = 0; start < N; start++) {
            boolean[] isVisited = new boolean[N];
            Stack<State> stack = new Stack<>();
            stack.push(new State(start, 1));

            while (!stack.isEmpty()) {
                State current = stack.pop();
                int state = current.node;
                int depth = current.depth;

                if (depth == 5) {
                    found = true;
                    break;
                }

                if (isVisited[state]) continue;
                isVisited[state] = true;

                for (int next : graph.get(state)) {
                    if (!isVisited[next]) {
                        stack.push(new State(next, depth + 1));
                    }
                }
            }

            if (found) break;
        }

        System.out.println(found ? 1 : 0);
    }
}
