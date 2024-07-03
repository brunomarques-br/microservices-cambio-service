package br.com.microservices.cambioservice.controller;

import br.com.microservices.cambioservice.model.Cambio;
import br.com.microservices.cambioservice.service.CambioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cambio-service")
public class CambioController {

    @Autowired
    private CambioService cambioService;


    @GetMapping("/cambio/{amount}/{from}/{to}")
    public Cambio getCambio(@PathVariable String amount, @PathVariable String from, @PathVariable String to) {
        return cambioService.getCambio(amount, from, to);
    }
}
