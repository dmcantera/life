
import java.awt.Color;
import java.awt.Graphics;


public class Celula {
	Estado estado;
	int fila, columna;
	
	public Celula(int fila, int columna , Estado estado){
		this.estado=estado;
		this.fila=fila;
		this.columna=columna;
	}
	
	public Estado GetEstado(){return estado;}
	public void SetEstado(Estado estado){ this.estado=estado;}
}