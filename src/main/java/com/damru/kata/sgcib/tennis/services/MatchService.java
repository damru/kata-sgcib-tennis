package com.damru.kata.sgcib.tennis.services;

import com.damru.kata.sgcib.tennis.enums.Point;
import com.damru.kata.sgcib.tennis.models.Jeu;
import com.damru.kata.sgcib.tennis.models.Joueur;
import com.damru.kata.sgcib.tennis.models.Match;
import com.damru.kata.sgcib.tennis.models.Set;
import org.springframework.stereotype.Service;

import static com.damru.kata.sgcib.tennis.enums.Point.*;

/**
 * Created by damien on 17/11/2016.
 */
@Service
public class MatchService {

    /**
     * Récupère le set en cours.
     * @param match
     * @return Set en cours
     */
    public Set getSetEnCours(Match match) {
        return match.getPartie().stream()
                .filter(set -> set.isEnCours())
                .findFirst()
                .get();
    }

    /**
     * Récupère le jeu en cours.
     * @param match
     * @return Jeu en cours
     */
    public Jeu getJeuEnCours(Match match) {
        return getSetEnCours(match).getJeux().stream()
                .filter(jeu -> jeu.isEnCours())
                .findFirst()
                .get();
    }

    /**
     * Lorsqu'un joueur marque un point, le match avance en fonction du score.
     * @param match
     * @param joueur
     */
    public void marquerPoint(Match match, Joueur joueur) {
        Jeu jeuEnCours = getJeuEnCours(match);
        Joueur adversaire = match.getJoueur1().equals(joueur) ?
                match.getJoueur2()
                : match.getJoueur1();
        Point scoreJoueur = jeuEnCours.getScores().get(joueur);
        Point scoreAdversaire = jeuEnCours.getScores().get(adversaire);

        switch (scoreJoueur) {
            case NUL:
                scoreJoueur = QUINZE;
                break;
            case QUINZE:
                scoreJoueur = TRENTE;
                break;
            case TRENTE:
                if (Point.QUARANTE.equals(scoreAdversaire)) {
                    scoreJoueur = DEUCE;
                    scoreAdversaire = DEUCE;
                } else {
                    scoreJoueur = QUARANTE;
                }
                break;
            case QUARANTE:
            case AVANTAGE:
                gagnerJeu(match, joueur);
                break;
            case DEUCE:
                scoreJoueur = AVANTAGE;
                scoreAdversaire = QUARANTE;
                break;
        }

        jeuEnCours.getScores().put(joueur, scoreJoueur);
        jeuEnCours.getScores().put(adversaire, scoreAdversaire);

    }

    /**
     * Récupère le nombre de jeux gagnés par un joueur dans le set en cours.
     * @param match
     * @param joueur
     * @return
     */
    public long getJeuxGagnes(Match match, Joueur joueur) {
        return getSetEnCours(match).getJeux().stream()
                .filter(jeu -> joueur.equals(jeu.getVainqueur()))
                .count();
    }

    /**
     * Lorsqu'un joueur gagne un jeu, le match avance en fonction du nombre de jeux gagnés.
     * @param match
     * @param joueur
     */
    private void gagnerJeu(Match match, Joueur joueur) {
        Jeu jeuEnCours = getJeuEnCours(match);
        jeuEnCours.setVainqueur(joueur);
        jeuEnCours.setEnCours(false);

        Jeu nouveauJeau = new Jeu();
        nouveauJeau.setEnCours(true);
        nouveauJeau.getScores().put(match.getJoueur1(), Point.NUL);
        nouveauJeau.getScores().put(match.getJoueur2(), Point.NUL);
        getSetEnCours(match).getJeux().add(nouveauJeau);
    }

    /**
     * Récupère le score courant d'un joueur.
     * @param match
     * @param joueur
     * @return
     */
    public Point getScore(Match match, Joueur joueur) {
        return getJeuEnCours(match).getScores().get(joueur);
    }
}
