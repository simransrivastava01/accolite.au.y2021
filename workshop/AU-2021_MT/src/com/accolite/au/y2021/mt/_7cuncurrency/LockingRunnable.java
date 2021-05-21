package com.accolite.au.y2021.mt._7cuncurrency;

/**
 * 
 * @author sree
 *
 */
public class LockingRunnable implements Runnable {

	static Thread getThreadInstance(String name, Object lock) {
		return new Thread(new LockingRunnable(lock), name);
	}
	
	private final Object lock;
	
	public LockingRunnable (Object lock) {
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
		System.out.println(Thread.currentThread().getName() + " -- Completed.");
	}

	void criticalSection() throws InterruptedException {
		// Sree: Topoc w &w/o Sync
		synchronized (lock) {
			System.out.println(Thread.currentThread().getName() + " --Entered critical section. Going to Sleep for some time.");
			
			// Sree: Significance of sleep here.
			Thread.sleep(10000L);
			
			System.out.println(Thread.currentThread().getName() + " --Going to release the lock.");
			lock.wait();
		}
	}
}
