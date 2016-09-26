package gof.watch;

import java.util.Observer;

public class WatchTest {
	
	public static void main(String[] args) {
		Watched o = new Watched();
		Observer watcher = new Watcher(o);
		o.setData("我改了！");
	}

}
