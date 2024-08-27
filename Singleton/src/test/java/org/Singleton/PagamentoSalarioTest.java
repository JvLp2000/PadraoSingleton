package org.Singleton;

import static org.junit.Assert.*;

import org.Singleton.PagamentoSalario;
import org.junit.Before;
import org.junit.Test;

public class PagamentoSalarioTest {

    private PagamentoSalario sistemaPagamento;

    @Before
    public void setUp() {
        sistemaPagamento = PagamentoSalario.getInstance();

        sistemaPagamento.setSalario(1, null);
        sistemaPagamento.setSalario(2, null);
        sistemaPagamento.setSalario(3, null);
    }

    @Test
    public void testSetAndGetSalario() {
        sistemaPagamento.setSalario(1, 5000);
        assertEquals((Integer) 5000, sistemaPagamento.getSalario(1));
    }

    @Test
    public void testProcessarPagamentoFuncionarioExistente() {
        sistemaPagamento.setSalario(1, 5000);
        java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outContent));

        sistemaPagamento.processarPagamento(1);
        String expectedOutput = "Pagamento de R$5000 realizado para o funcionário ID: 1\n";
        String actualOutput = outContent.toString();

        System.out.println("Esperado: " + expectedOutput);
        System.out.println("Atual: " + actualOutput);

        assertEquals(expectedOutput.trim(), actualOutput.trim());
    }

    @Test
    public void testProcessarPagamentoFuncionarioInexistente() {
        java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outContent));

        sistemaPagamento.processarPagamento(99);
        String expectedOutput = "Funcionário ID: 99 não encontrado.\n";
        String actualOutput = outContent.toString();

        System.out.println("Esperado: " + expectedOutput);
        System.out.println("Atual: " + actualOutput);

        assertEquals(expectedOutput.trim(), actualOutput.trim());
    }

    @Test
    public void testSingletonInstance() {
        PagamentoSalario instance1 = PagamentoSalario.getInstance();
        PagamentoSalario instance2 = PagamentoSalario.getInstance();
        assertSame(instance1, instance2);
    }
}
