import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * ���ԣ�����ʵ�ֲ�ͬ���߳��õ��������ǻ�������ģ��Ҷ�ÿ���߳���˵����ֻ��ʵ����һ��
 */
public class test {
	
}

class StringHandler extends ThreadLocal<String>{
	private static List<String> stringHandlers = new ArrayList<String>();
	private static Map<Object, String> threadMap = new HashMap<Object, String>();
	private static Map<Object, Integer> logThreadMap = new HashMap<Object, Integer>();
	public StringHandler() throws InstantiationException, IllegalAccessException {
		// TODO �Զ����ɵĹ��캯�����
		if(!isJuddge()){
			stringHandlers.add(currentThreadName);
		}
	}
	/*
	 * ��û�е�ǰ�̶߳���
	 */
	public Boolean isJuddge(){
		if(threadMap.get(Thread.currentThread().getName())== null){
			threadMap.put(Thread.currentThread().getName(), Thread.currentThread().getName()+"�Ѿ���Session�����ˣ����Ƕ���1");
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
		// TODO �Զ����ɵķ������
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
				// TODO �Զ����ɵķ������
				StringHandler stringHandler6;
				try {
					stringHandler6 = new StringHandler();

					stringHandler6 = new StringHandler();

					stringHandler6 = new StringHandler();
					stringHandler6.getLogPleaseTime();
				} catch (InstantiationException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO �Զ����ɵ� catch ��
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
