import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ViaCepService {

    private static final String VIA_CEP_URL = "https://viacep.com.br/ws/";

    public Endereco consultarEnderecoPorCep(String cep) {
        String url = VIA_CEP_URL + cep + "/json";
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, Endereco.class);
    }
}
