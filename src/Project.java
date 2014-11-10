import java.util.ArrayList;

/**
 * <p>Class that implement {@link IProjectElements} whose instance represent a Project.
 * <p>Implementation Notes:
 * <ul><li> A project has a name and it is managed by a consultant who is not inserted into any team;
 * <li> A project has a consultant team who has a consultant leader.
 * <li> Each project has his own location.
 * </ul>
 *
 * @author Filipa E., Filipa G., Gonçalo C., José O.
 * @since 6/11/2014
 */
public class Project implements IProjectElements
{
	private String name;
	private Consultant manager;
	private Local local;
	private AProjectElementsContainer team;
	private AProjectElementsContainer containerProject;

	/**
	 * Constructor that receives a name, a local, a manager and a team to create a new object.
	 * Each project has embedded a listCost that will store all the elements of the project (local, 
	 * manager, team and the subprojects container). 
	 * @param project name 
	 * @param project local
	 * @param consultant manager
	 * @param consultant team
	 */
	public Project( String name, Local local, Consultant manager, AProjectElementsContainer team )
	{
		this.name = name;
		//Local de trabalho associado ao projecto
		this.local = local;
		//Nome do gestor do projecto
		this.manager = manager;
		//Equipa de trabalho associada ao projecto
		this.team = team;			  
		//Criação de um contentor para armazenar os possíveis subprojectos
		this.containerProject = new ContainerProjects();
	}

	/**
	 * Return the total costs of this project and subprojects if they exists
	 * @return cost of the project
	 */
	@Override
	public double getCosts()
	{
		return local.getCosts() + manager.getCosts() + team.getCosts() + containerProject.getCosts();
	}

	//ADDs
	/**
	 * Each project can add a new <i>{@link AWorker} </i>into a team.
	 * @param consultant
	 * @return call addWorker method of <i>{@link TeamWorker}<i> Class
	 */
	public boolean addWorker( AWorker worker)
	{
		if( worker.getName().equals( manager.getName()) )
			return false;
		return team.addElement( worker );
	}

	/**
	 * Each project can add new projects into a container project, define in <i>{@link ContainerProjects}</i> class.
	 * @param project
	 * @return Call addProject method of <i> {@link ContainerProject} </i> Class
	 */
	public boolean addProject( Project project )
	{
		return containerProject.addElement( project.ChangeName( project, this.name +" - " +project.name) );
	}

	/**
	 * This method allows to change the name of a project previously created, be it the initial 
	 * project, whether a subproject of this.
	 * @param string name of the consultant that we want to find
	 * @param project which we want to change the name
	 * @return true if the consultant was removed and false otherwise.
	 */
	private Project ChangeName(Project project, String newName)
	{
		project.setName( newName );
		return project;
	}

	//REMOVEs
	/**
	 * This method remove a consultant for a team work of a project previously created, be it the initial 
	 * project, whether a subproject of this
	 * @param string name of the consultant that we want to find
	 * @return true if the consultant was removed and false otherwise.
	 */
	public boolean removeConsultant( String name )
	{
		return team.remove( getConsultantsByName(name) );
	}

	/**
	 * This method remove a subproject form a project previously created, be it the initial project,
	 * whether a subproject of this
	 * @param string name of the project that we want to find
	 * @return true if the subproject was removed and false otherwise.
	 */
	public boolean removeProject( String name )
	{
		return containerProject.remove( getSubProjectByName(name) );		
	}

	//GETs
	/**
	 * This Method allows to find a subproject stored in the container by name. 
	 * @param string name of the project that we want to find
	 * @return project if the project with this name exists in this level or call getSubProjectByName again to 
	 * search if the project exists in the next level. The call continuous until return the project or null
	 */
	public Project getSubProjectByName(String string)
	{
		return ( getName().equals(string) ? this : (Project)containerProject.getElementByName(string) );
	}

	/**
	 * This Method return the subproject by a given name
	 * @param name  name of the subproject
	 * @return call getSubProject method of <i>{@link ContainerProject}</i>
	 */
	public IProjectElements getConsultantsByName( String name )
	{
		return team.getElementByName( name );
	}

	/**
	 * Return the name of the project
	 */
	@Override
	public String getName()
	{
		return name;
	}

	/**
	 * @return team
	 */
	public ArrayList< IProjectElements > getTeam()
	{
		return this.team.getElementsList();
	}

	/**
	 * @return project container
	 */
	public ArrayList< IProjectElements > getContainerProject()
	{
		return this.containerProject.getElementsList();
	}
	
	/**
	 * This method allows to set the name of a project/subproject
	 */
	public void setName(String newName)
	{
		this.name = newName;
	}

	/**
	 * @return the project info
	 */
	public String writeInfo()
	{
		return getName() +", cost: "+ getCosts() +"€"
				+"\r\nLocal: " +local.writeInfo()
				+"\r\nManager: " +manager.writeInfo()
				+"\r\nTeam: " +team.writeInfo()
				+"\r\n" +containerProject.writeInfo() +"\n";
	}

}







