import java.text.ParseException;
import java.text.SimpleDateFormat;

public class HeapSort extends Arquivo {
	
	private String[][] casoMedio;
	private String[][] piorCaso;
	private String[][] melhorCaso;
	
	public HeapSort(String[][] bancoDeDados) {
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
	
	public String[][] heapSortLength(String [][] bancoDeDados) {
		String[][] banco;

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
	
	public void noLength(String banco[][], int n, int i) {
		
		int maior = i;
		int l = 2 * i + 1;
		int r = 2 * i + 2;
		
		if (l < n && (Integer.parseInt(banco[l][1])) > Integer.parseInt(banco[maior][1])){
			maior = l;
			}
		
		if (r < n && (Integer.parseInt(banco[r][1]) > Integer.parseInt(banco[maior][1]))){
			maior = r;
	        }
		
		if (maior != i) {
			troca(banco,i,maior);
	  
	        noLength(banco, n, maior);
	    }
	}
	
	public String[][] heapSortMonth(String [][] bancoDeDados) {
		String[][] banco;

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
	
	public void noMonth(String banco[][], int n, int i) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat formato = new SimpleDateFormat("MM/yyyy");
		
		int maior = i;
		int l = 2 * i + 1;
		int r = 2 * i + 2;
		try {
			if (l < n && (formato.parse(formato.format(formatter.parse(banco[l][2]))).compareTo(formato.parse(formato.format(formatter.parse(banco[maior][2]))))<0)){
				maior = l;
				}
			
			if (r < n && (formato.parse(formato.format(formatter.parse(banco[l][2]))).compareTo(formato.parse(formato.format(formatter.parse(banco[maior][2]))))>0)){
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
	public String[][] heapSortDate(String [][] bancoDeDados) {
		String[][] banco;

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
	
	public void noDate(String banco[][], int n, int i) {
	    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		
		int maior = i;
		int l = 2 * i + 1;
		int r = 2 * i + 2;
		try {
			if (l < n && (formatter.parse(banco[l][2]).compareTo(formatter.parse(banco[maior][2])))<0){
				maior = l;
				}
			
			if (r < n && (formatter.parse(banco[l][2]).compareTo(formatter.parse(banco[maior][2])))>0){
				maior = r;
		        }
		}catch (ParseException e) {
			e.printStackTrace();
		}  
		if (maior != i) {
			troca(banco,i,maior);
	  
			noDate(banco, n, maior);
	    }
	}
	public String[][] gerarListaOrdenar(String [][] listaInicial,int inicio) {
		String [][] listaFinal = new String[listaInicial.length-inicio][3];
		
		for(int i=0;i<listaFinal.length;i++) {
			listaFinal[i] = listaInicial[i+inicio];
		}	
		
		return listaFinal;
	}
	
	public String[][] gerarListaFinal(String [][] listaComColuna,String [][] listaHeap) {
		String [][] listaFinal = new String[listaComColuna.length][3];
		
		listaFinal[0] = listaComColuna[0];
		for(int i=1;i<listaFinal.length;i++) {
			listaFinal[i] = listaHeap[i-1];
		}	
		return listaFinal;
	}
	
	public void gerarCasos(String [][] bancoOrdenado) {
			setMelhorCaso(bancoOrdenado);
			setPiorCaso(construirPiorCaso(melhorCaso));
			
	}
	
	public void transcricaoLenghtCaso() {

		System.out.println("#------------HeapSort-Lenght------------#");
		transcricao(casoMedio,"passwords_length_heapSort_medioCaso.csv");
		gerarCasos(heapSortLength(casoMedio));
		transcricao(piorCaso,"passwords_length_heapSort_piorCaso.csv");
		heapSortLength(piorCaso);
		transcricao(melhorCaso,"passwords_length_heapSort_melhorCaso.csv");
		heapSortLength(melhorCaso);

	}
	
	public void transcricaoMonthCaso() {
		System.out.println("#------------HeapSort-Month------------#");
		transcricao(casoMedio,"passwords_data_month_heapSort_medioCaso.csv");
		gerarCasos(heapSortMonth(casoMedio));
		transcricao(piorCaso,"passwords_data_month_heapSort_piorCaso.csv");
		heapSortMonth(piorCaso);
		transcricao(melhorCaso,"passwords_data_month_heapSort_melhorCaso.csv");
		heapSortMonth(melhorCaso);
	}
	public void transcricaoDataCaso() {
		System.out.println("#------------HeapSort-Date------------#");
		transcricao(casoMedio,"passwords_data_heapSortt_medioCaso.csv");;
		gerarCasos(heapSortDate(casoMedio));
		transcricao(piorCaso,"passwords_data_heapSort_piorCaso.csv");
		heapSortDate(piorCaso);
		transcricao(melhorCaso,"passwords_data_month_heapSort_melhorCaso.csv");
		heapSortDate(melhorCaso);
	}

}
