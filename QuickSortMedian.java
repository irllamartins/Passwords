import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class QuickSortMedian extends Arquivo {
	private Password[] casoMedio;
	private Password[] piorCaso;
	private Password[] melhorCaso;
	
	public QuickSortMedian(Password[] bancoDeDados) {
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


	public Password[] startQuickSortMedianLength(Password[] bancoDeDados, int num) {
		Password[] banco = bancoDeDados.clone();
		
		long tempoInicial = System.currentTimeMillis();
		quickSortMedianLength(banco, 1, num);
		System.out.println("O metodo executou em " +( System.currentTimeMillis()-tempoInicial)+" ms\n");
		
		return banco;
	
	}
	
	public Password[] startQuickSortMedianMonth(Password[] bancoDeDados, int num) {
		Password[] banco = bancoDeDados.clone();
		
		long tempoInicial = System.currentTimeMillis();
		quickSortMedianMonth(banco, 1, num);
		System.out.println("O metodo executou em " +( System.currentTimeMillis()-tempoInicial)+" ms\n");

		return banco;
	}
	
	public Password[] startQuickSortMedianDate(Password[] bancoDeDados, int num) {
		Password[] banco = bancoDeDados.clone();
		
		long tempoInicial = System.currentTimeMillis();
		quickSortMedianDate(banco, 1, num);
		System.out.println("O metodo executou em " +( System.currentTimeMillis()-tempoInicial)+" ms\n");
		
		return banco;
	}	
	
	public void quickSortMedianLength(Password[] vetor, int inicio, int fim) {
		if (inicio < fim) {
			int meio = particaoLength(vetor, inicio, fim);
			quickSortMedianLength(vetor, inicio, meio - 1);
			quickSortMedianLength(vetor, inicio + 1, fim);
		}
	}

	//ordenacao do quickSort mediana de 3 pelo tamanho
	public int particaoLength(Password[] vetor, int inicio, int fim) {
		int meio = (int) (inicio + fim) / 2;
		int a = vetor[inicio].getLength();
		int b = vetor[meio].getLength();
		int c = vetor[fim].getLength();
		int medianaIndice = 0;

		if (a < b) {
			if (b < c) {
				medianaIndice = meio;
			} else {
				if (a < c) {
					medianaIndice = fim;
				} else {
					medianaIndice = inicio;
				}
			}
		} else {
			if (c < b) {
				medianaIndice = meio;
			} else {
				if (c < a) {
					medianaIndice = fim;
				} else {
					medianaIndice = inicio;
				}
			}
		}
		troca(vetor,medianaIndice, fim);
		
		int i = inicio - 1;

		int pivo = vetor[fim].getLength();

		for (int j = inicio; j <= fim - 1; j++) {

			if (vetor[j].getLength() <=pivo) {
				i = i + 1;
				troca(vetor, i, j);
			}
		}

		troca(vetor, i + 1, fim);

		return i + 1;
	}
	
	//ordenacao do quickSort mediana de 3 pelo mes/ano
	public void quickSortMedianMonth(Password[] vetor, int inicio, int fim) {
	if (inicio < fim) {
			int meio = particaoMonth(vetor, inicio, fim);
			quickSortMedianMonth(vetor, inicio, meio - 1);
			quickSortMedianMonth(vetor, inicio + 1, fim);
		}
	}

	public int particaoMonth(Password[] vetor, int inicio, int fim) {
		int meio = (int) (inicio + fim) / 2;
		int a = vetor[inicio].getLength();
		int b = vetor[meio].getLength();
		int c = vetor[fim].getLength();
		int medianaIndice = 0;

		if (a < b) {
			if (b < c) {
				medianaIndice = meio;
			} else {
				if (a < c) {
					medianaIndice = fim;
				} else {
					medianaIndice = inicio;
				}
			}
		} else {
			if (c < b) {
				medianaIndice = meio;
			} else {
				if (c < a) {
					medianaIndice = fim;
				} else {
					medianaIndice = inicio;
				}
			}
		}
		troca(vetor,medianaIndice, fim);
		
		int i = inicio - 1;
		Date pivo;
		SimpleDateFormat formato = new SimpleDateFormat("MM/yyyy");
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
	
	//ordenacao do quickSort mediana de 3 pela data
	public void quickSortMedianDate(Password[] vetor, int inicio, int fim) {
		if (inicio < fim) {
			int meio = particaoDate(vetor, inicio, fim);
			quickSortMedianDate(vetor, inicio, meio - 1);
			quickSortMedianDate(vetor, inicio + 1, fim);
		}
	}

	public int particaoDate(Password[] vetor, int inicio, int fim) {
		int meio = (int) (inicio + fim) / 2;
		int a = vetor[inicio].getLength();
		int b = vetor[meio].getLength();
		int c = vetor[fim].getLength();
		int medianaIndice = 0;

		if (a < b) {
			if (b < c) {
				medianaIndice = meio;
			} else {
				if (a < c) {
					medianaIndice = fim;
				} else {
					medianaIndice = inicio;
				}
			}
		} else {
			if (c < b) {
				medianaIndice = meio;
			} else {
				if (c < a) {
					medianaIndice = fim;
				} else {
					medianaIndice = inicio;
				}
			}
		}
		troca(vetor,medianaIndice, fim);
		
		Date pivo = vetor[fim].getData();
		int i = inicio - 1;
		
		for (int j = inicio; j <= fim - 1; j++) {
			if (vetor[j].getData().compareTo(pivo)<=0) {
				i = i + 1;
				troca(vetor, i, j);
			}
		}
		troca(vetor, i + 1, fim);
		return i + 1;
	}
	
	//gera os casos crescente e decrescente
	public void gerarCasos(Password[] bancoOrdenado) {
		setMelhorCaso(bancoOrdenado);
		setPiorCaso(construirCasoDecrescente(melhorCaso.clone()));
		
	}
	
	//chama a ordenacao que vai ser classificada pelo tamanho,gera os casos crescente e decrescentemente e finaliza criando o arquivo
	public void transcricaoLenghtCaso() {
	System.out.println("#------------QuickSortMedian-Lenght------------#");
		transcricao(casoMedio, "passwords_length_quickSortMedian_medioCaso.csv");
		
		startQuickSortMedianLength(casoMedio, casoMedio.length - 1);System.out.println("oi");
		transcricao(piorCaso, "passwords_length_quickSortMedian_piorCaso.csv");
		startQuickSortMedianLength(piorCaso, piorCaso.length - 1);
		transcricao(melhorCaso, "passwords_length_quickSortMedian_melhorCaso.csv");
		startQuickSortMedianLength(melhorCaso, melhorCaso.length - 1);
	}
	
	//chama a ordenacao que vai ser classificada pelo mes/ano,gera os casos crescente e decrescentemente e finaliza criando o arquivo
	public void transcricaoMonthCaso() {
		System.out.println("#------------QuickSortMedian-Month------------#");
		transcricao(casoMedio, "passwords_data_month_quickSortMedian_medioCaso.csv");
		gerarCasos(startQuickSortMedianMonth(casoMedio, casoMedio.length - 1));
		transcricao(piorCaso, "passwords_data_month_quickSortMedian_piorCaso.csv");
		startQuickSortMedianMonth(piorCaso, piorCaso.length - 1);
		transcricao(melhorCaso, "passwords_data_month_quickSortMedian_melhorCaso.csv");
		startQuickSortMedianMonth(melhorCaso, melhorCaso.length - 1);
	}
	
	//chama a ordenacao que vai ser classificada pela data,gera os casos crescente e decrescentemente e finaliza criando o arquivo
	public void transcricaoDataCaso() {
		System.out.println("#------------QuickSortMedian-Date------------#");
		transcricao(casoMedio, "passwords_data_quickSortMedian_medioCaso.csv");
		gerarCasos(startQuickSortMedianDate(casoMedio, casoMedio.length - 1));
		transcricao(piorCaso, "passwords_data_quickSortMedian_piorCaso.csv");
		startQuickSortMedianDate(piorCaso, piorCaso.length - 1);
		transcricao(melhorCaso, "passwords_data_quickSortMedian_melhorCaso.csv");
		startQuickSortMedianDate(melhorCaso, melhorCaso.length - 1);
	}

}
