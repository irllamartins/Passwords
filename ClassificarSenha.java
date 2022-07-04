import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.*;

public class ClassificarSenha extends Arquivo {

    private String[][] bancoDeDados;


    public ClassificarSenha(String[][] dados) {
        this.bancoDeDados = classificacao(dados.clone());
    }


    public String[][] classificacao(String[][] dados) {

        String [][] banco = new String[dados.length][4];

        banco[0][0] = dados[0][0];
        banco[0][1] = dados[0][1];
        banco[0][2] = dados[0][2];
        banco[0][3] ="class";

        for (int i = 1; i < banco.length; i++) {
            banco[i][0] = dados[i][0];
            banco[i][1] = dados[i][1];
            banco[i][2] = dados[i][2];
            banco[i][3] = classificaNivel(banco[i][0]);
            //System.out.println("classifica: "+ banco[i][0]+" "+banco[i][1]+" "+ banco[i][2]+" "+ banco[i][3]);

        };
        return banco;
    }
    //Classifica o nivel
    public String classificaNivel(String senha) {

        char[] caracteres = senha.toCharArray();

        //System.out.println("classificaNivel "+ senha);
        boolean especial = false, numeral = false;
        int minusculoMaiusculo = 0;

        numeral = classificaNumeral(caracteres);
        //System.out.println("num: "+numeral);
        minusculoMaiusculo = classificaMinusculoMaiusculo(caracteres);
       // System.out.println("Mm: "+minusculoMaiusculo);
        especial = classificaEspecial(caracteres);
       // System.out.println("esp: "+especial);


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
	public int classificaMinusculoMaiusculo(char[] letras) {
		boolean minusculo = false,maiusculo = false;
		int cont=0;

		while((!minusculo   || !maiusculo )&&cont<letras.length) {
           // System.out.println("NMn");
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
	public boolean classificaEspecial(char[] letras) {
		boolean especial = false;
        int cont=0;
		
		while(!especial  && cont<letras.length) {
           // System.out.println("especial: "+letras[cont]);

            if(!((letras[cont] >='a' && letras[cont] <= 'z') || (letras[cont] >='A' && letras[cont] <= 'Z') || (letras[cont]  >= '0' && letras[cont]  <= '9'))){
                especial = true;
            }

			cont++;
		}
		return especial;
	}
    //valida se tem numeral
	public boolean classificaNumeral(char[] letras) {
		boolean numeral = false; 
		int cont = 0;
		
		while(!numeral && cont<letras.length) {
			//		System.out.println("Numeral");
			if(Character.isDigit(letras[cont])) {
                numeral = true;

           }
            cont++;
		}
		return numeral;
	}

    public void transcricaoClasses() {
        transcricaoClassificacao(bancoDeDados, "password_classifier.csv");

    }


}