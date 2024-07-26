package br.com.microservices.cambioservice.controller;

import br.com.microservices.cambioservice.model.Cambio;
import br.com.microservices.cambioservice.service.CambioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Cambio Service", description = "Cambio Service API")
@RestController
@RequestMapping("cambio-service")
public class CambioController {

    private final CambioService cambioService;

    public CambioController(CambioService cambioService) {
        this.cambioService = cambioService;
    }

    @Operation(summary = "Get cambio by amount, from and to")
    @GetMapping("/cambio/{amount}/{from}/{to}")
    public Cambio getCambio(@PathVariable Double amount, @PathVariable String from, @PathVariable String to) {
        return cambioService.getCambio(amount, from, to);
    }
}
