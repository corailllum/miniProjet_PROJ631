import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ArbreHuffman {
	
	//Attributs

	private ArrayList< ArbreBinaire>listeEnsembleNoeud;
	private ArrayList< ArbreBinaire>listetempoNoeud;
	private int pMax;
	
	//Constructeur
	public ArbreHuffman(ArrayList<ArbreBinaire> listeNoeud) {
		this.listeEnsembleNoeud=new ArrayList<ArbreBinaire>();
		this.listetempoNoeud=new ArrayList<ArbreBinaire>();
		this.setListetempoNoeud(listeNoeud);
		this.pMax=this.calculePMax();
		
		System.out.println("non");
		System.out.println("taille de listetempo "+ this.listetempoNoeud.size());
		
	}
	
	//Methode
	public ArrayList<ArbreBinaire> getListeEnsembleNoeud() {
		return this.listeEnsembleNoeud;
	}

	public void setListeEnsembleNoeud(ArrayList<ArbreBinaire> listeEnsembleNoeud) {
		this.listeEnsembleNoeud = listeEnsembleNoeud;
	}

	public ArrayList<ArbreBinaire> getListetempoNoeud() {
		return this.listetempoNoeud;
	}

	public void setListetempoNoeud(ArrayList<ArbreBinaire> listetempoNoeud) {
		this.listetempoNoeud = listetempoNoeud;
	}
	
	
	
	
	public void trieList(ArrayList<ArbreBinaire> l) { 
		ArrayList<ArbreBinaire> nl=new ArrayList<ArbreBinaire>();
		nl.add(l.get(0));
		for(int i=1;i<l.size();i++) {
			for (int j=0 ; j<nl.size();j++) {
				if(l.get(i).getEtiquette()<nl.get(j).getEtiquette() ) {
					nl.add(j,l.get(i));
						break;
						}
				else if (j==nl.size()-1) {
							nl.add(l.get(i));
							break;
					}
			}
			
		}
		this.setListetempoNoeud(nl);
    } 
	
	
	public int calculePMax() {
		int somme=0;
		for(int k=0;k<this.listetempoNoeud.size();k++) {
			somme=somme+this.listetempoNoeud.get(k).getEtiquette();
		}
		return somme;
	}
	
	public void creationArbreComplet() {
		//Fonction qui permet la creation de l'arbre du huffman par recurrence 
		// il faut définir une condition d'arrêt qui fonctionne peut importe ce que tu as. Le tout dernier élément est à prendre en compte
		 if (this.listetempoNoeud.size()>1 && this.listetempoNoeud.get(0).getEtiquette()<=this.pMax) {
			 //le prendre le poids le plus faible de la liste : créer un objet temporaire qui permet de le stocker
			//je prendre le second poid le plus faible de la liste  : créer un objet temporaire qui permet de le stocker
			 ArbreBinaire arbreG = this.listetempoNoeud.get(0);
		     ArbreBinaire arbreD = this.listetempoNoeud.get(1);
		     int valeur = arbreG.getEtiquette() + arbreD.getEtiquette();
		     
			 //je crée le nouveau noeud avec arbrzg et arbre droit + nouvelle valeur
		     
		     ArbreBinaire nouvelArbre = new ArbreBinaire(valeur, arbreG, arbreD);
		     this.listetempoNoeud.add(nouvelArbre);
		     //System.out.println(this.getListetempoNoeud());
			 //je supprime les deux noeuds utilisés
		     this.listetempoNoeud.remove(this.listetempoNoeud.get(0));
		     //System.out.println(this.getListetempoNoeud());
		     this.listetempoNoeud.remove(this.listetempoNoeud.get(0));
		     //System.out.println(this.getListetempoNoeud());
			 //je trie la liste 
		     this.trieList(listetempoNoeud);
			 //j'appelle de nveau la fonction creationArbreComplet
		     //System.out.println(this.getListetempoNoeud());
		     
		     /*for(int k=0;k<this.listetempoNoeud.size();k++) {
		    	 System.out.println("interation de la boucle "+k);
		    	 System.out.println(this.getListetempoNoeud().get(k).getEtiquette());
		    	 System.out.println("noueud gauche");
		    	 this.getListetempoNoeud().get(k).etiquetteenfantG();
		    	 System.out.println("noeud droit");
		    	 this.getListetempoNoeud().get(k).etiquetteenfantD();
		     }*/
		     this.creationArbreComplet();
		    
		 }
		 
	}
	
	
	public void chiffrement() {
		
	}
	
	
	
	
	
	
}
