package com.algaworks.junit.utilidade;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class SimuladorEsperaTest {

    @Test
    public void esperar(){
        Assertions.assertTimeout(Duration.ofSeconds(1),
                ()-> SimuladorEspera.esperar(Duration.ofSeconds(10)));
//        Assertions.assertTimeoutPreemptively(Duration.ofSeconds(1),
//                ()-> SimuladorEspera.esperar(Duration.ofSeconds(10)));
    }

}