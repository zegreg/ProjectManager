/**
 * Interface that represent the elements in a project. They have a name and a cost.
 * <p> Elements that implement this interface:
 * <ul><li> {@link AWorker};
 * <li> {@link AProjectElementsContainer};
 * <li> {@link Local};
 * <li> {@link Project};
 * </ul>
 * 
 * @author Filipa E., Filipa G., Gonçalo C., José O.
 * @since 6/11/2014
 *
 */
public interface IProjectElements
{
	/**
	 * @return element name
	 */
	public String getName();

	/**
	 * @return element costs
	 */
	public double getCosts();
	
	/**
	 * This method allows to write a String with necessary info (name and cost)
	 */
	public String writeInfo();
}
