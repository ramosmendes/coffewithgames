package com.coffeewgames.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import com.coffeewgames.entities.enums.RentStatus;

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

	@Enumerated(EnumType.STRING)
	@Column(name = "rent_status")
	private RentStatus rentStatus;

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

	public Rent(Instant moment, RentStatus rentStatus, User client, Computer pc) {
		super();
		this.moment = moment;
		this.rentStatus = rentStatus;
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
		this.payment = payment;
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
