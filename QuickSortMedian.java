import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class QuickSortMedian extends Arquivo {
	private String[][] casoMedio;
	private String[][] piorCaso;
	private String[][] melhorCaso;

	public QuickSortMedian(String[][] bancoDeDados) {
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

	public String[][] startQuickSortMedianLength(String[][] bancoDeDados, int num) {
		String[][] banco = bancoDeDados.clone();
		long tempoInicial = System.currentTimeMillis();
		quickSortMedianLength(banco, 1, num);
		System.out.println("O metodo executou em " +( System.currentTimeMillis()-tempoInicial)+" ms\n");
		return banco;
	}

	public String[][] startQuickSortMedianMonth(String[][] bancoDeDados, int num) {
		String[][] banco = bancoDeDados.clone();
		long tempoInicial = System.currentTimeMillis();
		// quickSortMedianMonth(banco, 1, num);
		System.out.println("O metodo executou em " +( System.currentTimeMillis()-tempoInicial)+" ms\n");
		return banco;
	}

	public String[][] startQuickSortMedianDate(String[][] bancoDeDados, int num) {
		String[][] banco = bancoDeDados.clone();
		long tempoInicial = System.currentTimeMillis();
		quickSortMedianDate(banco, 1, num);
		System.out.println("O metodo executou em " +( System.currentTimeMillis()-tempoInicial)+" ms\n");
		return banco;
	}

	public void quickSortMedianLength(String[][] vetor, int inicio, int fim) {
		if (inicio < fim) {
			int meio = particaoLength(vetor, inicio, fim);
			quickSortMedianLength(vetor, inicio, meio - 1);
			quickSortMedianLength(vetor, inicio + 1, fim);
		}
	}

	public int particaoLength(String[][] vetor, int inicio, int fim) {
		int meio = (int) (inicio + fim) / 2;
		int a = verificarNumero(vetor[inicio][1]);
		int b = verificarNumero(vetor[meio][1]);
		int c = verificarNumero(vetor[fim][1]);
		int medianaIndice = 0;

		if (a < b) {
			if (b < c) {
				// a < b && b < c
				medianaIndice = meio;
			} else {
				if (a < c) {
					// a < c && c <= b
					medianaIndice = fim;
				} else {
					// c <= a && a < b
					medianaIndice = inicio;
				}
			}
		} else {
			if (c < b) {
				// c < b && b <= a
				medianaIndice = meio;
			} else {
				if (c < a) {
					// b <= c && c < a
					medianaIndice = fim;
				} else {
					// b <= a && a <= c
					medianaIndice = inicio;
				}
			}
		}
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

	public void quickSortMedianMonth(String[][] vetor, int inicio, int fim) {
		if (inicio < fim) {
			int meio = particaoMonth(vetor, inicio, fim);
			quickSortMedianMonth(vetor, inicio, meio - 1);
			quickSortMedianMonth(vetor, inicio + 1, fim);
		}
	}

	public int particaoMonth(String[][] vetor, int inicio, int fim) {
		int meio = (int) (inicio + fim) / 2;
		int a = Integer.parseInt(vetor[inicio][1]);
		int b = Integer.parseInt(vetor[meio][1]);
		int c = Integer.parseInt(vetor[fim][1]);
		int medianaIndice = 0;

		if (a < b) {
			if (b < c) {
				// a < b && b < c
				medianaIndice = meio;
			} else {
				if (a < c) {
					// a < c && c <= b
					medianaIndice = fim;
				} else {
					// c <= a && a < b
					medianaIndice = inicio;
				}
			}
		} else {
			if (c < b) {
				// c < b && b <= a
				medianaIndice = meio;
			} else {
				if (c < a) {
					// b <= c && c < a
					medianaIndice = fim;
				} else {
					// b <= a && a <= c
					medianaIndice = inicio;
				}
			}
		}
		int pivo = Integer.parseInt(vetor[fim][1]);
		int i = inicio - 1;
		// System.out.println("!"+i);
		for (int j = inicio; j <= fim - 1; j++) {
			if (Integer.parseInt(vetor[j][1]) <= pivo) {
				i = i + 1;
				troca(vetor, i, j);
			}
		}
		troca(vetor, i + 1, fim);
		return i + 1;
	}

	public void quickSortMedianDate(String[][] vetor, int inicio, int fim) {
		if (inicio < fim) {
			int meio = particaoDate(vetor, inicio, fim);
			quickSortMedianDate(vetor, inicio, meio - 1);
			quickSortMedianDate(vetor, inicio + 1, fim);
		}
	}

	public int particaoDate(String[][] vetor, int inicio, int fim) {
		int meio = (int) (inicio + fim) / 2;
		int a = verificarNumero(vetor[inicio][1]);
		int b = verificarNumero(vetor[meio][1]);
		int c = verificarNumero(vetor[fim][1]);
		int medianaIndice = 0;

		if (a < b) {
			if (b < c) {
				// a < b && b < c
				medianaIndice = meio;
			} else {
				if (a < c) {
					// a < c && c <= b
					medianaIndice = fim;
				} else {
					// c <= a && a < b
					medianaIndice = inicio;
				}
			}
		} else {
			if (c < b) {
				// c < b && b <= a
				medianaIndice = meio;
			} else {
				if (c < a) {
					// b <= c && c < a
					medianaIndice = fim;
				} else {
					// b <= a && a <= c
					medianaIndice = inicio;
				}
			}
		}

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		try {
			
			Date pivo = formatter.parse(vetor[fim][2]);
			int i = inicio - 1;
			// System.out.println("!"+i);
			for (int j = inicio; j <= fim - 1; j++) {
				if (formatter.parse(vetor[j][2]).compareTo(pivo) < 0) {
					i = i + 1;
					troca(vetor, i, j);
				}
			}
			troca(vetor, i + 1, fim);
			return i + 1;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public void gerarCasos(String[][] bancoOrdenado) {
		setMelhorCaso(bancoOrdenado);
		setPiorCaso(construirPiorCaso(melhorCaso));

	}

	public void transcricaoLenghtCaso() {
		System.out.println("#------------QuickSortMedian-Lenght------------#");
		transcricao(casoMedio, "passwords_length_quickSortMedian_medioCaso.csv");
		startQuickSortMedianLength(casoMedio, casoMedio.length - 1);
		transcricao(piorCaso, "passwords_length_quickSortMedian_piorCaso.csv");
		startQuickSortMedianLength(piorCaso, piorCaso.length - 1);
		transcricao(melhorCaso, "passwords_length_quickSortMedian_melhorCaso.csv");
		startQuickSortMedianLength(melhorCaso, melhorCaso.length - 1);
	}

	public void transcricaoMonthCaso() {
		System.out.println("#------------QuickSortMedian-Month------------#");
		transcricao(casoMedio, "passwords_data_month_quickSortMedian_medioCaso.csv");
		gerarCasos(startQuickSortMedianMonth(casoMedio, casoMedio.length - 1));
		transcricao(piorCaso, "passwords_data_month_quickSortMedian_piorCaso.csv");
		startQuickSortMedianMonth(piorCaso, piorCaso.length - 1);
		transcricao(melhorCaso, "passwords_data_month_quickSortMedian_melhorCaso.csv");
		startQuickSortMedianMonth(melhorCaso, melhorCaso.length - 1);
	}

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
