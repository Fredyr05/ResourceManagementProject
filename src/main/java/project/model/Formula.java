package project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class Formula {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	@JoinColumn(name="colId")
	@PrimaryKeyJoinColumn
	private Columns columns;
	private String equation;
	
	public Long getFormulaId() {
		return id;
	}
	public void setFormulaId(Long formulaId) {
		this.id = formulaId;
	}
	public Columns getCol() {
		return this.columns;
	}
	public void setColumn(Columns columns) {
		this.columns = columns;
	}
	public String getEquation() {
		return equation;
	}
	public void setEquation(String equation) {
		this.equation = equation;
	}

}
