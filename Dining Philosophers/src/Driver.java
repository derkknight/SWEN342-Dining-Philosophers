import java.util.ArrayList;


public class Driver {

	public static void main(String[] args) {

		boolean hasLHanded = false;
		long np = 4;
		int nt = 10;
		long tm = 0;
		long em = 0;
		int count = 0;
	
		//parse all command line arguments, if any were provided
		// *NOTE* parser only assumes that correct arguments are given. does not handle otherwise 
		
		if (args.length > 0) {
			
			//check the first parameter. if args[0] is "-l" then set flag for left-handed philosophers.
			// otherwise, parse first integer value and set np to it
			
			if (args[0].equals("-l")) {
				hasLHanded = true;
			} else {
				if (Integer.parseInt(args[0]) >= 0) {
					np = Integer.parseInt(args[0]);
					count++;
				} else {
					System.err.println("No negative numbers");
					System.exit(1);
				}
			}
		
			//parse the rest of the command arguments, if any exist
			
			for(int i = 1; i < args.length; i++) {
				if (Integer.parseInt(args[i]) < 0) {
					System.err.println("No negative numbers");
					System.exit(1);
				}
			
				//switch statement to handle setting each variable
				//since it is given that each argument is given in the same order
				
				switch (count) {
					case 1: nt = Integer.parseInt(args[i]);
							break;
					case 2: tm = Integer.parseInt(args[i]);
							break;
					case 3: em = Integer.parseInt(args[i]);
				}
				count++;
			}
		}
		
		ArrayList<Fork> forks = new ArrayList<Fork>();
		
		//fill the Fork ArrayList with Forks
		
		for (int i = 0; i < np ; i++)
		{
			forks.add(new Fork());
		}
		
		// create and start each of the np philosophers
		
		for (int i = 0; i < np; i++)
		{
			int np_int = (int)np;
			
			//if there are left handed philosophers and if creating an odd-numbered philosopher, make them left handed
			
			if (hasLHanded) {
				if ((i % 2) != 0) {
					(new Philosopher(i, forks.get(i), forks.get((np_int+i-1)%np_int), false, nt, tm, em)).start();
					continue;
				}
			}
			
			// create right handed-philosophers
			
			(new Philosopher(i, forks.get(i), forks.get((np_int+i-1)%np_int), true, nt, tm, em)).start();
		}
	}

}
