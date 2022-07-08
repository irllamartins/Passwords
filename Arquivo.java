import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public abstract class Arquivo {
	public Arquivo() {

	}
	//responsavel por construir o caso da ordenação decrescente
	public Password[] construirCasoDecrescente(Password[] bancoDeDados){
		Password[] banco = new Password[bancoDeDados.length];
		
		banco[0] = bancoDeDados[0];
		
		for(int i=1;i<banco.length;i++) {
			banco[i] = bancoDeDados[banco.length-i];
		}
		return banco;
		
	}
	
	//responsavel por criar e/ou escrever arquivo
	public static void transcricao(Password[] bancoDeDados, String nomeArquivo) {

		try {
			FileWriter arq = new FileWriter(nomeArquivo);
			PrintWriter gravarArq = new PrintWriter(arq);

			gravarArq.println(bancoDeDados[0].toStringColunas());
			for (int k = 1; k < bancoDeDados.length; k++) {
		
				gravarArq.println(k-1 + bancoDeDados[k].toString());
			}
			arq.close();
			System.out.println("O Arquivo " + nomeArquivo + " gerado com sucesso!");

		} catch (IOException e) {
			System.err.println("O Arquivo não pode ser criado!\n");
		}

	}

	// troca os elementos de acordo com o criterio selecionado
	public void troca(Password[] array, int i, int j) {
		Password aux;

		aux = array[i];
		array[i] = array[j];
		array[j] = aux;
	}
	
    public String[] tratamentoDadosClasses(String linha) {
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
  //gera a lista para ordenar sem coluna
  	public Password[] gerarListaOrdenar(Password[] listaInicial,int inicio) {
  		Password[] listaFinal = new Password[listaInicial.length-inicio];
  		
  		for(int i=0;i<listaFinal.length;i++) {
  			listaFinal[i] = listaInicial[i+inicio];
  		}	
  		
  		return listaFinal;
  	}
  	//gera lista final com coluna
  	public Password[] gerarListaFinal(Password[] listaComColuna, Password[] lista) {
  		Password[] listaFinal = new Password[listaComColuna.length];
  		
  		listaFinal[0] = listaComColuna[0];
  		for(int i=1;i<listaFinal.length;i++) {
  			listaFinal[i] = lista[i-1];
  		}	
  		return listaFinal;
  	}

}
