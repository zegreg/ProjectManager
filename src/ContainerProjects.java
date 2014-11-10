
/**
 * This class extends {@link AProjectElementsContainer}
 * The instances of this class represents a project Container.
 * It cost is the sum of all elements costs in that container.
 * In addition, the elements are sorted by name.
 * 
 * @author Filipa E., Filipa G., Gonçalo C., José O.
 * @since  6/11/2014
 */
public class ContainerProjects extends AProjectElementsContainer
{
	public ContainerProjects()
	{
		super();
	}

	//ADDs
	/**
	 * This method add a subproject to a project ordered by alphabetical order,
	 */
	@Override
	public boolean ordering( IProjectElements project )
	{
		for( IProjectElements element : getElementsList() )
		{
			// the compareToIgnoreCase, compares two string (ignore case) and returns an integer, depending on the 
			//lexicographical order 
			if( element.getName().compareToIgnoreCase( project.getName() ) > 0 )
			{
				// if the subproject that we want to add to the project, in alphabetical order cames
				// first then a certain project already inserted it will be inserted into the index 
				//array of other subproject.
				getElementsList().add( getElementsList().indexOf(element), project );
				return true;
			}
		}
		return getElementsList().add( project );
	}
	
	//GETs
	/**
	 * Searching a project in elementsList by name
	 * @return element if there is an element with the inserted name, null otherwise
	 */
	@Override
	public Project getElementByName( String name )
	{
		//For each element of arrayList getElementsList , check if there is an element (project/subproject) with 
		//the same name that was entered at the console. If it exists, returns the (Project)element
		for( IProjectElements element : getElementsList() )
		{
			if( ((Project)element).getSubProjectByName( name ) == null)
				continue;
			else
				return ((Project)element).getSubProjectByName(name);
		}
		return null;
	}

}




