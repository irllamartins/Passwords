import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class FiltrarSenha extends Arquivo {
	private String path;
    private int linhas;

    public FiltrarSenha(String path,int linhas) {

        this.linhas = linhas;
        this.path = path;
    }


    public String getPath() {
		return path;
	}


	public void setPath(String path) {
		this.path = path;
	}


	public int getLinhas() {
		return linhas;
	}


	public void setLinhas(int linhas) {
		this.linhas = linhas;
	}


	public void filtrar(int quantidade, String path) {

		String linha = null;
		int indice = 0;
		String colunas;

		try {

			BufferedReader arquivo = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
			FileWriter arq = new FileWriter(path);
			PrintWriter gravarArq = new PrintWriter(arq);
			
			colunas = arquivo.readLine();
			gravarArq.println(colunas);
			
			while ((linha = arquivo.readLine()) != null) {
				String classe = linha.substring(linha.lastIndexOf(",")+1);

				if(classe.equals("muito boa")||classe.equals("muito boa")) {
					gravarArq.println(indice+linha.substring(linha.indexOf(",")));
					indice++;
				}
			}
			arq.close();
			arquivo.close();
		} catch (IOException e) {
			System.err.println("Arquivo não foi encontrado!Verifique o diretorio do arquivo!\n");
		}

	}
	public void transcricaoClasses() {
		filtrar(getLinhas(),getPath());

    }


}