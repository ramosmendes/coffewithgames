package com.coffeewgames.dto;

import org.springframework.beans.BeanUtils;

import com.coffeewgames.entities.Computer;
import com.coffeewgames.entities.enums.TypePc;

public class ComputerDto {

	private Long id;
	private String name;
	private TypePc typePc;

	public ComputerDto(Computer pc) {
		BeanUtils.copyProperties(pc, this);
	}

	public ComputerDto() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

}
