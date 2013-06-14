
import java.util.Random;


public class EspacioCelular {
	Celula arrayCelulas[][]= new Celula[20][40];
	Random r = new Random();
	
	public EspacioCelular(){
		for(int i=0; i<20; i++){
			for(int j=0; j<40; j++){
				arrayCelulas[i][j]= new Celula(i,j,Estado.MUERTA);
			}
		}	
	}

	public void recorrerArray(){
		int contadorV;
		for(int i=0; i<arrayCelulas.length; i++){
			for(int j=0; j<arrayCelulas[i].length; j++){		
					contadorV=Vecinos(i,j);
				if(contadorV==3 && arrayCelulas[i][j].GetEstado()==Estado.MUERTA)
					arrayCelulas[i][j].SetEstado(Estado.CASIVIVA);
				else if((contadorV<2 || contadorV>3) && arrayCelulas[i][j].GetEstado()==Estado.VIVA)
					arrayCelulas[i][j].SetEstado(Estado.CASIMUERTA);
			}
		}
	}
	public int Vecinos(int i, int j){
		int contadorV=0;
		for(int fila=i-1; fila<=i+1; fila++){
			for(int colum=j-1; colum<=j+1; colum++){
				try {
					if((arrayCelulas[fila][colum].GetEstado()==Estado.VIVA
							|| arrayCelulas[fila][colum].GetEstado()==Estado.CASIMUERTA)
							&& (fila!=i || colum!=j))
						contadorV++;	
				} catch(IndexOutOfBoundsException e){}						
			}
		}
		return contadorV;
	}
	public void MatarYnacer(){
		for(int h=0; h<arrayCelulas.length; h++){
			for(int k=0; k<arrayCelulas[h].length; k++){		
				if(arrayCelulas[h][k].GetEstado()==Estado.CASIMUERTA)
					arrayCelulas[h][k].SetEstado(Estado.MUERTA);
				else if(arrayCelulas[h][k].GetEstado()==Estado.CASIVIVA)
					arrayCelulas[h][k].SetEstado(Estado.VIVA);
			}
		}
	}
	
	public void borrar(){
			for(int h=0; h<arrayCelulas.length; h++){
				for(int k=0; k<arrayCelulas[h].length; k++){		
						arrayCelulas[h][k].SetEstado(Estado.MUERTA);
				}
			}
	}
	
	public void aleatorio(){
		int aux;
		for(int h=0; h<arrayCelulas.length; h++){
			for(int k=0; k<arrayCelulas[h].length; k++){
				aux = r.nextInt(2);
				if(aux == 1)
					arrayCelulas[h][k].SetEstado(Estado.VIVA);
				else
					arrayCelulas[h][k].SetEstado(Estado.MUERTA);
			}
		}
	}
	public Celula getCelula(int fila, int col){
		return arrayCelulas[fila][col];
	}
	
	public void setVivaOmuerta(int f, int c){
		if(arrayCelulas[f][c].GetEstado()==Estado.MUERTA || arrayCelulas[f][c].GetEstado()==Estado.CASIMUERTA)
			arrayCelulas[f][c].SetEstado(Estado.VIVA);
		else
			arrayCelulas[f][c].SetEstado(Estado.MUERTA);
	}

}
