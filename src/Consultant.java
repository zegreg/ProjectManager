
public class Consultant extends Worker
{

	
	private String workerName;
	private double workerCost;
	private double workerHours;
	private double bonus;
	
	/**
	 * Consultant without bonus
	 * @param name
	 * @param cost
	 * @param hours
	 */
	public Consultant( String name, double cost, double hours)
	{
		this.workerCost = cost;
		this.workerHours = hours;
		this.workerName = name;
		this.bonus = 0;
	}

	/**
	 * consultant with bonus -> leader / manager
	 * @param name
	 * @param cost
	 * @param hours
	 * @param bonus
	 */
	public Consultant( String name, double cost, double hours, double bonus)
	{
		this.workerCost = cost;
		this.workerHours = hours;
		this.workerName = name;
		this.bonus = bonus;
	}
	
	
	@Override
	public String getName()
	{
		return workerName;
	}

	@Override
	public double getCosts()
	{
		return workerCost * workerHours + bonus;
	}

	@Override
	public double getHourCost()
	{
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	

}
