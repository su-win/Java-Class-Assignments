//Written by: Su Win

package PartI;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;


public class Packet {
	private Byte[] payload;
	private int priority;
	ArrayList<Integer> arr = new ArrayList<Integer>();
	
	public Packet(Byte[] payload, int priority){
		this.payload = payload;
		this.priority = priority;
		int length = payload.length;
		byte[] convert = new byte[length];
		for (int i = 0; i < length; i++) {
			  Byte b = payload[i];
			  if (b != null) {
				  convert[i] = b.byteValue();
			  }
		}
	}
	
	@Override
	public String toString() {
		int length = payload.length;
		byte[] convert = new byte[length];
		for (int i = 0; i < length; i++) {
			  Byte b = payload[i];
			  if (b != null) {
				  convert[i] = b.byteValue();
			  }
		}
		String s = new String(convert);
		
		return "priority: " + priority + " packet: " + s;
	}
	
	public static void main(String[] args) {
		PriorityQueue<Packet> pq = new PriorityQueue<Packet>();
		
		class compareCustom implements Comparator<Packet>{
		public int compare(Packet p1, Packet p2) {
			return p2.priority - p1.priority;
			}
		}
	
		Comparator<Packet> priorityCompare = new compareCustom();
		pq = new PriorityQueue<>(priorityCompare);

		
		//5 is the highest priority Packet
		//1 is the lowest priority Packet. 
		for (int i=0;i<10;i++) {
			Byte[] payload = new Byte[256];
			int priority = (int)(Math.random()*5) + 1;
			Packet p = new Packet(payload, priority);
			pq.add(p);
		}
		
		while (!pq.isEmpty()) {
			System.out.println("got packet " + pq.remove());
		}
	}

}

