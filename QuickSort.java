import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class QuickSort extends Arquivo {
	private String[][] casoMedio;
	private String[][] piorCaso;
	private String[][] melhorCaso;

	public QuickSort(String[][] bancoDeDados) {
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

	public String[][] startQuickSortLength(String[][] bancoDeDados, int num) {
		String[][] banco = bancoDeDados.clone();
		long tempoInicial = System.currentTimeMillis();
		quickSortLenght(banco, 1, num);
		System.out.println("O metodo executou em " +( System.currentTimeMillis()-tempoInicial)+" ms\n");
		return banco;
	}

	public String[][] startQuickSortMonth(String[][] bancoDeDados, int num) {
		String[][] banco = bancoDeDados.clone();
		long tempoInicial = System.currentTimeMillis();
		quickSortMonth(banco, 1, num);
		System.out.println("O metodo executou em " +( System.currentTimeMillis()-tempoInicial)+" ms\n");
		return banco;
	}

	public String[][] startQuickSortDate(String[][] bancoDeDados, int num) {
		String[][] banco = bancoDeDados.clone();
		long tempoInicial = System.currentTimeMillis();
		quickSortDate(banco, 1, num);
		System.out.println("O metodo executou em " +( System.currentTimeMillis()-tempoInicial)+" ms\n");

		return banco;
	}

	public void quickSortLenght(String[][] vetor, int inicio, int fim) {
		if (inicio < fim) {
			int meio = particaoLenght(vetor, inicio, fim);
			quickSortLenght(vetor, inicio, meio - 1);
			quickSortLenght(vetor, inicio + 1, fim);
		}
	}

	public int particaoLenght(String[][] vetor, int inicio, int fim) {
		int pivo = verificarNumero(vetor[fim][1]);
		int i = inicio - 1;
		// System.out.println("!"+i);
		for (int j = inicio; j <= fim - 1; j++) {
			if (verificarNumero(vetor[j][1]) < pivo) {
				i = i + 1;
				troca(vetor, i, j);
			}
		}
		troca(vetor, i + 1, fim);
		return i + 1;
	}

	public void quickSortMonth(String[][] vetor, int inicio, int fim) {
		if (inicio < fim) {
			int meio = particaoMonth(vetor, inicio, fim);
			quickSortMonth(vetor, inicio, meio - 1);
			quickSortMonth(vetor, inicio + 1, fim);
		}
	}

	public int particaoMonth(String[][] vetor, int inicio, int fim) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

		Date pivo = comparaDataMes((vetor[fim][2]));
		int i = inicio - 1;

		for (int j = inicio; j <= fim - 1; j++) {

			if (comparaDataMes((vetor[j][2])).compareTo(pivo) < 0) {
				i = i + 1;
				troca(vetor, i, j);
			}
		}

		troca(vetor, i + 1, fim);
		return i + 1;
	}

	public void quickSortDate(String[][] vetor, int inicio, int fim) {
		if (inicio < fim) {
			int meio = particaoDate(vetor, inicio, fim);
			quickSortDate(vetor, inicio, meio - 1);
			quickSortDate(vetor, inicio + 1, fim);
		}
	}

	public int particaoDate(String[][] vetor, int inicio, int fim) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		try {
			Date pivo = formatter.parse(vetor[fim][2]);
			int i = inicio - 1;
			// System.out.println("-------------------------------");
			for (int j = inicio; j <= fim - 1; j++) {

				if (formatter.parse(vetor[j][2]).compareTo(pivo) < 0) {
					// System.out.println("->"+formatter.parse(vetor[j][2])+"!"+pivo);
					i = i + 1;
					troca(vetor, i, j);
				}
			}
			troca(vetor, i + 1, fim);
			return i + 1;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		// System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		return 0;
	}

	public void gerarCasos(String[][] bancoOrdenado) {
		setMelhorCaso(bancoOrdenado);
		setPiorCaso(construirPiorCaso(melhorCaso));

	}

	public void transcricaoLenghtCaso() {

		System.out.println("#------------QuickSort-Lenght------------#");
		transcricao(casoMedio, "passwords_length_quickSort_medioCaso.csv");
		gerarCasos(startQuickSortLength(casoMedio, casoMedio.length - 1));
		transcricao(piorCaso, "passwords_length_quickSort_piorCaso.csv");
		startQuickSortLength(piorCaso, piorCaso.length - 1);
		transcricao(melhorCaso, "passwords_length_quickSort_melhorCaso.csv");
		startQuickSortLength(melhorCaso, melhorCaso.length - 1);

	}

	public void transcricaoMonthCaso() {
		System.out.println("#------------QuickSort-Month------------#");
		transcricao(casoMedio, "passwords_data_month_quickSort_medioCaso.csv");
		gerarCasos(startQuickSortMonth(casoMedio, casoMedio.length - 1));
		transcricao(piorCaso, "passwords_data_month_quickSort_piorCaso.csv");
		startQuickSortMonth(piorCaso, piorCaso.length - 1);
		transcricao(melhorCaso, "passwords_data_month_quickSort_melhorCaso.csv");
		startQuickSortMonth(melhorCaso, melhorCaso.length - 1);
	}

	public void transcricaoDataCaso() {
		System.out.println("#------------QuickSort-Date------------#");

		transcricao(casoMedio, "passwords_data_quickSort_medioCaso.csv");
		gerarCasos(startQuickSortDate(casoMedio, casoMedio.length - 1));
		transcricao(piorCaso, "passwords_data_quickSort_piorCaso.csv");
		startQuickSortDate(piorCaso, piorCaso.length - 1);
		transcricao(melhorCaso, "passwords_data_quickSort_melhorCaso.csv");
		startQuickSortDate(melhorCaso, melhorCaso.length - 1);
	}
}
