package jsample;

import java.util.Date;

public class Employee {

	private Integer empid;

	private String empname;

	private String occupation;

	private String gender;

	private String department;

	private Date dateofbirth;

	public Employee(Integer empid, String empname, String occupation, String gender, String department,
			Date dateofbirth) {
		this.empid = empid;
		this.empname = empname;
		this.occupation = occupation;
		this.gender = gender;
		this.department = department;
		this.dateofbirth = dateofbirth;
	}

	public Employee() {
	}

	public Integer getEmpid() {
		return empid;
	}

	public void setEmpid(Integer empid) {
		this.empid = empid;
	}

	public String getEmpname() {
		return empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname == null ? null : empname.trim();
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation == null ? null : occupation.trim();
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender == null ? null : gender.trim();
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department == null ? null : department.trim();
	}

	public Date getDateofbirth() {
		return dateofbirth;
	}

	public void setDateofbirth(Date dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", empid=").append(empid);
		sb.append(", empname=").append(empname);
		sb.append(", occupation=").append(occupation);
		sb.append(", gender=").append(gender);
		sb.append(", department=").append(department);
		sb.append(", dateofbirth=").append(dateofbirth);
		sb.append("]");
		return sb.toString();
	}

}