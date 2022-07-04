import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class PasswordsFormated extends Arquivo {
	private String[][] bancoDeDados;
	private int linhas;

	public PasswordsFormated(String path) {

		this.linhas = contarLinha(path);
		this.bancoDeDados = ArquivoFormatado(linhas, path);

	}

	public String[][] getBancoDeDados() {
		return bancoDeDados;
	}

	public void setBancoDeDados(String[][] bancoDeDados) {
		this.bancoDeDados = bancoDeDados;
	}

	public int getLinhas() {
		return linhas;
	}

	public void setLinhas(int linhas) {
		this.linhas = linhas;
	}

	public String[][] ArquivoFormatado(int quantidade, String path) {

		String linha = null;
		int indice = 0;
		String[][] bancoDeDados = new String[quantidade][3];
		String[] colunas;

		try {

			BufferedReader arquivo = new BufferedReader(new InputStreamReader(new FileInputStream(path)));

			colunas = (arquivo.readLine()).split(",");

			bancoDeDados[indice][0] = colunas[1];
			bancoDeDados[indice][1] = colunas[2];
			bancoDeDados[indice][2] = colunas[3];
			indice++;

			while ((linha = arquivo.readLine()) != null) {
				try {
					String[] dadosFormatados = tratamentoDados(linha);

					bancoDeDados[indice][0] = dadosFormatados[0];
					bancoDeDados[indice][1] = Integer.toString(verificarNumero(dadosFormatados[1]));
					SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
					bancoDeDados[indice][2] = formato.format(new SimpleDateFormat("yyyy-MM-dd").parse(dadosFormatados[2]));

					// para outro momento.replaceAll("^\"|\"$", "");
					indice++;
				} catch (ParseException e) {
					System.err.println("Ocorreu um erro inesperado na conversao de data!\n");
				}
			}

			arquivo.close();
		} catch (IOException e) {
			System.err.println("Arquivo nao foi encontrado!Verifique o diretorio do arquivo!\n");
		}
		return bancoDeDados;

	}

	public static int contarLinha(String path) {
		int contador = 0;

		try {
			BufferedReader arquivo = new BufferedReader(new InputStreamReader(new FileInputStream(path)));

			while (arquivo.readLine() != null) {
				contador++;
			}
			arquivo.close();

		} catch (IOException e) {
			System.err.println("Arquivo nao foi encontrado!Verifique o diretorio do arquivo!\n");
		}

		return contador;

	}

	public void transcricaoFomatado() {
		transcricao(bancoDeDados, "passwords_formated_data.csv");

	}

}
