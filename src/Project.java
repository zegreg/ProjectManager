import java.util.ArrayList;
import java.util.Set;

/**
 * 
 * @author José Oliveira
 *
 */
public class Project 
{
	private String name;
	private Consultant manager;
	private Local local;
	private TeamWorkers team;
	private ArrayList< IProjectElements > listCosts;
	private ContainerProjects containerProject;
	
	public Project( String name, Local local, Consultant manager, TeamWorkers team )
	{
		 this.name = name;		
		 this.manager = manager;
		 this.local = local;
		 this.team = team;
		 this.containerProject = new ContainerProjects();
		 
		 this.listCosts = new ArrayList< IProjectElements >();
		 listCosts.add( local );
		 listCosts.add( manager );
		 listCosts.add( team );
		 listCosts.add( containerProject );
	}
		
	@Override
	public String getName()
	{
		return name;
	}

	@Override
	public double getCosts()
	{
		double cost = 0;
		for( IProjectElements element : listCosts)
			cost += element.getCosts();
		return cost;
	}

	public boolean addProject( Project project )
	{		
		return containerProject.addProject( project );
	}

	public boolean addWorker( Consultant consultant )
	{
		return team.addWorker( consultant );
	}
	
	public Project getSubProject( int i )
	{
		return containerProject.getSubProject( i );
	}
	
	
	
	


	
}
