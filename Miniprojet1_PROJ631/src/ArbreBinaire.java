import java.util.ArrayList;
public class ArbreBinaire {
	//Attributs 
	private ArbreBinaire noeudG;
	private ArbreBinaire noeudD;
	private int etiquette;
	private String lettreAssocier;
	private boolean estRacine;
	
	
	//Constructeur
	public ArbreBinaire(int etiquette) {
		this.noeudG=null;
		this.noeudD=null;
		this.etiquette=etiquette;
		this.lettreAssocier=null;
		this.estRacine=false;
		
		
	}
	public ArbreBinaire(int etiquette,ArbreBinaire arbreG,ArbreBinaire arbreD) {
		this.noeudG=arbreG;
		this.noeudD=arbreD;
		this.etiquette=etiquette;
		this.lettreAssocier=null;
		this.estRacine=false;
		
		
	}

	//Methode
	//Getteur et Setteur 

	public boolean isEstRacine() {
		return estRacine;
	}

	public void setEstRacine(boolean estRacine) {
		this.estRacine = estRacine;
	}

	

	public ArbreBinaire getNoeudG() {
		return noeudG;
	}


	public void setNoeudG(ArbreBinaire noeudG) {
		this.noeudG = noeudG;
	}


	public ArbreBinaire getNoeudD() {
		return noeudD;
	}


	public void setNoeudD(ArbreBinaire noeudD) {
		this.noeudD = noeudD;
	}


	public int getEtiquette() {
		return etiquette;
	}


	public void setEtiquette(int etiquette) {
		this.etiquette = etiquette;
	}


	public String getLettreAssocier() {
		return lettreAssocier;
	}
	
	public void etiquetteenfantG() {
		if (this.noeudG!=null) {
			System.out.println(this.noeudG.getEtiquette());
		}
		
	}
	public void etiquetteenfantD() {
		if (this.noeudD!=null) {
			System.out.println(this.noeudD.getEtiquette());
		}
	}

	public void setLettreAssocier(String lettreAssocier) {
		this.lettreAssocier = lettreAssocier;
	}
	
	public boolean estFeuille(){
		if(this.noeudD==null && this.noeudG==null) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	
	
	
	
	
		
	
	
	
}
