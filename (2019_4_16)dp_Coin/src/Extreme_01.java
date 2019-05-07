public class Extreme_01 {
    /**
     * 装配站问题
     * Colonel汽车公司在有两条装配线上的工厂内生产汽车，如下图所示。每条装配线上有n个装配站，编号为j=1,2,......,n。将装配线i(i为1或2)的第j个装配站表示为Si,j 。
     * 装配线1的第j个站和装配站2的第j个站执行相同的功能，但是由于装配站性能不同，所需要的装配时间各不相同。
     * 把在装配站Si,j上所需的时间表示为ai,j，汽车底盘进入装配线i的时间为ei，离开装配线i的时间为xi。
     *
     * 正常情况下，汽车在一条装配线上完成装配。
     * 当有紧急订单时，允许汽车从任一装配站上移动至另外一条装配线上，以加快装配速度，但是仍然要经过n道工序。
     * 从Si,j移动至另外一条装配线的时间表示为ti,j，i=1,2，j=1,2,3,...,n-1（第n个之后，装配已经完成）。
     *
     * 目标是确定选择装配线1和2中的哪些站，以使汽车制造时间最短？
     * @param args
     */
    public static int nums = 3; //装配点数目
    public static int lineNum = 2; //装配线数目
    public static Line [] lines = new Line[lineNum];
    public static void main(String[] args) {
//        for (int i = 0 ; i < lineNum ; i++){
//            lines[i] = new Line();
//        }
        lines[0] = new Line();
        lines[0].time = new int[]{0,4,16,9};
        lines[0].exitTime = new int[]{0,1,2,1};
        lines[0].joinTime = new int[]{0,2,2,3};

        lines[1] = new Line();
        lines[1].time = new int[]{0,5,2,3};
        lines[1].exitTime = new int[]{0,3,1,4};
        lines[1].joinTime = new int[]{0,3,2,2};

        State [] sum = new State[nums+1];
        for (int i = 0 ; i <= nums ; i++){
            sum[i] = new State();
            sum[i].useTime = 10000;
        }
        sum[0].noLine = 0;
        for (int i = 1 ;i <= nums ; i++){
            for (int j = 0 ;j<lineNum;j++){
                /**
                 * 两种情况 本装配线 和 其它装配线 用上一个状态的标志位判断
                 */
                if (lines[j].time[i] < sum[i].useTime && sum[i-1].noLine == j){
                    sum[i].useTime = lines[j].time[i];
                    sum[i].noLine = j;
                }else if (lines[j].time[i]+lines[j].joinTime[i]+lines[sum[i].noLine].exitTime[i]< sum[i].useTime&& sum[i-1].noLine != j&& sum[i-1].noLine != j){
                    sum[i].useTime = lines[j].time[i]+lines[j].joinTime[i]+lines[sum[i].noLine].exitTime[i];
                    sum[i].noLine = j;
                }
            }
        }
        for (int i = 1 ; i < sum.length ; i++){
            System.out.println(sum[i].toString()+"|");
        }
//        System.out.println(sum);
    }

    /**
     * 状态转换的类
     * 从一个装配到另一个装配
     * s[i] = min(s[i-1]+l[i],s[i-1]+l[j])
     */
    static class State{
        public int useTime;//状态转换的最少时间
        public int noLine;//转换的装配线标志

        @Override
        public String toString() {
            return String.valueOf(noLine);
        }
    }
    static class Line{
//        public int[] point;
        public int[] time;
        public int[] exitTime;
        public int[] joinTime;

        public Line( int[] time, int[] exitTime, int[] joinTime) {
            this.time = time;
            this.exitTime = exitTime;
            this.joinTime = joinTime;
        }

        public Line() {}
    }
}
