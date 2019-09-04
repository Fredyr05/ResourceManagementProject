package project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "Column")
public class Column {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long colId;
	private String colName;
	private String type;
	
	@ManyToOne
	@JoinColumn(name = "projId")
	private Long projId;
	
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
	
	public Long getProjId() {
		return projId;
	}
	
	public void setProjId(Long projId) {
		this.projId = projId;
	}
	
}
