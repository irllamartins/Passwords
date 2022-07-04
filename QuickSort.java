import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class QuickSort extends Arquivo {
	private Password[] casoMedio;
	private Password[] piorCaso;
	private Password[] melhorCaso;

	public QuickSort(Password[] bancoDeDados) {
		this.casoMedio = bancoDeDados;

	}

	public Password[] getCasoMedio() {
		return casoMedio;
	}

	public void setCasoMedio(Password[] casoMedio) {
		this.casoMedio = casoMedio;
	}

	public Password[] getPiorCaso() {
		return piorCaso;
	}

	public void setPiorCaso(Password[] piorCaso) {
		this.piorCaso = piorCaso;
	}

	public Password[] getMelhorCaso() {
		return melhorCaso;
	}

	public void setMelhorCaso(Password[] melhorCaso) {
		this.melhorCaso = melhorCaso;
	}



	public Password[] startQuickSortLength(Password[] bancoDeDados, int num) {
		Password[] banco = bancoDeDados.clone();
		long tempoInicial = System.currentTimeMillis();
		quickSortLenght(banco, 1, num);
		System.out.println("O metodo executou em " + (System.currentTimeMillis() - tempoInicial) + " ms\n");
		return banco;
	}

	public Password[] startQuickSortMonth(Password[] bancoDeDados, int num) {
		Password[] banco = bancoDeDados.clone();
		long tempoInicial = System.currentTimeMillis();
		quickSortMonth(banco, 1, num);
		System.out.println("O metodo executou em " + (System.currentTimeMillis() - tempoInicial) + " ms\n");
		return banco;
	}

	public Password[] startQuickSortDate(Password[] bancoDeDados, int num) {
		Password[] banco = bancoDeDados.clone();
		long tempoInicial = System.currentTimeMillis();
		quickSortDate(banco, 1, num);
		System.out.println("O metodo executou em " + (System.currentTimeMillis() - tempoInicial) + " ms\n");
		return banco;
	}
	
	//ordenação do quickSort pelo tamahno
	public void quickSortLenght(Password[] vetor, int inicio, int fim) {
		if (inicio < fim) {
			int meio = particaoLenght(vetor, inicio, fim);
			quickSortLenght(vetor, inicio, meio - 1);
			quickSortLenght(vetor, inicio + 1, fim);
		}
	}

	public int particaoLenght(Password[] vetor, int inicio, int fim) {
		int pivo = vetor[fim].getLength();
		int i = inicio - 1;
		// System.out.println("!"+i);
		for (int j = inicio; j <= fim - 1; j++) {
			if (vetor[j].getLength() <= pivo) {
				i = i + 1;
				troca(vetor, i, j);
			}
		}
		troca(vetor, i + 1, fim);
		return i + 1;
	}
	
	//ordenação do quickSort pelo mes/ano 
	public void quickSortMonth(Password[] vetor, int inicio, int fim) {

		if (inicio < fim) {
			int meio = particaoMonth(vetor, inicio, fim);
			quickSortMonth(vetor, inicio, meio - 1);
			quickSortMonth(vetor, inicio + 1, fim);
		}
	}

	public int particaoMonth(Password[] vetor, int inicio, int fim) {

		SimpleDateFormat formato = new SimpleDateFormat("MM/yyyy");

		int i = inicio - 1;
		Date pivo;

		try {
			pivo = formato.parse(formato.format(vetor[fim].getData()));

			for (int j = inicio; j <= fim - 1; j++) {

				if (formato.parse(formato.format(vetor[j].getData())).compareTo(pivo) <= 0) {
					i = i + 1;
					troca(vetor, i, j);
				}
			}

			troca(vetor, i + 1, fim);

		} catch (ParseException e) {
			e.printStackTrace();
		}

		return i + 1;
	}
	//ordenação do quickSort pela data
	public void quickSortDate(Password[] vetor, int inicio, int fim) {

		if (inicio < fim) {
			int meio = particaoDate(vetor, inicio, fim);
			quickSortDate(vetor, inicio, meio - 1);
			quickSortDate(vetor, inicio + 1, fim);
		}
	}

	public int particaoDate(Password[] vetor, int inicio, int fim) {

		int i = inicio - 1;

			Date pivo = vetor[fim].getData();

			// System.out.println("-------------------------------");
			for (int j = inicio; j <= fim - 1; j++) {

				if (vetor[j].getData().compareTo(pivo) <= 0) {
					i = i + 1;
					troca(vetor, i, j);
				}
			}
			troca(vetor, i + 1, fim);

		return i + 1;
	}
	
	//gera os casos crescente e decrescentemente
	public void gerarCasos(Password[] bancoOrdenado) {
		setMelhorCaso(bancoOrdenado);
		setPiorCaso(construirCasoDecrescente(melhorCaso.clone()));

	}
	//chama a ordenação que vai ser classificada pelo tamanho,gera os casos crescente e decrescentemente e finaliza criando o arquivo 
	public void transcricaoLenghtCaso() {
		System.out.println("#------------QuickSort-Lenght------------#");
		transcricao(casoMedio, "passwords_length_quickSort_medioCaso.csv");
		gerarCasos(startQuickSortLength(casoMedio, casoMedio.length - 1));
		transcricao(piorCaso, "passwords_length_quickSort_piorCaso.csv");
		startQuickSortLength(piorCaso, piorCaso.length - 1);
		transcricao(melhorCaso, "passwords_length_quickSort_melhorCaso.csv");
		startQuickSortLength(melhorCaso, melhorCaso.length - 1);
	}

	//chama a ordenação que vai ser classificada pelo mes/ano,gera os casos crescente e decrescentemente e finaliza criando o arquivo 
	public void transcricaoMonthCaso() {
		System.out.println("#------------QuickSort-Month------------#");
		transcricao(casoMedio, "passwords_data_month_quickSort_medioCaso.csv");
		gerarCasos(startQuickSortMonth(casoMedio, casoMedio.length - 1));
		transcricao(piorCaso, "passwords_data_month_quickSort_piorCaso.csv");
		startQuickSortMonth(piorCaso, piorCaso.length - 1);
		transcricao(melhorCaso, "passwords_data_month_quickSort_melhorCaso.csv");
		startQuickSortMonth(melhorCaso, melhorCaso.length - 1);
	}

	//chama a ordenação que vai ser classificada pela data,gera os casos crescente e decrescentemente e finaliza criando o arquivo 
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
