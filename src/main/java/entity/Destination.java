package entity;


import javax.persistence.*;

@Entity
@Table(name = "destination")
public class Destination {

	@Id
	private int destination_id;

	@Column
	private String destinationName;

	public Destination() {}

	public Destination(int destination_id, String destinationName) {
		this.destination_id = destination_id;
		this.destinationName = destinationName;
	}

	public int getDestination_id() {
		return destination_id;
	}

	public String getDestinationName() {
		return destinationName;
	}

	public void setDestination_id(int destination_id) {
		this.destination_id = destination_id;
	}

	public void setDestinationName(String destinationName) {
		this.destinationName = destinationName;
	}
}
