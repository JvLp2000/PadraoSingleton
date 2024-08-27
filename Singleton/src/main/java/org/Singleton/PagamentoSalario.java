package org.Singleton;

import java.util.HashMap;
import java.util.Map;

public class PagamentoSalario {

    // Construtor privado para evitar a criação de novas instâncias
    private PagamentoSalario() {};

    // Instância única da classe
    private static PagamentoSalario instance = new PagamentoSalario();

    // Método público para obter a instância única da classe
    public static PagamentoSalario getInstance() {
        return instance;
    }

    // Armazena os salários dos funcionários por ID
    private Map<Integer, Integer> salarios = new HashMap<>();

    // Adiciona ou atualiza o salário de um funcionário
    public void setSalario(Integer funcionarioId, Integer salario) {
        salarios.put(funcionarioId, salario);
    }

    // Obtém o salário de um funcionário
    public Integer getSalario(Integer funcionarioId) {
        return salarios.get(funcionarioId);
    }

    // Processa o pagamento de um funcionário
    public void processarPagamento(Integer funcionarioId) {
        Integer salario = salarios.get(funcionarioId);
        if (salario != null) {
            // Lógica de pagamento
            System.out.println("Pagamento de R$" + salario + " realizado para o funcionário ID: " + funcionarioId);
        } else {
            System.out.println("Funcionário ID: " + funcionarioId + " não encontrado.");
        }
    }

    // Exemplo de uso
    public static void main(String[] args) {
        PagamentoSalario sistemaPagamento = PagamentoSalario.getInstance();

        // Configurando salários
        sistemaPagamento.setSalario(1, 5000);
        sistemaPagamento.setSalario(2, 7000);
        sistemaPagamento.setSalario(3,100000);
        // Processando pagamentos
        sistemaPagamento.processarPagamento(1);
        sistemaPagamento.processarPagamento(2);
        sistemaPagamento.processarPagamento(3); // Funcionário inexistente
    }
}