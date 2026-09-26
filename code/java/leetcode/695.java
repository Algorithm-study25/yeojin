public class 695 {
    int maxCount = 0;
    public int maxAreaOfIsland(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                maxCount = Math.max(dfs(grid, visited, i, j), maxCount);
            }
        }
        return maxCount;
    }

    public int dfs(int[][] grid, boolean[][] visited, int i, int j) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length){
            return 0;
        }

        if(visited[i][j] || grid[i][j] == 0){
            return 0;
        }

        visited[i][j] = true;
        
        int count = 1;

        count += dfs(grid, visited, i+1, j);
        count += dfs(grid, visited, i-1, j);
        count += dfs(grid, visited, i, j+1);
        count += dfs(grid, visited, i, j-1);


        return count;
    }
}
