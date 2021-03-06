package kodlamaio.ReCapProject.entities.concretes;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="cars")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","carImages"})
public class Car {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	
	@Column(name="model_year")
	private int modelYear;
	
	@Column(name="daily_price")
	private int dailyPrice;
	
	@Column(name="description")
	private String description;
	
	@ManyToOne
	@JoinColumn(name="brand_id")
	private Brand brand;
	
	@ManyToOne
	@JoinColumn(name="color_id")
	private Color color;
	
	@Column(name="is_busy")
	private boolean isBusy;
	
//	@OneToMany(mappedBy = "car")
//	private List<CarImage> carImages;
	
}
