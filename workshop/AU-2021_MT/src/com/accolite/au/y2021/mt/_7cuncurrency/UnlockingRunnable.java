package com.accolite.au.y2021.mt._7cuncurrency;

/**
 * 
 * @author sree
 *
 */
public class UnlockingRunnable implements Runnable {

	static Thread getThreadInstance(String name, Object lock) {
		return new Thread(new UnlockingRunnable(lock), name);
	}

	private final Object lock;

	public UnlockingRunnable (Object lock) {
		this.lock = lock;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " -- Started.");
		try {
			criticalSection();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	void criticalSection() throws InterruptedException {
		// Sree: Topoc w &w/o Sync
		synchronized (lock) {
			System.out.println(Thread.currentThread().getName() + " -- Going to Unlock.");
			//lock.notifyAll();
			lock.notify();
			System.out.println(Thread.currentThread().getName() + " -- Done.");

		}
	}
}
