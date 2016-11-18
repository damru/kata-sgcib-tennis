# kata-sgcib-tennis

Dans ce kata, vous vous focaliserez sur le score d'un set de Tennis.

## La base
Dans le jeu du Tennis, les joueurs commencent avec un score de 0. Avec plusieurs échanges ils gagnent des points et donc gagnent des séquences (jeux) : 
* 0 -> 15 -> 30 -> 40
* Si un joueur a *__40__* et marque encore contre son adversaire alors il gagne le jeu tant que l'autre joueur n'a pas lui aussi 40.
* Si les deux joueurs ont *__40__* alors il y a *__deuce__*.
 
## Deuce 
Marquer durant *__deuce__* donne au joueur *__avantage__* . Si l'autre joueur marque aussi alors on retourne *__deuce__* à nouveau. Si un joueur a *__avantage__* et marque après alors ce joueur __gagne le jeu__.
 
## Prérequis
Ecrire un programme qui prend en compte ces éléments pour le tableau des score entre deux joueurs de Tennis.
* Les joueurs doivent être capable de __marquer des points__.
* Le set doit être __fini avec un gagnant__.
* Le cas __*deuce* doit être traité__.
* Le cas du __*tie-break* en fin de set doit être traité__.
* Apres qu'une partie soit gagnée, le joueur __gagnant doit être déterminé__.
* On doit pouvoir __suivre le score de chaque joueurs à tout moment durant la partie__.
