public class 1971 {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> arraylist = new ArrayList<Integer>();
        for(int i = 0; i < n; i++){
            arraylist.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            int a = edge[0];
            int b = edge[1];

            arraylist.get(a).add(b);
            arraylist.get(b).add(a);
        }

        boolean[] visited = new boolean[n];

        return dfs(source, destination, graph, visited);
    }

    private boolean dfs(int current, int destination, List<List<Integer>> list, boolean[] visited){
        if(current == destination){
            return true;
        }

        visited[current] = true;

        for(int next : list.get(current)){
            if(!visited[next]){
                if(dfs(next, destination, graph, visited)){
                    return true;
                }
            }
        }
        return false;
    }
}
