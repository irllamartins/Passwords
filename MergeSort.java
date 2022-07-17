import java.text.SimpleDateFormat;
import java.text.ParseException;

public class MergeSort extends Arquivo{
	private Password[] casoMedio;
	private Password[] piorCaso;
	private Password[] melhorCaso;
	
	public MergeSort( Password[] bancoDeDados) {
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


	public Password[] startMergeSortLength(Password[] bancoDeDados, int num) {
		Password[] banco = bancoDeDados.clone();
		
		long tempoInicial = System.currentTimeMillis();
		mergeSortLength(banco, 1, num);
		System.out.println("O metodo executou em " +( System.currentTimeMillis()-tempoInicial)+" ms\n");
		
		return banco;
	}
	
	public Password[] startMergeSortMonth(Password[] bancoDeDados, int num) {
		Password[] banco = bancoDeDados.clone();
		
		long tempoInicial = System.currentTimeMillis();
		mergeSortMonth(banco, 1, num);
		System.out.println("O metodo executou em " +( System.currentTimeMillis()-tempoInicial)+" ms\n");
		
		return banco;
	}
	
	public Password[] startMergeSortDate(Password[] bancoDeDados, int num) {
		Password[] banco = bancoDeDados.clone();
		
		long tempoInicial = System.currentTimeMillis();
		mergeSortDate(banco, 1, num);
		System.out.println("O metodo executou em " +( System.currentTimeMillis()-tempoInicial)+" ms\n");
		
		return banco;
	}
	
	
	public void mergeSortLength(Password[] vetor, int inicio, int fim) {
		if (inicio < fim) {
			int meio = (inicio + fim) / 2;
			mergeSortLength(vetor, inicio, meio);
			mergeSortLength(vetor, meio + 1, fim);
			mergeLength(vetor, inicio, meio, fim);
		}
	}
	
	//ordenacao mergeSort pelo tamanho
	private void mergeLength(Password[] vetor, int inicio, int meio, int fim) {
		int tamL = meio - inicio + 1;
		int tamR = fim - meio;
		Password[] L = new Password[tamL];
		Password[] R = new Password[tamR];
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
			if (L[indexL].getLength() <= R[indexR].getLength()) {
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
	
	//ordenacao mergeSort pelo mes/ano
	public void mergeSortMonth(Password[] vetor, int inicio, int fim) {
		if (inicio < fim) {
			int meio = (inicio + fim) / 2;
			mergeSortMonth(vetor, inicio, meio);
			mergeSortMonth(vetor, meio + 1, fim);
			mergeMonth(vetor, inicio, meio, fim);
		}
	}
	private void mergeMonth(Password[] vetor, int inicio, int meio, int fim) {
		int tamL = meio - inicio + 1;
		int tamR = fim - meio;
		Password[] L = new Password[tamL];
		Password[] R = new Password[tamR];
		int indexL = 0;
		int indexR = 0;

		
		for (int i = 0; i < tamL; i++) {
			L[i] = vetor[inicio + i];
		}
		
		for (int j = 0; j < tamR; j++) {
			R[j] = vetor[meio + 1 + j];
		}
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat formato = new SimpleDateFormat("MM/yyyy");
		int k = inicio;
		while(indexL < L.length && indexR< R.length) {
			try{
			if ((formato.parse(formato.format(L[indexL].getData()))).compareTo(formato.parse(formato.format(L[indexR].getData())))<0) {
				//System.out.println(formato.parse(formato.format(formatter.parse(L[indexL][2])))+"!"+formato.parse(formato.format(formatter.parse(L[indexR][2]))));
				vetor[k++] = L[indexL++];
			} else {
				vetor[k++] = R[indexR++];
			}
			} catch (ParseException e) {
				e.printStackTrace();
			}  
		}
		
		for (int x = indexL;x < L.length; x++) {
			vetor[k++] = L[x];
		}
		for (int y = indexR; y < R.length; y++) {
			vetor[k++] = R[y];
		}
	}
	public void mergeSortDate(Password vetor[], int inicio, int fim) {
		if (inicio < fim) {
			int meio = (inicio + fim) / 2;
			mergeSortDate(vetor, inicio, meio);
			mergeSortDate(vetor, meio + 1, fim);
			mergeDate(vetor, inicio, meio, fim);
		}
	}
	
	//ordenacao mergeSort pela data
	private void mergeDate(Password vetor[], int inicio, int meio, int fim) {
		int tamL = meio - inicio + 1;
		int tamR = fim - meio;
		Password[] L = new Password[tamL];
		Password[] R = new Password[tamR];
		int indexL = 0;
		int indexR = 0;

		
		for (int i = 0; i < tamL; i++) {
			L[i] = vetor[inicio + i];
		}
		
		for (int j = 0; j < tamR; j++) {
			R[j] = vetor[meio + 1 + j];
		}
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		
		int k = inicio;
		while(indexL < L.length && indexR< R.length) {
			if (L[indexL].getData().compareTo(L[indexR].getData())>0) {
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
	
	//gera os casos crescente e decrescente
	public void gerarCasos(Password [] bancoOrdenado) {
		setMelhorCaso(bancoOrdenado);
		setPiorCaso(construirCasoDecrescente(melhorCaso.clone()));
		
	}
	
	//resposavel por chamar a ordenacao por tamanho com os tipos de casos e criar arquivo
	public void transcricaoLenghtCaso() {

		System.out.println("#------------MergeSort-Lenght------------#");
		transcricao(casoMedio,"passwords_length_mergeSort_medioCaso.csv");
		gerarCasos(startMergeSortLength(casoMedio, casoMedio.length - 1));
		transcricao(piorCaso, "passwords_length_mergeSort_piorCaso.csv");
		startMergeSortLength(piorCaso, piorCaso.length - 1);
		transcricao(melhorCaso,"passwords_length_mergeSort_melhorCaso.csv");
		startMergeSortLength(melhorCaso, melhorCaso.length - 1);

	}
	
	//resposavel por chamar a ordenacao por mes/ano com os tipos de casos e criar arquivo
	public void transcricaoMonthCaso() {
		System.out.println("#------------MergeSort-Month------------#");
		transcricao(casoMedio,"passwords_month_mergeSort_medioCaso.csv");
		gerarCasos(startMergeSortMonth(casoMedio, casoMedio.length - 1));
		transcricao(piorCaso, "passwords_month_mergeSort_piorCaso.csv");
		startMergeSortMonth(piorCaso, piorCaso.length - 1);
		transcricao(melhorCaso,"passwords_month_mergeSort_melhorCaso.csv");
		startMergeSortMonth(melhorCaso, melhorCaso.length - 1);
	}
	
	//resposavel por chamar a ordenacao por data com os tipos de casos e criar arquivo
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




