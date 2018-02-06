package jadePingChecker;

public class JadePingChecker {	

	public static enum State {
		IDLE, RUNNING, STOPPED
	}

	private State state;

	public JadePingChecker() {
		this.setState(State.STOPPED);
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public void toggleState() {
		state = state.equals(State.IDLE) ? State.RUNNING : State.IDLE;
	}

	public void fetchPing() {

	}

	public void run() {
		new Thread(() -> {
			handleState();
		}).start();
	}

	public void handleState() {
		switch (state) {
		case RUNNING:
			fetchPing();
		case IDLE:
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
			}
			break;
		case STOPPED:
			System.exit(0);
			break;
		}
	}

}
