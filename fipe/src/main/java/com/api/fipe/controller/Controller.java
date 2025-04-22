package com.api.fipe.controller;

import com.api.fipe.service.Service;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;





@RestController
public class Controller {

    Service service  = new Service(); 

    @GetMapping("/marcas")
    public String consultarMarcas() {
        return service.consultarMarca();
    }
    @GetMapping("/modelo/{marca}")
    public String consultarModelo(@PathVariable int marca) {
        return service.consultarModelo(marca);
    }

    @GetMapping("/anos/{marca}/{modelo}")
    public String consultarAnos(@PathVariable int marca, @PathVariable int modelo) {
        return service.consultarAno(marca, modelo);
    }
    
    @GetMapping("/valor/{marca}/{modelo}/{ano}")
    public String consultarValor(@PathVariable int marca, @PathVariable int modelo, @PathVariable String ano) {
        return service.consultarValor(marca, modelo, ano);
    }
    
}
