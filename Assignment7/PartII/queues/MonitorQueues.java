package queues;
//Written by: Su Win

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class MonitorQueues implements Runnable {

	Queue<Object> generalPurposeQueue;
	Queue<Object> integerQueue;
	Queue<Object> stringQueue;
	
	private IntegerMiddleMan m1,m2;
	private StringMiddleMan m3,m4;
	private Consumer c1;
	private Consumer c2;
	private Producer p;
	private static final int DELAY = 10;
	
	public MonitorQueues() {
		generalPurposeQueue = new LinkedList<Object>();
		integerQueue = new ConcurrentLinkedQueue<Object>();
		stringQueue = new ConcurrentLinkedQueue<Object>();
		
		p = new Producer(generalPurposeQueue);
		m1 = new IntegerMiddleMan(generalPurposeQueue, integerQueue);
		m2 = new IntegerMiddleMan(generalPurposeQueue, integerQueue);
		m3 = new StringMiddleMan(generalPurposeQueue, stringQueue);
		m4 = new StringMiddleMan(generalPurposeQueue, stringQueue);
		c1 = new Consumer(integerQueue);
		c2 = new Consumer(stringQueue);
		
	}

	@Override
	public void run() {
		//set the name of the thread to be able to trace the program
		new Thread(c1,"c1").start(); //start consumer
		new Thread(c2,"c2").start();
		new Thread(m1,"integermiddle1").start(); //start integer middle man
		new Thread(m2,"integermiddle2").start();
		new Thread(m3,"stringmiddle3").start(); //start string middle man
		new Thread(m4,"m4").start();
		new Thread(p,"p").start(); //start producer
		
		while (true) {
			
			if (integerQueue.size() > 10) {
				System.out.println("Alert. Queue 1  > 10. Shouldn't happen");
			}

			if (stringQueue.size() > 10) {
				System.out.println("Alert. Queue 2 > 10. Shouldn't happen");
			}
			
			if (generalPurposeQueue.size() > Producer.MAX_QUEUE_SIZE) {
				System.out.println("Alert. Input Queue > " + Producer.MAX_QUEUE_SIZE + ". Shouldn't happen");
			}
			
			try {
				Thread.sleep(DELAY);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		
	}
	
	public static void main(String[] args) {
		MonitorQueues mq = new MonitorQueues();
		Thread t = new Thread(mq);
		t.start();
	}
}



