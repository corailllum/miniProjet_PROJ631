import java.util.ArrayList;
public class Texte {
	// Attributs
	
	private String texts;
	private int nbCaractere;
	private ArrayList<String> tableauTexteNormal;
	
	private ArrayList<String> tabDeCaractere;
	private ArrayList<Integer> tabNbIteration;
	
	private ArrayList<String> tabChararctereHuffman;
	private ArrayList<Integer> tabIterationHuffman;
	
	
	// Constructeur
	
	public Texte(String texts) {
		this.texts=texts;
		this.nbCaractere = texts.length();
		this.tableauTexteNormal = new ArrayList<String>();
		this.remplissage();
		this.tabDeCaractere=new ArrayList<String>();
		this.creaTabDesCaractere();
		this.tabNbIteration=new ArrayList<Integer>();
		this.nbDIteration();
		
		this.tabChararctereHuffman=new ArrayList<String>();
		
		this.tabIterationHuffman=new ArrayList<Integer>();
		this.trieHuffman();
	}
	
	//Methode
	
	//Getteur et setteur
	
	public String getTexts() {
		return this.texts;
	}
	
	public int getNbCaractere() {
		return this.nbCaractere;
	}
	
	public ArrayList getTableauTexteNormal() {
		return tableauTexteNormal;
	}

	public void setTableauTexteNormal(ArrayList tableauTexteNormal) {
		this.tableauTexteNormal = tableauTexteNormal;
	}

	public void setTexts(String texts) {
		this.texts = texts;
	}

	public void setNbCaractere(int nbCaractere) {
		this.nbCaractere = nbCaractere;
	}
	
	public ArrayList getTabDeCaractere() {
		return tabDeCaractere;
	}

	public void setTabDeCaractere(ArrayList tabDeCaractere) {
		this.tabDeCaractere = tabDeCaractere;
	}
	
	public ArrayList<Integer> getTabNbIteration() {
		return tabNbIteration;
	}

	public void setTabNbIteration(ArrayList<Integer> tabNbIteration) {
		this.tabNbIteration = tabNbIteration;
	}
	
	public ArrayList<String> getTabChararctereHuffman() {
		return tabChararctereHuffman;
	}

	public void setTabChararctereHuffman(ArrayList<String> tabChararctereHuffman) {
		this.tabChararctereHuffman = tabChararctereHuffman;
	}

	public ArrayList<Integer> getTabIterationHuffman() {
		return tabIterationHuffman;
	}

	public void setTabIterationHuffman(ArrayList<Integer> tabIterationHuffman) {
		this.tabIterationHuffman = tabIterationHuffman;
	}
	
	
	public void remplissage() {
		//methode qui permet de crée un tableau a partir d'une chaine de caractere
		for (int i =0; i<this.texts.length();i++){
			this.tableauTexteNormal.add(texts.substring(i,i+1));
		}
	}
	
	public void creaTabDesCaractere() {
		
		//fonction qui ajoute dans une liste uniquement 1 fois chaque caractere de la liste 
		for (int i=0;i<this.tableauTexteNormal.size();i++) {
			String var = this.tableauTexteNormal.get(i);
			if (! this.tabDeCaractere.contains(var)) {
				this.tabDeCaractere.add(var);
			}
			
		}
	}

	public void nbDIteration() {
		//fonction qui compte le nombre d'iteration de chaque lettre dans dans l'object 
		Integer compteur ;
		for(int i=0;i<this.tabDeCaractere.size();i++) {
			compteur=0;
			for(int j=0;j<this.tableauTexteNormal.size();j++) {
				if(this.tabDeCaractere.get(i).equals(this.tableauTexteNormal.get(j))) {
					compteur=compteur+1;
				}
				
			}
			this.tabNbIteration.add(compteur);
		}
	}
	
	public void trieHuffman() {
		//fonction qui permet de triée la liste en fonction du nb d'interation en ordre croissant
		this.tabIterationHuffman.add(this.tabNbIteration.get(0));
		this.tabChararctereHuffman.add(this.tabDeCaractere.get(0));
		for(int i=1;i<this.tabNbIteration.size();i++) {
				for (int j=0 ; j<this.tabIterationHuffman.size();j++) {
					if(this.tabNbIteration.get(i)<this.tabIterationHuffman.get(j) ) {
						this.tabIterationHuffman.add(j,this.tabNbIteration.get(i));
						this.tabChararctereHuffman.add(j,this.tabDeCaractere.get(i));
						break;
						}
						else if (j==this.tabIterationHuffman.size()-1) {
							this.tabIterationHuffman.add(this.tabNbIteration.get(i));
							this.tabChararctereHuffman.add(this.tabDeCaractere.get(i));
							break;
					}
			}
			
		}
	}

	
}

	
	
	

