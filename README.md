# kata-sgcib-tennis

Dans ce kata, vous vous focaliserez sur le score d'un set de Tennis.

La base:
<br>Dans le jeu du Tennis, les joueurs commencent avec un score de 0. Avec plusieurs échanges ils gagnent des points et donc gagnent des séquences (jeux) : <ul><li>0 -> 15 -> 30 -> 40</li></ul>
<br>Si un joueur a 40 et marque encore contre son adversaire alors il gagne le jeu tant que l'autre joueur n'a pas lui aussi 40 . Si les deux joueurs ont 40 points alors il y a "deuce".
 
<br><br>Deuce:
<br>Marquer durant "deuce" donne au joueur avantage . Si l'autre joueur marque aussi alors on retourne "deuce" à nouveau. Si un joueur a avantage et marque après alors ce joueur gagne le jeu.
 
<br><br>Prérequis:
<br>Ecrire un programme qui prend en compte ces éléments pour le tableau des score entre deux joueurs de Tennis.
<ul>
<li>Les joueurs doivent être capable de marquer des points.</li>
<li>Le set doit être fini avec un gagnant.</li>
<li>Le cas "deuce" doit être traité.</li>
<li>Le cas du tie-break en fin de set doit être traité.</li>
<li>Apres qu'une partie soit gagnée, le joueur gagnant doit être déterminé.</li>
<li>On doit pouvoir suivre le score de chaque joueurs à tout moment durant la partie.</li>
</ul>
