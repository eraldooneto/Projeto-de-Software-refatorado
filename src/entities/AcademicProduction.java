package entities;

public abstract class AcademicProduction implements Comparable<AcademicProduction> {
    protected String title;
    protected int year;
    protected Project associatedProject;

    public AcademicProduction() {
	}

    public AcademicProduction(String title, int year) {
        this.title = title;
        this.year = year;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer Year) {
        this.year = Year;
    }

    public String getTitle() {
        return title;
    }

    public Project getAssociatedProject() {
        return associatedProject;
    }

    public void setTitle(String title) {
		this.title = title;
	}

	public void projectAssociation(Project project) {
		associatedProject = project;
	}

    @Override
	public int compareTo(AcademicProduction academicReport) {
		if(this.year > academicReport.getYear()) {
			return -1;
		} else if(this.year < academicReport.getYear()) {
			return 1;
		}
		return 0;
	}

    public abstract String toString();

}