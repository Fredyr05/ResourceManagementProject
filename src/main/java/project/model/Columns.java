package project.model;
import com.fasterxml.jackson.annotation.*;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity(name = "Columns")

public class Columns {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long colId;
	private String colName;
	private String type;
	
	
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JsonBackReference
	@JoinColumn(name = "projId",nullable = false)
	private Project project;
	
	@OneToMany(mappedBy="columns")
	private Set<Block> blocks;
	
	@OneToOne(fetch = FetchType.EAGER, mappedBy="columns", cascade = CascadeType.ALL)
	private Formula formula;
	
	public Long getColId() {
		return colId;
	}
	
	public void setColId(Long colId) {
		this.colId = colId;
	}
	
	public String getColName() {
		return colName;
	}
	
	public void setColName(String colName) {
		this.colName = colName;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public String getEquation() {
		if(formula!=null)
		return formula.getEquation();
		else {
			return null;
		}
	}


}
