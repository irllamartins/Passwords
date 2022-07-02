import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class InsertionSort extends Arquivo {
	private String[][] casoMedio;
	private String[][] piorCaso;
	private String[][] melhorCaso;

	public InsertionSort(String[][] bancoDeDados) {
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

	public String[][] insertionSortLength(String[][] bancoDeDados) {
		String[][] banco = bancoDeDados.clone();
		long tempoInicial = System.currentTimeMillis();
		for (int i = 2; i < banco.length; ++i) {
			int key = verificarNumero(banco[i][1]);
			int j = i - 1;

			while (j >= 0 && verificarNumero(banco[j][1]) > key) {
				troca(banco, j, j + 1);
				j = j - 1;
			}
			banco[j + 1][1] = Integer.toString(key);
		}
		System.out.println("O metodo executou em " +( System.currentTimeMillis()-tempoInicial)+" ms\n");
		return banco;
	}

	public String[][] insertionSortMonth(String[][] bancoDeDados) {
		int j;
		String[] aux;
		String[][] banco = bancoDeDados.clone();
		long tempoInicial = System.currentTimeMillis();
		for (int k = 1; k < banco.length; k++) {
			aux = banco[k];
			Date key = comparaDataMes(banco[k][2]);
			j = k - 1;
			// System.out.println(key);
			while (j > 0 && key.compareTo(comparaDataMes(banco[j][2])) < 0) {
				banco[j + 1] = banco[j];
				j = j - 1;
				// System.out.println("->"+banco[j][0]+" "+banco[j][1]+" "+banco[j][2]);
			}
			banco[j + 1] = aux;
		}
		System.out.println("O metodo executou em " +( System.currentTimeMillis()-tempoInicial)+" ms\n");
		return banco;
	}

	// não precisa fazer agora,não quero atrapalhar o seu projeto!!!!
	public String[][] insertionSortDate(String[][] bancoDeDados) {
		int j;
		String[] aux;
		String[][] banco = bancoDeDados.clone();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		long tempoInicial = System.currentTimeMillis();
		for (int k = 1; k < banco.length; k++) {
			aux = banco[k];
			try {
				Date key = formatter.parse(banco[k][2]);
				j = k - 1;
				// System.out.println(formatter.format(key)+"#");
				while (j > 0 && (key.compareTo(formatter.parse(banco[j][2])) < 0)) {
					// System.out.println(formatter.parse(banco[j][2])+"!");
					banco[j + 1] = banco[j];
					j = j - 1;
					// System.out.println("->"+banco[j][0]+" "+banco[j][1]+" "+banco[j][2]);
				}
				banco[j + 1] = aux;
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		System.out.println("O metodo executou em " +( System.currentTimeMillis()-tempoInicial)+" ms\n");
		return banco;
	}

	public void gerarCasos(String[][] bancoOrdenado) {
		setMelhorCaso(bancoOrdenado);
		setPiorCaso(construirPiorCaso(melhorCaso));

	}

	public void transcricaoLenghtCaso() {

		System.out.println("#------------InsertSort-Lenght------------#");
		transcricao(casoMedio, "passwords_length_insertionSort_medioCaso.csv");
		gerarCasos(insertionSortLength(casoMedio));
		transcricao(piorCaso, "passwords_length_insertionSort_piorCaso.csv");
		insertionSortLength(piorCaso);
		transcricao(melhorCaso, "passwords_length_insertionSort_melhorCaso.csv");
		insertionSortLength(melhorCaso);
	}

	public void transcricaoMonthCaso() {

		System.out.println("#------------InsertSort-Month------------#");
		transcricao(casoMedio, "passwords_data_month_insertionSort_medioCaso.csv");
		gerarCasos(insertionSortMonth(casoMedio));
		transcricao(piorCaso, "passwords_data_month_insertionSort_piorCaso.csv");
		insertionSortMonth(piorCaso);
		transcricao(melhorCaso, "passwords_data_month_insertionSort_melhorCaso.csv");
		insertionSortMonth(melhorCaso);
	}

	public void transcricaoDataCaso() {

		System.out.println("#------------InsertSort-Date------------#");
		transcricao(casoMedio, "passwords_data_insertionSort_medioCaso.csv");
		gerarCasos(insertionSortDate(casoMedio));
		transcricao(piorCaso, "passwords_data_insertionSort_piorCaso.csv");
		insertionSortDate(piorCaso);
		transcricao(melhorCaso, "passwords_data_insertionSort_melhorCaso.csv");
		insertionSortDate(melhorCaso);
	}

}
