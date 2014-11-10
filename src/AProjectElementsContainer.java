import java.util.ArrayList;

/**
 * This class implements {@link IProjectElements}.
 * Is an abstract class that represent lists of elements of a project.
 * It cost is the sum of all elements costs of that list.
 * In addition, the elements can be sorted, using the abstract ordering method.
 * <p> Classes that extend this abstract class:
 * <ul><li> {@link ContainerProjects}
 * <li> {@link TeamWorkers}
 * <ul>
 * 
 * @author Filipa E., Filipa G., Gonçalo C., José O.
 * @since 6/11/2014
 */
public abstract class AProjectElementsContainer implements IProjectElements
{
	private ArrayList< IProjectElements > elementsList;

	//constructor
	public AProjectElementsContainer()
	{
		this.elementsList  = new ArrayList< IProjectElements >();
	}

	/**
	 * This method allows to get the cost of all the elements that are stored in the elementsList
	 * @return the total cost
	 */
	@Override
	public double getCosts()
	{
		double cost = 0;
		for( IProjectElements element : elementsList)
		{
			//For each element of the arrayList elementsList, add cost
			cost += element.getCosts(); 
		}
		return cost;
	}
	
	//ADDs
	/**
	 * This method allows to add IProjectElements objects;
	 * @param projectElement;
	 * @return boolean - true if the projectElement is add, false otherwise;
	 */
	public boolean addElement( IProjectElements projectElement )
	{
		//For each element of the arrayList elementsList
		for( IProjectElements element : elementsList )
		{
			// only adds new element in elementsList if there is another with the same name.
			if( element.getName().equals( projectElement.getName()) )   
				return false;  
		}
		ordering( projectElement );
		return true;
	}

	/**
	 * This method allows to sort the elements stored in an object of this class in the desired 
	 * order.
	 */
	public abstract boolean ordering( IProjectElements projectElement );
	
	//REMOVEs
	/**
	 * This method allows you to remove elements stored in an object of this class .
	 */
	public boolean remove( IProjectElements element )
	{
		return getElementsList().remove( element );
	}	
	
	//GETs
	/**
	 * @return elementsList
	 */
	public ArrayList< IProjectElements > getElementsList()
	{
		return elementsList;
	}
	
	/**
	 * Searching an element in elementsList using its name
	 * @return element if there is an element with the inserted name, null otherwise
	 */
	public IProjectElements getElementByName( String name )
	{
		for( IProjectElements element : getElementsList() )
		{
			//For each element of arrayList getElementsList, check if there is an element with 
			//the same name that was entered at the console. If it exists, returns the element
			if( element.getName().equals(name) )
				return element;
		}
		return null;
	}
	
	/**
	 * @return element name
	 */
	@Override
	public String getName()
	{
		return null;
	}
	
	//Info
	/**
	 * this method write the information stored in each element of elementsList
	 * @return containerElementsString
	 */
	public String writeInfo()
	{
		String containerElementsString = "";
		for( IProjectElements element : elementsList )
		{
			//Build a String with all the information stored in each element of the elementsList.
			//Each element is represented in a different line of the outputStream.
			containerElementsString += element.writeInfo()+ "\r\n";
		}

		return containerElementsString;
	}
}











