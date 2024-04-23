package com.coffeewgames.demo.entities;

import java.io.Serializable;
import java.util.Objects;

import com.coffeewgames.demo.entities.enums.TypePc;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_computer")
public class Computer implements Serializable {

	private static final long serialVersionUID = 1;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Nonnull
	private String name;

	@Nonnull
	private TypePc typePc;

	public Computer() {

	}

	public Computer(Long id, String name, TypePc typePc) {
		this.id = id;
		this.name = name;
		this.typePc = typePc;
	}

	public Integer getPrice() {
		return typePc.getPrice();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TypePc getTypePc() {
		return typePc;
	}

	public void setTypePc(TypePc typePc) {
		this.typePc = typePc;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Computer other = (Computer) obj;
		return Objects.equals(id, other.id);
	}

}
