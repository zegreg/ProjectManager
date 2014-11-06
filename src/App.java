
public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Consultant manager = new Consultant("Filipa", 300, 48);
		Local local = new Local("Campolide", "Lisboa", 3);
		
		
		
		
		Project project = new Project("AplicativoJava", manager, local);
		
		
		Leader leader = new Leader("Gonçalo", 400, 8);
		
		TeamWorkers team = new TeamWorkers("FCPorto", leader);
		Consultant consultant= new Consultant("josé", 200, 8);
		
		
		
		team.addConsultant(consultant);
		
		
		
		
		
	}

}
