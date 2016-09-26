package core;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.Date;

import org.junit.Test;

public class ReferenceTest {
	
	@Test
	public void testSoftReference() throws InterruptedException {
		SoftReference<Date> sr = new SoftReference<>(new Date());
		System.gc();
		Thread.sleep(2000);
		System.out.println(sr.get());
	}
	
	@Test
	public void testWeakReference() throws InterruptedException{
		ReferenceQueue<Date> queue = new ReferenceQueue<>();
		WeakReference<Date> wr = new WeakReference<Date>(new Date(),queue);
		System.gc();
		Thread.sleep(2000);
		System.out.println(wr.get());
		System.out.println(queue.poll());
	}
	
	@Test
	public void testPhantomReference() throws InterruptedException{
		ReferenceQueue<Date> queue = new ReferenceQueue<>();
		PhantomReference<Date> pr=new PhantomReference<Date>(new Date(), queue);
		System.gc();
		System.out.println(queue.remove());
		System.out.println(pr);
	}
}
