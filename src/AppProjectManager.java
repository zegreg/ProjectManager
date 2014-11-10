import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Class for Project Manager. Create a new project and write it all its information in .txt file.
 * <p>Commands:
 * <li>ADD_PROJECT: add a subproject, to a project/subproject.
 * <li>ADD_CONSULTANT: add a consultant to a project/subproject.
 * <li>REMOVE_PROJECT: remove a subproject from a project/subproject.
 * <li>REMOVE_CONSULTANT: remove a consultant from a project/subproject.
 * <li>PROJECT_COSTS: calculate and print in the command line the costs of a project/subproject. 
 * <li>WRITE_INFO: write in a .txt file all the information of project/subproject. The name of the file is the name of that project/subproject.
 * 		Contains the information of the Manager, Local, Team, and all of its subprojects.
 * <li>END_APP: terminates the application.
 * <p>Public methods:
 * <li>execute: created a new project, and ask for a command and execute it, till the END_APP command is called.
 * <li>main: run the app.
 * <p>Private methods:
 * <li>showCommands: print all current commands in the command line. This method is called very time a command is conclude.
 * <li>readCommand: reads a command.
 * <li>readProject: ask all project information (manager, local, team).
 * <li>readLeader: ask for the Manager/Leader name, payment per hour, working hours and bonus.
 * <li>readProjectLocation: ask for the local information (workplace name, workplace location and workplace cost).
 * <li>readConsultantTeam: ask for the Team name, and its leader infotmation.
 * <li>readConsultant: ask for a consultant information.
 * <li>inputDouble: verify if the inputed data is double type.  
 * 
 * @author Filipa E., Filipa G., Gonçalo C., José O.
 * @since 6/11/2014
 */
public class AppProjectManager
{
	//Constructor
	public AppProjectManager()
	{
		scanner = new Scanner (System.in);
	}

	private static final String ADD_PROJECT		= "subproject";
	private static final String ADD_CONSULTANT  = "consultant";
	private static final String REMOVE_PROJECT  = "remove project";
	private static final String REMOVE_CONSULTANT = "remove consultant";
	private static final String PROJECT_COSTS	= "costs";
	private static final String WRITE_INFO		= "info";
	private static final String END_APP			= "exit";

	private Scanner scanner;
	private Project project;

	private String[] commands =
		{
			ADD_PROJECT,
			ADD_CONSULTANT,
			REMOVE_PROJECT,
			REMOVE_CONSULTANT,
			PROJECT_COSTS,
			WRITE_INFO,
			END_APP
		};

	/**
	 * Will automatically ask (in the command line) for the project info, (name, manager, local and team) and create an Object of the type {@link Project}.
	 * Then all commands are shown: "subproject", "consultant", "remove project", "remove consultant", "costs", "info" and "exit".
	 * <p>Commands:
	 * <li>ADD_PROJECT: add a subproject, to a project/subproject.
	 * <li>ADD_CONSULTANT: ad a consultant to a project/subproject.
	 * <li>REMOVE_PROJECT: remove a subproject from a project/subproject.
	 * <li>REMOVE_CONSULTANT: remove a consultant from a project/subproject.
	 * <li>PROJECT_COSTS: calculate and print in the command line the costs of a project/subproject. 
	 * <li>WRITE_INFO: write in a .txt file all the information of project/subproject. The name of the file is the name of that project/subproject.
	 * 		Contains the information of the Manager, Local, Team, and all of its subprojects.
	 * <li>END_APP: terminates the application.
	 */
	public void execute()
	{
		String projectName;

		System.out.println("New Project");
		project = readProject();

		boolean done = false;

		do
		{
			showCommands();

			switch( readCommand() )
			{

			//Add a subproject, to a project/subproject.
			case  ADD_PROJECT:

				System.out.print( "Add subproject to the project/subproject with the name: " );
				projectName = scanner.nextLine();
				while( true )
				{
					try
					{
						if( project.getSubProjectByName( projectName ).addProject( readProject() ) == false )
							System.out.println("That subproject has already been added to this project!");
					}
					catch( NullPointerException npe)
					{
						System.out.println( "The project/subproject do not exist!" );
						break;
					}
					System.out.print( "Do you want to add a new subproject? (y) " );

					if( ! scanner.nextLine().equals("y") )
						break;
				}
				break;

			//Add a consultant to a project/subproject.
			case ADD_CONSULTANT:

				System.out.print( "Add a consultant to the project/subproject with the name: " );
				projectName = scanner.nextLine();
				while( true )
				{
					try
					{
						if( project.getSubProjectByName( projectName ).addWorker( readConsultant() ) == false)
							System.out.println("That worker has already been added to this project!");

					}
					catch( NullPointerException npe)
					{
						System.out.println( "The project/subproject do not exist!" );
						break;
					}
					System.out.print( "Do you want to add a new consultant? (y) " );

					if( ! scanner.nextLine().equals("y") )
						break;
				}
				break;

			//Remove a subproject from a project/subproject.
			case REMOVE_PROJECT:

				System.out.print("Remove a Subproject from the Project with the name: ");
				projectName = scanner.nextLine();
				System.out.print("Subproject name: ");
				try
				{
					project.getSubProjectByName( projectName ).removeProject( scanner.nextLine() );
				}
				catch( NullPointerException npe)
				{
					System.out.println( "The project/subproject do not exist!" );
				}
				break;

			//Remove a consultant from a project/subproject.
			case REMOVE_CONSULTANT:

				System.out.print("Remove a Consultant from the Project with the name: ");
				projectName = scanner.nextLine();
				System.out.print("Consultant name: ");
				try
				{
					project.getSubProjectByName( projectName ).removeConsultant( scanner.nextLine() );
				}
				catch( NullPointerException npe)
				{
					System.out.println( "The project/subproject do not exist!" );
				}

				break;

			//Calculate and print in the command line the costs of a project/subproject. 
			case PROJECT_COSTS:
				System.out.print( "Calculate the costs of the project/subproject with the name: " );
				projectName = scanner.nextLine();

				try
				{
					System.out.println( "Project costs: " +project.getSubProjectByName( projectName ).getCosts() );
				}
				catch( NullPointerException npe )
				{
					System.out.println( "The project/subproject do not exist!" );
				}
				break;
				
			//Write in a .txt file all the information of project/subproject. The name of the file is the name of that project/subproject.
			//Contains the information of the Manager, Local, Team, and all of its subprojects.
			case WRITE_INFO:
				System.out.print( "Write all information of the project/subproject with the name: " );
				projectName = scanner.nextLine();

				try( PrintWriter writer = new PrintWriter(projectName +".txt") )
				{
					writer.println( project.getSubProjectByName( projectName ).writeInfo() );
				}
				catch( NullPointerException npe )
				{
					System.out.println( "The project/subproject do not exist!" );
				}
				catch (FileNotFoundException e)
				{
					System.out.println( "The project/subproject do not exist!" );
				}
				
				break;

			//Terminates the application.
			case END_APP:

				done = true;
				break;

			default:
				System.out.println("Invalid command");
			}
		}
		while(!done);
	}	

	/**
	 * Shows all the commands that are available to choose.
	 */
	private void showCommands()
	{
		System.out.println( "\nType a Command:" );
		for( String i : commands )
		{
			System.out.println( i );
		}
	}

	/**
	 * This method reads the command that was entered on the console. This method is used in the switch parameter of the execute method.
	 * @return a String with the command name.
	 */
	private String readCommand()
	{
		return scanner.nextLine();
	}

	/**
	 * This method reads the information necessary to create a new object of type Project.
	 * @return new Project - This object is characterized by its name , manager , workplace and work team
	 */
	private  Project readProject()
	{
		String name;
		Consultant manager;
		System.out.print( "- Project Name: " );
		name = scanner.nextLine();

		System.out.println("- Project Manager" );
		manager = readLeader();

		System.out.println( "- Project Location" );
		Local local = readProjectLocation();

		System.out.println( "- Project Team" );
		TeamWorkers team = readConsultantTeam();

		return new Project(name,local, manager,team); 
	}

	/**
	 * This method reads the information necessary to create a new object of type Consultant with the leader characteristics.
	 * @return new Consultant - The subject of Consultant type, in this case, is characterized by 
	 * its name, the value of his Payment per hour, the number of hours of work and the value of his bonus prize.
	 */
	private  Consultant readLeader()
	{
		String name;
		double cost, bonus, hours;
		System.out.print("Name: ");
		name = scanner.nextLine();

		System.out.print("Payment per hour: ");
		cost = inputDouble();

		System.out.print("Working hours: ");
		hours = inputDouble();

		System.out.print("Bonus: ");
		bonus = inputDouble();
		scanner.nextLine();

		return new Consultant( name, cost, hours, bonus);
	}

	/**
	 * This method reads the information necessary to create a new object of type Local.
	 * @return new Local - The subject of local type is characterized by its name , location and cost .
	 */
	private  Local readProjectLocation()
	{
		String name, location;
		double cost;
		System.out.print("Workplace name: ");
		name = scanner.nextLine();

		System.out.print("Workplace location: ");
		location = scanner.nextLine();

		System.out.print("Workplace cost: ");
		cost = inputDouble();
		scanner.nextLine();

		return new Local(name, location, cost);
	}

	/**
	 * This method reads the information necessary to create a new object of type TeamWorkers.
	 * @return new TeamWorkers - The subject of TeamWorkers type is characterized by its name and leader.
	 */
	private  TeamWorkers readConsultantTeam()
	{
		String name;
		Consultant leader;
		System.out.print("Team Name: ");
		name = scanner.nextLine();

		System.out.println("- Team Leader");
		leader = readLeader();

		return new TeamWorkers( name, leader );
	}

	/**
	 * This method reads the information necessary to create a new object of type Consultant.
	 * @return new Consultant - The subject of Consultant type is characterized by its name, 
	 * the value of his Payment per hour, and the number of hours of work.
	 */
	private Consultant readConsultant()
	{
		String name;
		double paymenPerHour, hours;
		System.out.println("- New Consultant" );
		System.out.print("Name: ");
		name = scanner.nextLine();

		System.out.print("Payment per hour: ");
		paymenPerHour = inputDouble();

		System.out.print("Working hours: ");
		hours = inputDouble();
		scanner.nextLine();

		return new Consultant( name, paymenPerHour, hours );
	}

	/**
	 * Verify if an inputed data is a double type.
	 * @return an inputed double
	 */
	private double inputDouble()
	{
		while( true )
		{
			try
			{  
				return scanner.nextDouble();
			}
			catch( InputMismatchException nfe )
			{
				System.out.println("Please insert a number!");
				scanner.nextLine();
			}
		}
	}

	/**
	 * Run the application
	 * @param args
	 */
	public static void main(String [] args )
	{
		AppProjectManager app = new AppProjectManager();
		app.execute();
	}
}
