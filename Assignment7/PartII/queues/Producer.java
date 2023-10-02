package queues;
//Written by: Su Win

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Random;

public class Producer implements Runnable {

	public static final int DELAY = 10;
	public static final int MAX_QUEUE_SIZE = 100;
	
	Queue<Object> out;
	ArrayList<String> words;
	
	public Producer(Queue<Object> out) {
		this.out = out;
		words = new ArrayList<String>();
		try {
			FileReader f = new FileReader("data/words");
			BufferedReader r = new BufferedReader(f);
			String inLine = r.readLine();
			while (inLine != null) {
				words.add(inLine);
				inLine = r.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
		
		
	}
	
	@Override
	public void run() {
		while(true) {
//			synchronized(out) {
				if (out.size() < MAX_QUEUE_SIZE) {
					// create a new object
					double d = Math.random();
					if (d < 0.5) {
						int size = words.size();
						int idx = new Random().nextInt(size);
						String obj = words.get(idx);
						out.offer(obj);
					} else {
						Integer outNum = new Random().nextInt();
						out.offer(outNum);
					}
				}
//			}
			try {
				Thread.sleep((long) (Math.random()*DELAY));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

		
	
}
