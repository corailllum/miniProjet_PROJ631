import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ArbreHuffman {
	
	//Attributs

	private ArrayList< String>listeLettrechiffree;
	private ArrayList< String>listechiffrement;
	private ArrayList< ArbreBinaire>listetempoNoeud;
	private int pMax;
	private String code;
	private String textechiffree;
	
	//Constructeur
	public ArbreHuffman(ArrayList<ArbreBinaire> listeNoeud) {
		this.listeLettrechiffree=new ArrayList<String>();
		this.listechiffrement=new ArrayList<String>();
		this.listetempoNoeud=new ArrayList<ArbreBinaire>();
		this.setListetempoNoeud(listeNoeud);
		this.pMax=this.calculePMax();
		this.textechiffree="";
		
		
		System.out.println("non");
		System.out.println("taille de listetempo "+ this.listetempoNoeud.size());
		
	}
	
	//Methode
	public ArrayList<String> getListeLettrechiffree() {
		return this.listeLettrechiffree;
	}

	public void setListeLettrechiffree(ArrayList<String> listeEnsembleNoeud) {
		this.listeLettrechiffree = listeEnsembleNoeud;
	}

	public ArrayList<ArbreBinaire> getListetempoNoeud() {
		return this.listetempoNoeud;
	}

	public void setListetempoNoeud(ArrayList<ArbreBinaire> listetempoNoeud) {
		this.listetempoNoeud = listetempoNoeud;
	}
	
	public ArrayList<String> getListechiffrement() {
		return listechiffrement;
	}

	public void setListechiffrement(ArrayList<String> listechiffrement) {
		this.listechiffrement = listechiffrement;
	}

	public int getpMax() {
		return pMax;
	}

	public void setpMax(int pMax) {
		this.pMax = pMax;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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
			 //je supprime les deux noeuds utilisés
		     this.listetempoNoeud.remove(this.listetempoNoeud.get(0));
		     this.listetempoNoeud.remove(this.listetempoNoeud.get(0));
			 //je trie la liste 
		     this.trieList(listetempoNoeud);
			 //j'appelle de nveau la fonction creationArbreComplet
		     
		     this.creationArbreComplet();
		    
		 }
		 
	}
	
	
	
	public void chiffrement(ArbreBinaire arbre,ArrayList<String> listechiffrement,ArrayList<String>listeLettrechiffrement,String code) {
		//fonction par recurrence qui permet de parcourir l'arbre et de trouvée les codes des different caractere
		//code trouver sur interent en python et radapter a la situation site :
		if(arbre.getLettreAssocier()!=null) {
			listeLettrechiffrement.add(arbre.getLettreAssocier());
			listechiffrement.add(code);
		}
		else {
			this.chiffrement(arbre.getNoeudG(),listechiffrement,listeLettrechiffrement,code+"0");
			this.chiffrement(arbre.getNoeudD(),listechiffrement,listeLettrechiffrement,code+"1");
		}
	}
		
	
	public void codageDuTexte(Texte texte){
		//fonction qui récup le nouvelle alphabet crée par l'arbre pour recrée le texte avec les codes binaires  
		String textFinal="";
		for (int i=0 ;i<texte.getTableauTexteNormal().size();i++) {
			for (int k=0;k<this.listeLettrechiffree.size();k++) {
				if(texte.getTableauTexteNormal().get(i)==this.listeLettrechiffree.get(k)) {
					textFinal+=this.listechiffrement.get(k);
				}
			}
		}
		
		this.textechiffree= textFinal;
	}
	
	public String getTextechiffree() {
		return textechiffree;
	}

	public void setTextechiffree(String textechiffree) {
		this.textechiffree = textechiffree;
	}

	public double calculeGainFinal(Texte texte) {
		//fonction qui calcule le gain qui est fais au niveau de la place apres codage
		
		double volumeini=texte.getNbCaractere()*8;
		System.out.println(volumeini);
		double volumef=this.textechiffree.length();
		System.out.println(volumef);
		double gain=1-(volumef/volumeini);
		return gain;
	}
	
	public double calculeTauxCompressionMoyen() {
		double taux=1.0;
		double res=0;
		for(int i=0;i<this.listechiffrement.size();i++) {
			res+=this.listechiffrement.get(i).length();
		}
		taux=res/this.listechiffrement.size();
		
		return taux;
	}

	
	
	
	
	
}
