package payable_system.core;

public interface Pagamento {
	
	/*A função do método getValorDoPagamento é permitir a leitura do 
	 * valor líquido após os descontos do INSS e terá uma implementação 
	 * em cada subclasse*/
	double getValorDoPagamento();
	
	/*O método getValorFormatado tem a palavra chave defaut, para permitir 
	 * a conversão do valor do pagamento em uma string formatada*/
	default String getValorFormatado() { 
		return String.format("R$ %,.2f", getValorDoPagamento()); }
	
}
