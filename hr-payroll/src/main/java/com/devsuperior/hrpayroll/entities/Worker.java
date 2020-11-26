package com.devsuperior.hrpayroll.entities;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

//Serializable para que a classe java possa ser transformada em bites
public class Worker implements Serializable {
//Padrao do Serializeble
private static final long serialVersionUID = 1L;


	private Long  id;
	private String name;
	private Double dailyIncome;
	
//Metodos Construtores
	public Worker() {
		
	}

	public Worker(Long id, String name, Double dailyIncome) {
		super();
		this.id = id;
		this.name = name;
		this.dailyIncome = dailyIncome;
	}
	//Fim construtores
	
	//Equals e hashCode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Worker other = (Worker) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	//Fim Equals e hashCode
	
	
}