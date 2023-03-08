package com.algaworks.junit.utilidade;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SaudacaoUtilTest {

    @Test
   public void saudarTest() {
        String saudar = SaudacaoUtil.saudar(9);
        System.out.printf(saudar);
        Assertions.assertTrue(saudar.equals("Bom dia"));
    }

    @Test
    public void deveLancarException(){
        IllegalArgumentException illegalArgumentException =
                assertThrows(IllegalArgumentException.class, () -> SaudacaoUtil.saudar(-10));
        assertEquals("Hora inválida", illegalArgumentException.getMessage());

    }

    @Test
    public void naoDeveLancarException(){
        assertDoesNotThrow(() -> SaudacaoUtil.saudar(-10));
    }


}