/*import java.text.ParseException;
import java.text.SimpleDateFormat;

public class CountingSort extends Arquivo {
	
	private Password[] casoMedio;
	private Password[] piorCaso;
	private Password[] melhorCaso;

	public CountingSort(Password[] bancoDeDados) {
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
	

	//Ordenação de CountingSort por tamanho de caractere  
	public Password[] CountingSortLength(Password[] bancoDeDados) {
		Password[] banco = bancoDeDados.clone();
		Password[] aux1 = bancoDeDados.clone();
		Password[] aux2 = bancoDeDados.clone();
		long tempoInicial = System.currentTimeMillis();
		int max=banco[0].getLength(),l=0,i=0,j=0;
		
		for(int k=1;k<banco.length;k++) {
			if (max<banco[k].getLength()) {
				max=banco[k].getLength();
			}
			
		}
		System.out.println("!"+max);
		for ( i = 0; i < max; i++) {
			//System.out.println("#Passei"+i+"!"+aux2[i].getLength());
			aux2[i].setLength(1);
			
		} 
	
		i=0;
		for ( i = 1; i < banco.length; i++) {
			
			aux2[banco[i].getLength()].setLength(aux2[banco[i-1].getLength()].getLength());
			
		} 
		System.out.println("Passei2");
		for (j = 1; j < max; j++) {
			
			aux2[j].setLength(aux1[j].getLength() + aux2[j-1].getLength());	
		}
		j=0;
		System.out.println("Passei3");
		for ( j = banco.length-1; j >=0 ; j--) {
			System.out.println("Passei4"+j);
			aux1[aux2[banco[j].getLength()-1].getLength()].setLength(banco[j].getLength());
			aux2[banco[j].getLength()].setLength(aux2[banco[j].getLength()].getLength()-1);
			
		}
		
		
		System.out.println("O metodo executou em " +( System.currentTimeMillis()-tempoInicial)+" ms\n");
		return banco;
	}
	
	
	//gera o caso ordenado crescentemente e descrecentemente
	private void gerarCasos(Password[] bancoOrdenado) {
		setMelhorCaso(bancoOrdenado);
		setPiorCaso(construirCasoDecrescente(melhorCaso.clone()));
		
	}
	
	//resposavel por chamar a ordenação por tamanho de caracteres com os tipos de casos 
	public void transcricaoLenghtCaso() {

		System.out.println("#------------counting-Lenght------------#");
		transcricao(casoMedio,"passwords_length_countingSort_medioCaso.csv");
		gerarCasos(CountingSortLength(casoMedio));
		transcricao(piorCaso, "passwords_length_countingSort_piorCaso.csv");
		CountingSortLength(piorCaso);
		transcricao(melhorCaso,"passwords_length_countingSort_melhorCaso.csv");
		CountingSortLength(melhorCaso);

	}
	
	//resposavel por chamar a ordenação por data mes-ano com os tipos de casos 
	public void transcricaoMonthCaso() {
		System.out.println("#------------counting-Month------------#");
		System.out.println("Não é posivel ordenar");
	
	}
	//resposavel por chamar a ordenação por data com os tipos de casos 
	public void transcricaoDataCaso() {
		System.out.println("#------------counting-Date------------#");
		System.out.println("Não é posivel ordenar");
	}
	
}*/
