package cloud.filho;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Filho {

	@Id @GeneratedValue
	Long id;
	String nome;
	Integer idade;
	String sexo;

}