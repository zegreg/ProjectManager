
/**
 * This class 'TeamWorkers' implements the interface {@link IProjectElements};
 * It contains the name of the team and the consultants of the team;
 * 
 * @author Filipa E., Filipa G., Gonçalo C., José O.
 * @since 6/11/2014
 */
public class TeamWorkers extends AProjectElementsContainer
{
	private String name;

	public TeamWorkers(String name, Consultant leader )
	{
		// The list of workers of the team;
		super();
		// Name of the team;
		this.name = name;
		addElement( leader );
	}

	//ADDs
	@Override
	/**
	 * This method adds workers to the teamWorker ranked in ascending order of price per hour
	 */
	public boolean ordering(IProjectElements worker)
	{
		for( IProjectElements element : getElementsList() )
		{
			// if the worker we want to add to the team, earn less then some team member , the new consultant
			//will be inserted into the index array of other worker.
			if( ((AWorker)element).getHourCost() > ((AWorker)worker).getHourCost() )
			{
				getElementsList().add( getElementsList().indexOf(element), worker );
				return true;
			}
		}
		return getElementsList().add( worker );		
	}

	//Gets
	/**
	 * Searching a AWorker (consultant) in elementsList by name
	 * @return element if there is an element with the inserted name, null otherwise
	 */
	public AWorker getConsultantsByName( String name )
	{
		for( IProjectElements element : getElementsList() )
		{	
			//For each element of arrayList getElementsList , check if there is an element with 
			//the same name that was entered at the console. If it exists, returns the (AWorker)element
			if( element.getName().equals(name) )
				return (AWorker)element;
		}
		return null;
	}

	/**
	 * @return the name of the TeamWorker
	 */
	@Override
	public String getName()
	{
		return name;
	}
}







