package com.coffeewgames.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.hibernate.annotations.Formula;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_user")
public class User implements Serializable {

	public User() {

	}

	public User(String name, Integer age, String email, String password, Double wallet) {
		super();
		this.name = name;
		this.age = age;
		this.email = email;
		this.password = password;
		this.wallet = wallet;
		this.adult = age >= 18;
	}

	private static final long serialVersionUID = 1;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Nonnull
	private String name;

	@Nonnull
	private String email;

	@Nonnull
	private String password;

	@Nonnull
	private Double wallet;

	@Nonnull
	private Integer age;

	@Nonnull
	@Formula("CASE WHEN age >= 18 THEN true ELSE false END")
	@Column(name = "IS_ADULT")
	private boolean adult;

	@JsonIgnore
	@OneToMany(mappedBy = "client")
	private List<Rent> rents = new ArrayList<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public Double getWallet() {
		return wallet;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public boolean getAdult() {
		return adult;
	}

	public List<Rent> getRent() {
		return rents;
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
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
