package tp_note;

import java.awt.*;      

import javax.swing.*;

import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;

/**
 * classe qui implémente une vue dans le cadre de l'architecture MVC
 * @author sinteff3u
 *
 */
public class PanneauImages extends JPanel implements Observer{  
	private Image fond, im[];	// contient les objets Images correspondants aux fichiers des images
	//private boolean init;
	private Model model;
	
	/**
	 * 
	 * @param m le modèle, nécessaire pour la méthode PaintComponent
	 */
	public PanneauImages(Model m){
		super();
		model = m;
		this.im= new Image[10];
		try{
			fond=ImageIO.read(new File("images/fond.png"));
			for(int i=0;i<10;i++){
				im[i]=ImageIO.read(new File("images/im"+i+".png"));
			}
		}catch(IOException e){System.out.println("PB chargement fichiers images "+e);};
	}
	
	
	/*
	 * Methode appelee automatiquement a la construction du JPanel
	 * pour l'appeler dans une autre methode, utiliser la methode repaint() 
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);			
		setBackground(Color.white);
		int x=5,y=5; //coordonnees des positions ou les images doivent etre dessinees
			
		// Affiche l'image fond dans chaque zone
		// --> a faire evoluer ensuite pour faire apparaitre les images de im dans les bonnes zones
		for(int i=0;i<20;i++){
			if(!model.getVisible()[i]){
				g.drawImage(fond,x,y,this); //Dessine l'image fond a la position (x,y)
			}else{
				g.drawImage(im[model.getOrdre()[i]],x,y,this);
			}
			x+=120;
			if(x==605){
				x=5;y+=120;
			}
		}		
  	}
	
	/**
	 * méthode appelée par notifyObervers() du modèle
	 */
	@Override
	public void update(Observable o, Object arg) {
		repaint();	
	}

}