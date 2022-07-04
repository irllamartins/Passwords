import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class ClassificarSenha extends Arquivo {
	
    private Password [] bancoDeDados;
    private int linhas;

    public ClassificarSenha(String path) {
    	
    	this.linhas = contarLinha(path);
        this.bancoDeDados = classificacao(linhas,path);
    }

	public Password[] getBancoDeDados() {
		return bancoDeDados;
	}

	public void setBancoDeDados(Password[] bancoDeDados) {
		this.bancoDeDados = bancoDeDados;
	}

	public int getLinhas() {
		return linhas;
	}

	public void setLinhas(int linhas) {
		this.linhas = linhas;
	}




	public Password[] classificacao(int quantidade, String path) {
	
			String linha = null;
			int indice = 0;
			Password[] bancoDeDados = new Password[quantidade];
			String colunas;
	
			try {
	
				BufferedReader arquivo = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
	
				colunas = arquivo.readLine();
				colunas = colunas+",class";
				bancoDeDados[0] = new Password(colunas);
				
				System.out.println(bancoDeDados[0].toStringColunas());
				indice++;
	
				while ((linha = arquivo.readLine()) != null) {
					
					try {
						SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

						String[] dadosFormatados = tratamentoDados(linha);
						
						bancoDeDados[indice] = new Password(dadosFormatados[0],verificarNumero(dadosFormatados[1]),formatter.parse(dadosFormatados[2]),dadosFormatados[2],classificaNivel(dadosFormatados[0].replaceAll("^\"|\"$", "")));
		
						indice++;
					}catch (ParseException e) {
						System.err.println("Ocorreu um erro inesperado na converçaõ de data!\n");
					}
				}
				
				arquivo.close();
			} catch (IOException e) {
				System.err.println("Arquivo não foi encontrado!Verifique o diretorio do arquivo!\n");
			}
			return bancoDeDados;
	
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
	
	private int contarLinha(String path) {
		int contador = 0;

		try {
			BufferedReader arquivo = new BufferedReader(new InputStreamReader(new FileInputStream(path)));

			while (arquivo.readLine() != null) {
				contador++;
			}
			arquivo.close();

		} catch (IOException e) {
			System.err.println("Arquivo não foi encontrado!Verifique o diretorio do arquivo!\n");
		}

		return contador;

	}
	
	private int verificarNumero(String palavra) {
		int numero;
		try {
			numero = Integer.parseInt(palavra);
		} catch (NumberFormatException e) {
			numero = 0;
		}
		return numero;
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

    public void transcricaoClasses() {
    	transcricao(getBancoDeDados(), "password_classifier.csv");

    }



}