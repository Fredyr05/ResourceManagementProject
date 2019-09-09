package project.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity(name = "Resource")
public class Resource {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long resId;
	@Column(unique = true)
	private String resCode;
	private String resName;
	
	@ManyToMany(mappedBy="resources",fetch=FetchType.EAGER)
	private Set<Project> projects = new HashSet<Project>(0);
	
	public long getResId() {
		return resId;
	}
	
	public void setResId(long resId) {
		this.resId = resId;
	}
	
	public String getResCode() {
		return resCode;
	}
	
	public void setResCode(String resCode) {
		this.resCode = resCode;
	}
	
	public String getResName() {
		return resName;
	}
	
	public void setResName(String resName) {
		this.resName = resName;
	}
	
}
