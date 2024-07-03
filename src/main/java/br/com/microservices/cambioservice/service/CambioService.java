package br.com.microservices.cambioservice.service;

import br.com.microservices.cambioservice.model.Cambio;
import br.com.microservices.cambioservice.repository.CambioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.math.RoundingMode;

@Service
public class CambioService {

    @Autowired
    private CambioRepository repository;

    @Autowired
    private Environment environment;

    public Cambio getCambio(String amount, String from, String to) {
        Cambio cambioResponse = repository.findByFromAndTo(from, to);
        if (cambioResponse == null) throw new RuntimeException("Currency Unsupported");
        var port = environment.getProperty("local.server.port");
        var conversionFactor = cambioResponse.getConversionFactor();
        var convertedValue = conversionFactor.multiply(new java.math.BigDecimal(amount));
        cambioResponse.setConvertedValue(convertedValue.setScale(2, RoundingMode.CEILING));
        cambioResponse.setEnvironment(port);
        return cambioResponse;
    }

}
