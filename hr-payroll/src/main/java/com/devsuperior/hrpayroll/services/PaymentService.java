package com.devsuperior.hrpayroll.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.devsuperior.hrpayroll.entities.Payment;
import com.devsuperior.hrpayroll.entities.Worker;

@Service
public class PaymentService {
	
	//inserir o nome da propriedade criada no application.properties
	@Value("${hr-worker.host}")
	//variavel para guardar o valor do @Value
	private String workerHost;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public Payment getPayment(Long workerId, int days) {
		//Criar um mapa/dicionario de Parametros para serem utilizados no RestTemplate 
		Map<String, String> uriVariables = new HashMap<>();
		//Inserir o Parametro do ID necessario para a rota (workerId tem que ser convertido para String)
		uriVariables.put("id", "" + workerId);
		
		
		//Criar a requisição para uma API externa usando RestTemplate
		//parametros: 1º URL+caminho/parametro/id / 2º Tipo do Objeto / 3º parâmetros
		Worker worker = restTemplate.getForObject(workerHost + "/workers/{id}", Worker.class, uriVariables);
		
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}

}
