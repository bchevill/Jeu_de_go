Jeu_de_go
=========

Olivier NGUYEN
Geoffray MENUDIER
Bertille CHEVILLOTTE
Cedric ANDO

Implémente une version simplifiée du jeu de go, jouable en console.


Nous avons parfois dû désactiver sonar pour certaintes lignes de codes. Voici les raisons:

! Dans certaines méthodes, nous avons ajouté //NOSONAR sur les lignes contenant des appels à println() car Sonarqube exigeait d'utiliser un logger. Nous avons effectivement utilisé des logger lorsque cela était approprié, mais ici il ne s'agit pas d'informations relatives au débug, il s'agit de l'interface utilisateur. L'utilisation des println est donc appropriée.

! Le constructeur de la classe GroupeDePierres utilise une LinkedList. Sonar demande de la déclarer sous la forme d'une collection List maliste = new LinkedList [...]. Cela ne convient pas car nous utilisons les méthodes push et pop de LinkedList, ainsi déclarer un élément de type List crée un problème de compilation (List n'a pas ces méthodes)

! Dans la méthode estACoteDe de la classe Pierre, SONAR se plaint du trop grand nombre de conditions. Il n'y a pas de partition logique de cette grosse condition en sous fonctions qui aurait du sens ou accroîtrait sa lisibilité.