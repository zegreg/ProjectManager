
/**
 * Class whose instance represent a consultant. This class extends {@link AWorker}. 
 * 
 * Implementation notes:
 * Each consultant are characterized by its name, the value of his Payment per hour, and the number
 * of hours of work, and if it is a leader/manager is characterized also by his bonus.
 * This class have two constructor because a consultant can be a leader and a leader receive a bonus. 
 * 
 * @author Filipa E., Filipa G., Gonçalo C., José O.
 * @since 6/11/2014
 */
public class Consultant extends AWorker
{
	private String workerName;
	private double workerCostByHour;
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
		this.workerCostByHour = cost;
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
		this.workerCostByHour = cost;
		this.workerHours = hours;
		this.workerName = name;
		this.bonus = bonus;
	}	

	/**
	 * @return element's name
	 */
	@Override
	public String getName()
	{
		return workerName;
	}

	/**
	 * @return cost of the object worker for all project
	 */
	@Override
	public double getCosts()
	{
		return workerCostByHour * workerHours + bonus;
	}

	/**
	 * @return cost of the object worker per hour
	 */
	@Override
	public double getHourCost()
	{
		return workerCostByHour;
	}
}
