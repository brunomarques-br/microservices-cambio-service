package br.com.microservices.cambioservice.controller;

import br.com.microservices.cambioservice.model.Cambio;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("cambio-service")
public class CambioController {

    @GetMapping("/cambio/{amount}/{from}/{to}")
    public Cambio getCambio(@PathVariable String amount, @PathVariable String from, @PathVariable String to) {
        return new Cambio(1L, from, to, BigDecimal.ONE, BigDecimal.ONE, "PORT 8000");
    }
}