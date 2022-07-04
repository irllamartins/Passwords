import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class PasswordsFormated extends Arquivo{
	private Password [] bancoDeDados;

	public PasswordsFormated(String path,int linhas) {
		
		this.bancoDeDados = ArquivoFormatado(linhas,path);

	}	
	public Password[] getBancoDeDados() {
		return bancoDeDados;
	}
	
	public void setBancoDeDados(Password[] bancoDeDados) {
		this.bancoDeDados = bancoDeDados;
	}
	

	public Password[] ArquivoFormatado(int quantidade, String path) {

		String linha = null;
		int indice = 0;
		Password[] bancoDeDados = new Password[quantidade];
		String colunas;

		try {

			BufferedReader arquivo = new BufferedReader(new InputStreamReader(new FileInputStream(path)));

			colunas = arquivo.readLine();
			bancoDeDados[0] = new Password( (colunas.substring(colunas.indexOf(",") + 1)).split(",")); 
	
			indice++;

			while ((linha = arquivo.readLine()) != null) {
				try {
					SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:MM:SS");
					SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
					
					String[] dadosFormatados = tratamentoDadosClasses(linha);
					
					bancoDeDados[indice] = new Password(dadosFormatados[0],verificarNumero(dadosFormatados[1]),formato.parse(formato.format(formatter.parse(dadosFormatados[2]))),formato.format(formatter.parse(dadosFormatados[2])),dadosFormatados[3]);
	
					indice++;
				}catch (ParseException e) {
					System.err.println("Ocorreu um erro inesperado na converçaõ de data!\n");
				}
			}
			
			arquivo.close();
		} catch (IOException e) {
			System.err.println("Arquivo não foi encontrado!Verifique o diretorio do arquivo!\n");
		}
		return bancoDeDados;

	}
	
	public static int verificarNumero(String palavra) {
		int numero;
		try {
			numero = Integer.parseInt(palavra);
		} catch (NumberFormatException e) {
			numero = 0;
		}
		return numero;
	}
	
	public void transcricaoFomatado() {
		transcricao(bancoDeDados,"passwords_formated_data.csv");
		
	}	

	

}
