public class 121 {
    public int maxProfit(int[] prices) {
        int min = prices[0]; // min을 초기값을 0으로 주면 안되지
        int maxProfit = 0;

        for(int i = 0; i < prices.length; i++){
            min = Math.min(min, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - min);
        }
        return maxProfit;
    } 
}
