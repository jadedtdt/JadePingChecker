package jadePingChecker;

import java.util.LinkedList;
import java.util.Queue;

@SuppressWarnings("serial")
public class PingQueue extends LinkedList<Integer> {

	private int length, sum;

	private Queue<Integer> pingQueue;

	PingQueue(int queueLength) {
		this.length = queueLength;
		this.sum = 0;
	}

	@Override
	public Integer remove() {
		int head = super.remove();
		sum -= head;
		return head;
	}

	@Override
	public boolean add(Integer tail) {
		int oldSize = pingQueue.size();
		super.add(tail);
		sum += tail;
		return pingQueue.size() != oldSize;
	}

	public float getAvg() {
		return sum / (float) length;
	}

}
