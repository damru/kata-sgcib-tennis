import com.damru.kata.sgcib.tennis.enums.Point;
import com.damru.kata.sgcib.tennis.models.Joueur;
import com.damru.kata.sgcib.tennis.models.Match;
import com.damru.kata.sgcib.tennis.models.Set;
import com.damru.kata.sgcib.tennis.models.TieBreak;
import com.damru.kata.sgcib.tennis.services.MatchService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.stream.IntStream;

import static junit.framework.TestCase.assertTrue;

/**
 * Created by damien on 17/11/2016.
 */

@ContextConfiguration(locations = {"file:src/main/resources/applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class TestMatch {

    @Autowired
    private MatchService matchService;

    private Match match;

    private Joueur john;

    private Joueur jane;

    @Before
    public void init() {
        john = new Joueur("John", "Doe");
        jane = new Joueur("Jane", "Doe");
        match = new Match(jane, john);
    }

    @Test
    public void testScore15Points() {
        matchService.marquerPoint(match, john);
        assertTrue(Point.QUINZE.equals(matchService.getScore(match, john)));
    }

    @Test
    public void testScore30Points() {
        matchService.marquerPoint(match, john);
        matchService.marquerPoint(match, john);
        assertTrue(Point.TRENTE.equals(matchService.getScore(match, john)));
    }

    @Test
    public void testScore40Points() {
        IntStream.rangeClosed(1, 3).forEach((Integer) -> {
            matchService.marquerPoint(match, john);
        });
        assertTrue(Point.QUARANTE.equals(matchService.getScore(match, john)));
    }

    @Test
    public void testScoreDeuce() {
        IntStream.rangeClosed(1, 3).forEach((Integer) -> {
            matchService.marquerPoint(match, john);
            matchService.marquerPoint(match, jane);
        });

        assertTrue(Point.DEUCE.equals(matchService.getScore(match, john)));
        assertTrue(Point.DEUCE.equals(matchService.getScore(match, jane)));
    }


    @Test
    public void testScoreAvantage() {
        IntStream.rangeClosed(1, 3).forEach((Integer) -> {
            matchService.marquerPoint(match, john);
            matchService.marquerPoint(match, jane);
        });

        matchService.marquerPoint(match, jane);

        assertTrue(Point.AVANTAGE.equals(matchService.getScore(match, jane)));
        assertTrue(Point.QUARANTE.equals(matchService.getScore(match, john)));
    }

    @Test
    public void testGagnerJeu() {
        gagnerUnJeu(match,jane);
        assertTrue(matchService.getJeuxGagnes(match, jane) == 1);
    }

    @Test
    public void testGagnerSet() {
        Set setEnCours = matchService.getSetEnCours(match);
        gagnerUnSet(match,jane);

        assertTrue(matchService.getJeuxGagnes(setEnCours, jane) == 6);
        assertTrue(jane.equals(setEnCours.getVainqueur()));
    }

    @Test
    public void testGagnerTieBreak() {
        Set setEnCours = matchService.getSetEnCours(match);
        // Gagner 6 jeux chacun
        IntStream.rangeClosed(1, 6).forEach((Integer) -> {
            gagnerUnJeu(match, john);
            gagnerUnJeu(match, jane);
        });
        //Il y a 6 jeux partout, le jeu en cours est un tie-break
        assertTrue(matchService.getJeuEnCours(match) instanceof TieBreak);

        // Gagner le tie break pour gagner le set
        IntStream.rangeClosed(1, 7).forEach((Integer) -> {
            matchService.marquerPoint(match, jane);
        });

        assertTrue(matchService.getJeuxGagnes(setEnCours, jane) == 7);
        assertTrue(jane.equals(setEnCours.getVainqueur()));
        assertTrue(match.getPartie().size() == 2 );
    }

    @Test
    public void testGagnerMatchNormal() {
        IntStream.rangeClosed(1, match.getNbSetsGagnants()).forEach((Integer) -> {
            gagnerUnSet(match,jane);
        });

        assertTrue(jane.equals(match.getVainqueur()));
    }

    @Test
    public void testGagnerMatch15A13() {
        // gagner x sets chacun afin d'arriver au dernier set
        IntStream.rangeClosed(1, match.getNbSetsGagnants()-1).forEach((Integer) -> {
            gagnerUnSet(match,jane);
            gagnerUnSet(match,john);
        });
        assertTrue(match.getPartie().size() == (match.getNbSetsGagnants()*2)-1 );
        assertTrue(matchService.getSetsGagnes(match,john) == match.getNbSetsGagnants()-1);
        assertTrue(matchService.getSetsGagnes(match,jane) == match.getNbSetsGagnants()-1);

        // stocker le dernier set pour les prochaines assertions
        Set dernierSet = matchService.getSetEnCours(match);
        // puis arriver a 13 jeux partout
        IntStream.rangeClosed(1, 13).forEach((Integer) -> {
            gagnerUnJeu(match,jane);
            gagnerUnJeu(match,john);
        });
        assertTrue(matchService.getJeuxGagnes(dernierSet,john) == 13);
        assertTrue(matchService.getJeuxGagnes(dernierSet,jane) == 13);

        // Enfin, faire gagner 2 jeux supplémentaires à un joueur pour terminer le match
        gagnerUnJeu(match,john);
        gagnerUnJeu(match,john);

        assertTrue(matchService.getJeuxGagnes(dernierSet,john) == 15);
        assertTrue(john.equals(match.getVainqueur()));
    }

    /****************************************************
     * Fonctions utiles
     ***************************************************/

    /**
     * Faire Gagner un jeu à un joueur.
     * @param match
     * @param joueur
     */
    private void gagnerUnJeu(Match match, Joueur joueur) {
        IntStream.rangeClosed(1, 4).forEach((Integer) -> {
            matchService.marquerPoint(match, joueur);
        });
    }

    /**
     * Faire Gagner un set à un joueur.
     * @param match
     * @param joueur
     */
    private void gagnerUnSet(Match match, Joueur joueur) {
        IntStream.rangeClosed(1, 6).forEach((Integer) -> {
            gagnerUnJeu(match, joueur);
        });
    }
}
