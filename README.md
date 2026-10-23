# Payable System — Sistema de Folha de Pagamento
 
 	Um sistema em Java para processamento e gestão polimórfica de folha de pagamento. 
	Esse projeto é um estudo baseado no livro DEITEL, Paul; DEITEL, Harvey. Java: como programar.
	O projeto demonstra conceitos fundamentais de Programação Orientada a Objetos, como herança, polimorfismo, encapsulamento, interfaces e validações de regras de negócio.
 	
## Visão Geral
 	
 	O sistema calcula os rendimentos brutos, as alíquotas de desconto de INSS e o valor líquido a ser pago para diferentes tipos de colaboradores. Além disso, fornece mecanismos polimórficos para aplicar regras específicas, como bonificação em salários base para categorias qualificadas. 
 
### Arquitetura e Estrutura:
 

O projeto é organizado em uma arquitetura de 3 camadas com responsabilidades distintas. Respectivamente:  

app: Classe de testes TesteFolhaPagamento.
        
core: Superclasse abstrata Funcionario.java, base para todos os funcionários; 
Interface Pagamento.java com métodos de contrato de pagamento.                  

domain: A camada de domínio tem as subclasses com as regras específicas de cálculos de pagamento: FuncionarioAssalariado.java;
FuncionarioComissionado.java;
FuncionarioBaseMaisComissao.java;
FuncionarioHorista.java.
           
## Regras de Negócio e Funcionalidades 

### Tipos de Funcionários:

Assalariado (FuncionarioAssalariado): Recebe um salário fixo mensal pré-determinado.

Horista (FuncionarioHorista): Recebe por hora trabalhada. Horas trabalhadas além da jornada normal de 160 horas mensais recebem um adicional de 50% (1.5x).

Comissionado (FuncionarioComissionado): Recebe uma porcentagem (taxaComissao) incidente sobre o valor total de vendasBrutas.

Comissionado com Salário Base (FuncionarioBaseMaisComissao): Herda as regras do funcionário comissionado e possui um salário fixo base garantido somado à comissão.

A classe de testes instancia os objetos e gera no console a folha de pagamente através de um processamento polifórmico.

### Cálculo do INSS:
O cálculo do desconto de INSS é aplicado sobre o rendimento bruto seguindo a tabela progressiva simples por faixas de rendimento.

## Tecnologias e Conceitos Utilizados

Java 21+: Uso de Pattern Matching no operador instanceof e métodos de fábrica imutáveis como List.of().

Polimorfismo e Abstração:
	Trata diferentes subtipos de funcionários de forma unificada através do tipo base Funcionario. O Método abstrato (calcularRendimentoBruto()). Sobrescrita de métodos com @Override indica que o método está sobrescrevendo uma implementação de uma superclasse.

O Uso de default string getValorFormatado() na interface Pagamento para formatação monetária padrão em Reais (R$).

## Como Executar
Pré-requisitos: JDK 21 ou superior instalado. Abra a classe de testes e execute o sistema
