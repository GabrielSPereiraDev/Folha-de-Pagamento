package payable_system.domain;

import payable_system.core.Funcionario;
/*Devido à herança multinpivel, a classe FuncionarioComissionado, 
 * aqui é uma superclasse para a classe FuncionarioBaseMaisComissao,
 *  mas para a classe Funcionario é uma subclasse.
 * */
public class FuncionarioComissionado extends Funcionario {
	
	//Variáveis de instância da subclasse atual
	private double vendasBrutas;
	private double taxaComissao;

	/*Construtor que recebe como parâmetro as variáveis das subclasse 
	 * atual e da superclasse Funcionario.*/
	public FuncionarioComissionado(String primeiroNome, String ultimoNome, String numeroDoPis, 
			double vendasBrutas, double taxaComissao) {
		
		/*a subclasse invoca o construtor da superclasse utilizando 
		 * super(...) como a primeira instrução do construtor*/
		super(primeiroNome, ultimoNome, numeroDoPis);
		
		// Validação que lança uma exceção se uma das variáveis for igual ou menor que 0
		if (taxaComissao <= 0.0 ||taxaComissao >= 1.0)
			throw new IllegalArgumentException("A taxa de comissao deve ser maior que 0 e menor que 1");
		if (vendasBrutas < 0.0)
			throw new IllegalArgumentException("As vendas brutas devem ser maior que 0");
		
		this.vendasBrutas = vendasBrutas;
		this.taxaComissao = taxaComissao;
	}
	
	//Método setter que valida se o valor arrecadado em vendas é maior que 0
	public void setVendasBrutas(double vendasBrutas) {
		
		if (vendasBrutas < 0.0)
			throw new IllegalArgumentException("As vendas brutas devem ser maior que 0");
		
		this.vendasBrutas = vendasBrutas;	
	}
	
	//Getters das variáveis de instância
	public double getVendasBrutas() {
		return vendasBrutas;
	}

	public double getTaxaComissao() {
		return taxaComissao;
	}
	
	//Método setter que valida se a taxa de comissão está em entre 0% e 100%
	public void setTaxaComissao(double taxaComissao) {
		
		if (taxaComissao < 0.0 ||taxaComissao > 1.0)
			throw new IllegalArgumentException("A taxa de comissao deve ser maior que 0 e menor que 1");
		
		this.taxaComissao = taxaComissao;
	}



	/*O funcionario tratado aqui recebe o produto da comissão e do 
	 * valor arrecadado em vendas, portanto o método 
	 * retorna o produto das variáveis de instância dessa subclasse*/
	@Override
	public double calcularRendimentoBruto() {
		
		return getTaxaComissao() * getVendasBrutas();
	}
	
	/*O método toString está construindo e retornando uma String formatada 
	 * contendo o tipo, o valor bruto arrecadado em vendas 
	 * e a taxa de comissão que o funcionário vai receber*/
	@Override
	public String toString() {
		return String.format("%s: %s%n%s: $%,.2f;%n %s: %.2f", 
				"Funcionario comissionado", super.toString(), 
				"Valor bruto arrecadado em vendas", getVendasBrutas(), 
				"Taxa de comissão", getTaxaComissao());
	}

}
