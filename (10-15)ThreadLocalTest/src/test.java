import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * 测试：该类实现不同的线程拿到它，都是互不共享的，且对每个线程来说都是只能实例化一次
 */
public class test {
	
}

class StringHandler extends ThreadLocal<String>{
	private static List<String> stringHandlers = new ArrayList<String>();
	private static Map<Object, String> threadMap = new HashMap<Object, String>();
	private static Map<Object, Integer> logThreadMap = new HashMap<Object, Integer>();
	public StringHandler() throws InstantiationException, IllegalAccessException {
		// TODO 自动生成的构造函数存根
		if(!isJuddge()){
			stringHandlers.add(currentThreadName);
		}
	}
	/*
	 * 有没有当前线程对象
	 */
	public Boolean isJuddge(){
		if(threadMap.get(Thread.currentThread().getName())== null){
			threadMap.put(Thread.currentThread().getName(), Thread.currentThread().getName()+"已经有Session对象了，我是对象1");
			logThreadMap.put(Thread.currentThread().getName(), 1);
			return false;
		}else{
			logThreadMap.put(Thread.currentThread().getName(), logThreadMap.get(Thread.currentThread().getName())+1);
			return true;
		}
	}
	String currentThreadName = Thread.currentThread().getName();
	public void getLogPleaseTime(){
		System.out.println(logThreadMap.get(currentThreadName));
	}
	@Override
	protected String initialValue() {
		// TODO 自动生成的方法存根
		return threadMap.get(Thread.currentThread().getName());
	}
	
	@SuppressWarnings("unused")
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, InterruptedException {
		StringHandler stringHandler1 = new StringHandler();
		StringHandler stringHandler2 = new StringHandler();
		StringHandler stringHandler3 = new StringHandler();
		StringHandler stringHandler4 = new StringHandler();
		StringHandler stringHandler5 = new StringHandler();
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO 自动生成的方法存根
				StringHandler stringHandler6;
				try {
					stringHandler6 = new StringHandler();

					stringHandler6 = new StringHandler();

					stringHandler6 = new StringHandler();
					stringHandler6.getLogPleaseTime();
				} catch (InstantiationException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
				
			}
		});
		System.out.println(stringHandler5.get());
		stringHandler1.getLogPleaseTime();
		t1.join();
		t1.start();
	}
	
}
