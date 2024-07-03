package br.com.microservices.cambioservice.service;

import br.com.microservices.cambioservice.model.Cambio;
import br.com.microservices.cambioservice.repository.CambioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class CambioService {

    @Autowired
    private CambioRepository repository;

    @Autowired
    private Environment environment;

    public Cambio getCambio(Double amount, String from, String to) {
        Cambio cambioResponse = repository.findByFromAndTo(from, to);
        if (cambioResponse == null) throw new RuntimeException("Currency Unsupported");
        var port = environment.getProperty("local.server.port");
        var conversionFactor = cambioResponse.getConversionFactor();
        var convertedValue = conversionFactor.multiply(BigDecimal.valueOf(amount));
        cambioResponse.setConvertedValue(convertedValue.setScale(2, RoundingMode.CEILING));
        cambioResponse.setEnvironment(port);
        return cambioResponse;
    }

}
