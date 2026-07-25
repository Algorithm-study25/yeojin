public class LNumberOfProvinces {
    boolean[] visited;
    
    public int findCircleNum(int[][] isConnected) {
        int answer = 0;
        visited = new boolean[isConnected.length];

        for(int i = 0; i < isConnected.length; i++){
            
            if(!visited[i]){
                dfs(isConnected, i);
                answer++;
            }
        }
        return answer;
    }

    void dfs(int[][] isConnected, int now){
        visited[now] = true;
        for(int i = 0; i < isConnected.length; i++){
            if(!visited[i] && isConnected[now][i] == 1){
                dfs(isConnected, i);
            }
        }
    }
}
