
public class Consultant implements ProjectElements {

	
	private String workerName;
	private double workerCost;
	private double workerHours;
	
	public Consultant( String name, double cost, double hours) {
		this.workerCost = cost;
		this.workerHours = hours;
		this.workerName = name;
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
