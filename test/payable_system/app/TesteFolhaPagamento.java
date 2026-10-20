package payable_system.app;

import payable_system.core.Funcionario;
import payable_system.domain.FuncionarioAssalariado;
import payable_system.domain.FuncionarioBaseMaisComissao;
import payable_system.domain.FuncionarioComissionado;
import payable_system.domain.FuncionarioHorista;

import java.util.List;

public class TesteFolhaPagamento {
    public static void main(String[] args) {
        
    	/*Instanciação e agrupamento em coleção imutável genérica
    	 * criando os objetos(funcionarios)*/
        
    	List<Funcionario> funcionarios = List.of(
            new FuncionarioAssalariado("John ", "Smith", "111.11111.11-1", 3521.00), 
            new FuncionarioAssalariado("Gabriel ", "Pereira", "333.33333.33-3", 4560.00),
            new FuncionarioHorista("Karen ", "Price", "222.22222.22-2", 10, 180),
            new FuncionarioComissionado("Sue ", "Jones", "555.55555.55-5", 10000, 0.4),
            new FuncionarioBaseMaisComissao("Bob ", "Lewis", "444.44444.44-4", 5000, 0.04, 3521.00)
        );

        System.out.println("=== PROCESSAMENTO POLIMÓRFICO DA FOLHA DE PAGAMENTO ===\n");

        /*Processamento polimórfico unificado.
         * Através do loop percorre a coleção "funcionários" declarada na linha 17 */
        for (Funcionario funcionario : funcionarios) {
        	
            System.out.println(funcionario); // Chamada polimórfica ao toString()

            /*para identificar se o funcionário atual é do tipo que possui salário base. 
             * Se for, ele concede 10% de aumento no salário base chamando setSalarioBase(...)
             *  e exibe o novo valor
             */
            if (funcionario instanceof FuncionarioBaseMaisComissao funcionarioBase) {
            	
            	//Feito o cálculo da bonificação de 10% no salário
                funcionarioBase.setSalarioBase(funcionarioBase.getSalarioBase() * 1.10);
                
                System.out.printf("-> salário base mais a bonificação (+10%%): R$ %,.2f%n", 
                		funcionarioBase.getSalarioBase());
            }

            //Ocorre o chamado para exibir o rendimento bruto
            System.out.printf(" Rendimento Bruto: R$ %,.2f%n", 
            		funcionario.calcularRendimentoBruto()); 
            
            //Ocorre o chamado para exibir desconto do INSS
            System.out.printf(" Desconto INSS: R$ %,.2f%n", 
            		funcionario.calcularINSS());
            
            //Ocorre o chamado para exibir o valor líquido
            System.out.println(" -> Valor Líquido: " + 
            funcionario.getValorFormatado()); 
            
            System.out.println("----------------------------------------------");
        }

        System.out.println("=== FIM DA EXECUÇÃO ===");

        
    }
}