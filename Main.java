import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		//String path = input.next();
		String path = "./passwords.csv";
		String pathAux = "./password_classifier.csv";
		
		ClassificarSenha classificarSenha = new ClassificarSenha(path);
		classificarSenha.transcricao();

		PasswordsFormated passwordsFormated = new PasswordsFormated(pathAux);
		passwordsFormated.transcricaoFomatado();

		FiltrarSenha filtrarSenha = new FiltrarSenha(pathAux);
		filtrarSenha.transcricaoClasses();

		InsertionSort insertionSort = new InsertionSort(passwordsFormated.getBancoDeDados());
		QuickSort quickSort = new QuickSort(passwordsFormated.getBancoDeDados());
		QuickSortMedian quickSortMedian = new QuickSortMedian(passwordsFormated.getBancoDeDados());
		MergeSort mergeSort = new MergeSort(passwordsFormated.getBancoDeDados());
		HeapSort heapSort = new HeapSort(passwordsFormated.getBancoDeDados());
		SelectionSort selectionSort = new SelectionSort(passwordsFormated.getBancoDeDados());
		CountingSort countingSort = new CountingSort(passwordsFormated.getBancoDeDados());

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

		countingSort.transcricaoLenghtCaso();
		countingSort.transcricaoMonthCaso();
		countingSort.transcricaoDataCaso();

		quickSort.transcricaoLenghtCaso();
		quickSort.transcricaoMonthCaso();
		quickSort.transcricaoDataCaso();
		
		//quickSortMedian.transcricaoLenghtCaso();
		quickSortMedian.transcricaoMonthCaso();
		quickSortMedian.transcricaoDataCaso();
		

		
		
	}

	

}
