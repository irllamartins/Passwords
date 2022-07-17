import java.text.ParseException;
import java.text.SimpleDateFormat;

public class HeapSort extends Arquivo {
	
	private Password[] casoMedio;
	private Password[] piorCaso;
	private Password[] melhorCaso;
	
	public HeapSort(Password[] bancoDeDados) {
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


	//Ordenacao do heapSort pelo tamanho 
	public Password[] heapSortLength(Password[] bancoDeDados) {
		Password[] banco;

		banco = gerarListaOrdenar(bancoDeDados,1);
		
		int n = banco.length;
		
		long tempoInicial = System.currentTimeMillis();
		
		for (int i = (n / 2) - 1; i >= 0; i--) {
			noLength(banco, n, i);
		}
		
		for (int i = n - 1; i >= 0; i--) {
			troca(banco,0,i);
	  
	        noLength(banco, i, 0);
	    }
		System.out.println("O metodo executou em " +( System.currentTimeMillis()-tempoInicial)+" ms\n");
		
		banco = gerarListaFinal(bancoDeDados,banco);
		return banco;
	}
	
	public void noLength(Password[] banco, int n, int i) {
		
		int maior = i;
		int l = 2 * i + 1;
		int r = 2 * i + 2;
		
		if (l < n && (banco[l].getLength() > banco[maior].getLength())){
			maior = l;
			}
		
		if (r < n && (banco[r].getLength()> banco[maior].getLength())){
			maior = r;
	        }
		
		if (maior != i) {
			troca(banco,i,maior);
	  
	        noLength(banco, n, maior);
	    }
	}
	
	//Ordenacao do heapSort pelo mes/ano
	public Password[] heapSortMonth(Password[] bancoDeDados) {
		Password[] banco;

		banco = gerarListaOrdenar(bancoDeDados,1);
		
		int n = banco.length;
		
		long tempoInicial = System.currentTimeMillis();
		
		for (int i = (n / 2) - 1; i >= 0; i--) {
			noMonth(banco, n, i);
		}
		
		for (int i = n - 1; i >= 0; i--) {
			troca(banco,0,i);
	  
	        noMonth(banco, i, 0);
	    }
		System.out.println("O metodo executou em " +( System.currentTimeMillis()-tempoInicial)+" ms\n");
		
		banco = gerarListaFinal(bancoDeDados,banco);
		return banco;
	}
	
	public void noMonth(Password[] banco, int n, int i) {
		SimpleDateFormat formato = new SimpleDateFormat("MM/yyyy");
		
		int maior = i;
		int l = 2 * i + 1;
		int r = 2 * i + 2;
		try {
			if (l < n &&( (formato.parse(formato.format(banco[l].getData()))).compareTo(formato.parse(formato.format(banco[maior].getData())))>0)){
				maior = l;
				}
			
			if (r < n && (formato.parse(formato.format(banco[l].getData())).compareTo(formato.parse(formato.format(banco[maior].getData())))>0)){
				maior = r;
		        }
		}catch (ParseException e) {
			e.printStackTrace();
		}  
		if (maior != i) {
			troca(banco,i,maior);
	  
	        noMonth(banco, n, maior);
	    }
	}
	
	//Ordenacao do heapSort pela data 
	public Password[] heapSortDate(Password[] bancoDeDados) {
		Password[] banco;

		banco = gerarListaOrdenar(bancoDeDados,1);
		int n = banco.length;
		long tempoInicial = System.currentTimeMillis();
		
		for (int i = (n / 2) - 1; i >= 0; i--) {
			noDate(banco, n, i);
		}
		
		for (int i = n - 1; i >= 0; i--) {
			troca(banco,0,i);
	  
			noDate(banco, i, 0);
	    }
		System.out.println("O metodo executou em " +( System.currentTimeMillis()-tempoInicial)+" ms\n");
		banco = gerarListaFinal(bancoDeDados,banco);
		return banco;
	}
	
	public void noDate(Password[] banco, int n, int i) {
		
		int maior = i;
		int l = 2 * i + 1;
		int r = 2 * i + 2;
		if (l < n && (banco[l].getData().compareTo(banco[maior].getData()))>0){
			maior = l;
			}
			
		if (r < n && (banco[l].getData().compareTo(banco[maior].getData()))>0){
			maior = r;
		       } 
		if (maior != i) {
			troca(banco,i,maior);
	  
			noDate(banco, n, maior);
	    }
	}
	
	//gera os casos crescente e decrescentemente
	public void gerarCasos(Password[] bancoOrdenado) {
			setMelhorCaso(bancoOrdenado);
			setPiorCaso(construirCasoDecrescente(melhorCaso.clone()));
			
	}
	
	//chama a ordenacao que vai ser classificada pelo tamanho,gera os casos crescente e decrescentemente e finaliza criando o arquivo 
	public void transcricaoLenghtCaso() {

		System.out.println("#------------HeapSort-Lenght------------#");
		transcricao(casoMedio,"passwords_length_heapSort_medioCaso.csv");
		gerarCasos(heapSortLength(casoMedio));
		transcricao(piorCaso,"passwords_length_heapSort_piorCaso.csv");
		heapSortLength(piorCaso);
		transcricao(melhorCaso,"passwords_length_heapSort_melhorCaso.csv");
		heapSortLength(melhorCaso);

	}
	
	//chama a ordenacao que vai ser classificada pelo mes/ano,gera os casos crescente e decrescentemente e finaliza criando o arquivo 
	public void transcricaoMonthCaso() {
		System.out.println("#------------HeapSort-Month------------#");
		transcricao(casoMedio,"passwords_data_month_heapSort_medioCaso.csv");
		gerarCasos(heapSortMonth(casoMedio));
		transcricao(piorCaso,"passwords_data_month_heapSort_piorCaso.csv");
		heapSortMonth(piorCaso);
		transcricao(melhorCaso,"passwords_data_month_heapSort_melhorCaso.csv");
		heapSortMonth(melhorCaso);
	}
	
	//chama a ordenacao que vai ser classificada pela data,gera os casos crescente e decrescentemente e finaliza criando o arquivo 
	public void transcricaoDataCaso() {
		System.out.println("#------------HeapSort-Date------------#");
		transcricao(casoMedio,"passwords_data_heapSort_medioCaso.csv");;
		gerarCasos(heapSortDate(casoMedio));
		transcricao(piorCaso,"passwords_data_heapSort_piorCaso.csv");
		heapSortDate(piorCaso);
		transcricao(melhorCaso,"passwords_data_heapSort_melhorCaso.csv");
		heapSortDate(melhorCaso);
	}

}
