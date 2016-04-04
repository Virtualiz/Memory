package tp_note;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Classe qui implémente le contrôleur dans le cadre d'un architecture MVC
 * Il modifie le modèle, qui lui notifiera son changement aux vues qui se metteront à jour
 * @author sinteff3u
 *
 */
public class Controler implements MouseListener{
	
	/**
	 * Modèle de MVC
	 */
	private Model model;
	
	/**
	 * 
	 * @param m de modèle
	 */
	public Controler(Model m){
		model=m;
	}

	@Override
	public void mouseClicked(MouseEvent e) {}
	
	/**
	 * L'évènement de la souris modifie le modèle
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		int positionImage = (int)Math.floor(x/120) + (int)Math.floor(y/120)*5;
		model.modifier(positionImage);
	}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

}
