package payable_system.core;

/*Superclasse abstrata que fornece os métodos calcularRendimentoBruto e toString,
 * além dos getters que retornam valores das variáveis de instância.*/
public abstract class Funcionario implements Pagamento {
	
	//Variáveis de instância aqui são os dados do funcionário
	private final String primeiroNome;
	private final String ultimoNome;
	private final String numeroDoPis;

	//Construtor que recebe como parâmetro as variáveis de instância
	public Funcionario(
			String primeiroNome, 
			String ultimoNome, 
			String numeroDoPis) {
		
		this.primeiroNome = primeiroNome;
		this.ultimoNome = ultimoNome;
		this.numeroDoPis = numeroDoPis;
	}
	/*O método calcularRendimentoBruto está declarado como abstract pois os calculos dos rendimentos
	 * depende da classe específica do funcionário que fará uma implementação específica*/
	public abstract double calcularRendimentoBruto();
	
	/*O método calcularINSS calcula o desconto aplicado aos rendimentos brutos
	 seguindo as faixas de alíquota do INSS.*/
	public double calcularINSS() {
		
	double bruto = calcularRendimentoBruto();
	
	if (bruto <= 1621.00) { 
		
		return bruto * 0.075; // 7,5% 
		
	} else if (bruto <= 2902.85) { 
			
		return bruto * 0.09; // 9% 
			
		
	} else if (bruto <= 4354.28) { 
			
		return bruto * 0.12; // 12% 
			
		
	} else { 
			
		return bruto * 0.14; // 14% 
			} 
	}
	
	/* a notação @Override permite sobrescrever o método da interface Pagamento.
	 * O método abaixo retorna o valor líquido que o funcionário vai receber.*/
	@Override
	public double getValorDoPagamento() {
		
		return calcularRendimentoBruto() - calcularINSS();
	}
	
	//Getters que retornam os dados do funcionário
	public String getPrimeiroNome() {
		
		return primeiroNome;
	}
	
	public String getUltimoNome() {
		
		return ultimoNome;
	}
	
	public String getNumeroDoPis() {
		
		return numeroDoPis;
	}
	
	
	/*O método toString está construindo e retornando uma String formatada 
	 * contendo as informações cadastrais básicas do funcionário*/
	@Override
	public String toString()
	{
		return String.format("%n %s%n numero do Pis: %s", 
				getPrimeiroNome() + getUltimoNome(), 
				getNumeroDoPis());
	}

}
