package day7.P택배상자꺼내기;

class Solution { // n은 총 갯수 w는 가로 길이 num은 내가 빼고 싶은 거의 값
    public int solution(int n, int w, int num) { // num = 8이라 가정한다면
        int answer = 0;

        int height = (n + w - 1) / w;

        // num 위치
        int layer = (num - 1) / w;  // 몇 번째 층에 있는지
        int row = (num - 1) % w; // 몇 번째 가로로 잇는지

        boolean leftRight = (layer % 2 == 0);

        // col 계산
        int col = leftRight ? row : (w - 1 - row); // 4

        // 위에 있는 상자 개수
        for (int i = 0; i < height; i++) {
            int base = i * w; // i = 0 일때 base = 0
            int idxInRow = (i % 2 == 0) ? col : (w - 1 - col); // 4
            int boxNum = base + idxInRow + 1; // 5

            // n보다 작거나 같을때만coutnt
            if (boxNum <= n && boxNum >= num) {
                answer++;
            }
        }
        return answer;
    }
}


