package project.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "Block")
public class Block {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long blockId;
	private String value;
	
	@ManyToOne
	@JoinColumn(name = "colId")
	private Columns columns;
	
	@ManyToOne
	@JoinColumn(name = "resId")
	private Resource resource;
	
	public Long getBlockId() {
		return blockId;
	}
	
	public void setBlockId(Long blockId) {
		this.blockId = blockId;
	}
	
	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	
	//@JsonManagedReference
	public Columns getColumns() {
		return columns;
	}
	
	public void setColumns(Columns columns) {
		this.columns = columns;
	}
	
	//@JsonManagedReference
	public Resource getResource() {
		return resource;
	}
	
	public void setResource(Resource resource) {
		this.resource = resource;
	}
	
}
