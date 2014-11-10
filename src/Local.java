
/**
 * This Class implement {@link IProjectElements}.
 * <p> Local Implementation:
 * <ul> <li> Local name;
 * <li> Localization;
 * <li> Local costs.
 * </ul>
 * 
 * @author Filipa E., Filipa G., Gonçalo C., José O.
 * @since  6/11/2014
 */
public class Local implements IProjectElements
{
	private String name;
	private String Localization;
	private double cost;
	
	/**
	 * Constructor
	 * @param local
	 * @param name
	 * @param cost
	 */
	public Local( String name, String local, double cost )
	{
		this.name = name;
		this.Localization = local;
		this.cost = cost;
	}
	
	@Override
	public String getName()
	{
		return name;
	}
	
	public String getLocal()
	{
		return Localization;
	}

	@Override
	public double getCosts()
	{		
		return cost;
	}

	@Override
	public String writeInfo()
	{
		return getName() +", " +getLocal() +", cost: " +getCosts() +"€";
	}

	
	
}
