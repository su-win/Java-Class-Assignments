package queues;
//Written by: Su Win

import java.util.Queue;

public class StringMiddleMan extends MiddleMan {

	public StringMiddleMan(Queue<Object> in, Queue<Object> out) {
		super(in, out);
		
	}

	@Override
	public boolean isInstance(Class clazz) {
		if (clazz == String.class) {
			return true;
		}
		return false;
	}

}
