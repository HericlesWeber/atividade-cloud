package cloud.pai;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/pais")
public class PaiRestController {

	@Autowired 
	DiscoveryClient discoveryClient;
	
	@Autowired
	ObjectMapper objectMapper;
	
	@GetMapping
	@SuppressWarnings("all")
	public PaiDTO getPai() throws Exception {
		List<ServiceInstance> filhosService = discoveryClient.getInstances("filho-service");
		ServiceInstance instance = filhosService.get(0);
		
		HttpGet getRequest = new HttpGet(instance.getUri() + "/filhos");
		HttpClientBuilder builder = HttpClientBuilder.create();
		HttpClient client = builder.build();
		HttpResponse response = client.execute(getRequest);
		String content = EntityUtils.toString(response.getEntity(), "UTF-8");
		Map mapContent = objectMapper.readValue(content, HashMap.class);
		List<Map> filhos = (List) PropertyUtils.getProperty(mapContent, "_embedded.filhos");
		List<String> nomes = filhos.stream()
				.map(m -> m.get("nome").toString() + " - " + m.get("sexo") + " - " + m.get("idade"))
				.collect(Collectors.toList());
		
		return PaiDTO.builder()
				.nome("PAIZÃO DA PORRA")
				.idade(72)
				.dataNascimento(new Date())
				.filhosCriados(nomes).build();
	}
	
}
