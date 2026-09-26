public class 733 {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        boolean[][] visited = new boolean[image.length][image[0].length];
        int originalColor = image[sr][sc];
        dfs(image, sr, sc, color, visited, originalColor);

        return image;
    }
    private void dfs(int[][] image, int sr, int sc, int color, boolean[][] visited, int originalColor){
        if(sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length){
            return;
        }

        if(visited[sr][sc]){
            return;
        }

        if(image[sr][sc] != originalColor){
            return;
        }

        visited[sr][sc] = true;
        image[sr][sc] = color; // if문 밖이니까. 

        dfs(image, r-1, c, color, visited, originalColor);
        dfs(image, r, c-1, color, visited, originalColor);
        dfs(image, r+1, c, color, visited, originalColor);
        dfs(image, r, c+1, color, visited, originalColor);
    }
}

public class 733 {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        boolean[][] visited = new boolean[image.length][image[0].length];

        int originalColor = image[sr][sc];

        dfs()
    }
    private void dfs(int[][] image, int sr, int sc, int color, int originalColor){
        
        if(visited[sr][sc]){
            return;
        }
        
        if(image[sr][sc] != originalColor){
            return;
        }
        image[sr][sc] = color;
        visited[sr][sc] = true;

        dfs(image, sr - 1, sc, color, originalColor);
    }
}