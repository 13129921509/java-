public class Main {
    /**
     * 硬币找零
     *
     * 假设有几种硬币，如1、3、5，并且数量无限。请找出能够组成某个数目的找零所使用最少的硬币数。
     */
    public static int coins[] = {1,3,5};//硬币种类
    public static int total = 19; // 总共需要找零的数目
    public static State [] sum;
    public static void main(String[] args) {
        sum = new State [total+1];
        for (int i = 0 ; i <= total ; i++){
            sum[i] = new State();
            sum[i].nCoin = 100000;
        }
        sum[0].nCoin = 0;
        sum[0].addCoin = 0;
        for (int i = 1 ; i <= total ; i++){
            for (int j = 0 ;j < coins.length ; j++){
                if (i - coins[j] >= 0 && sum[i-coins[j]].nCoin+1<sum[i].nCoin){
                    sum[i].addCoin = coins[j];
                    sum[i].nCoin = sum[i-coins[j]].nCoin+1;
                    sum[i].lastSum = j;
                }
            }
        }
        System.out.println(sum[total].nCoin);
    }

    static class State{
        public int nCoin;//找零到目前总共的数目
        public int lastSum;//上一个状态
        public int addCoin;//从上一个状态达到当前状态所用的硬币种类
    }
}
