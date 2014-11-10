import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class ProjectManagerTest
{
	private Project project;

	@Before
	public void Arrange()
	{	
		//Arrange
		double costHour = 10;
		double hour = 5;
		double bonus = 50;
		Consultant manager = new Consultant("Filipa", costHour, hour, bonus); //50
		Consultant leader = new Consultant("Jose", costHour, hour, bonus); //100
		TeamWorkers team = new TeamWorkers ("team", leader);

		Local local = new Local("RT", "Lisboa", 300); //300
		project = new Project( "Randstad", local, manager, team );

		Consultant consultant1 = new Consultant("Gonçalo", 1, 2); //2

		//Act		
		project.addWorker( consultant1 );
	}

	@Test
	public void gestTotalCost_test()
	{	
		//Assert
		assertTrue( project.getCosts() ==  502);
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
		Consultant leader_1 = new Consultant("Jose", 10, 10, 100); //200
		TeamWorkers team = new TeamWorkers ("team", leader_1);

		Project subproject = new Project( "subproject", local, manager, team );

		//Act
		project.addProject(subproject);

		//Assert
		assertTrue( project.getCosts() ==  1205);
	}

	@Test
	public void shouldNotAcepetSubProjectsWithSameName_test()
	{	
		//Arrange
		Local local = new Local("RT", "Porto", 500);
		Consultant manager = new Consultant("Filipa", 1, 3);
		Consultant leader = new Consultant("Jose", 10, 10, 100);
		TeamWorkers team = new TeamWorkers ("team", leader);
		//Subproject_0
		Project subproject = new Project( "subproject", local, manager, team );

		Local local1 = new Local("TR", "Lisboa", 900);
		Consultant manager1 = new Consultant("Filipa_1", 2, 3);
		Consultant leader1 = new Consultant("Jose_1", 100, 100, 50);
		TeamWorkers team1 = new TeamWorkers ("team_1", leader1);
		//Subproject_1
		Project subproject1 = new Project("subproject", local1, manager1, team1);

		//Act
		project.addProject(subproject);

		//Assert
		assertFalse( project.addProject(subproject1)  );
	}
	
	@Test
	public void findConsultantByName_test()
	{
		//Arrange
		Consultant consultant1 = new Consultant("Paulo", 20, 10);

		//Act
		project.addWorker(consultant1);

		//Assert
		assertTrue( project.getConsultantsByName(consultant1.getName()).getName().equals("Paulo") );
	}

	@Test
	public void findSubProjectByName_test()
	{
		//Arrange
		Consultant leader_1 = new Consultant("Luis", 10, 8, 200);
		TeamWorkers team1 = new TeamWorkers("GRUPO2", leader_1);

		Consultant manager1 = new Consultant("Lara", 10, 8);
		Local  local1 = new Local("Saldanha", "Lisboa", 20);

		Project subProj = new Project("RT_Challenge", local1, manager1, team1);
		Project subProj_1 = new Project("RT_Challenge1", local1, manager1, team1);
		Project subProj_2 = new Project("RT_Challenge2", local1, manager1, team1);

		//Act
		project.addProject(subProj);
		project.addProject(subProj_1);		
		subProj_1.addProject(subProj_2);

		//Assert
		assertTrue( project.getSubProjectByName(subProj_2.getName()).getName().equals("Randstad - RT_Challenge1 - RT_Challenge2"));

	}


	@Test
	public void shouldRemoveASubProject_test()
	{
		//Arrange
		Local local = new Local("RT", "Porto", 500);
		Consultant manager = new Consultant("Filipa", 1, 3);
		Consultant leader = new Consultant("Jose", 10, 10, 100);
		TeamWorkers team = new TeamWorkers ("team", leader);
		//Subproject
		Project subproject = new Project( "subproject", local, manager, team );

		//Act
		project.addProject( subproject );

		//Assert
		assertNotNull( project.getSubProjectByName("Randstad - subproject") );
		assertTrue( project.removeProject("Randstad - subproject") );
		assertNull( project.getSubProjectByName("Randstad - subproject") );
	}

	@Test
	public void shouldNotAcepetConsultantsWithSameName_test()
	{
		Consultant c1 = new Consultant("Filipa", 10, 5);
		Consultant c2 = new Consultant("Filipa", 5, 10);

		//Act
		project.addWorker(c1);

		//Assert
		assertFalse( project.addWorker(c2) );
	}

	@Test
	public void shouldRemoveAConsultants_test()
	{
		Consultant g = new Consultant("Gonçalo", 10, 10);

		//Act
		project.addWorker( g );

		//Assert
		assertNotNull( project.getConsultantsByName("Gonçalo") );
		assertTrue( project.removeConsultant("Gonçalo") );
		assertNull( project.getConsultantsByName("Gonçalo") );
	}


	@Test
	public void shoulSortByNameSubProjects_test()
	{	
		//Arrange
		Local local = new Local("RT", "Porto", 500);
		Consultant manager = new Consultant("Filipa", 1, 3);
		Consultant leader = new Consultant("Jose", 10, 10, 100);
		TeamWorkers team = new TeamWorkers ("team", leader);
		//Subproject_0
		Project subproject = new Project( "Randstad", local, manager, team );

		//Subproject_1
		Project subproject1 = new Project("Challenge", local, manager, team);

		//Subproject_2
		Project subproject2 = new Project("projectManager", local, manager, team);

		//Act
		project.addProject(subproject);
		project.addProject(subproject1);
		project.addProject(subproject2);

		//Assert
		assertTrue( project.getContainerProject().get(0).getName().equals(subproject1.getName()) );
		assertTrue( project.getContainerProject().get(1).getName().equals(subproject2.getName()) );
		assertTrue( project.getContainerProject().get(2).getName().equals(subproject.getName()) );
	}


	@Test
	public void shoulSortByConsultsCostPerHourInATeam_test()
	{
		//Arrange
		Consultant consultant_2 = new Consultant("Estiveira", 6, 10);
		Consultant consultant_3 = new Consultant("Daniel", 2, 10);
		Consultant consultant_4 = new Consultant("Pedro", 4, 10);
		Consultant consultant_5 = new Consultant("asg", 13, 10);

		
		//Act		
		project.addWorker(consultant_2);
		project.addWorker(consultant_3);
		project.addWorker(consultant_4);
		project.addWorker(consultant_5);

		//Assert
		assertTrue( project.getTeam().get(0).getName().equals("Gonçalo") );
		assertTrue( project.getTeam().get(1).getName().equals("Daniel") );
		assertTrue( project.getTeam().get(2).getName().equals("Pedro") );
		assertTrue( project.getTeam().get(3).getName().equals("Estiveira") );
		assertTrue( project.getTeam().get(4).getName().equals("Jose") );
		assertTrue( project.getTeam().get(5).getName().equals("asg") );

	}
}
