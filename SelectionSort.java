import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;


public class SelectionSort extends Arquivo {
	
	private String[][] casoMedio;
	private String[][] piorCaso;
	private String[][] melhorCaso;

	public SelectionSort(String[][] bancoDeDados) {
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

	//Ordenação de SelectSort por tamanho de caractere  
	public String[][] SelectionSortLength(String[][] bancoDeDados) {
		String [][] banco = bancoDeDados;
		
		long tempoInicial = System.currentTimeMillis();
		
		for (int i = 1; i < banco.length; i++) {
			
			String menor=banco[i][1];
            int posicao=i;
			for (int j = i+1; j < banco.length ; j++) {
				if (Integer.parseInt(menor)>Integer.parseInt(banco[j][1])) {
					posicao=j;
                     menor=banco[j][1];
				}
			}
			
			troca(banco, i, posicao);
		}
		
		System.out.println("O metodo executou em " +( System.currentTimeMillis()-tempoInicial)+" ms\n");
		return banco;
	}
	
	//Ordenação de SelectSort por data mês-ano
	private String[][] SelectionSortMonth(String[][] bancoDeDados) {
		String [][] banco = bancoDeDados;
	    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat formato = new SimpleDateFormat("MM/yyyy");
		long tempoInicial = System.currentTimeMillis();
		for (int i = 1; i < banco.length; i++) {
			String menor=banco[i][2];
            int posicao=i;
			for (int j = i+1; j < banco.length ; j++) {
				try {
					if (formato.parse(formato.format(formatter.parse(menor))).compareTo(formato.parse(formato.format(formatter.parse(banco[j][2]))))>0) {
						posicao = j;
						menor=banco[j][2];
					}
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
			
			troca(banco, i, posicao);
		}
		System.out.println("O metodo executou em " +( System.currentTimeMillis()-tempoInicial)+" ms\n");
		return banco;
	}
	
	//Ordenação de SelectSort por data
	private String[][] SelectionSortDate(String[][] bancoDeDados) {
		String [][] banco = bancoDeDados;
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		long tempoInicial = System.currentTimeMillis();
		for (int i = 1; i < banco.length; i++) {
			String menor=banco[i][2];
            int posicao=i;
			for (int j = i+1; j < banco.length ; j++) {
				try {
					if ((formatter.parse(menor)).compareTo(formatter.parse(banco[j][2]))>0) {
						posicao = j;
						menor=banco[j][2];
					}
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
			
			troca(banco, i, posicao);
		}
		System.out.println("O metodo executou em " +( System.currentTimeMillis()-tempoInicial)+" ms\n");
		return banco;
	}
	
	//gera o caso ordenado crescentemente e descrecentemente
	private void gerarCasos(String [][] bancoOrdenado) {
		setMelhorCaso(bancoOrdenado);
		setPiorCaso(construirPiorCaso(melhorCaso));
		
	}
	
	//resposavel por chamar a ordenação por tamanho de caracteres com os tipos de casos 
	public void transcricaoLenghtCaso() {

		System.out.println("#------------Selection-Lenght------------#");
		transcricao(casoMedio,"passwords_length_selectionSort_medioCaso.csv");
		gerarCasos(SelectionSortLength(casoMedio));
		transcricao(piorCaso, "passwords_length_selectionSort_piorCaso.csv");
		SelectionSortLength(piorCaso);
		transcricao(melhorCaso,"passwords_length_selectionSort_melhorCaso.csv");
		SelectionSortLength(melhorCaso);

	}
	
	//resposavel por chamar a ordenação por data mes-ano com os tipos de casos 
	public void transcricaoMonthCaso() {
		System.out.println("#------------Selection-Month------------#");
		transcricao(casoMedio,"passwords_data_month_selectionSort_medioCaso.csv");
		gerarCasos(SelectionSortMonth(casoMedio));
		transcricao(piorCaso, "passwords_data_month_selectionSort_piorCaso.csv");
		SelectionSortMonth(piorCaso);
		transcricao(melhorCaso,"passwords_data_month_selectionSort_melhorCaso.csv");
		SelectionSortMonth(melhorCaso);
	}
	//resposavel por chamar a ordenação por data com os tipos de casos 
	public void transcricaoDataCaso() {
		System.out.println("#------------Selection-Date------------#");
		transcricao(casoMedio,"passwords_data_selectionSort_medioCaso.csv");
		gerarCasos(SelectionSortDate(casoMedio));
		transcricao(piorCaso, "passwords_data_selectionSort_piorCaso.csv");
		SelectionSortDate(piorCaso);
		transcricao(melhorCaso,"passwords_data_selectionSort_melhorCaso.csv");
		SelectionSortDate(melhorCaso);
	}
	
}
