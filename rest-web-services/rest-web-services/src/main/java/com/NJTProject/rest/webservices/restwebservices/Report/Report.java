package com.NJTProject.rest.webservices.restwebservices.Report;
import java.util.Date;
import java.util.Objects; 



public class Report {
	 private long PatientID;
	 private long DoctorID;
	 private String Description;
	 private String Office;
	 private Date Date;
	 
	 protected Report() {
			
	 } 
	 
	public Report(long patientID, long doctorID, String description, String office, java.util.Date date) {
		super();
		PatientID = patientID;
		DoctorID = doctorID;
		Description = description;
		Office = office;
		Date = date;
	}
	public long getPatientID() {
		return PatientID;
	}
	public void setPatientID(long patientID) {
		PatientID = patientID;
	}
	public long getDoctorID() {
		return DoctorID;
	}
	public void setDoctorID(long doctorID) {
		DoctorID = doctorID;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getOffice() {
		return Office;
	}
	public void setOffice(String office) {
		Office = office;
	}
	public Date getDate() {
		return Date;
	}
	public void setDate(Date date) {
		Date = date;
	}
	@Override
	public int hashCode() {
		return Objects.hash(Date, Description, DoctorID, Office, PatientID);
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
		return Objects.equals(Date, other.Date) && Objects.equals(Description, other.Description)
				&& DoctorID == other.DoctorID && Objects.equals(Office, other.Office) && PatientID == other.PatientID;
	}
	
	
}
