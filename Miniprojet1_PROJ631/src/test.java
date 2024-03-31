
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
//, ces créatures légendaires qui peuplent nos contes et nos rêves, possèdent une diversité de caractères aussi vaste que les nuances de l'arc-en-ciel. Chacune de ces majestueuses créatures est unique en son genre, arborant des traits qui les distinguent les unes des autres avec grâce et mystère.\r\n"
//+ "Certaines licornes sont douces et bienveillantes, portant sur leur pelage l'éclat de la pureté et de l'innocence. Elles incarnent la compassion et la sérénité, répandant autour d'elles une aura de calme et de réconfort. Leurs yeux reflètent la bienveillance, et leur présence apaise les cœurs tourmentés".