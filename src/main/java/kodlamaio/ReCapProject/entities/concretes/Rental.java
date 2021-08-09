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
	//TODO şu rental'a eklemek için bir dto oluştursana. Spring videoları çeken bir adam vardı onu da izle. Her şeye dto yazıyordu
	//TODO api'da sadece car-images-controller'da getByCarImageDetails çalışmıyor. ona bak gerekirse dto yazmaya çalış
	//*************************************************************
	@Column(name="rent_date")
	private LocalDate rentDate;
	
	@Column(name="return_date")
	private LocalDate returnDate;
	
	@OneToOne
	@JoinColumn(name="car_id")
	private Car car;
	
	@OneToOne
	@JoinColumn(name="customer_id")
	private Customer customer;
	
	
}
