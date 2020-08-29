package BlackJack;

import java.util.Random;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.lang.Thread;
import javax.swing.*;

public class MainBlackJack {

    public static void main(String[] args) throws InterruptedException 
    {
        String st, stNaipe, jop, totalCartas, cartaAtual;
        String simbCarta;
        int nValorTotal, valorCarta = 0, naipe = 0, simbolo = 0;
        boolean denovo = true, perdeu = false;

        
        
        
        
        
//---------------------------------------------------------------------------------------------	Cores  (fundo e fonte)
 
        JFrame frame1 = new JFrame("Showing Error Message");
        UIManager UI=new UIManager();
        UI.put("OptionPane.background", Color.black);
        UI.put("OptionPane.messagebackground", Color.black);
        UI.put("Panel.background", Color.black);
        UI.put("OptionPane.messageForeground", Color.orange);

       
//--------------------------------------------------------------------------------Icones do jogo------------------------------------------------------------------------------------------        
       
        ImageIcon icon = new ImageIcon("C:\\Users\\user\\Documents\\Repositorio_Local\\Generation\\Java\\primeiroprojetogeneration\\Primeiro-Projeto_Generation\\imagens\\blackjack.png");
        ImageIcon icon1 = new ImageIcon("C:\\Users\\user\\Documents\\Repositorio_Local\\Generation\\Java\\primeiroprojetogeneration\\Primeiro-Projeto_Generation\\imagens\\feliz.png");
        ImageIcon icon2 = new ImageIcon("C:\\Users\\user\\Documents\\Repositorio_Local\\Generation\\Java\\primeiroprojetogeneration\\Primeiro-Projeto_Generation\\imagens\\triste.png");
        ImageIcon icon3 = new ImageIcon("C:\\Users\\user\\Documents\\Repositorio_Local\\Generation\\Java\\primeiroprojetogeneration\\Primeiro-Projeto_Generation\\imagens\\cartas.png");
        
        //JOptionPane.showMessageDialog(null, "Texto", "Titulo" ,JOptionPane.INFORMATION_MESSAGE, icone);BlackJack 21 - Generation
        JOptionPane.showMessageDialog(null, "Generation Brasil\nProjeto de Lucas e Alex\n\t\tJogo 21\nClique para iniciar","BlackJack 21 - Generation" ,JOptionPane.INFORMATION_MESSAGE, icon3);
        
        while(true)
        {
            Baralho b1 = new Baralho();//-------------------------------------------------------Objeto Baralho Criado
            nValorTotal = 0;
            totalCartas = "";
            
            do{
	                perdeu = false;
	                valorCarta = 0;
	                
	                Random random = new Random();
	                
		            do{//-----------------------------------------------------------------------Verifica se a carta já foi escolhida
		            	naipe = random.nextInt(3);
			            simbolo = random.nextInt(12);
		            }while(b1.verificaSeJaFoi(naipe, simbolo)== true);
	                 
		            simbCarta = b1.getCarta(naipe, simbolo);
		            b1.lancaCarta(naipe, simbolo);
		            valorCarta = b1.calculaValorCarta(simbolo);
		            stNaipe = b1.getNaipe(naipe, simbolo);
		            nValorTotal += b1.calculaValorCarta(simbolo);
		            cartaAtual = "|" + simbCarta + " " + stNaipe + "| ";
		            totalCartas = totalCartas + " " + cartaAtual;
		            jop = "Total Cartas: " + totalCartas + "\nValor total: " + nValorTotal;
		            
		            if(nValorTotal > 21)//------------------------------------------------------Verifica se o total de pts do jogador passou de 21
		            {
		            	JOptionPane.showMessageDialog(null, jop + "\nQue Pena Você Perdeu", "Fim de Jogo", JOptionPane.ERROR_MESSAGE, icon2);
		                perdeu = true;
		                break;
		            }
		            st = JOptionPane.showInputDialog(null,jop + "\nDeseja continuar? [S/N] \nDigite 0 para sair","BlackJack 21 - Generation", JOptionPane.PLAIN_MESSAGE, icon3,  null, "").toString();
		         
		            if(st.equals("S") || st.equals("s")) //-------------------------------------Verifica se o jogador quer comprar mais uma carta
		            {
		            	denovo = true;
		            }
		            else if(st.equals("0"))
		            	return;
		            else
		            	denovo = false;
            }while(denovo == true); 
            
            
            if(perdeu == false)//---------------------------------------------------------------O JOGADOR DECIDIU PARAR
            {
                int scoreJogador = nValorTotal;
                
                
                
                
                b1 = new Baralho();//-----------------------------------------------------------VEZ DA MAQUINA JOGAR
                do{
	                    valorCarta = 0;
	                    Random random = new Random();
	                    do{
	                        naipe = random.nextInt(3);
	                        if(nValorTotal <= 15)
	                            simbolo = random.nextInt(12);
	                        else
	                            simbolo = random.nextInt(4);
	                    }while(b1.verificaSeJaFoi(naipe, simbolo)== true);
	                    
	                    simbCarta = b1.getCarta(naipe, simbolo);
	                    b1.lancaCarta(naipe, simbolo);
	                    valorCarta = b1.calculaValorCarta(simbolo);
	                    stNaipe = b1.getNaipe(naipe, simbolo);
	                    nValorTotal += b1.calculaValorCarta(simbolo);
	                    cartaAtual = "|" + simbCarta + " " + stNaipe + "| ";
	                    totalCartas = totalCartas + " " + cartaAtual;                
	               }while(nValorTotal <= scoreJogador);
                jop = "Cartas CPU: " + totalCartas;
                jop = jop + "\nScore Jogador: "+ scoreJogador + "\nScore CPU: " + nValorTotal;
                if(nValorTotal > 21)//---------------------------------------------------------Verifica se o total de pts da maquina passou de 21
                {
                    JOptionPane.showMessageDialog(null, jop + "\nVocê Venceu! :D", "Fim de Jogo", JOptionPane.ERROR_MESSAGE, icon1);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, jop + "\nVocê Perdeu D:", "Fim de Jogo", JOptionPane.ERROR_MESSAGE, icon2);
                }
            }
        }
    }
    
}