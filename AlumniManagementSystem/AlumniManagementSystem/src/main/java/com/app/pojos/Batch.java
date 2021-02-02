package com.app.pojos;
import javax.persistence.*;

//can we set PassingYear as PK?
@Entity
public class Batch {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer batchId;
	
	@Column(unique = true)
	private Integer passingYear;
	
	public Batch() {
		super();
	}

	public Batch(Integer batchId, Integer passingYear) {
		super();
		this.batchId = batchId;
		this.passingYear = passingYear;
	}

	public Integer getBatchId() {
		return batchId;
	}

	public void setBatchId(Integer batchId) {
		this.batchId = batchId;
	}

	public Integer getPassingYear() {
		return passingYear;
	}

	public void setPassingYear(Integer passingYear) {
		this.passingYear = passingYear;
	}
	
	
	
}
