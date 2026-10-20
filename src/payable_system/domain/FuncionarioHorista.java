package payable_system.domain;

import payable_system.core.Funcionario;

public class FuncionarioHorista extends Funcionario {
	
	//Variáveis de instância da subclasse atual
	private double remuneracao;
	private double horas;
	
	/*Construtor que recebe como parâmetro as variáveis das subclasse 
	 * atual e da superclasse Funcionario.*/
	public FuncionarioHorista(String primeiroNome, String ultimoNome, String numeroDoPis, 
			double remuneracao, double horas) {
		
		/*a subclasse invoca o construtor da superclasse utilizando 
		 * super(...) como a primeira instrução do construtor*/
		super(primeiroNome, ultimoNome, numeroDoPis);
		
		
		// Validação que lança uma exceção se uma das variáveis for igual ou menor que 0
		if (remuneracao <= 0.0)
			throw new IllegalArgumentException("A remuneração por hora deve ser maior que 0");
		
		if (horas <= 0.0)
			throw new IllegalArgumentException("As horas trabalhadas devem ser maior que 0");
		
		this.remuneracao = remuneracao;
		this.horas = horas;
	}
	
	//Getters e Setters das variáveis de instância
	public void setRemuneracao(double remuneracao) {
		this.remuneracao = remuneracao;
	}
	
	public double getRemuneracao() {
		return remuneracao;
	}
	
	public void setHoras(double horas) {
		this.horas = horas;
	}
	
	public double getHoras() {
		return horas;
	}

	/*O funcionario tratado aqui recebe por horas trabalhadas, portanto o método 
	 * retorna o produto das variáveis de instância dessa subclasse*/
	@Override
	public double calcularRendimentoBruto() {
		
		if (getHoras() <= 160)
			return getRemuneracao() * getHoras();
		/*Caso o funcionário faça hora extra além das 160 horas mensais 
		 * de trabalho, as horas extras terão um adicional de 50%*/
		else
			return 160 * getRemuneracao() + (getHoras() - 160) * getRemuneracao() * 1.5;
	}
	
	/*O método toString está construindo e retornando uma String formatada 
	 * contendo o tipo, a remuneração por hora e as horas trabanlhadas
	 * do funcionário*/
	@Override
	public String toString() {
		return String.format("Funcionário horista: %s%n%s: $%,.2f;%n %s: %,.2f", super.toString(), 
				"Remuneração por hora", getRemuneracao(), "Horas trabalhadas", getHoras());
	}
		

}
