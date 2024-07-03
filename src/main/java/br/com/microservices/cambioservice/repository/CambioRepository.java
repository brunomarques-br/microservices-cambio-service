package br.com.microservices.cambioservice.repository;

import br.com.microservices.cambioservice.model.Cambio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CambioRepository extends JpaRepository<Cambio, Long> {

    Cambio findByFromAndTo(String from, String to);

}
