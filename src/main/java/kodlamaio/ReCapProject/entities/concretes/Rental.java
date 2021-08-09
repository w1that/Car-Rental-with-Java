package kodlamaio.ReCapProject.entities.concretes;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="rentals")
public class Rental {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	//private int carId;
	
	//private int customerId;
	
	@Column(name="rent_date")
	private Date rentDate;
	
	@Column(name="return_date")
	private Date returnDate;
	
	@OneToOne
	@JoinColumn(name="car_id")
	private Car car;
	
	@OneToOne
	@JoinColumn(name="customer_id")
	private Customer customer;
	
	
}
