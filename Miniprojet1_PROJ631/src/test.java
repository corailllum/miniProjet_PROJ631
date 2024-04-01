
import java.util.ArrayList;
import java.io.BufferedReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.IOException;
import java.io.BufferedWriter;

public class test {
	public static void main(String[] args) {
		//partie du code permettant la lecture du fichier qui sera par la suite codée
		
		//entre les parenthese du get renseignée le chemin complet du fichier a codée 
		//  /!\/!\TOUS LES BACKSLASH DU CHEMIN DOIVENT ETRE DOUBLEE /!\/!\ (exemple avec mon propre chemin de fichier)
		Path f =Paths.get("C:\\Users\\chanu\\Documents\\polytech\\3emeAnnee\\PROJ631\\files\\textesimple.txt");
		System.out.println(f);
		String test2="";
		try {
			
			BufferedReader bfr=Files.newBufferedReader(f);
			String test="";
			
			while((test=bfr.readLine())!=null) {
				test2+=test;
			}
			bfr.close();
		}
		catch(IOException e){
			System.err.println("IOexception");
		}
		catch(Exception e) {
			System.err.println("erreur impossible de lire les ligne du fichier ");
		}
		
		//partie qui permet de verifier de faire l'encodage du fichier rentré en paramettre 
		
		Texte mot= new Texte(test2);
		/*System.out.println(mot.getTexts());
		System.out.println(mot.getNbCaractere());
		System.out.println(mot.getTableauTexteNormal());
		System.out.println(mot.getTabDeCaractere());
		System.out.println(mot.getTabNbIteration());
		System.out.println(mot.getTabChararctereHuffman());
		System.out.println(mot.getTabIterationHuffman());*/
		
		
		//creation de tous les arbre binaire ainsi que leur report dans une liste qui sera donc la liste de toute les feuilles de l'arbre 
		ArrayList<ArbreBinaire> listeNoeud=new ArrayList<ArbreBinaire>();
		for (int i=0; i<mot.getTabIterationHuffman().size();i++) {
			listeNoeud.add(new ArbreBinaire(mot.getTabIterationHuffman().get(i)));
			listeNoeud.get(i).setLettreAssocier(mot.getTabChararctereHuffman().get(i));
			//System.out.println(listeNoeud.get(i).getLettreAssocier());
			//System.out.println(listeNoeud.get(i).getEtiquette());
			
		}
		//System.out.println("taille des feuille "+listeNoeud.size());
		ArbreHuffman arb=new ArbreHuffman(listeNoeud);
		
		arb.creationArbreComplet();
		
		arb.chiffrement(arb.getListetempoNoeud().get(0), arb.getListechiffrement(), arb.getListeLettrechiffree(), "");
		//System.out.println(arb.getListeLettrechiffree());
		//System.out.println(arb.getListechiffrement());
		arb.codageDuTexte(mot);
		//System.out.println(arb.getTextechiffree());
		//System.out.println(arb.calculeGainFinal(mot));
		//System.out.println(arb.calculeTauxCompressionMoyen());
		
		
		
		//Partie du code qui permet de crée les fichier alphabet ainsi que le document codée en lui meme 
		
		try {
			//entre les parenthese du get renseignée le chemin complet de l'emplacemnt du futur fichier codée ainsi que le fichier de l'alphabets
			//  /!\/!\TOUS LES BACKSLASH DU CHEMIN DOIVENT ETRE DOUBLEE /!\/!\ (exemple avec mon propre chemin de fichier)
			Path falphabet =Paths.get("C:\\Users\\chanu\\Documents\\polytech\\3emeAnnee\\PROJ631\\files\\alphabets.txt");
			Path fcompr =Paths.get("C:\\Users\\chanu\\Documents\\polytech\\3emeAnnee\\PROJ631\\files\\textecompresser.txt");
			BufferedWriter bfwalpha=Files.newBufferedWriter(falphabet);
			BufferedWriter bfwcompr=Files.newBufferedWriter(fcompr);
			
			//ecriture du fichier comprenant l'entierter du fichier codée
			bfwcompr.write(arb.getTextechiffree());
			//ecriture du fichier comptent l'alphabets le gain anisi que le taux moyen de compression d'une lettre
			bfwalpha.write("il y a "+mot.getNbCaractere()+" caracterts qui on été codées");
			bfwalpha.newLine();
			bfwalpha.write("la taille moyenne de chaque caractere codée est de :"+arb.calculeTauxCompressionMoyen()+" bits");
			bfwalpha.newLine();
			bfwalpha.write("le taux de compression du fichier est de :"+arb.calculeGainFinal(mot)+" %");
			bfwalpha.newLine();
			bfwalpha.newLine();
			bfwalpha.write("l'alphabets utiliser est le suivant :");
			bfwalpha.newLine();
			for(int h=0 ; h<arb.getListechiffrement().size();h++) {
				bfwalpha.write(mot.getTabChararctereHuffman().get(h)+ ": "+mot.getTabIterationHuffman().get(h));
				bfwalpha.newLine();
			}
			
			bfwalpha.close();
			bfwcompr.close();
		}
		catch(IOException e){
			System.err.println("IOexception ouverture impossible");
		}
		catch(Exception e) {
			System.err.println("erreur impossible d'ecrire  les ligne du fichier ");
		}
	}
}

//phrase longue test 
//les licornes, ces créatures légendaires qui peuplent nos contes et nos rêves, possèdent une diversité de caractères aussi vaste que les nuances de l'arc-en-ciel. Chacune de ces majestueuses créatures est unique en son genre, arborant des traits qui les distinguent les unes des autres avec grâce et mystère Certaines licornes sont douces et bienveillantes, portant sur leur pelage l'éclat de la pureté et de l'innocence. Elles incarnent la compassion et la sérénité, répandant autour d'elles une aura de calme et de réconfort. Leurs yeux reflètent la bienveillance, et leur présence apaise les cœurs tourmentés.







