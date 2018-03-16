package cloud.pai;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaiDTO {

	String nome;
	Integer idade;
	Date dataNascimento;
	List<String> filhosCriados;

}
