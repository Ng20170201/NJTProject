package com.NJTProject.rest.webservices.restwebservices.Report;



public class Report {
	
	private long id;
	 private String diagnosis;
	 private String therapy;
	 private String note;
	public Report(long id, String diagnosis, String therapy, String note) {
		super();
		this.id = id;
		this.diagnosis = diagnosis;
		this.therapy = therapy;
		this.note = note;
	}
	   public Report() {
	    }
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDiagnosis() {
		return diagnosis;
	}
	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}
	public String getTherapy() {
		return therapy;
	}
	public void setTherapy(String therapy) {
		this.therapy = therapy;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((diagnosis == null) ? 0 : diagnosis.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((note == null) ? 0 : note.hashCode());
		result = prime * result + ((therapy == null) ? 0 : therapy.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Report other = (Report) obj;
		if (diagnosis == null) {
			if (other.diagnosis != null)
				return false;
		} else if (!diagnosis.equals(other.diagnosis))
			return false;
		if (id != other.id)
			return false;
		if (note == null) {
			if (other.note != null)
				return false;
		} else if (!note.equals(other.note))
			return false;
		if (therapy == null) {
			if (other.therapy != null)
				return false;
		} else if (!therapy.equals(other.therapy))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Report [id=" + id + ", diagnosis=" + diagnosis + ", therapy=" + therapy + ", note=" + note + "]";
	}
	


	
	
}
