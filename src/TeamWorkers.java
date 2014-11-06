import java.util.ArrayList;


public class TeamWorkers implements IProjectElements{

	private String name;
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



	public void addConsultant(Consultant consultant) {
		this.consultants.add(consultant);
		
	}

	
	
}
