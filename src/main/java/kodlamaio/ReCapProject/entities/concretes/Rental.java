package kodlamaio.ReCapProject.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
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
	
	@Column(name="rent_date")
	private LocalDate rentDate = LocalDate.now();
	
	@Column(name="return_date") 
	private LocalDate returnDate;
	
	@OneToOne
	@JoinColumn(name="car_id")
	private Car car;
	
	@OneToOne
	@JoinColumn(name="customer_id")
	private Customer customer;
	
	
}
