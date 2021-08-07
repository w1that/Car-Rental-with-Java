package kodlamaio.ReCapProject.entities.concretes;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="cars")
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
	
	@OneToOne()
	@JsonIgnore
	@JsonProperty(value = "brand.name")
	@JoinColumn(name="brand_id")
	private Brand brand;
	
	@OneToOne()
	@JoinColumn(name="color_id")
	private Color color;
	
	public Car(int id, int modelYear, int dailyPrice, String description, int brandId, int colorId) {
		this.id = id;
		this.modelYear = modelYear;
		this.dailyPrice=dailyPrice;
		this.description =description;
		this.brand.setId(brandId);
		this.color.setId(colorId);
	}
}
