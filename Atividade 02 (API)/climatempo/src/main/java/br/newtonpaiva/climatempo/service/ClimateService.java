 // Declara o pacote da classe
 package br.newtonpaiva.climatempo.service;

import org.springframework.beans.factory.annotation.Value; // Importa a anotação @Value para injeção de valores de propriedades
import org.springframework.http.ResponseEntity; // Importa a classe ResponseEntity para manipulação de respostas HTTP
import org.springframework.stereotype.Service; // Importa a anotação @Service para definir a classe como um serviço do Spring
import org.springframework.web.client.RestTemplate; // Importa a classe RestTemplate para fazer chamadas HTTP

import com.fasterxml.jackson.core.JsonProcessingException; // Importa a exceção JsonProcessingException da biblioteca Jackson
import com.fasterxml.jackson.databind.JsonNode; // Importa a classe JsonNode da biblioteca Jackson
import com.fasterxml.jackson.databind.ObjectMapper; // Importa a classe ObjectMapper da biblioteca Jackson

@Service // Define a classe como um serviço do Spring
public class ClimateService {

    // @Value("${climatempo.api.url}") // Injeta o valor da propriedade climatempo.api.url
    private String apiUrl =  "https://apiadvisor.climatempo.com.br/api/v1"; // Injeta o valor da propriedade climatempo.api.url;


    @Value("2d615d58a6400d81cf973be09c0718d4") // Injeta o valor da propriedade climatempo.api.key
    private String apiKey;

    private final RestTemplate restTemplate; // Declaração do RestTemplate para fazer chamadas HTTP
    private final ObjectMapper objectMapper; // Declaração do ObjectMapper para manipulação de JSON

    public ClimateService() {
        this.restTemplate = new RestTemplate(); // Inicializa o RestTemplate
        this.objectMapper = new ObjectMapper(); // Inicializa o ObjectMapper
    }

    public JsonNode getClimate(String country) {
        // Formata a URL da API com o país e a chave de API
        String url = String.format("%s/anl/synoptic/locale/%s?token=%s", apiUrl, country, apiKey);
        // Faz uma chamada GET para a URL e obtém a resposta como uma string
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);

        // Verifica se a resposta HTTP tem um status 2xx (sucesso)
        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            try {
                // Converte a resposta para um objeto JSON formatado
                return objectMapper.readTree(responseEntity.getBody());
            } catch (JsonProcessingException e) {
                // Em caso de falha na formatação, retorna null
                return null;
            }
        } else {
            // Se a resposta HTTP não for de sucesso, retorna null
            return null;
        }
    }

    public JsonNode getClimateRain(String id) {
        // Formata a URL da API com o país e a chave de API
        String url = String.format("%s/climate/temperature/locale/%s?token=%s", apiUrl, id, apiKey);
        // Faz uma chamada GET para a URL e obtém a resposta como uma string
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);

        // Verifica se a resposta HTTP tem um status 2xx (sucesso)
        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            try {
                // Converte a resposta para um objeto JSON formatado
                return objectMapper.readTree(responseEntity.getBody());
            } catch (JsonProcessingException e) {
                // Em caso de falha na formatação, retorna null
                return null;
            }
        } else {
            // Se a resposta HTTP não for de sucesso, retorna null
            return null;
        }
    }



}