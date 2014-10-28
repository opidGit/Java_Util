package Time;

public class Timer {
	private double start;
	private double stop;

	public void start() {
		start = System.nanoTime();
		// start = System.currentTimeMillis();
	}

	public void stop() {
		stop = System.nanoTime();
	}

	public double getRunTimeNano() {
		return stop - start;
	}

	public void printExecTime() {
		double ns = stop - start;
		double ms = ns / 1000000;
		// double sec = ms / 1000;
		System.out.println("Processing time : " + ms + " ms");
	}
}
