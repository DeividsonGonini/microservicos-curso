package com.devsuperior.hruser.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="tb_user")
public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	//garante que o campo seja único
	@Column(unique=true)
	private String email;
	private String password;
	
	//Cria a tabela para fazer a associação muitos para muitos
	//FetchType.EAGER= os dados dos perfis serao carregados automaticamente com os usuarios
	@ManyToMany(fetch = FetchType.EAGER)
	
	//nomeia a tabela que fara a associação
	@JoinTable(name="tb_user_role",
		//informa qual é a chave estrangeira da tabela/classe onde estamos (User)
		joinColumns = @JoinColumn(name="user_id"),
		//informa qual é a chave estrangeira da outra tabela (Role)
		inverseJoinColumns = @JoinColumn(name="role_id")
			)
	
	
	//Set é uma collection que não aceita repetição do mesmo valor
	private Set<Role> roles = new HashSet<>();
	
	//Construtor sem argumentos
	public User() {
	}
	
	public User(Long id, String name, String email, String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
	}

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
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	
}
