package com.ruegnerlukas;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

import com.ruegnerlukas.simpleutils.logging.builder.MessageGroupBuilder;
import com.ruegnerlukas.simpleutils.logging.logger.Logger;


public class LoggerTest {

	
	
	
	public static void main(String[] args) {
		
		Logger.get().setMessageBuilder(MessageGroupBuilder.createByThread("    - "));

		
		final int N_THREADS = 20;
		AtomicInteger counter = new AtomicInteger();
		counter.set(0);
		
		List<Thread> threads = new ArrayList<Thread>();
		
		for(int i=0; i<N_THREADS; i++) {
			Thread t = new Thread() {
				@Override
				public void run() {
					
					Logger.get().debug("Thread ", Thread.currentThread().getId(), " START");
					
					Random random = new Random();
					
					for(int i=0; i<30; i++) {

						Logger.get().debug("Thread ", Thread.currentThread().getId(), " in loop ", i);
						
						if(random.nextInt(100) > 70) {
							try {
								Thread.sleep(random.nextInt(300));
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						
					}
					
					Logger.get().debug("Thread ", Thread.currentThread().getId(), " DONE");
					counter.incrementAndGet();
					
				}
			};
			threads.add(t);
		}
		
		
		for(Thread t : threads) {
			t.start();
		}
		
		
		while(counter.get() < N_THREADS) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		
		Logger.get().debug("ALL THREADS DONE");
		
	}
	
	
	
}
