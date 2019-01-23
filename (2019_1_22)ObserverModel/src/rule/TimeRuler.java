package rule;

import rule.inf.Ruler;

/**
 * 规矩制定者，有他决定观察者出不出局
 */
public class TimeRuler implements Ruler {
    Object syn;
    Long time;
    boolean status;
    boolean endStatus;//表示结束的状态
    Long start;
    public TimeRuler(Long time){
        this.time = time;
        this.status = true;
        endStatus = false;
        this.start = System.currentTimeMillis();
        syn = new Object();
    }

    @Override
    public void run() {
        execute();
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean getStatus() {
        return status;
    }

    @Override
    public void execute() {
        /**
         * 用来做判断 判断状态是否改变
         */
        synchronized (syn){
            while(status){//如果状态 true 代表在做耗时操作 死循环 内部计时
                if(System.currentTimeMillis()-start>time*1000){
                    break;
                }
            }
            if(status == false){
                System.out.println("任务已经完成,计时结束!!!");
            }else {
                System.out.println("Time Out!!!");
                setEndStatus(true);
            }
        }
    }

    public boolean isEndStatus() {
        return endStatus;
    }

    public void setEndStatus(boolean endStatus) {
        this.endStatus = endStatus;
    }
}
