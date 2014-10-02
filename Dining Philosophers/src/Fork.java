
public class Fork implements IFork {
	
	private boolean available;
	
	public Fork() {
		this.available = true;
	}


	public synchronized void acquire() {
		while (this.available == false) {
			try {
				wait();
			} catch (Exception e) {
				System.err.println( "Abort. Unexpected thread interruption.");
			}
			
		}
		this.available = false;
	}


	public void release() {
		this.available = true;
		notifyAll();	
	}
	
	

}
