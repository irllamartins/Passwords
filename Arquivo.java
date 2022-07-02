import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Arquivo {
	public Arquivo() {

		
	}

	public String [][] construirPiorCaso(String[][] bancoDeDados){
		String[][] banco = new String [bancoDeDados.length][3];
		banco[0] = bancoDeDados[0];
		for(int i=1;i<banco.length;i++) {
			banco[i] = bancoDeDados[banco.length-i];
		}
		return banco;
		
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

	public static void transcricao(String[][] bancoDeDados, String nomeArquivo) {

		try {
			FileWriter arq = new FileWriter(nomeArquivo);
			PrintWriter gravarArq = new PrintWriter(arq);

			gravarArq.println("," + bancoDeDados[0][0] + "," + bancoDeDados[0][1] + "," + bancoDeDados[0][2]);
			for (int k = 1; k < bancoDeDados.length; k++) {
		
				gravarArq.println(k-1 + "," + bancoDeDados[k][0] + "," + bancoDeDados[k][1] + "," + bancoDeDados[k][2]);
			}
			arq.close();
			System.out.println("O Arquivo " + nomeArquivo + " gerado com sucesso!");

		} catch (IOException e) {
			System.err.println("O Arquivo não pode ser criado!\n");
		}

	}


	public static String[] tratamentoDados(String linha) {
		String palavra = null;
		String[] dadosFormatados = new String[3];
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

	// troca os elementos de acordo com o criterio selecionado
	public void troca(String array[][], int i, int j) {
		String[] aux;

		aux = array[i];
		array[i] = array[j];
		array[j] = aux;
	}
	
	/*public static Date comparaDataMesAno(String data) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date date = null;
		 try {
			 date = formatter.parse(data);
	     } catch (ParseException e) {
	            e.printStackTrace();
	      }
		 return date;
	}*/
	public static Date comparaDataMes(String data) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat formato = new SimpleDateFormat("MM/yyyy");
		Date date = null;
		 try {
			 date = formato.parse(formato.format(formatter.parse(data)));
	     } catch (ParseException e) {
	            e.printStackTrace();
	      }
		 return date;
	}
		
}
