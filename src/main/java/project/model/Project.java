package project.model;
import com.fasterxml.jackson.annotation.*;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity(name = "Project")

public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long projId;
	private String projName;

	@ManyToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinTable(name = "Project_Resource", joinColumns = {
			@JoinColumn(name = "projId", referencedColumnName = "projId") }, inverseJoinColumns = {
					@JoinColumn(name = "resId", referencedColumnName = "resId") })
	private Set<Resource> resources = new HashSet<Resource>(0);
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy="project", cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<Columns> columns;
	
	public long getProjId() {
		return projId;
	}
	 
	public void setProjId(long projId) {
		this.projId = projId;
	}
	
	public String getProjName() {
		return projName;
	}

	public void setProjName(String projName) {
		this.projName = projName;
	}

	public Set<Resource> getResources() {
		return resources;
	}

	public void setResources(Set<Resource> resources) {
		this.resources = resources;
	}
	
	public void setColumns(Set<Columns> columns) {
		this.columns = columns;
	}
	public Set<Columns> getColumns(){
		return this.columns;
	}
}
