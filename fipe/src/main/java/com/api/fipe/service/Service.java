package com.api.fipe.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class Service {
    private String consultarUrl(String apiUrl){
        String dados = " ";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity <String> responseEntity = restTemplate.getForEntity(apiUrl, String.class);
        if(responseEntity.getStatusCode().is2xxSuccessful()){
            dados = responseEntity.getBody();
        }
        else {
            dados = " Falha ao  obter dados. Código de status: " +responseEntity.getStatusCode();
        }
        return dados;
    }

    public String consultarMarca(){
        return consultarUrl("https://parallelum.com.br/fipe/api/v1/carros/marcas");
    }
    public String consultarModelo(int id){
        return consultarUrl("https://parallelum.com.br/fipe/api/v1/carros/marcas/59/modelos");
    }
    public String consultarAno(int marca, int modelo){
        return consultarUrl("https://parallelum.com.br/fipe/api/v1/carros/marcas/59/modelos/5940/anos");
    }
    public String consultarValor(int marca, int modelo, String ano){
        return consultarUrl("https://parallelum.com.br/fipe/api/v1/carros/marcas/59/modelos/5940/anos/2014-3");
    }
}
