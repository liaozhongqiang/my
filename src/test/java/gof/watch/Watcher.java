package gof.watch;

import java.util.Observable;
import java.util.Observer;

public class Watcher implements Observer{
	
	public Watcher(Observable o) {
		o.addObserver(this);
	}

	@Override
	public void update(Observable o, Object arg) {
		System.out.println("被观察者状态改变了"+((Watched)o).getData());
	}

}
