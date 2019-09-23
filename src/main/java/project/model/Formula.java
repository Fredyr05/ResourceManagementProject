package project.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Formula {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="ColId")	
	private Columns columns;
	
	private String equation;
	
	public Long getFormulaId() {
		return id;
	}
	public void setFormulaId(Long formulaId) {
		this.id = formulaId;
	}
	public Columns getColumns() {
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
