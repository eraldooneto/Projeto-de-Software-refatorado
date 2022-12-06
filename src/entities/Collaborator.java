package entities;

import  java.util.ArrayList;
import  java.util.List;

import entities.enums.ProjectStatus;

public abstract class Collaborator {

    private String name;
    private String email;
 
    private List<Project> projects = new ArrayList<>();
    private List<AcademicProduction> academicProductions = new ArrayList<>();
    
    public Collaborator (String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getCollaboratorName() {
        return name;
    }

    public String getCollaboratorEmail() {
        return email;
    }
    
    public List<Project> getCollaboratorProjects() {
		return projects;
	}

    public List<AcademicProduction> getAcademicProductions() {
        return academicProductions;
    }

    public void addAProjectToCollaborator(Project project) {
        projects.add(project);
    }

    public void adddAcademicProduction(AcademicProduction academicProduction) {
        academicProductions.add(academicProduction);
    }

    public int numberOfProjectsInElaboration() {
        int quantity = 0;
        for (Project project : projects) {
            if (project.getProjectStatus().equals(ProjectStatus.IN_ELABORATION)) {
                quantity++;
            }
        }

        return quantity;
    }

    public void printCollaboratorProjects() {
        for (Project project : projects) {
            System.out.println(project);
        }
    }

    public void printCollaboratorAcademicProductions() {
        for (AcademicProduction ap : academicProductions) {
            System.out.println(ap);
        }
    }

	public String toString() {
		return "Name: " + name + "\nE-mail: " + email;
	}

}