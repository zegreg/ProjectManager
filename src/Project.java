import java.util.Set;

/**
 * 
 * @author José Oliveira
 *
 */
public class Project implements IProjectElements, IProject {

	private String name;
	private Consultant manager;
	private Local local;
	
	
	
	public Project(String name, Consultant manager,  Local local) {
		 this.manager = manager;
		 this.name = name;
		 this.local = local;
		 
	
	}
		
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getCosts() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public IProjectElements addProject() {
		
		return ;
	}


	
}
