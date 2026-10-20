package payable_system.domain;

import payable_system.core.Funcionario;
/*A subclasse FuncionarioAssalariado herda os atributos e o método 
 * abstrato da superclasse Funcionario*/
public class FuncionarioAssalariado extends Funcionario {
	
	//Variável de instância da subclasse atual
	private double salarioMensal;
	
	/*Construtor que recebe como parâmetro as variáveis das subclasse 
	 * atual e da superclasse Funcionario.*/
	public FuncionarioAssalariado(String primeiroNome, String ultimoNome, String numeroDoPis, 
			double salarioMensal) {
		/*a subclasse invoca o construtor da superclasse utilizando 
		 * super(...) como a primeira instrução do construtor*/
		super(primeiroNome, ultimoNome, numeroDoPis);
		
		if (salarioMensal < 0.0)
			throw new IllegalArgumentException("O salario mensal deve ser maior ou igual à 0");
		
		this.salarioMensal = salarioMensal;
	}

	/*O funcionario tratado aqui recebe um salário fixo, portanto o método 
	 * retorna o getSalarioMensal, que é um atributo dessa subclasse*/
	@Override
	public double calcularRendimentoBruto() {
		
		return getSalarioMensal();
	}
	
	public double getSalarioMensal() {
		return salarioMensal;
	}
	
	/*O método toString está construindo e retornando uma String formatada 
	 * contendo o tipo e o salário bruto do funcionário*/
	@Override
	public String toString() {
		return String.format("Funcionário assalariado: %s%n%s: R$%, .2f", 
				super.toString(), " Remuneração básica", getSalarioMensal());
	}
	

}
