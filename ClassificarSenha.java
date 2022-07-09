import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;


public class ClassificarSenha extends Arquivo {
	private String path;
    public ClassificarSenha(String path) {
    	this.path = path;
    }

	private void classificacao(String path) {
	
			String linha = null;
			int indice=0;
			String colunas;
	
			try {
				BufferedReader arquivo = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
				FileWriter arq = new FileWriter("password_classifier.csv");
				
				PrintWriter gravarArq = new PrintWriter(arq);
				colunas = arquivo.readLine();
				gravarArq.println(colunas+",class");
	
				while ((linha = arquivo.readLine()) != null) {
					
					String[] arrayVariaveis = tratamentoDados(linha);
					
					gravarArq.println(indice+","+arrayVariaveis[0]+","+arrayVariaveis[1]+","+arrayVariaveis[2]+","+classificaNivel(arrayVariaveis[0]));
					indice++;
				}
					
					System.out.println("O Arquivo password_classifier.csv gerado com sucesso!");

				arq.close();
				arquivo.close();
			} catch (IOException e) {
				System.err.println("Arquivo não foi encontrado!Verifique o diretorio do arquivo!\n");
			}
	
		}
	 
	 private String[] tratamentoDados(String linha) {
		
		String palavra = null;
		String[] dadosFormatados = new String[3];
		int indice = dadosFormatados.length - 1;

		while (indice > 0) {

			palavra = linha.substring(linha.lastIndexOf(","));
			dadosFormatados[indice] = palavra.substring(1);
			linha = linha.substring(0, linha.lastIndexOf(","));
			indice--;
		}
		dadosFormatados[indice] = linha.substring(linha.indexOf(",") + 1);

		return dadosFormatados;

	}
	
    //Classifica o nivel
	private String classificaNivel(String senha) {

        char[] caracteres = senha.toCharArray();

        boolean especial = false, numeral = false;
        int minusculoMaiusculo = 0;

        numeral = classificaNumeral(caracteres);
        minusculoMaiusculo = classificaMinusculoMaiusculo(caracteres);
        especial = classificaEspecial(caracteres);


        if(senha.length()>8 && numeral==true && minusculoMaiusculo==2 && especial==true){
            return "muito boa";
        }
        else if(senha.length()<=7 && numeral==true && minusculoMaiusculo==2 && especial==true ){
            return "boa";
        }
        else if(senha.length()<=6 &&((numeral==true && minusculoMaiusculo==1 && especial==false)||(especial==true && minusculoMaiusculo==1 &&numeral==false)||(numeral==true && especial==true&& minusculoMaiusculo==0))){
            return "fraca";
        }
        else if(senha.length()==5 &&(((minusculoMaiusculo==1 && numeral==false && especial==false) || (numeral==true && minusculoMaiusculo==0 && especial==false) || (especial==true && numeral==false && minusculoMaiusculo==0))) ){
            return "ruim";
        }
        if(senha.length()<5 && ((minusculoMaiusculo==1 && numeral==false && especial==false) || (numeral==true && minusculoMaiusculo==0 && especial==false) || (especial==true && numeral==false && minusculoMaiusculo==0))){
            return "muito ruim";
        }
        else{
            return "sem classificação";
        }

    }
    //valida se tem caractere Minusculo/Maiusculo
    private int classificaMinusculoMaiusculo(char[] letras) {
		boolean minusculo = false,maiusculo = false;
		int cont=0;

		while((!minusculo   || !maiusculo )&&cont<letras.length) {
			if(letras[cont] == Character.toUpperCase(letras[cont]) && !Character.isDigit(letras[cont])) {
				minusculo = true;
			}
			if(letras[cont] == Character.toLowerCase(letras[cont]) && !Character.isDigit(letras[cont])) {
				maiusculo = true;
			}
            cont++;
			
		}
		if(minusculo   && maiusculo ) {
			return 2;
		}
		else if(minusculo  || maiusculo ) {
			
			return 1;
		}
		else {
			return 0;
		}
		
	}

    //vai validar se tem caractere especial
	private boolean classificaEspecial(char[] letras) {
		boolean especial = false;
        int cont=0;
		
		while(!especial  && cont<letras.length) {

            if(!((letras[cont] >='a' && letras[cont] <= 'z') || (letras[cont] >='A' && letras[cont] <= 'Z') || (letras[cont]  >= '0' && letras[cont]  <= '9'))){
                especial = true;
            }

			cont++;
		}
		return especial;
	}
    //valida se tem numeral
	private boolean classificaNumeral(char[] letras) {
		boolean numeral = false; 
		int cont = 0;
		
		while(!numeral && cont<letras.length) {
			if(Character.isDigit(letras[cont])) {
                numeral = true;

           }
            cont++;
		}
		return numeral;
	}
	public void transcricao() {
		classificacao(path);
	};
	

}