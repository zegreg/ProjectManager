import java.util.ArrayList;


public class TeamWorkers implements ProjectElements{

	private String name;
	private Consultant consultant;
	private Leader leader;
	ArrayList<Consultant> consultants = new ArrayList<Consultant>();
	
	public TeamWorkers(String name, Consultant consultant, Leader leader) {
		this.consultant = consultant;
		this.leader = leader;
		this.name = name;
	}
	
	
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getCosts() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	
}
