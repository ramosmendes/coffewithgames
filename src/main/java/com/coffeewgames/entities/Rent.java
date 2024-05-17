package com.coffeewgames.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import com.coffeewgames.entities.enums.RentStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_rent")
public class Rent implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "payment_instant")
	private Instant moment;

	@Column(name = "time_rent")
	private Double time;

	@Column(name = "value_rent")
	private Double value;

	@Enumerated(EnumType.STRING)
	@Column(name = "rent_status")
	private RentStatus rentStatus;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "client_id")
	private User client;

	@OneToOne
	@JoinColumn(name = "computer_id")
	private Computer pc;

	@OneToOne(mappedBy = "rent", cascade = CascadeType.ALL)
	private Payment payment;

	public Rent() {

	}

	public Rent(User client, Computer pc, Double time) {
		super();
		this.moment = Instant.now();
		this.time = time;
		setValue(pc);
		rentStatus = RentStatus.PENDING;
		this.client = client;
		this.pc = pc;
	}

	public RentStatus getRentStatus() {
		return rentStatus;
	}

	public void setRentStatus(RentStatus rentStatus) {
		this.rentStatus = rentStatus;
	}

	public Long getId() {
		return id;
	}

	public Instant getMoment() {
		return moment;
	}

	public User getClient() {
		return client;
	}

	public void setClient(User client) {
		this.client = client;
	}

	public Computer getPc() {
		return pc;
	}

	public void setPc(Computer pc) {
		this.pc = pc;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		setRentStatus(RentStatus.PAID);
		this.payment = payment;
	}

	public Double getTime() {
		return time;
	}

	public void setTime(Double time) {
		this.time = time;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Computer pc) {
		switch (pc.getTypePc().getCode()) {
		case 1:
			value = 1 * time;
			break;
		case 2:
			value = 2 * time;
			break;
		case 3:
			value = 3.5 * time;
			break;
		case 4:
			value = 5 * time;
			break;
		default:
			throw new IllegalArgumentException("code invalid");
		}

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
		Rent other = (Rent) obj;
		return Objects.equals(id, other.id);
	}

}
