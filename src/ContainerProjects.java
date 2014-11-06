import java.util.ArrayList;


public class ContainerProjects implements IProjectElements
{
	private ArrayList< Project > subProjects;
	
	public ContainerProjects()
	{
		this.subProjects  = new ArrayList< Project >();
	}
	
	public boolean addProject( Project project)
	{
		for( Project element : subProjects)
		{
			if( element.getName().equals( project.getName() ))
				return false;
		}
		
		for( Project element : subProjects)
		{
			if( element.getName().compareToIgnoreCase( project.getName() ) > 0 )
			{
				subProjects.add(subProjects.indexOf( element ), project);
				return true;
			}
		}
		subProjects.add( project );
		return true;
	}
	
	
	@Override
	public String getName()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getCosts()
	{
		double cost = 0;
		for( Project element : subProjects)
		{
			cost += element.getCosts();
		}
		return cost;
	}

	public Project getSubProject(int i)
	{
		return subProjects.get( i );
	}
	

}
