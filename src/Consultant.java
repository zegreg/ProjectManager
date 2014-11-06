
<<<<<<< HEAD
public class Consultant extends Worker
{
=======
public class Consultant implements Worker, IProjectElements  {
>>>>>>> 7e77928a2809fa55e27a80d53a897a6b6dfaebfd

	
	private String workerName;
	private double workerCost;
	private double workerHours;
<<<<<<< HEAD
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
=======
	
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

	@Override
	public double getHourCost() {
>>>>>>> 7e77928a2809fa55e27a80d53a897a6b6dfaebfd
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	

}
