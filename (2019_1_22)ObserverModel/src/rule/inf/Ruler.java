package rule.inf;

public interface Ruler extends Runnable{
    /**
     * 策略的具体细节
     */
    void execute();
    /**
     * 策略的改变因素
     */
    void setStatus(boolean status);
    boolean isEndStatus();
    void setEndStatus(boolean endStatus);
}
