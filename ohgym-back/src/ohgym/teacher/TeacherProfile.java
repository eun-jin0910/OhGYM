
package ohgym.teacher;

import java.util.List;

public class TeacherProfile {
	private String id;
	private String appeal;
	private String contactTime;
	private List<String> exercise;
	private String introduction;
	private String centerName;
	private String location;
	private String career;
	
	public TeacherProfile() {}

	public TeacherProfile(String id, String appeal, String contactTime, List<String> exercise, String introduction,
			String centerName, String location, String career) {
		super();
		this.id = id;
		this.appeal = appeal;
		this.contactTime = contactTime;
		this.exercise = exercise;
		this.introduction = introduction;
		this.centerName = centerName;
		this.location = location;
		this.career = career;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAppeal() {
		return appeal;
	}

	public void setAppeal(String appeal) {
		this.appeal = appeal;
	}

	public String getContactTime() {
		return contactTime;
	}

	public void setContactTime(String contactTime) {
		this.contactTime = contactTime;
	}

	public List<String> getExercise() {
		return exercise;
	}

	public void setExercise(List<String> exercise) {
		this.exercise = exercise;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getCenterName() {
		return centerName;
	}

	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCareer() {
		return career;
	}

	public void setCareer(String career) {
		this.career = career;
	}

	@Override
	public String toString() {
		return "TeacherProfile [id=" + id + ", appeal=" + appeal + ", contactTime=" + contactTime + ", exercise="
				+ exercise + ", introduction=" + introduction + ", centerName=" + centerName + ", location=" + location
				+ ", career=" + career + "]";
	}

	
}