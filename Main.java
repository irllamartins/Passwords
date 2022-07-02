public class Main {
	
	public static void main(String[] args) {
		String path = "passwords8.csv";
		
		PasswordsFormated arquivo= new PasswordsFormated(path);
		InsertionSort insertionSort = new InsertionSort(arquivo.getBancoDeDados());
		QuickSort quickSort = new QuickSort(arquivo.getBancoDeDados());
		QuickSortMedian quickSortMedian = new QuickSortMedian(arquivo.getBancoDeDados());
		
		arquivo.transcricaoFomatado();
		
		insertionSort.transcricaoLenghtCaso();
		insertionSort.transcricaoMonthCaso();
		insertionSort.transcricaoDataCaso();
		
		quickSort.transcricaoLenghtCaso();
		quickSort.transcricaoMonthCaso();
		quickSort.transcricaoDataCaso();
		
		quickSortMedian.transcricaoLenghtCaso();
		quickSortMedian.transcricaoMonthCaso();
		quickSortMedian.transcricaoDataCaso();

		//insertionSortLength(bancoDeDados);
		//startQuickSort(bancoDeDados, bancoDeDados.length - 1);
		//startQuickSortMedian(bancoDeDados, bancoDeDados.length - 1);
		//startMergeSort(bancoDeDados, bancoDeDados.length - 1);
	}
}
