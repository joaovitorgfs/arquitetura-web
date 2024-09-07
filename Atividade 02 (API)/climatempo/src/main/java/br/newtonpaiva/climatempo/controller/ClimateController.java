package br.newtonpaiva.climatempo.controller;

import br.newtonpaiva.climatempo.service.ClimateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.fasterxml.jackson.databind.JsonNode;

@RestController // Anotação que indica que esta classe é um controlador REST
@RequestMapping("/climate") // Mapeia as requisições que começam com "/weather" para esta classe
public class ClimateController {

    @Autowired // Injeta uma instância do WeatherService nesta classe
    private ClimateService weatherService;

    @GetMapping("/{country}") // Mapeia requisições GET para "/weather/country/{country}"
    public JsonNode getClimate(@PathVariable String country) {
        // Chama o método getClimate do Climate Service e retorna o resultado
        return weatherService.getClimate(country);
    }


    @GetMapping("/rain/{id}")
    public JsonNode getClimateRain(@PathVariable String id) {
        // Chama o método getWeatherByCountry do WeatherService e retorna o resultado
        return weatherService.getClimateRain(id);
    }
}