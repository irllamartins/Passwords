import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class FiltrarSenha extends Arquivo {
	private String path;

    public FiltrarSenha(String path) {

        this.path = path;
    }


    public String getPath() {
		return path;
	}


	public void setPath(String path) {
		this.path = path;
	}


	public void filtrar(String path) {

		String linha = null;
		String colunas;

		try {
			int indice = 0;
			BufferedReader arquivo = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
			FileWriter arq = new FileWriter("passwords_classifier.csv");
			PrintWriter gravarArq = new PrintWriter(arq);
			
			colunas = arquivo.readLine();
			gravarArq.println(colunas);
			
			while ((linha = arquivo.readLine()) != null) {
				String classe = linha.substring(linha.lastIndexOf(",")+1);

				if(classe.equals("muito boa")||classe.equals("muito boa")) {
					linha = linha.substring(linha.indexOf(","));
					gravarArq.println(indice+linha);
					indice++;
				}
			}
			System.out.println("O Arquivo passwords_classifier.csv gerado com sucesso!");
			arq.close();
			arquivo.close();
		} catch (IOException e) {
			System.err.println("Arquivo não foi encontrado!Verifique o diretorio do arquivo!\n");
		}

	}
	public void transcricaoClasses() {
		filtrar(getPath());

    }


}