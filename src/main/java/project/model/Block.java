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
	private Long value;
	
	@ManyToOne
	@JoinColumn(name = "colId")
	private Long colId;
	
	@ManyToOne
	@JoinColumn(name = "resId")
	private Long resId;
	
	public Long getBlockId() {
		return blockId;
	}
	
	public void setBlockId(Long blockId) {
		this.blockId = blockId;
	}
	
	public Long getValue() {
		return value;
	}
	
	public void setValue(Long value) {
		this.value = value;
	}
	
	public Long getColId() {
		return colId;
	}
	
	public void setColId(Long colId) {
		this.colId = colId;
	}
	
	public Long getResId() {
		return resId;
	}
	
	public void setResId(Long resId) {
		this.resId = resId;
	}
	
}
