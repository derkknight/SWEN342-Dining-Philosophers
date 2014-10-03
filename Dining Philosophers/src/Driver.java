import java.util.ArrayList;


public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean rhanded = true;
		if (args.length <= 4)
		{
			long np;
			int nt;
			long tm;
			long em;
			
			for (int i = 0; i < args.length; i++)
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
				tm = Long.parseLong(args[1]);
				em = Long.parseLong(args[2]);
			}
			else
			{
				np = Long.parseLong(args[0]);
				nt = Integer.parseInt(args[1]);
				tm = Long.parseLong(args[2]);
				em = Long.parseLong(args[3]);
			}
			
			ArrayList<Fork> forks = new ArrayList<Fork>();
			ArrayList<Philosopher> phils = new ArrayList<Philosopher>();
			for (int i = 0; i < np ; i++)
			{
				forks.add(new Fork());
			}
			for (int i = 0; i < np - 1; i++)
			{
				int np_int = (int)np;
				(new Philosopher(i, forks.get(i), forks.get((np_int+i-1)%np_int), rhanded, nt, tm, em)).start();
			}

		}
		
	}

}
