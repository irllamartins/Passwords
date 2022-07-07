import java.util.Date;

public class Password{
	private String password;
	private int length;
	private Date data;
	private String dataFormatada;
	private String classificacao;
	private String colunas;

	public Password(String password,int length, Date data, String dataFormatada,String classificacao) {
		this.password = password;
		this.length = length;
		this.data = data;
		this.dataFormatada = dataFormatada;
		this.setClassificacao(classificacao);
	}
	public Password(String colunas) {
		this.colunas = colunas;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getColunas() {
		return colunas;
	}
	public void setColunas(String colunas) {
		this.colunas = colunas;
	}
	
	public String getDataFormatada() {
		return dataFormatada;
	}

	public void setDataFormatada(String dataFormatada) {
		this.dataFormatada = dataFormatada;
	}

	public String getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(String classificacao) {
		this.classificacao = classificacao;
	}

	@Override
	public String toString() {
		return "," + password + "," + length + "," + dataFormatada+","+classificacao;
	}
	public String toStringColunas() {
		return colunas;
	}



	

}
