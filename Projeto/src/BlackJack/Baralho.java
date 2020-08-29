package BlackJack;



	import java.util.Random;

	public class Baralho {
	    private String cartas[][] = new String[4][13];
	    private boolean flgJaFoi[][] = new boolean[4][13];
	    private String naipes[][] = new String[4][13];
	    
	    
	    
	    
//----------------------------------------------------------------Método Baralho - cria uma matriz com valores e os naipes das cartas
	    Baralho(){
	        int i, j;
	        for (i = 0; i < 4; i++)
	        {
	            
	            for(j = 0; j < 13; j++)
	            {
	                flgJaFoi[i][j] = false;
	            
		            switch (i) 
		            {
		                case 0:
		                    naipes[i][j] = "\u2666";
		                    break;
		                case 1:
		                    naipes[i][j] = "\u2660";
		                    break;
		                case 2:
		                    naipes[i][j] = "\u2665";
		                    break;
		                case 3:
		                    naipes[i][j] = "\u2663";
		                    break;
		            }
	            
		            switch(j)
		            {
		                case 0:
		                    cartas[i][j] = "A";
		                    break;
		                    
		                case 1:
		                    cartas[i][j] = "2";
		                    break;
		                    
		                case 2:
		                    cartas[i][j] = "3";
		                    break;
		                    
		                case 3:
		                    cartas[i][j] = "4";
		                    break;
		                    
		                case 4:
		                    cartas[i][j] = "5";
		                    break;
		                    
		                case 5:
		                    cartas[i][j] = "6";
		                    break;
		                    
		                case 6:
		                    cartas[i][j] = "7";
		                    break;
		                    
		                case 7:
		                    cartas[i][j] = "8";
		                    break;
		                    
		                case 8:
		                    cartas[i][j] = "9";
		                    break;
		                    
		                case 9:
		                    cartas[i][j] = "10";
		                    break;
		                    
		                case 10:
		                    cartas[i][j] = "J";
		                    break;
		                    
		                case 11:
		                    cartas[i][j] = "Q";
		                    break;
		                    
		                case 12:
		                    cartas[i][j] = "K";
		                    break;
		            }
	            }//FIM FOR J
	        }// FIM FOR I
	    }
	    
	    public String getNaipe(int naipe, int simbolo){
	        return naipes[naipe][simbolo];
	    }
	    
	    public void lancaCarta(int naip, int simbol){
	        flgJaFoi[naip][simbol] = true;
	    }
	    
	    public String getCarta(int naipe, int simbolo){
	        return cartas[naipe][simbolo];
	    }
	    
	    public boolean verificaSeJaFoi(int naipe, int simbolo){//-------------------------------------------------------Indica se a carta já foi lançada
	        if (flgJaFoi[naipe][simbolo] == true)
	            return true;
	        else
	            return false;
	    }
	    
	    public int calculaValorCarta(int simbolo){//---------------------------------------------------------------------Valor das cartas J Q K
	        if (simbolo == 10 || simbolo == 11 || simbolo == 12)
	            return 10;        
	        else
	            return (simbolo+1);        
	    }
	    
	}

