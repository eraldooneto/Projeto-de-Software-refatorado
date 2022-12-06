package application;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.AcademicProduction;
import entities.Analist;
import entities.Collaborator;
import entities.Developer;
import entities.Graduation;
import entities.Orientation;
import entities.Password;
import entities.Postgraduation;
import entities.Professor;
import entities.Project;
import entities.Publication;
import entities.Researcher;
import entities.Tester;
import entities.Undergraduation;
import entities.enums.ProjectStatus;

public class Program {
		
		 	public final static Scanner read = new Scanner(System.in);
		    public final static Password userCredentials = new Password();

		    public static void main(String[] args) throws ParseException {
		        SimpleDateFormat dataFormat = new SimpleDateFormat("dd/mm/yyyy");
		        Locale.setDefault(Locale.US);  
		        List<Project> listProjects = new ArrayList<>();
				List<Collaborator> listCollaborators = new ArrayList<>();

		        int select = -1;

		        System.out.println("----------ACADEMIC SYSTEM----------");
		        System.out.print("USER: ");
		        String user = read.nextLine();
		        System.out.print("PASSWORD: ");
		        String password = read.nextLine();

		        while (!user.equals(userCredentials.getUsername()) || !password.equals(userCredentials.getPassword())) {
					
		            // tratar
					System.out.println("The username or password must be worng. Would you like to redefine your credentials? y/n");
					
					char menuChoice = read.nextLine().charAt(0);
		            
					
					if (menuChoice == 'n' || menuChoice == 'N') {
						exitSystem(); 
						break;
					} 
					
					passwordMenu();

		            System.out.println();
		            System.out.println("----------INSERT THE CREDENTIALS----------");
					
					System.out.print("USER: ");
					user = read.nextLine();
						
					System.out.print("PASSWORD: ");
					password = read.nextLine();
		            System.out.println();
		        }


		       // 👍 Change this piece later 🤦‍♂️
		        if (user.equals(userCredentials.getUsername()) && password.equals(userCredentials.getPassword())) {
		            System.out.println("----------WELCOME TO THE ACADEMIC SYSTEM----------");
		            System.out.println();


		            // Começa aqui

		            do {
		                
		                System.out.println("[0] - Exit the System");
		                System.out.println("[1] - Create a New Project");
		                System.out.println("[2] - Start a Project");
		                System.out.println("[3] - Finish a Project");
		                System.out.println("[4] - Alocate a Collaborator to a project");
		                System.out.println("[5] - Create a Publication of a Project");
		                System.out.println("[6] - Orientation and Tasks Management");
		                System.out.println("[7] - Consult a Collaborator");
		                System.out.println("[8] - Consult a Project");
		                System.out.println("[9] - Generate the Academic Report about the projects");
		                System.out.println();
		                
		                System.out.print("Please, select an option: ");
		                System.out.println();
		                
		                try {
		                    select = Integer.parseInt(read.nextLine());

		                } catch (NumberFormatException e) {
		                    System.out.println("It is not a valid input.");
		                } 
		                
		                //select = read.nextInt();

		                switch (select) {
		                    case 0:
		                        System.out.println("The system has been closed.");
		                        break;
		                    
		                    case 1:
		                        System.out.println("----------CREATE A NEW PROJECT----------");
		                        System.out.println();

		                        System.out.print("Please, type the Project's name: ");
		                        String title = read.nextLine();
		                    
		                        Date startDate; 
		                        
		                        try {
		                            System.out.print("Start date (dd/mm/yyyy): ");
		                            startDate = dataFormat.parse(read.next());
		                        } catch (ParseException e) {
		                            System.out.println("The data is in invalid format!");
		                            System.out.print("Start date (dd/mm/yyyy): ");
		                            startDate = dataFormat.parse(read.next());
		                        }
		                        
		                        Date finalDate; 

		                        try {
		                            System.out.print("Final date (dd/mm/yyyy): ");
		                            finalDate = dataFormat.parse(read.next());

		                        } catch (ParseException e) {
		                            System.out.println("The data is in invalid format!");
		                            System.out.print("End date (dd/mm/yyyy): ");
		                            finalDate = dataFormat.parse(read.next());
		                        }
		                        
		                        read.nextLine();
		                        System.out.print("Project's coordinator: ");
		                        String coordinator = read.nextLine();
		                        System.out.print("Financial Agency: ");
		                        String financialAgency = read.nextLine();
		                        System.out.print("Project Description: ");
		                        String description = read.nextLine();
		                        
		                        // Tratar
		                        System.out.print("Scholarship value: ");
		                        Double scholarshipValue = null; 
		                        
		                        //read.nextDouble();
		                        try {
		                            scholarshipValue = Double.parseDouble(read.nextLine());

		                        } catch (NumberFormatException e) {
		                            System.out.println("It is not a valid input.");
		                            System.out.print("Scholarship value: ");
		                            scholarshipValue = Double.parseDouble(read.nextLine());
		                        } 

		                        // Tratar
		                        System.out.print("How many collaborators does the project have? ");
		                        
		                        //int numberOfParticipants = read.nextInt();
		                        //read.nextLine();

		                        int numberOfParticipants = -1;

		                        try {
		                            numberOfParticipants = Integer.parseInt(read.nextLine());
		                        } catch (NumberFormatException e) {
		                            System.out.println("It is not a valid input.");
		                            System.out.print("How many collaborators does the project have? ");
		                            numberOfParticipants = Integer.parseInt(read.nextLine());
		                        }

		                        
		                        int professorsNumber = 0;
		                        
		                        Project project = new Project(title, startDate, finalDate, coordinator, financialAgency, description, scholarshipValue);

		                        Collaborator participant;

		                        for (int i = 0; i < numberOfParticipants; i++) {
		                           System.out.println();
		                           System.out.println("PARTICIPANT #" + (i + 1) + ":");
		                        
		                            // define this function
		                           participant = setCollaborator(listCollaborators, read); 

		                           if (participant instanceof Undergraduation && participant.numberOfProjectsInElaboration() >= 2) {
		                            System.out.println("An undergraduation student cannot be in more than 2 running projects.");
		                           } else {
		                            if (participant instanceof Professor) {
		                                professorsNumber += 1;
		                            }
		                            
		                            project.addCollaborator(participant);
		                            participant.addAProjectToCollaborator(project);

		                           }

		                           if (i == numberOfParticipants - 1 && professorsNumber == 0) {
		                            System.out.println("A project must have at least one Professor associated.");
		                            System.out.println("Please, insert a Professor.");
		                            numberOfParticipants++;
		                           }
		                        }

		                        listProjects.add(project);
		                        System.out.println("The project was created succesfully!");
		                        break;

		                    case 2:
		                        System.out.println("----------START A PROJECT----------");
		                        System.out.println();

		                        System.out.print("Please, type the Project's name you want to begin: ");
		                        title = read.nextLine();

		                        Project auxiliarInProject = LookForProject(listProjects, title);

		                        while (auxiliarInProject == null) {
		                            System.out.println("The project don't exists!");
		                            System.out.print("Type the name of the project to begin: ");
		                            title = read.nextLine();
		                            auxiliarInProject = LookForProject(listProjects, title);
		                        }

		                        if (auxiliarInProject.VerifyProject()) {
		                            
		                            // tratar 
		                            System.out.print("Modify the Project's status to 'IN PROGRESS'? y/n ");
		                            char choice =  read.next().charAt(0);

		                            if (choice == 'y') {
		                                auxiliarInProject.setStatus(ProjectStatus.IN_PROGRESS);
		                                System.out.println("Success! The project has begun! \n");
		                            }

		                        } else {
		                            System.out.println("A project must need all the basic registered informations to begin!");
		                        }

		                        break;
		                    
		                    case 3:
		                        System.out.println("----------FINISH A PROJECT----------");
		                        System.out.println();

		                        System.out.print("Please, inform the Project's title to finish: ");
		                        title = read.nextLine();
		                        read.nextLine();
		                        auxiliarInProject = LookForProject(listProjects, title);

		                        while (auxiliarInProject == null) {
		                            System.out.println("The project was not found! Try again.");
		                            System.out.print("Type the Project's name to be finished: ");
		                            title = read.nextLine(); 
		                            auxiliarInProject = LookForProject(listProjects, title);
		                        }

		                        // Lógica de publicação para finalizar? ...

		                        int publications = 0;
		                        for (AcademicProduction ap : auxiliarInProject.getAcademicProduction()) {
		                            if (ap instanceof Publication) {
		                                publications++;
		                                break;
		                            }
		                        }

		                        if (publications == 0) {
		                            System.out.println("To conclude a project, must have a publication associated.");
		                        } else {
		                            auxiliarInProject.setStatus(ProjectStatus.FINISHED);
		                            System.out.println("Success! The project has been finished.");
		                        }

		                        break;
		                    
		                    case 4: 
		                        System.out.println("----------ALLOCATE A COLLAORATOR TO A PROJECT----------");
		                        System.out.println();

		                        System.out.print("Collaborator's data to be allocated: ");
		                        participant = setCollaborator(listCollaborators, read);

		                        if (participant instanceof Undergraduation && participant.numberOfProjectsInElaboration() >= 2) {
		                            System.out.println("An undergraduation student can't be on two projects at the same time.");
		                            break;
		                        }

		                        System.out.print("Type the project's title that the collaborator will be allocated: ");
		                        title = read.nextLine();
		                        read.nextLine();
		                        auxiliarInProject = LookForProject(listProjects, title);

		                        while (auxiliarInProject == null) {
		                            System.out.println("The project doesn't exist. Try again. \n");
		                            System.out.println("Type the Project's title name: ");
		                            title = read.nextLine();
		                            auxiliarInProject = LookForProject(listProjects, title);
		                        }

		                        if(auxiliarInProject.getProjectStatus().equals(ProjectStatus.IN_ELABORATION)) {
		                            auxiliarInProject.addCollaborator(participant);
		                            participant.addAProjectToCollaborator(auxiliarInProject);
		                            System.out.println("Success! The collaborator has been alocated. \n");
		                        } else {
		                            System.out.println("Forbiden! The project is already in curse.");
		                        }
		                        
		                        break;

		                    case 5:
		                        System.out.println("----------CREATE A PUBLICATION----------");
		                        System.out.println();

		                        System.out.print("Type the Publication's title: ");
		                        String publicationTitle = read.nextLine();
		                        read.nextLine();
		                        System.out.print("Type the conference name: ");
		                        String conferenceName = read.nextLine();
		                        
		                        // Tratar 
		                        System.out.print("Publication year: ");
		                        int publicationYear = read.nextInt();

		                        List<AcademicProduction> nonAssociatedPublications = new ArrayList<>();
		                        AcademicProduction publication = new Publication(publicationTitle, conferenceName, publicationYear);
		                        
		                        System.out.print("How many authors does the publication have? ");
		                        int numberOfAuthors = read.nextInt();
		                        read.nextLine();
		                        System.out.println();

		                        if (numberOfAuthors == 0) {
		                            System.out.println("Forbiden! A publication must have at least one author associated!");
		                            break;
		                        }

		                        for (int i = 0; i < numberOfAuthors; i++) {
		                            System.out.println("Author #" + (i + 1) + ": ");
		                            System.out.print("Name: ");
		                            String name = read.nextLine();

		                            Collaborator collaboratorAux = LookForCollaborator(listCollaborators, name);

		                            while (collaboratorAux == null) {
		                                System.out.println("The author was not found! Try again.");
		                                System.out.println("Name: ");
		                                name = read.nextLine();
		                                collaboratorAux = LookForCollaborator(listCollaborators, name);
		                            }
		                            System.out.println("Success! The author has been found.");
		                            collaboratorAux.adddAcademicProduction(publication);
		                        }

		                        System.out.print("The publication has some research project associated? y/n");
		                        char choice = read.next().charAt(0);

		                        if (choice == 'y') {
		                            System.out.print("What is the project title? ");
		                            read.nextLine();
		                            title = read.nextLine();
		                            auxiliarInProject = LookForProject(listProjects, title);

		                            while (auxiliarInProject == null) {
		                                System.out.println("The project doesn't exist!");
		                                System.out.print("Type the associated project name: ");
		                                title = read.nextLine();
		                                auxiliarInProject = LookForProject(listProjects, title);
		                            }

		                            if (auxiliarInProject.getProjectStatus() != ProjectStatus.IN_PROGRESS) {
		                                System.out.println("A publication cannot be associated to a project while a project is in curse.");
		                            } else {
		                                auxiliarInProject.addAcademicProduction(publication);
		                                publication.projectAssociation(auxiliarInProject);
		                                System.out.println("Success! Publication has been added.");
		                            } 

		                        } else {
		                            nonAssociatedPublications.add(publication);
		                            System.out.println("Success! Publication has been done!");
		                        }

		                        break;
		                    
		                    
		                    case 6:
		                        System.out.println("----------ORIENTATION AND TASK MANAGEMENT----------");
		                        System.out.println();

		                        System.out.print("Please, type the orientation's title: ");
		                        title = read.nextLine();
		                        read.nextLine();
		                        System.out.print("Now, type the orientation description: ");
		                        String orientationDescription = read.nextLine();
		                        System.out.print("Year: ");
		                        int orientationYear = read.nextInt();
		                        System.out.print("The number of tasks: ");
		                        int numberOfTasks = read.nextInt();
		                        read.nextLine();
		                        String [] tasks = new String[numberOfTasks];
		                        
		                        System.out.println("Tasks: ");
		                        
		                        for (int i = 0; i < numberOfTasks; i++) {
		                            System.out.print("Type the task #" + (i + 1) + ": ");
		                            tasks[i] = read.nextLine();
		                        }

		                        Orientation orientations = new Orientation(title, orientationDescription, orientationYear, numberOfTasks, tasks);
		                        
		                        System.out.print("Number of Professors that gave orientation: ");
		                        int numberOfProfessors = read.nextInt();
		                        read.nextLine();
		                        System.out.println();

		                        if (numberOfProfessors == 0) {
		                            System.out.println("Forbiden! An orientation must have at least one Professor.");
		                            break;
		                        }
		                        
		                        for (int i = 0; i < numberOfProfessors; i++) {
		                            System.out.println("Professor #" + (i + 1) + ": ");
		                            System.out.print("Name: ");
		                            String professorName = read.nextLine();
		                            Collaborator collaboratorAuxiliar = LookForCollaborator(listCollaborators, professorName);

		                            while (collaboratorAuxiliar == null) {
		                                System.out.println("The professor was not found! Try again.");
		                                System.out.print("Name: ");
		                                professorName = read.nextLine();
		                                collaboratorAuxiliar = LookForCollaborator(listCollaborators, professorName); 
		                            }

		                            if (collaboratorAuxiliar instanceof Professor) {
		                                System.out.println("Success! The professor was found.");
		                            } else {
		                                System.out.println("The orientation requires a professor!");
		                            }

		                        }

		                        // Tratar aqui 

		                        System.out.print("Does the orientatio require any project to associate? y/n ");
		                        choice = read.next().charAt(0);

		                        if (choice == 'y') {
		                            System.out.print("What is the name of the associated project? ");
		                            read.nextLine();
		                            title = read.nextLine();
		                            auxiliarInProject = LookForProject(listProjects, title);

		                            while (auxiliarInProject == null) {
		                                System.out.println("The project doesn't exist! Try again.");
		                                System.out.print("Type the project name: ");
		                                title = read.nextLine();
		                                auxiliarInProject = LookForProject(listProjects, title);
		                            }

		                            auxiliarInProject.addAcademicProduction(orientations);
		                            orientations.projectAssociation(auxiliarInProject);
		                            System.out.println("Success! The orientation has been added.");
		                        }

		                        System.out.println();

		                        break;

		                    case 7: 
		                        System.out.println("----------CONSULT A COLLABORATOR----------");
		                        System.out.println();
		                        
		                        System.out.print("Type the Collaborator's name to query: ");
		                        String name = read.next();

		                        Collaborator auxiliarCollaborator = LookForCollaborator(listCollaborators, name);

		                        while (auxiliarCollaborator == null) {
		                            System.out.println("The collaborator doesn't exist! Try again.");
		                            name = read.nextLine();
		                            auxiliarCollaborator = LookForCollaborator(listCollaborators, name);
		                        }

		                        Collections.sort(auxiliarCollaborator.getCollaboratorProjects());
		                        Collections.sort(auxiliarCollaborator.getAcademicProductions());
		                        System.out.println("Success! The collaborator was found!");
		                        System.out.println("Informations: ");
		                        System.out.println(auxiliarCollaborator);
		                        System.out.println("Collaborator's Project List: ");
		                        
		                        // Resolver esse bug 👽👽👽👽👽👽👽👽👽👽👽

		                        auxiliarCollaborator.printCollaboratorProjects();
		                        System.out.println("Collaborator's Academic Production: ");
		                        auxiliarCollaborator.printCollaboratorAcademicProductions();
		                        System.out.println();

		                        break;
		                    
		                    case 8:
		                        System.out.println("----------CONSULT A PROJECT----------");
		                        System.out.println();
		                        
		                        System.out.print("Type the Project's name to query: ");
		                        title = read.nextLine();

		                        auxiliarInProject = LookForProject(listProjects, title);

		                        while (auxiliarInProject == null) {
		                            System.out.println("The project was not found. Try again!");
		                            System.out.print("Name: ");
		                            name = read.nextLine();
		                            auxiliarInProject = LookForProject(listProjects, title);
		                        }

		                        System.out.println("Success! The project was found!");
		                        System.out.println("Project Informations: ");
		                        System.out.println(auxiliarInProject);
		                        System.out.println("Collaborators that is current allocated to the project: ");
		                        auxiliarInProject.printCollaboratorsOnProject();
		                        System.out.println("Project's Academic Production: ");
		                        Collections.sort(auxiliarInProject.getAcademicProduction());
		                        auxiliarInProject.printAcademicProductionProjects();
		                        System.out.println();

		                        break;
		                    
		                    case 9:
		                        System.out.println("----------GENERAL REPORT----------");
		                        System.out.println();

		                        int inProgressProject = 0;
		                        int inElaborationProject = 0;
		                        int endedProjects = 0;
		                        int publicationsNumber = 0;
		                        int orientationsNumber = 0; 

		                        //System.out.println("-------GENERAL REPORT-------");
		                        //System.out.println();
		                        System.out.println("Number of Collaborators: " + listCollaborators.size());

		                        for (Project p : listProjects) {
		                            if (p.getProjectStatus().equals(ProjectStatus.IN_ELABORATION)) {
		                                inElaborationProject += 1;
		                            }
		                            
		                            if (p.getProjectStatus().equals(ProjectStatus.IN_PROGRESS)) {
		                                inProgressProject += 1;
		                            }
		                            
		                            if (p.getProjectStatus().equals(ProjectStatus.FINISHED)) {
		                                endedProjects += 1;
		                            }
		                        }

		                        System.out.println("Number of projects in elaboration: " + inElaborationProject);
		                        System.out.println("Number of projects in progress: " + inProgressProject);
		                        System.out.println("Number of projects finished: " + endedProjects);
		                        System.out.println("Total of projects: " + (inElaborationProject + inProgressProject + endedProjects));

		                        for (Project p : listProjects) {
		                            for (AcademicProduction ap : p.getAcademicProduction()) {
		                                if(ap instanceof Publication) {
		                                    publicationsNumber += 1;
		                                }

		                                if (ap instanceof Orientation) {
		                                    orientationsNumber += 1;
		                                }
		                            }
		                        }

		                        System.out.println("Publications number: " + publicationsNumber);
		                        System.out.println("Orientations number: " + orientationsNumber);
		                        System.out.println();
		                       
		                        break;
		                    
		                    default: 
		                        System.out.println("Please, select an option between 0 - 9");
		                        break;
		                }
		            

		            } while (select != 0);

		        } else {
		            System.out.println("See you!");
		        }

		        read.close();
		    }

		    public static Collaborator setCollaborator(List<Collaborator> listCollaborators, Scanner read) {
		        Collaborator participant;

		        System.out.print("Is the Colaborator already in a project? y/n ");
		        char selection = read.next().charAt(0); 
		        read.nextLine();

		        if (selection == 'y') {
		            System.out.print("Name: ");
		            String name = read.nextLine(); 
		            participant = LookForCollaborator(listCollaborators, name);

		            while (participant == null) {
		                System.out.println("The collaborator was not found! Try again.");
		                System.out.print("Name: ");
		                name = read.nextLine();
		                participant = LookForCollaborator(listCollaborators, name);
		            }

		            System.out.println("Success! The collaborator was found.");

		        } else {
		            System.out.print("Name: ");
		            String name = read.nextLine();
		            System.out.print("Email: ");
		            String email = read.nextLine();

		            // Criar essas classes abaixo
		            System.out.println("What is his/her function on project?");
		            System.out.println("[1] - Undergraduation");
		            System.out.println("[2] - Graduation");
		            System.out.println("[3] - Postgraduation");
		            System.out.println("[4] - Professor");
		            System.out.println("[5] - Researcher");
		            System.out.println("[6] - Developer");
		            System.out.println("[7] - Tester");
		            System.out.println("[8] - Analist");

		            int function; 
		            
		            try {
		                function = read.nextInt();
		            } catch (InputMismatchException e) {
		                System.out.println("Invalid input!");
		                read.nextLine();
		                function = read.nextInt();
		            }

		            if (function == 1) {
		                participant = new Undergraduation(name, email);
		            } else if (function == 2){
		                participant = new Graduation(name, email);
		            } else if (function == 3) {
		                participant = new Postgraduation(name, email);
		            } else if (function == 4) {
		                participant = new Professor(name, email);
		            } else if (function == 5){
		                participant = new Researcher(name, email);
		            } else if (function == 6) {
		                participant = new Developer(name, email);
		            } else if (function == 7) {
		                participant = new Tester(name, email);
		            } else {
		                participant = new Analist(name, email);
		            }

		            listCollaborators.add(participant);
		            System.out.println("Success! The participant has been inserted.");
		        }

		        return participant;
		    }

		    public static void passwordMenu() {
				
				System.out.print("New Username: ");

				String newUsername = read.nextLine();
				changeUsername(newUsername);

				System.out.print("New Password: ");
				String newPassword = read.nextLine();
				changePassword(newPassword);	
				
			}
			
			public static void changeUsername(String newUser) {
				userCredentials.setUsername(newUser);
			}
			
			public static void changePassword(String newPassword) {
				userCredentials.setPassword(newPassword);
			}
			
			public static void exitSystem() {
				System.out.println("Try again later.");
			}

		    public static Collaborator LookForCollaborator(List<Collaborator> listCollaborators, String name) {
		        for (Collaborator collaborator : listCollaborators) {
		            if(name.equals(collaborator.getCollaboratorName())) {
		                return collaborator;
		            }
		        }

		        return null;
		    }

		    public static Project LookForProject(List<Project> listProjects, String title) {
		        for (Project project : listProjects) {
		            if (title.equals(project.getProjectTitle())) {
		                return project;
		            }
		        }

		        return null;
		  }
	
	}
