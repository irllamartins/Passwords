import java.text.ParseException;
import java.text.SimpleDateFormat;

public class SelectionSort extends Arquivo {
	
	private Password[] casoMedio;
	private Password[] piorCaso;
	private Password[] melhorCaso;

	public SelectionSort(Password[] bancoDeDados) {
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
	

	//Ordenacao de SelectSort por tamanho de caractere  
	public Password[] SelectionSortLength(Password[] bancoDeDados) {
		Password[] banco = bancoDeDados.clone();
		
		long tempoInicial = System.currentTimeMillis();
		
		for (int i = 1; i < banco.length; i++) {
			
			Password menor=banco[i];
            int posicao=i;
            
			for (int j = i+1; j < banco.length ; j++) {
				if (menor.getLength()>banco[j].getLength()) {
					posicao=j;
                     menor = banco[j];
				}
			}
			
			troca(banco, i, posicao);
		}
		
		System.out.println("O metodo executou em " +( System.currentTimeMillis()-tempoInicial)+" ms\n");
		return banco;
	}
	
	//Ordenacaoo de SelectSort por data mes-ano
	private Password[] SelectionSortMonth(Password[] bancoDeDados) {
		
		Password[] banco=bancoDeDados.clone();

		SimpleDateFormat formato = new SimpleDateFormat("MM/yyyy");
		
		long tempoInicial = System.currentTimeMillis();
		for (int i = 1; i < banco.length; i++) {
			
			Password menor=banco[i];
            int posicao=i;
            
			for (int j = i+1; j < banco.length ; j++) {
				try {
					if (formato.parse(formato.format(menor.getData())).compareTo(formato.parse(formato.format(banco[j].getData())))>0) {
						posicao = j;
						menor=banco[j];
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
	
	//Ordenacao de SelectSort por data
	private Password[] SelectionSortDate(Password[] bancoDeDados) {
		
		Password[] banco=bancoDeDados.clone();
		
		long tempoInicial = System.currentTimeMillis();
		
		for (int i = 1; i < banco.length; i++) {
			Password menor = banco[i];
            int posicao=i;
			for (int j = i+1; j < banco.length ; j++) {
				if (menor.getData().compareTo(banco[j].getData())>0) {
					posicao = j;
					menor=banco[j];
				}
			}
			troca(banco, i, posicao);
		}
		System.out.println("O metodo executou em " +( System.currentTimeMillis()-tempoInicial)+" ms\n");
		
		return banco;
	}
	
	//gera o caso ordenado crescentemente e descrecentemente
	private void gerarCasos(Password[] bancoOrdenado) {
		setMelhorCaso(bancoOrdenado);
		setPiorCaso(construirCasoDecrescente(melhorCaso.clone()));
		
	}
	
	//resposavel por chamar a ordenacao por tamanho de caracteres com os tipos de casos 
	public void transcricaoLenghtCaso() {

		System.out.println("#------------Selection-Lenght------------#");
		transcricao(casoMedio,"passwords_length_selectionSort_medioCaso.csv");
		gerarCasos(SelectionSortLength(casoMedio));
		transcricao(piorCaso, "passwords_length_selectionSort_piorCaso.csv");
		SelectionSortLength(piorCaso);
		transcricao(melhorCaso,"passwords_length_selectionSort_melhorCaso.csv");
		SelectionSortLength(melhorCaso);

	}
	
	//resposavel por chamar a ordenacao por data mes-ano com os tipos de casos 
	public void transcricaoMonthCaso() {
		System.out.println("#------------Selection-Month------------#");
		transcricao(casoMedio,"passwords_data_month_selectionSort_medioCaso.csv");
		gerarCasos(SelectionSortMonth(casoMedio));
		transcricao(piorCaso, "passwords_data_month_selectionSort_piorCaso.csv");
		SelectionSortMonth(piorCaso);
		transcricao(melhorCaso,"passwords_data_month_selectionSort_melhorCaso.csv");
		SelectionSortMonth(melhorCaso);
	}
	//resposavel por chamar a ordenacao por data com os tipos de casos 
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
