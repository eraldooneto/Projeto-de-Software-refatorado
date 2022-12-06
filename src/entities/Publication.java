package entities;

public final class Publication extends AcademicProduction {
    private String conferenceId;

    public Publication() {

    }

    public Publication(String title, String conferenceId, Integer year) {
        super(title, year);
        this.conferenceId = conferenceId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getConferenceId() {
        return conferenceId;
    }

    public void setConferenceId(String conferenceId) {
        this.conferenceId = conferenceId;
    }

    @Override
	public String toString() {
		return "Publication's Title: " + title + 
			   "\nConference ID: " + conferenceId + 
			   "\nYear of publication: " + year;	
	}

}
