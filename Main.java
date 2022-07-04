public class Main {
	
	public static void main(String[] args) {
		String path = "../EstruturaDeDados3/src/passwords.csv";
			
		PasswordsFormated arquivo = new PasswordsFormated(path);
		
		InsertionSort insertionSort = new InsertionSort(arquivo.getBancoDeDados());
		QuickSort quickSort = new QuickSort(arquivo.getBancoDeDados());
		QuickSortMedian quickSortMedian = new QuickSortMedian(arquivo.getBancoDeDados());
		MergeSort mergeSort = new MergeSort(arquivo.getBancoDeDados());
		HeapSort heapSort = new HeapSort(arquivo.getBancoDeDados());
		SelectionSort selectionSort = new SelectionSort(arquivo.getBancoDeDados());
	
		arquivo.transcricaoFomatado();

		
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
		
		
	}

	

}
