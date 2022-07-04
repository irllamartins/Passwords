public class Main {
	
	public static void main(String[] args) {
		String path = "../EstruturaDeDados2/src/passwords2.csv";
		
		String pathClass = "password_classifier.csv";
		
		ClassificarSenha classificarSenha = new ClassificarSenha(path);
		PasswordsFormated arquivo = new PasswordsFormated(pathClass,classificarSenha.getLinhas());
		FiltrarSenha filtro = new FiltrarSenha(pathClass,classificarSenha.getLinhas());
		
		InsertionSort insertionSort = new InsertionSort(arquivo.getBancoDeDados());
		QuickSort quickSort = new QuickSort(arquivo.getBancoDeDados());
		QuickSortMedian quickSortMedian = new QuickSortMedian(arquivo.getBancoDeDados());
		MergeSort mergeSort = new MergeSort(arquivo.getBancoDeDados());
		HeapSort heapSort = new HeapSort(arquivo.getBancoDeDados());
		SelectionSort selectionSort = new SelectionSort(arquivo.getBancoDeDados());
	
		arquivo.transcricaoFomatado();
		classificarSenha.transcricaoClasses();
		filtro.transcricaoClasses();
		
		insertionSort.transcricaoLenghtCaso();
		insertionSort.transcricaoMonthCaso();
		insertionSort.transcricaoDataCaso();
		
		selectionSort.transcricaoLenghtCaso();
		selectionSort.transcricaoMonthCaso();
		selectionSort.transcricaoDataCaso();

		mergeSort.transcricaoLenghtCaso();
		mergeSort.transcricaoMonthCaso();
		mergeSort.transcricaoDataCaso();
		
		quickSort.transcricaoLenghtCaso();
		quickSort.transcricaoMonthCaso();
		quickSort.transcricaoDataCaso();
		
		//quickSortMedian.transcricaoLenghtCaso();
		quickSortMedian.transcricaoMonthCaso();
		quickSortMedian.transcricaoDataCaso();
		
		heapSort.transcricaoLenghtCaso();
		heapSort.transcricaoMonthCaso();
		heapSort.transcricaoDataCaso();
		
		
	}

	

}
