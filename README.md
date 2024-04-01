# miniProjet_PROJ631
Le codage de huffman permet de faire une compresstion de fichier texte en fonction du nombre d'occurence des lettre de se fichier. Les lettre 
ainsi codée prene la forme d'un nombre binaire. pour se faire l'algorithime construit un arbre binaire en fonction du nombre d'iteration de chaque lettre et le parcour pour pouvoir codée les lettre.
Le programme renvoie crée ensuit 2 fichier different 
le texte codée en lui meme 
un fichier alphabet que permettra de decoldée les fichier
Ces projet codée en java

classe présentes
    classe test
la classe test est le main du prgramme java et permet l'intencisatoion de tous les object dont nous avons besoin pour crée les fichier
celle si s'occupe aussi de lire le fihcier que sera codée par la suite et ecrire les fichier finaux qui vous seront retournée
il n'y a que dans cette classe que vous aurée a changée certaine paramettre pour que le programme marche

    classe texte
la classe texte permet de faire le trie dans les caractere du texte initale et de comptée le nombre d'occurence de chacune 


    classe arbre binaire 
la classe arbre binaire permet la creation d'object arbre binaire qui sont utils pour pouvoir recrée l'arbre entier

    classe arbre huffman
la classe arbre huffman quand a elle permet de crée entierement l'arbre binaire en partant de se feuille ainsi que de le parcourir 
elle permet aussi de calculer les gain de place entre les 2 version du fichier et le nombre moyen de bits sur les quel est codée un caractere


instaltion 
pour installer le programme , il suffie de telecharger les fichier git de la page et d'voir un interpreteur java sur sont orinateur afin de pouvoir les ouvrire


utilisation
pour pouvoir codée un fichier vous aller devoir cepedant touchée a la classe test (le main )
Vous devée simplment a la ligne 16 renseignée le chemin du fichier que vous voulée codée (attention les backslash doivent etre doublée )
pareillment a la ligne 77 et 78 vous devez renseignée le chemin (ainsi que le nom en soit) des 2 fichier qui seront crée pour contenir l'alphabets et le fichier codée 
une fois se 2 etpa faite il vous suffit simplment de lancée le programme

crédit
pour comprendre le codage j'ai utilisée 
cett video :
https://www.youtube.com/watch?v=Wfdv6854QTw

pour pouvoir faire le parcour de l'arbre je me suis grandement aidée de se document 
https://lewebpedagogique.com/isneiffel/files/2020/12/Codage_Huffman_El%C3%A8ves.pdf
je me suis servie de la cass avant le q8 pour reussir a raisonnée 
j'ai bien sur tous du reappliquer a mon programme (code montre origininelment en python)

