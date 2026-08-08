class Solution {
    boolean[] visited;

    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];

        for(int i = 0; i < n; i++){
            if(!visited[i]){
                dfs(computers, i);

                answer++;
            }
        }

        return answer;
    }
    void dfs(int[][] computers, int now){
        visited[now] = true;

        // for(int next : graph[now]){
        //     if(!visited[next]){
        //         dfs(next);
        //     }
        // }

        for(int i = 0; i < computers.length; i++){
            if(computers[now][i] == 1 && !visited[i]){
                dfs(computers, i);
            }
        }
    }
}