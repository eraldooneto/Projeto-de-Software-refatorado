import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;

import enums.ProjectStatus;

public class Project implements Comparable<Project>{
    private String name;
    private Date startDate;
    private Date finalDate;
    private String coordinator;
    private String financialAgency;
    private String description;
    private Double scholarshipValue;
    private List<Collaborator> participants = new ArrayList<>();
    private List<AcademicProduction> academicProductions = new ArrayList<>();
    private ProjectStatus status = ProjectStatus.IN_ELABORATION;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Project() {
	}

    public Project(String name, Date startDate, Date finalDate, String coordinator, String financialAgency, String description, double scholarshipValue) {
        this.name = name;
        this.startDate = startDate;
        this.finalDate = finalDate;
        this.coordinator = coordinator;
        this.financialAgency = financialAgency;
        this.description = description;
        this.scholarshipValue = scholarshipValue;
    }

    public String getProjectTitle() {
        return name;    
    }

    public Date getProjectStartDate() {
        return startDate;
    }

    public Date getProjectFinalDate() {
        return finalDate;
    }

    public String getCoordinatorName() {
        return coordinator;
    }

    public String getFinancialAgency() {
        return financialAgency;
    }

    public String getProjectDescription() {
        return description;
    }

    public void setStatus(ProjectStatus status) {
        this.status = status;
    }

    public Double getScholarshipValue() {
        return scholarshipValue;
    }

    public List<Collaborator> getProjectParticipants() {
        return participants;
    }

    public ProjectStatus getProjectStatus() {
        return status;
    }

    public List<AcademicProduction> getAcademicProduction() {
        return academicProductions;
    }

    public void addCollaborator(Collaborator participant) {
        participants.add(participant);
    }

    public void addAcademicProduction(AcademicProduction academicProduction) {
        academicProductions.add(academicProduction);
    }

    public void printAcademicProductionProjects() {
        for (AcademicProduction ap : academicProductions) {
            System.out.println(ap);
        }
    }

    public boolean VerifyProject() {
		if (name != null && startDate != null && finalDate != null && description != null && coordinator != null && participants != null) {
			return true;
		} else {
			return false;
		}
	}

    @Override
    public int compareTo(Project project) {
		if(this.finalDate.after(project.getProjectFinalDate())) {
			return -1;
		} else if(this.finalDate.before(project.getProjectStartDate())) {
			return 1;
		}
		return 0;
	}

    public String projectDate() {
		return "Titulo do projeto: " + name + "\nData de inicio: " + sdf.format(finalDate) + 
				"\nData de termino: " + sdf.format(finalDate);
	}

    public void printCollaboratorsOnProject() {
		for(Collaborator n : participants) {
			System.out.println(n);
		}
	}

    public String toString() {
		return "Project's name: " + name +
			   "\nBegin in: " + sdf.format(startDate) +
			   "\nEnd in: " + sdf.format(finalDate) +
			   "\nCoordinator: " + coordinator +
			   "\nProject Description: " + description +
			   "\nScholarship Value: " + scholarshipValue;
	}
}
