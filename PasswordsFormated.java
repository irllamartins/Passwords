import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class PasswordsFormated extends Arquivo{
	private Password[] bancoDeDados;
	private int linhas;

	public PasswordsFormated(String path) {

		this.linhas = contarLinha(path);
		this.bancoDeDados = ArquivoFormatado(linhas,path);

	}
	public Password[] getBancoDeDados() {
		return bancoDeDados;
	}

	public void setBancoDeDados(Password[] bancoDeDados) {
		this.bancoDeDados = bancoDeDados;
	}

	public int getLinhas() {
		return linhas;
	}

	public void setLinhas(int linhas) {
		this.linhas = linhas;
	}

	private Password[] ArquivoFormatado(int quantidade, String path) {

		String linha = null;
		int indice = 0;
		Password[] banco = new Password[quantidade];
		String colunas;
		try {

			BufferedReader arquivo = new BufferedReader(new InputStreamReader(new FileInputStream(path)));

			colunas = arquivo.readLine();
			banco[0] = new Password(colunas);
			indice++;

			while ((linha = arquivo.readLine()) != null) {
				try {
					String[] dadosFormatados = tratamentoDados(linha);

					SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
					SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

					banco[indice] = new Password(dadosFormatados[0],verificarNumero(dadosFormatados[1]),formato.parse(formato.format(formatter.parse(dadosFormatados[2]))),formato.format(formatter.parse(dadosFormatados[2])),dadosFormatados[3]);
					indice++;
				} catch (ParseException e) {
					System.err.println("Ocorreu um erro inesperado na convercao de data!\n");
				}
			}

			arquivo.close();
		} catch (IOException e) {
			System.err.println("Arquivo nao foi encontrado!Verifique o diretorio do arquivo!\n");
		}

		return banco;

	}


	private int contarLinha(String path) {
		int contador=0;
		try {
			//FileReader fr = new FileReader(path)
			BufferedReader arquivo = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
			String linha;

			while ((linha = arquivo.readLine())!=null) {
				contador++;
			}
			arquivo.close();

		} catch (IOException e) {
			System.err.println("Arquivo nao foi encontrado!Verifique o diretorio do arquivo!\n");
		}

		return contador;

	}

	private int verificarNumero(String palavra) {
		int numero;
		try {
			numero = Integer.parseInt(palavra);
		} catch (NumberFormatException e) {
			numero = 0;
		}
		return numero;
	}
	private String[] tratamentoDados(String linha) {
		String palavra = null;
		String[] dadosFormatados = new String[4];
		int indice = dadosFormatados.length - 1;

		while (indice > 0) {

			palavra = linha.substring(linha.lastIndexOf(","));
			dadosFormatados[indice] = palavra.substring(1);
			linha = linha.substring(0, linha.lastIndexOf(","));
			indice--;
		}
		dadosFormatados[indice] = linha.substring(linha.indexOf(",") + 1);

		return dadosFormatados;

	}
	public void transcricaoFomatado() {
		transcricao(bancoDeDados,"passwords_formated_data.csv");

	}



}
