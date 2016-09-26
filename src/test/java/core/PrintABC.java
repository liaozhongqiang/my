package core;

import java.util.concurrent.Semaphore;

public class PrintABC {

	public static void main(String[] args) {
		

		Semaphore semaphoreA = new Semaphore(1);

		Semaphore semaphoreB = new Semaphore(0);

		Semaphore semaphoreC = new Semaphore(0);

		int count = 10;

		Thread threadA = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < count; i++) {

					try {
						semaphoreA.acquire();
					} catch (InterruptedException e) {
						e.printStackTrace();
					} finally {
						System.out.println("A");
						semaphoreB.release();
					}

				}
			}
		});

		Thread threadB = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < count; i++) {

					try {
						semaphoreB.acquire();
					} catch (InterruptedException e) {
						e.printStackTrace();
					} finally {
						System.out.println("B");
						semaphoreC.release();
					}

				}
			}
		});

		Thread threadC = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < count; i++) {

					try {
						semaphoreC.acquire();
					} catch (InterruptedException e) {
						e.printStackTrace();
					} finally {
						System.out.println("C");
						semaphoreA.release();
					}

				}
			}
		});
		
		threadA.start();
		threadB.start();
		threadC.start();

	}

}
