package in.thiru.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Mobile {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer mobileId;
	private String mobileName;
	private Double mobilePrice;

}
