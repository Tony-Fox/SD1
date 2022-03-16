package entity;


import javax.persistence.*;

@Entity
@Table(name = "vacation")
public class Vacation {

	@Id
	private int vacation_id;



	@Column
	private String name;

	@Column
	private int price;

	@Column
	private int period;

	@Column
	private String extra_details;

	@Column
	private int max_people;


	@ManyToOne
	@JoinColumn
	private Destination destination;

	public int getVacation_id() {
		return vacation_id;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public int getPeriod() {
		return period;
	}

	public String getExtra_details() {
		return extra_details;
	}

	public int getMax_people() {
		return max_people;
	}

	public Destination getDestination() {
		return destination;
	}

	public Vacation() {}

	public Vacation(int vacation_id, String name, int price, int period, String extra_details, int max_people, Destination destination) {
		this.vacation_id = vacation_id;
		this.name = name;
		this.price = price;
		this.period = period;
		this.extra_details = extra_details;
		this.max_people = max_people;
		this.destination = destination;
	}

	public void setVacation_id(int vacation_id) {
		this.vacation_id = vacation_id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setPeriod(int period) {
		this.period = period;
	}

	public void setExtra_details(String extra_details) {
		this.extra_details = extra_details;
	}

	public void setMax_people(int max_people) {
		this.max_people = max_people;
	}

	public void setDestination(Destination destination) {
		this.destination = destination;
	}
}
