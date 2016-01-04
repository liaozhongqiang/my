package stackoverflow;

/**
 * volalite变量
 * @author liaozq
 * @DATE 2015年12月31日
 */
public class Question7 {
	
	public static void main(String[] args) {
		Question7Runnable q7r=new Question7Runnable();
		new Thread(q7r).start();
		while(q7r.isFlag()){
			//System.out.println(11111);//去掉将是死循环
		}
		System.out.println(q7r.isFlag());
		
	}

}

class Question7Runnable implements Runnable{
	
	private  boolean flag=true;
	
	public boolean isFlag() {
		return flag;
	}

	@Override
	public void run() {
		if(flag){
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			flag=false;
		}
		System.out.println("改变结束");
	}
}
