
import java.util.ArrayList;
public class test {
	public static void main(String[] args) {
		Texte mot= new Texte("les licornes !");
		System.out.println(mot.getTexts());
		System.out.println(mot.getNbCaractere());
		System.out.println(mot.getTableauTexteNormal());
		System.out.println(mot.getTabDeCaractere());
		System.out.println(mot.getTabNbIteration());
		System.out.println(mot.getTabChararctereHuffman());
		System.out.println(mot.getTabIterationHuffman());
		
		
		
		ArrayList<ArbreBinaire> listeNoeud=new ArrayList<ArbreBinaire>();
		for (int i=0; i<mot.getTabIterationHuffman().size();i++) {
			listeNoeud.add(new ArbreBinaire(mot.getTabIterationHuffman().get(i)));
			listeNoeud.get(i).setLettreAssocier(mot.getTabChararctereHuffman().get(i));
			System.out.println(listeNoeud.get(i).getLettreAssocier());
			System.out.println(listeNoeud.get(i).getEtiquette());
			
		}
		System.out.println("taille des feuille "+listeNoeud.size());
		ArbreHuffman arb=new ArbreHuffman(listeNoeud);
		
		arb.creationArbreComplet();
		
		arb.chiffrement(arb.getListetempoNoeud().get(0), arb.getListechiffrement(), arb.getListeLettrechiffree(), "");
		System.out.println(arb.getListeLettrechiffree());
		System.out.println(arb.getListechiffrement());
		arb.codageDuTexte(mot);
		System.out.println(arb.getTextechiffree());
		System.out.println(arb.calculeGainFinal(mot));
		System.out.println(arb.calculeTauxCompressionMoyen());
	}
}
// les licornes sont des creatures magnifiques !
//, ces cr�atures l�gendaires qui peuplent nos contes et nos r�ves, poss�dent une diversit� de caract�res aussi vaste que les nuances de l'arc-en-ciel. Chacune de ces majestueuses cr�atures est unique en son genre, arborant des traits qui les distinguent les unes des autres avec gr�ce et myst�re.\r\n"
//+ "Certaines licornes sont douces et bienveillantes, portant sur leur pelage l'�clat de la puret� et de l'innocence. Elles incarnent la compassion et la s�r�nit�, r�pandant autour d'elles une aura de calme et de r�confort. Leurs yeux refl�tent la bienveillance, et leur pr�sence apaise les c�urs tourment�s".