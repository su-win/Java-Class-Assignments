package queues;
//Written by: Su Win

import java.util.Queue;

public abstract class MiddleMan implements Runnable {

	public static int DELAY = 20;
	Queue<?> in;
	Queue<Object> out;
	Object outObj;
	
	public MiddleMan(Queue<? extends Object> in, Queue<Object> out) {
		this.in = in;
		this.out = out;
		outObj = null;
	}
	
	public abstract boolean isInstance(Class clazz);
	

	
	@Override
	public void run() {
		while (true) {
			if (outObj == null) {
				synchronized(in) { 
					if ((in.peek() != null) && (isInstance(in.peek().getClass()))) {
						this.outObj = in.remove();
						
					} else {
						this.outObj = null;
						continue;
					}
				} 
			}
			if (outObj != null) {
				while (out.size() >= 10) { 
					try {
						Thread.sleep((long) (DELAY*Math.random()));
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					} 
				}

//Question 3

				synchronized(out) {

					if (out.size() >= 10) {
						continue;
					} else {
						out.offer(outObj);
						if (out.contains(null)) {
							System.out.println("why did this happen?");
						}
						outObj = null;
					}
				
				}
			
			}		
			try {
				Thread.sleep((long) (DELAY*Math.random()));
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			} 
		}
		
	}
	
	
}
