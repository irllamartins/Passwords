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
	
	
	//Ordenacao de CountingSort por tamanho de caractere
	public Password[] CountingSortLength(Password[] bancoDeDados) {
		Password[] banco = bancoDeDados.clone();
		
		banco = gerarListaOrdenar(banco,1);
		
		long tempoInicial = System.currentTimeMillis();
		
		int max=banco[0].getLength();
		
		Password[] arr1 = new Password[banco.length + 1];
		//1
		for(int k=1;k<banco.length;k++) {
			if (max<banco[k].getLength()) {
				max=banco[k].getLength();
			}
			
		}
		Password[] count_arr = new Password[max+1];
		
		for (int i = 0; i <=max; ++i) {
			 count_arr[i] = new Password(null); 
			 count_arr[i].setLength(0); 
		}
		
		 for (int i = 0; i < banco.length; i++) {
			
		     count_arr[banco[i].getLength()].setLength(count_arr[banco[i].getLength()].getLength()+1);
		 }
		 
		
		 for (int i = 1; i <= max; i++) {
		      count_arr[i].setLength(  count_arr[i].getLength()+count_arr[i-1].getLength());
		  }
		
		  for (int i =  banco.length - 1; i >= 0; i--) {
			   arr1[count_arr[banco[i].getLength()].getLength() - 1] = banco[i];
			   count_arr[banco[i].getLength()].setLength( count_arr[banco[i].getLength()].getLength()-1);
		  }
		
		  for (int i = 0; i <  banco.length; i++) {
		        banco[i] = arr1[i];
		      }  
		System.out.println("O metodo executou em " +( System.currentTimeMillis()-tempoInicial)+" ms\n");
		
		banco = gerarListaFinal(bancoDeDados,banco);
		
		return banco;
		
	}
	
	
	//gera o caso ordenado crescentemente e descrecentemente
	private void gerarCasos(Password[] bancoOrdenado) {
		setMelhorCaso(bancoOrdenado);
		setPiorCaso(construirCasoDecrescente(melhorCaso.clone()));
		
	}
	
	//resposavel por chamar a ordenacao por tamanho de caracteres com os tipos de casos 
	public void transcricaoLenghtCaso() {

		System.out.println("#------------counting-Lenght------------#");
		transcricao(casoMedio,"passwords_length_countingSort_medioCaso.csv");
		gerarCasos(CountingSortLength(casoMedio));
		transcricao(piorCaso, "passwords_length_countingSort_piorCaso.csv");
		CountingSortLength(piorCaso);
		transcricao(melhorCaso,"passwords_length_countingSort_melhorCaso.csv");
		CountingSortLength(melhorCaso);

	}
	
	//resposavel por chamar a ordenacao por data mes-ano com os tipos de casos 
	public void transcricaoMonthCaso() {
		System.out.println("#------------counting-Month------------#");
		System.out.println("Nao e posivel ordenar");
	
	}
	//resposavel por chamar a ordenacao por data com os tipos de casos 
	public void transcricaoDataCaso() {
		System.out.println("#------------counting-Date------------#");
		System.out.println("Nao e posivel ordenar");
	}
	
}
