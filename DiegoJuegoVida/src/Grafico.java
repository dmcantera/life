
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;


public class Grafico extends  JPanel implements MouseListener {
	
	EspacioCelular espacio;
	
	public Grafico(){
		setPreferredSize(new Dimension(800,400));
		addMouseListener(this);
		setVisible(true);
		espacio= new EspacioCelular();
	}
	
	public void paintComponent(Graphics g){

		for(int i=0; i<20; i++){
			for(int j=0; j<40; j++){
				if(espacio.getCelula(i,j).GetEstado()==Estado.VIVA)
					g.setColor(Color.BLUE);		
				else
					g.setColor(Color.WHITE);
				g.fillRect(j*20, i*20, 20, 20);	
				
				g.setColor(Color.GRAY);
				g.fillRect(j*20, i*20, getWidth(), 1);
				g.fillRect(j*20, i*20, 1, getHeight());
			}
		}	
	}
	public EspacioCelular getEspacio(){return espacio;}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		espacio.setVivaOmuerta(Math.abs(e.getY()/20), Math.abs(e.getX()/20));
		repaint();
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
