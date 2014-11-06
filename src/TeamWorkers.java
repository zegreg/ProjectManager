import java.util.ArrayList;


public class TeamWorkers implements IProjectElements{

	private String name;
<<<<<<< HEAD
	private ArrayList< Worker > consultantsTeam;
	
	public TeamWorkers(String name, Consultant leader )
	{
		this.name = name;
		this.consultantsTeam  = new ArrayList< Worker >();
		consultantsTeam.add( leader );		
	}
	
	public boolean addWorker( Worker worker )
	{
		for( Worker element : consultantsTeam)
		{
			if( element.getName().equals( worker.getName() ))
				return false;
		}
		consultantsTeam.add( worker );
		return true;
	}
	
	
	
//	public Consultant getConsultant() {
//		return consultant;
//	}
//	
//	public double getLeaderBonus() {
//		return leaderBonus;
//	}
=======
	private Consultant consultant;
	private double leaderBonus;

	ArrayList<Consultant> consultants = new ArrayList<Consultant>();
	
	public TeamWorkers(String name, Consultant leader, double leaderBonus) {
		this.consultant = leader;
		this.name = name;
		this.leaderBonus = leaderBonus;
		
	}
	
	public Consultant getConsultant() {
		return consultant;
	}
	
	public double getLeaderBonus() {
		return leaderBonus;
	}
>>>>>>> 7e77928a2809fa55e27a80d53a897a6b6dfaebfd
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
<<<<<<< HEAD
	public double getCosts()
	{
		double cost = 0;
		for( Worker element : consultantsTeam)
		{
			cost += element.getCosts();
		}
		return cost;
	}
=======
	public double getCosts() {
		// TODO Auto-generated method stub
		return 0;
	}



	public void addConsultant(Consultant consultant) {
		this.consultants.add(consultant);
		
	}

	
	
>>>>>>> 7e77928a2809fa55e27a80d53a897a6b6dfaebfd
}
