import java.util.Random;

public class Philosopher extends Thread{
	private int id;
	private Fork right;
	private Fork left;
	private boolean rightHanded;
	private int nTimes;
	private long thinkMillis;
	private long eatMillis;

	/*-----------------------------------------------------------------------------------
	 * Constructor for the Philosopher class.
	 * 
	 * @param id     The id integer for this philosopher
	 * @param right  The philosopher's right fork
	 * @param left   The philosopher's left fork
	 * @param rightHanded    Boolean value determining hand dominance.
	 * @param nTimes    value for the number of times the philosopher will wait and eat
	 * @param thinkMillis     upper bound value for how long the philosopher will think
	 * @param eatMillis    upper bound value for how long the philosopher will eat
	 ------------------------------------------------------------------------------------*/
	
	public Philosopher(int id, Fork left, Fork right, boolean rightHanded, 
			int nTimes, long thinkMillis, long eatMillis) {
		this.id = id;
		this.right = right;
		this.left = left;
		this.rightHanded = rightHanded;
		this.nTimes = nTimes;
		this.thinkMillis = thinkMillis;
		this.eatMillis = eatMillis;
	}
	
	public void run() {
		Random randomizer = new Random();
		long waitTime = 0; // variable for sleep length created through Random object
		
		for(int i = 0; i < nTimes; i++) {
			
			//think about eating
			
			waitTime = (long)(randomizer.nextDouble()*thinkMillis);
			System.out.println("Philosopher " + id + " thinks for " + waitTime + " time units");
			
			try {
			sleep(waitTime);
			} catch(InterruptedException e) {
				System.err.println("Philosopher " + id + " sleeps forever... (Error)");
			}
		
			//acquire the forks. if right-handed, philosopher starts with acquiring the right fork, then the left.
			//if left-handed, the philosopher acquires the left fork first, then the right.
			
			if (rightHanded) {
				System.out.println("Philosopher " + id + " goes for right fork.");
				right.acquire();
				System.out.println("Philosopher " + id + " has right fork.");
				Thread.yield();
				System.out.println("Philosopher " + id + " goes for left fork.");
				left.acquire();
				System.out.println("Philosopher " + id + " has left fork.");
			} else {
				System.out.println("Philosopher " + id + " goes for left fork.");
				left.acquire();
				System.out.println("Philosopher " + id + " has left fork.");
				Thread.yield();
				System.out.println("Philosopher " + id + " goes for right fork.");
				right.acquire();
				System.out.println("Philosopher " + id + " has right fork.");
			}
			
			//begin eating.
			
			waitTime = (long)(randomizer.nextDouble()*eatMillis);
			System.out.println("Philosopher " + id + " eats for " + waitTime + " time unints");
			
			try {
				sleep(waitTime);
			} catch(InterruptedException e) {
				System.err.println("Philosopher " + id + " eats himself to death... (Error)");
			}
			
			//release both forks once completed eating
			
			right.release();
			System.out.println("Philosopher " + id + " releases right fork.");
			left.release();
			System.out.println("Philosopher " + id + " releases left fork.");
		}
	}
}
