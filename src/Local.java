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
<<<<<<< HEAD
	public Local(  String name, String local, double cost) {
=======
	public Local( String local, String name, double cost) {
>>>>>>> 7e77928a2809fa55e27a80d53a897a6b6dfaebfd
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
<<<<<<< HEAD
	public double getCosts()
	{		
=======
	public double getCosts() {
		
>>>>>>> 7e77928a2809fa55e27a80d53a897a6b6dfaebfd
		return cost;
	}

	
	
}
