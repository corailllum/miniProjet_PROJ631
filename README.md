# miniProjet_PROJ631
Le codage de huffman permet de faire une compression de fichier texte en fonction du nombre d'occurence des lettres de ce fichier. Les lettres 
ainsi codées prennent la forme d'un nombre binaire. Pour ce faire, l'algorithime construit un arbre binaire en fonction du nombre d'iteration de chaque lettre et le parcours pour pouvoir coder les lettres.
Le programme créé renvoie ensuite 2 fichiers differents:  
le texte codé, ainsi qu'un fichier alphabet qui permettra de decoder les fichiers

Ce projet est codé en java

classes présentes
    classe test
la classe test est le 'main' du programme java et permet l'instenciantion de tous les object dont nous avons besoins pour créer les fichiers
celle-ci s'occupe aussi de lire le fichier qui sera codé par la suite et écrire les fichier finnaux qui seront retournés
il n'y a que dans cette classe que vous aurez à changer certains paramettres pour que le programme fonctionne.

    classe texte
la classe texte permet de faire le tri dans les caractères du texte inital et de compter le nombre d'occurences de chacune 


    classe arbre binaire 
la classe arbre binaire permet la creation d'objects "arbre binaire" qui sont utilsés pour pouvoir recrer l'arbre entier

    classe arbre huffman
la classe arbre huffman quand a elle permet de crée entierement l'arbre binaire en partant de se feuille ainsi que de le parcourir.
Elle permet aussi de calculer les gain de place entre les 2 version du fichier et le nombre moyen de bits sur les quel est codée un caractere.


instalation 
pour installer le programme , il suffit de télécharger les fichiers git de la page et d'avoir un interpreteur java sur sont ordinateur afin de pouvoir les éditer et les executer.


utilisation
pour pouvoir coder un fichier vous aller devoir cependant modifier la classe test (le main )
Vous devez simplement à la ligne 16, renseigner le chemin du fichier que vous voulez coder (attention les backslash doivent etre doublée )
pareillment aux ligne 77 et 78 vous devez renseigner le chemin (ainsi que le nom) des 2 fichiers qui seront crées pour contenir l'alphabet et le fichier codé. 
Une fois ces 2 étapes faites il vous suffit simplment de lancer le programme.

crédit
pour comprendre le codage j'ai utilisée 
cette video :
https://www.youtube.com/watch?v=Wfdv6854QTw

pour pouvoir faire le parcour de l'arbre je me suis grandement aidée de se document 
https://lewebpedagogique.com/isneiffel/files/2020/12/Codage_Huffman_El%C3%A8ves.pdf
je me suis servie de la case avant la q8 pour reussir à raisonner 
j'ai bien sur tout du réappliquer à mon programme (code montré originellement en python)