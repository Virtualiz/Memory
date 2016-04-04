package tp_note;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Observable;

/**
 * Classe qui impl�mente le mod�le dans le cadre de l'architecture MVC
 * @author sinteff3u
 *
 */
public class Model extends Observable{
	
	/**
	 * ordre des images
	 */
	private List<Integer> ordre ; 
	
	/**
	 * status de visibilit� des images de m�me indice
	 */
	private boolean[] visible;
	
	/**
	 * nombre de paires d�couvertes
	 */
	private int nbPaires,
	
	/**
	 * nombre de coups r�alis�s
	 */
	nbCoups,
	
	/**
	 * indice de l'image corresopndant au premier clic, -1 par d�faut
	 */
	numZoneIm1,
	
	/**
	 * indice de l'image corresopndant au second clic, -1 par d�faut
	 */
	numZoneIm2,
	
	/**
	 * correspond au num�ro du clic dans le coup courant, 0 par d�faut
	 */
	numclic;

	
	/**
	 * constructeur, il initialise les attributs � leur valeur par d�faut
	 */
	public Model(){
		int[] tab = {9,8,0,1,3,1,6,5,4,9,2,2,7,8,0,7,5,4,3,6};
		ordre = new ArrayList<Integer>();
		for(int i = 0;i<tab.length;i++){
			ordre.add(tab[i]);
		}
		visible = new boolean[20];
		nbPaires=0;
		nbCoups=0;
		numZoneIm1=-1;
		numZoneIm2=-1;
		numclic=0;
	}

	/**
	 * 
	 * @return attribut ordre
	 */
	public int[] getOrdre() {
		int[] tab = new int[20];
		int i=0;
		for(int n: ordre){
			tab[i]=n;
			i++;
		}
		return tab;
	}
	
	/**
	 * 
	 * @return attribut visible
	 */
	public boolean[] getVisible() {
		return visible;
	}
	
	/**
	 * 
	 * @return attribut nbPaires
	 */
	public int getNbPaires() {
		return nbPaires;
	}
	
	/**
	 * 
	 * @return attribut nbCoups
	 */
	public int getNbCoups() {
		return nbCoups;
	}

	/**
	 * m�thode qui est appel�e par le Controler, elle notifie les Observers 
	 * qu'il y a eu une modification lors des clics
	 * 
	 * @param numz zone click�e
	 */
	public void modifier(int numz){
			if(numclic == 2){
				numclic = 0;
				if(ordre.get(numZoneIm1)!=ordre.get(numZoneIm2)){
					visible[numZoneIm1]=false;
					visible[numZoneIm2]=false;

				}}
		if(!visible[numz]){
			//}
			//else{
				if(numclic == 0){
					numZoneIm1 = numz;
					visible[numz]=true;
					numclic++;
				}
				else{
					if(numclic == 1){
						numZoneIm2 = numz;
						visible[numz]=true;
						numclic++;
						nbCoups++;
						if(ordre.get(numZoneIm1)==ordre.get(numZoneIm2)){
							nbPaires++;
						}
					}
			//	}
			}
			this.setChanged();
			this.notifyObservers();
		}
	}
	
	/**
	 * m�thode remettant l'instance � d�faut
	 */
	public void init(){
		visible = new boolean[20];
		nbPaires=0;
		nbCoups=0;
		numZoneIm1=-1;
		numZoneIm2=-1;
		numclic=0;
		
		Collections.shuffle(ordre);
		
		this.setChanged();
		this.notifyObservers();
	}

}
