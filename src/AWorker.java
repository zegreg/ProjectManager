/**
 * This class implements {@link IProjectElements} - All elements have names and associated cost. 
 * Its elements are objects that can be added to the teams. It allows to create new classes of 
 * type Worker with objects different than the consultant type.
 * 
 * @author Filipa E., Filipa G., Gonçalo C., José O.
 * @since 6/11/2014
 *
 */
public abstract class AWorker  implements IProjectElements
{	
	/**
	 * Allows to get the cost of the object worker
	 * @return cost
	 */
	public abstract double getHourCost();
	
	/**
	 * @return String with the name of the worker and his cost
	 */
	@Override
	public String writeInfo()
	{
		return getName() +", payment per hour:" +getHourCost() +"€"+", cost: " +getCosts() +"€";
	}
}