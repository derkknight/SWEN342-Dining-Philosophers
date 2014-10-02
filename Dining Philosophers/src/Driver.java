import java.util.ArrayList;


public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if (args.length <= 4)
		{
			int np;
			int nt;
			int tm;
			int em;
			
			for (int i = 0; i <= args.length; i++)
			{
				if (Integer.parseInt(args[i]) < 0)
				{
					System.out.println("No negative numbers!");
					System.exit(0);
				}
			}
			if (args.length == 3)
			{
				np = 4;
				nt = Integer.parseInt(args[0]);
				tm = Integer.parseInt(args[1]);
				em = Integer.parseInt(args[2]);
			}
			else
			{
				np = Integer.parseInt(args[0]);
				nt = Integer.parseInt(args[1]);
				tm = Integer.parseInt(args[2]);
				em = Integer.parseInt(args[3]);
			}
			
			ArrayList<Fork> forks = new ArrayList<Fork>();
			ArrayList<Philosopher> phils = new ArrayList<Philosopher>();
			for (int i = 0; i < np - 1; i++)
			{
				forks.add(new Fork());
			}
			for (int i = 0; i < np; i++)
			{
				phils.add(new Philosopher());
				//phils.add(new Philosopher(i, i, (np+i-1)%np,nt, tm, em));
			}

		}
		
		for (int i = 1; i <= 4; i++)
		{
			if (Integer.parseInt(args[i]) < 0)
			{
				System.out.println("No negative numbers!");
			}
		}
		
		//Creates an array of np Forks
		
		
		//np Philosopher threads are created, where Philospher's i right fork is i and left fork is (np + i - 1)%np
		//note that i rnages from 0 to np - 1
	}

}
