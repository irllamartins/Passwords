import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		//String path = input.next();
		String path = "./passwords.csv";
		String pathAux = "./password_classifier.csv";
		
		ClassificarSenha classificarSenha = new ClassificarSenha(path);
		PasswordsFormated arquivo = new PasswordsFormated(pathAux);
		FiltrarSenha filtrarSenha = new FiltrarSenha(pathAux);
		
		InsertionSort insertionSort = new InsertionSort(arquivo.getBancoDeDados());
		QuickSort quickSort = new QuickSort(arquivo.getBancoDeDados());
		QuickSortMedian quickSortMedian = new QuickSortMedian(arquivo.getBancoDeDados());
		MergeSort mergeSort = new MergeSort(arquivo.getBancoDeDados());
		HeapSort heapSort = new HeapSort(arquivo.getBancoDeDados());
		SelectionSort selectionSort = new SelectionSort(arquivo.getBancoDeDados());
		CountingSort countingSort = new CountingSort(arquivo.getBancoDeDados());
		
		classificarSenha.transcricao();
		arquivo.transcricaoFomatado();
		filtrarSenha.transcricaoClasses();
		
		insertionSort.transcricaoLenghtCaso();
		insertionSort.transcricaoMonthCaso();
		insertionSort.transcricaoDataCaso();
		
		selectionSort.transcricaoLenghtCaso();
		selectionSort.transcricaoMonthCaso();
		selectionSort.transcricaoDataCaso();

		mergeSort.transcricaoLenghtCaso();
		mergeSort.transcricaoMonthCaso();
		mergeSort.transcricaoDataCaso();
		
		heapSort.transcricaoLenghtCaso();
		heapSort.transcricaoMonthCaso();
		heapSort.transcricaoDataCaso();
		
		quickSort.transcricaoLenghtCaso();
		quickSort.transcricaoMonthCaso();
		quickSort.transcricaoDataCaso();
		
		//quickSortMedian.transcricaoLenghtCaso();
		quickSortMedian.transcricaoMonthCaso();
		quickSortMedian.transcricaoDataCaso();
		
		countingSort.transcricaoLenghtCaso();
		
		
		
	}

	

}
