public class Main {
	
	public static void main(String[] args) {
		String path = "passwords8.csv";
		String pathFiltro = "password_classifier.csv";

		PasswordsFormated arquivo= new PasswordsFormated(path);
		ClassificarSenha classes = new ClassificarSenha(arquivo.getBancoDeDados());
		FiltrarSenha filtro = new FiltrarSenha(pathFiltro);
		InsertionSort insertionSort = new InsertionSort(arquivo.getBancoDeDados());
		QuickSort quickSort = new QuickSort(arquivo.getBancoDeDados());
		QuickSortMedian quickSortMedian = new QuickSortMedian(arquivo.getBancoDeDados());
		MergeSort mergeSort = new MergeSort(arquivo.getBancoDeDados());

		arquivo.transcricaoFomatado();
		classes.transcricaoClasses();
		filtro.transcricaoClasses();


		//insertionSort.transcricaoLenghtCaso();
		//insertionSort.transcricaoMonthCaso();
		//insertionSort.transcricaoDataCaso();
		
		//quickSort.transcricaoLenghtCaso();
		//quickSort.transcricaoMonthCaso();
		//quickSort.transcricaoDataCaso();
		
		//quickSortMedian.transcricaoLenghtCaso();
		//quickSortMedian.transcricaoMonthCaso();
		//quickSortMedian.transcricaoDataCaso();

		//mergeSort.transcricaoLenghtCaso();
		//mergeSort.transcricaoMonthCaso();
		//mergeSort.transcricaoDataCaso();

		//insertionSortLength(bancoDeDados);
		//startQuickSort(bancoDeDados, bancoDeDados.length - 1);
		//startQuickSortMedian(bancoDeDados, bancoDeDados.length - 1);
		//startMergeSort(bancoDeDados, bancoDeDados.length - 1);
	}
}
