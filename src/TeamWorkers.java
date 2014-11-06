import java.util.ArrayList;


public class TeamWorkers implements IProjectElements{

	private String name;
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
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getCosts()
	{
		double cost = 0;
		for( Worker element : consultantsTeam)
		{
			cost += element.getCosts();
		}
		return cost;
	}
}
