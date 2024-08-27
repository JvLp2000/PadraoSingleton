package org.Singleton;

import java.util.HashMap;
import java.util.Map;

public class PagamentoSalario {

    private PagamentoSalario() {};

    private static PagamentoSalario instance = new PagamentoSalario();

    public static PagamentoSalario getInstance() {
        return instance;
    }

    private Map<Integer, Integer> salarios = new HashMap<>();

    public void setSalario(Integer funcionarioId, Integer salario) {
        salarios.put(funcionarioId, salario);
    }

    public Integer getSalario(Integer funcionarioId) {
        return salarios.get(funcionarioId);
    }

    public void processarPagamento(Integer funcionarioId) {
        Integer salario = salarios.get(funcionarioId);
        if (salario != null) {
            System.out.println("Pagamento de R$" + salario + " realizado para o funcionário ID: " + funcionarioId);
        } else {
            System.out.println("Funcionário ID: " + funcionarioId + " não encontrado.");
        }
    }

    public static void main(String[] args) {
        PagamentoSalario sistemaPagamento = PagamentoSalario.getInstance();

        sistemaPagamento.setSalario(1, 5000);
        sistemaPagamento.setSalario(2, 7000);
        sistemaPagamento.setSalario(3,100000);

        sistemaPagamento.processarPagamento(1);
        sistemaPagamento.processarPagamento(2);
        sistemaPagamento.processarPagamento(3);
    }
}