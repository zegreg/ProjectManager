/**
 * This Class give us the local name and it´s local cost.
 * <p> Local Implementation :
 * <ul> <li> Localization;
 * <li> Local name;
 * <li> Local costs;
 * </ul>
 * 
 * 
 * @author José Oliveira
 *
 */
public class Local implements IProjectElements {

	
	private String Localization;
	private String name;
	private double cost;
	
	/**
	 * Constructor
	 * @param local
	 * @param name
	 * @param cost
	 */
	public Local( String local, String name, double cost) {
		this.cost = cost;
		this.Localization = local;
		this.name = name;
	}
	
	public String getLocal() {
		return Localization;
	}
	
	
	@Override
	public String getName() {
		
		return name;
	}

	@Override
	public double getCosts() {
		
		return cost;
	}

	
	
}
