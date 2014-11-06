import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class ProjectManagerTest
{
	private Project project;

	@Before
	public void test()
	{	
		//Arrange
		double costHour = 10;
		double hour = 5;
		double bonus = 50;
		Consultant manager = new Consultant("Filipa", costHour, hour); //50
		Consultant leader = new Consultant("Jose", costHour, hour, bonus); //100
		TeamWorkers team = new TeamWorkers ("team", leader);

		Local local = new Local("RT", "Lisboa", 300); //300
		project = new Project( "project", local, manager, team );

		Consultant consultant1 = new Consultant("Gonçalo", 1, 2); //2

		//Act		
		project.addWorker( consultant1 );
	}

	@Test
	public void gestTotalCost_test()
	{	
		//Assert
		assertTrue( project.getCosts() ==  452);
	}

	@Test
	public void shouldNotAcepetTheSameConsultant_test()
	{	
		//Assert
		assertFalse( project.addWorker( new Consultant("Gonçalo", 4, 6) ) );
	}

	@Test 
	public void getTotalCost_withNewProject_test()
	{	
		//Arrange
		Local local = new Local("RT", "Porto", 500); //500
		Consultant manager = new Consultant("Filipa", 1, 3); //3
		Consultant leader = new Consultant("Jose", 10, 10, 100); //200
		TeamWorkers team = new TeamWorkers ("team", leader);

		Project subproject = new Project( "subproject", local, manager, team );

		//Act
		project.addProject(subproject);

		//Assert
		assertTrue( project.getCosts() ==  1155);
	}

	@Test
	public void shouldNotAcepetTheSameProject_test()
	{	
		//Arrange
		//Subproject_0
		Local local = new Local("RT", "Porto", 500); //500
		Consultant manager = new Consultant("Filipa", 1, 3); //3
		Consultant leader = new Consultant("Jose", 10, 10, 100); //200
		TeamWorkers team = new TeamWorkers ("team", leader);
		Project subproject = new Project( "subproject", local, manager, team );

		//Subproject_1
		Local local1 = new Local("RT", "Porto", 500); //500
		Consultant manager1 = new Consultant("Filipa", 1, 3); //3
		Consultant leader1 = new Consultant("Jose", 10, 10, 100); //200
		TeamWorkers team1 = new TeamWorkers ("team", leader);
		Project subproject1 = new Project("subproject", local1, manager1, team1);

		//Act
		project.addProject(subproject);

		//Assert
		assertFalse( project.addProject(subproject1)  );
	}

	@Test
	public void shoulSortByNameSubProjects_test()
	{	
		//Arrange
		//Subproject_0
		Local local = new Local("RT", "Porto", 500); //500
		Consultant manager = new Consultant("Filipa", 1, 3); //3
		Consultant leader = new Consultant("Jose", 10, 10, 100); //200
		TeamWorkers team = new TeamWorkers ("team", leader);
		Project subproject = new Project( "Randstad", local, manager, team );


		//Subproject_1
		Local local1 = new Local("RT", "Porto", 500); //500
		Consultant manager1 = new Consultant("Filipa", 1, 3); //3
		Consultant leader1 = new Consultant("Jose", 10, 10, 100); //200
		TeamWorkers team1 = new TeamWorkers ("team", leader);
		Project subproject1 = new Project("Challenge", local1, manager1, team1);

		//Subproject_2
		Local local2 = new Local("RT", "Porto", 500); //500
		Consultant manager2 = new Consultant("Filipa", 1, 3); //3
		Consultant leader2 = new Consultant("Jose", 10, 10, 100); //200
		TeamWorkers team2 = new TeamWorkers ("team", leader);
		Project subproject2 = new Project("projectManager", local1, manager1, team1);

		//Act
		project.addProject(subproject);
		project.addProject(subproject1);
		project.addProject(subproject2);
		
		//Assert
		assertTrue( project.getSubProject( 0 ).getName().equals(subproject1.getName()) );
		assertTrue( project.getSubProject( 1 ).getName().equals(subproject2.getName()) );
		assertTrue( project.getSubProject( 2 ).getName().equals(subproject.getName()) );
	}

}
