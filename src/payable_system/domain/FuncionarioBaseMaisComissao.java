package payable_system.domain;

/*Essa classe representa um funcionario que ganha um salário fixo base e recebe também uma
 * taxa de comissão de vendas.*/


/*Aqui a classe FuncionarioBaseMaisComissao está herdando as variáveis de intância da supeclasse 
 * FuncionarioComissionado. */

public class FuncionarioBaseMaisComissao extends FuncionarioComissionado {

	//Variável de intância da subclasse atual
	private double salarioBase;
	
	
	/*Construtor que recebe como parâmetro as variáveis das classes FuncionarioComissionado e Funcionario.
	 Como também da classe atual FuncionarioBaseMaisComissao*/
	public FuncionarioBaseMaisComissao(String primeiroNome, String ultimoNome, String numeroDoPis,
			double vendasBrutas, double taxaComissao, double salarioBase) {
		
		super(primeiroNome, ultimoNome, numeroDoPis, vendasBrutas, taxaComissao);
		
		if (salarioBase < 0.0)
			throw new IllegalArgumentException("Salario base deve ser maior que 0");
		
		this.salarioBase = salarioBase;
		
	}
	//Setter que faz uma Validação que lança uma exceção se o salário base for igual ou menor que 0
	public void setSalarioBase(double salarioBase) {
		
		if (salarioBase <= 0.0)
			throw new IllegalArgumentException("Salario base deve ser maior que 0");
		
		this.salarioBase = salarioBase;
		
	}
	
	//getter do salário base
	public double getSalarioBase() {
		return salarioBase;
	}
	
	/*a palavra-chave super para chama a implementação do método presente na 
	superclasse FuncionarioComissionado. Esse método calcula a comissão multiplicando 
	a taxa de comissão pelas vendas brutas e soma com o salário base que é uma
	Variável de instância da classe atual*/
	@Override
	public double calcularRendimentoBruto() {
		
		return getSalarioBase() + super.calcularRendimentoBruto();
		
	}
	
	/*O método toString está construindo e retornando uma String formatada 
	 * contendo as informações do subtipo do funcionário e o salário base*/
	@Override
	public String toString() {
		return String.format("%s %s;%n %s: $%,.2f", 
				"Assalariado +", super.toString(), 
				"Remuneração básica", getSalarioBase());
	}

	
	

}
