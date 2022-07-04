import java.text.ParseException;
import java.text.SimpleDateFormat;

public class InsertionSort extends Arquivo {
	private Password[] casoMedio;
	private Password[] piorCaso;
	private Password[] melhorCaso;
	
	public InsertionSort( Password[] bancoDeDados) {
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

	//ordenação insertionSort pelo tamanho
	public Password[] insertionSortLength(Password[] bancoDeDados) {
	    int j;
	    Password[] banco=bancoDeDados.clone();
	    
	    long tempoInicial = System.currentTimeMillis();
	    
		for(int k=1; k<banco.length; k++)   {

			Password key = banco[k];
			j = k-1;
			while(j>0 &&(key.getLength()<banco[j].getLength()))   {
				banco[j+1] = banco[j];
				j = j-1;
			}
			banco[j+1] = key;
			
		}
		System.out.println("O metodo executou em " +( System.currentTimeMillis()-tempoInicial)+" ms\n");
		return banco; 
	}
	
	//ordenação insertionSort pelo mes/ano
	public Password[] insertionSortMonth(Password[] bancoDeDados){
	    int j;
	    Password[] banco=bancoDeDados.clone();
	    
		SimpleDateFormat formato = new SimpleDateFormat("MM/yyyy");
		
		long tempoInicial = System.currentTimeMillis();

		for(int k=1; k<banco.length; k++)   {

			Password key = banco[k];
			j = k-1;
			try {

				while(j>0 && formato.parse(formato.format(key.getData())).compareTo(formato.parse(formato.format(banco[j].getData())))<0)   {
					
					banco[j+1] = banco[j];
					j = j-1;
				}
				
			} catch (ParseException e) {

				System.err.println("Não foi possivel converter data!");
			}
			banco[j+1] = key;
			
		}
		
		System.out.println("O metodo executou em " + (System.currentTimeMillis()-tempoInicial)+ " ms\n" );
		return banco; 
	}
	
	//ordenação insertionSort pela data
	public Password[] insertionSortDate(Password[] bancoDeDados){
	    int j;
	    Password[] banco=bancoDeDados.clone();
	    long tempoInicial = System.currentTimeMillis();
	    
		for(int k=1; k<banco.length; k++)   {

			Password key = banco[k];
			j = k-1;
			while(j>0 &&(key.getData().compareTo(banco[j].getData())<0))   {
				banco[j+1] = banco[j];
				j = j-1;
			}
			banco[j+1] = key;
			
		}
		System.out.println("O metodo executou em " +( System.currentTimeMillis()-tempoInicial)+" ms\n");
		return banco; 
	}
	
	public void gerarCasos(Password[] bancoOrdenado) {
		
		setPiorCaso(construirCasoDecrescente(bancoOrdenado));
		
		setMelhorCaso(bancoOrdenado.clone());
		
	}
	
	//chama a ordenação que vai ser classificada pelo tamanho,gera os casos crescente e decrescentemente e finaliza criando o arquivo
	public void transcricaoLenghtCaso() {
		System.out.println("#------------InsertSort-Lenght------------#");
		transcricao(casoMedio, "passwords_length_insertionSort_medioCaso.csv");
		gerarCasos(insertionSortLength(casoMedio));
		transcricao(piorCaso, "passwords_length_insertionSort_piorCaso.csv");
		insertionSortLength(piorCaso);
		transcricao(melhorCaso, "passwords_length_insertionSort_melhorCaso.csv");
		insertionSortLength(melhorCaso);
	}
	
	//chama a ordenação que vai ser classificada pelo mes/data,gera os casos crescente e decrescentemente e finaliza criando o arquivo
	public void transcricaoMonthCaso() {
		System.out.println("#------------InsertSort-Month------------#");
		transcricao(casoMedio, "passwords_data_month_insertionSort_medioCaso.csv");
		gerarCasos(insertionSortMonth(casoMedio));
		transcricao(piorCaso, "passwords_data_month_insertionSort_piorCaso.csv");
		insertionSortMonth(piorCaso);
		transcricao(melhorCaso, "passwords_data_month_insertionSort_melhorCaso.csv");
		insertionSortMonth(melhorCaso);
	}
	
	//chama a ordenação que vai ser classificada pela data,gera os casos crescente e decrescentemente e finaliza criando o arquivo
	public void transcricaoDataCaso() {
		System.out.println("#------------InsertSort-Date------------#");
		transcricao(casoMedio, "passwords_data_insertionSort_medioCaso.csv");
		gerarCasos(insertionSortDate(casoMedio));
		transcricao(piorCaso, "passwords_data_insertionSort_piorCaso.csv");
		insertionSortDate(piorCaso);
		transcricao(melhorCaso,"passwords_data_insertionSort_melhorCaso.csv");
		insertionSortDate(melhorCaso);
	}

}
