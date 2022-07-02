import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class MergeSort extends Arquivo {
	private String[][] casoMedio;
	private String[][] piorCaso;
	private String[][] melhorCaso;

	public MergeSort(String[][] bancoDeDados) {
		this.casoMedio = bancoDeDados;
		this.melhorCaso = startMegerSortLength(casoMedio, casoMedio.length - 1);
		this.piorCaso = construirPiorCaso(melhorCaso);
	}

	public String[][] startMegerSortLength(String[][] bancoDeDados, int num) {
		String[][] banco = bancoDeDados.clone();
		long tempoInicial = System.currentTimeMillis();
		mergeSort(banco, 1, num);
		System.out.println("O metodo executou em " +( System.currentTimeMillis()-tempoInicial)+" ms\n");
		return banco;
	}

	public static void mergeSort(String vetor[][], int inicio, int fim) {
		if (inicio < fim) {
			int meio = (inicio + fim) / 2;
			mergeSort(vetor, inicio, meio);
			mergeSort(vetor, meio + 1, fim);
			merge(vetor, inicio, meio, fim);
		}
	}

	private static void merge(String vetor[][], int inicio, int meio, int fim) {
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

		for (int k = inicio; k <= fim; k++) {
			if (indexL < tamL) {
				if (fim < tamR) {
					if (verificarNumero(L[indexL][1]) < verificarNumero(R[indexR][1])) {
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
		}
	}

	public void transcricaoLenghtCaso() {
		// transcricao(casoMedio,"passwords_length_mergeSort_medioCaso.csv");
		//System.out.println("ok");
		// transcricao(piorCaso,"passwords_length_mergeSort_piorCaso.csv");
		System.out.println("#------------MergeSort-Lenght------------#");
		transcricao(melhorCaso, "passwords_length_mergeSort_melhorCaso.csv");
	}

	/*
	 * public void transcricaoMonthCaso() {
	 * transcricao(casoMedio,"passwords_data_month_mergeSort_medioCaso.csv");
	 * transcricao(piorCaso,"passwords_data_month_mergeSort_piorCaso.csv");
	 * transcricao(melhorCaso,"passwords_data_month_mergeSort_melhorCaso.csv");
	 * }
	 * public void transcricaoDataCaso() {
	 * transcricao(casoMedio,"passwords_data_mergeSort_medioCaso.csv");
	 * transcricao(piorCaso,"passwords_data_mergeSort_piorCaso.csv");
	 * transcricao(melhorCaso,"passwords_data_mergeSort_melhorCaso.csv");
	 * }
	 */
}
