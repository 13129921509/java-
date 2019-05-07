import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(1);
        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                int sum=0;
                for(int i = 0 ;i < 100; i++){
                    Thread.sleep(100);
                    sum+=100;
                }
                return String.valueOf(sum);
            }
        };
        FutureTask<String> task = new FutureTask<String>(callable);
        service.submit(task);
        Thread.sleep(5000);
        if(!task.isDone()){
            task.cancel(true);
            task.get();//会报错 因为根本就没有完成
        }

    }
}
