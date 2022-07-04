import java.text.SimpleDateFormat;
import java.text.ParseException;

public class MergeSort extends Arquivo{
	private String[][] casoMedio;
	private String[][] piorCaso;
	private String[][] melhorCaso;
	public MergeSort( String[][] bancoDeDados) {
		this.casoMedio = bancoDeDados;

	}

	public String[][] getCasoMedio() {
		return casoMedio;
	}

	public void setCasoMedio(String[][] casoMedio) {
		this.casoMedio = casoMedio;

	}

	public String[][] getPiorCaso() {
		return piorCaso;
	}

	public void setPiorCaso(String[][] piorCaso) {
		this.piorCaso = piorCaso;
	}

	public String[][] getMelhorCaso() {
		return melhorCaso;
	}

	public void setMelhorCaso(String[][] melhorCaso) {
		this.melhorCaso = melhorCaso;
	}


	public String[][] startMergeSortLength(String[][] bancoDeDados, int num) {
		String[][] banco = bancoDeDados.clone();
		long tempoInicial = System.currentTimeMillis();
		mergeSortLength(banco, 1, num);
		System.out.println("O metodo executou em " +((long) System.currentTimeMillis()-tempoInicial)+" ms\n");
		return banco;
	}
	public String[][] startMergeSortMonth(String[][] bancoDeDados, int num) {
		String[][] banco = bancoDeDados.clone();
		long tempoInicial = System.currentTimeMillis();
		mergeSortMonth(banco, 1, num);
		System.out.println("O metodo executou em " +( System.currentTimeMillis()-tempoInicial)+" ms\n");
		return banco;
	}
	public String[][] startMergeSortDate(String[][] bancoDeDados, int num) {
		String[][] banco = bancoDeDados.clone();
		long tempoInicial = System.currentTimeMillis();
		mergeSortDate(banco, 1, num);
		System.out.println("O metodo executou em " +( System.currentTimeMillis()-tempoInicial)+" ms\n");
		return banco;
	}


	public static void mergeSortLength(String vetor[][], int inicio, int fim) {
		if (inicio < fim) {
			int meio = (inicio + fim) / 2;
			mergeSortLength(vetor, inicio, meio);
			mergeSortLength(vetor, meio + 1, fim);
			mergeLength(vetor, inicio, meio, fim);
		}
	}

	private static void mergeLength(String vetor[][], int inicio, int meio, int fim) {
		int tamL = meio - inicio + 1;
		int tamR = fim - meio;
		String L[][] = new String[tamL][3];
		String R[][] = new String[tamR][3];
		int indexL = 0;
		int indexR = 0;


		for (int i = 0; i < tamL; i++) {
			L[i] = vetor[inicio + i];
		}

		for (int j = 0; j < tamR; j++) {
			R[j] = vetor[meio + 1 + j];
		}

		/*for (int k = inicio; k <= fim; k++) {
			if (indexL < tamL) {
				if (fim < tamR) {
					if (Integer.parseInt(L[indexL][1]) < Integer.parseInt(R[indexR][1])) {
						vetor[k] = L[indexL++];
					} else {
						vetor[k] = R[indexR++];
					}
				} else {
					vetor[k] = L[indexL++];
				}
			} else {
				vetor[k] = R[indexR++];
			}
		}*/

		int k = inicio;
		while(indexL < L.length && indexR< R.length) {
			if (Integer.parseInt(L[indexL][1]) <= Integer.parseInt(R[indexR][1])) {
				vetor[k++] = L[indexL++];
			} else {
				vetor[k++] = R[indexR++];
			}
		}

		for (int x = indexL;x < L.length; x++) {
			vetor[k++] = L[x];
		}
		for (int y = indexR; y < R.length; y++) {
			vetor[k++] = R[y];
		}
	}


	public static void mergeSortMonth(String vetor[][], int inicio, int fim) {
		if (inicio < fim) {
			int meio = (inicio + fim) / 2;
			mergeSortMonth(vetor, inicio, meio);
			mergeSortMonth(vetor, meio + 1, fim);
			mergeMonth(vetor, inicio, meio, fim);
		}
	}
	private static void mergeMonth(String vetor[][], int inicio, int meio, int fim) {
		int tamL = meio - inicio + 1;
		int tamR = fim - meio;
		String L[][] = new String[tamL][3];
		String R[][] = new String[tamR][3];
		int indexL = 0;
		int indexR = 0;


		for (int i = 0; i < tamL; i++) {
			L[i] = vetor[inicio + i];
		}

		for (int j = 0; j < tamR; j++) {
			R[j] = vetor[meio + 1 + j];
		}


		int k = inicio;
		while(indexL < L.length && indexR< R.length) {
			String[] data1 = vetor[indexL][2].split("/");
			String[] data2 = vetor[indexR][2].split("/");
			String fdata1="",fdata2="";
			for (int v=0;v<data1.length;v++){
				fdata1+=data1[v];
				fdata2+=data2[v];
			}

			System.out.println(fdata1+"&"+fdata2);

			if (!fdata2.equals("data") && !fdata1.equals("data")&& (Integer.parseInt(fdata1)<Integer.parseInt(fdata2))) {
				System.out.println(fdata1+"&"+fdata2+"|"+Integer.parseInt(fdata1)+"&"+Integer.parseInt(fdata2));
				vetor[k++] = L[indexL++];
			} else {
				vetor[k++] = R[indexR++];
			}

		}

		for (int x = indexL;x < L.length; x++) {
			vetor[k++] = L[x];
		}
		for (int y = indexR; y < R.length; y++) {
			vetor[k++] = R[y];
		}
	}
	public static void mergeSortDate(String vetor[][], int inicio, int fim) {
		if (inicio < fim) {
			int meio = (inicio + fim) / 2;
			mergeSortDate(vetor, inicio, meio);
			mergeSortDate(vetor, meio + 1, fim);
			mergeDate(vetor, inicio, meio, fim);
		}
	}
	private static void mergeDate(String vetor[][], int inicio, int meio, int fim) {
		int tamL = meio - inicio + 1;
		int tamR = fim - meio;
		String L[][] = new String[tamL][3];
		String R[][] = new String[tamR][3];
		int indexL = 1;
		int indexR = 1;


		for (int i = 0; i < tamL; i++) {
			L[i] = vetor[inicio + i];
		}

		for (int j = 0; j < tamR; j++) {
			R[j] = vetor[meio + 1 + j];
		}

		int k = inicio;
		while(indexL < L.length && indexR< R.length) {
			String[] data1 = vetor[indexL][2].split("/");
			String[] data2 = vetor[indexR][2].split("/");
			String fdata1="",fdata2="";
			for (int v=data1.length-1;v>=0 ;v--){
				fdata1+=data1[v];
				fdata2+=data2[v];
			}

				if (!fdata2.equals("data") && !fdata1.equals("data")&&(Integer.parseInt(fdata1)<Integer.parseInt(fdata2))) {
					vetor[k++] = L[indexL++];
				} else {
					vetor[k++] = R[indexR++];
				}

		}

		for (int x = indexL;x < L.length; x++) {
			vetor[k++] = L[x];
		}
		for (int y = indexR; y < R.length; y++) {
			vetor[k++] = R[y];
		}
	}

	public void gerarCasos(String [][] bancoOrdenado) {
		setMelhorCaso(bancoOrdenado);
		setPiorCaso(construirPiorCaso(melhorCaso));

	}

	public void transcricaoLenghtCaso() {

		System.out.println("#------------MergeSort-Lenght------------#");
		transcricao(casoMedio,"passwords_length_mergeSort_medioCaso.csv");
		gerarCasos(startMergeSortLength(casoMedio, casoMedio.length - 1));
		transcricao(piorCaso, "passwords_length_mergeSort_piorCaso.csv");
		startMergeSortLength(piorCaso, piorCaso.length - 1);
		transcricao(melhorCaso,"passwords_length_mergeSort_melhorCaso.csv");
		startMergeSortLength(melhorCaso, melhorCaso.length - 1);

	}

	public void transcricaoMonthCaso() {
		System.out.println("#------------MergeSort-Month------------#");
		transcricao(casoMedio,"passwords_data_month_mergeSort_medioCaso.csv");
		gerarCasos(startMergeSortMonth(casoMedio, casoMedio.length - 1));
		transcricao(piorCaso, "passwords_data_month_mergeSort_piorCaso.csv");
		startMergeSortMonth(piorCaso, piorCaso.length - 1);
		transcricao(melhorCaso,"passwords_data_month_mergeSort_melhorCaso.csv");
		startMergeSortMonth(melhorCaso, melhorCaso.length - 1);
	}
	public void transcricaoDataCaso() {
		System.out.println("#------------MergeSort-Date------------#");
		transcricao(casoMedio,"passwords_data_mergeSort_medioCaso.csv");
		gerarCasos(startMergeSortDate(casoMedio, casoMedio.length - 1));
		transcricao(piorCaso, "passwords_data_mergeSort_piorCaso.csv");
		startMergeSortDate(piorCaso, piorCaso.length - 1);
		transcricao(melhorCaso,"passwords_data_mergeSort_melhorCaso.csv");
		startMergeSortDate(melhorCaso, melhorCaso.length - 1);
	}

}
