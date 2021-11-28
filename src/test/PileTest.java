package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.Pile;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PileTest {

    private Pile<Integer> pile;

    /**
     * Initialise la pile de test avant chaque test pour qu'elle contienne depuis le sommet: 1 2 3
     */
    @BeforeEach
    private void init() {

        pile = new Pile<>();
        pile.empiler(3);
        pile.empiler(2);
        pile.empiler(1);

    }

    /**
     * Essaie d'empiler une donnée sur la pile
     */
    @Test
    void assertEmpiler() {
        pile.empiler(589);
        Iterator<Integer> it = pile.iterator();
        assertEquals(589, it.next());
    }

    /**
     * test la fomnction desempiler() de la pile
     */
    @Test
    void assertDesempiler() {
        assertEquals(1, pile.desempiler());
        assertEquals(2, pile.desempiler());
        assertEquals(3, pile.desempiler());
    }

    /**
     * Vérifie que la pile lance une exception si on tente de désempiler une pile vide
     */
    @Test
    void assertDesempilerLanceExceptionSiVide() {
        pile = new Pile<>();
        assertThrows(EmptyStackException.class, () -> pile.desempiler());
    }

    /**
     * Test la boucle foreach sur la pile et vérifie que toutes les données soient traitées
     */
    @Test
    void assertForAmelioree() {
        ArrayList<Integer> pileVerification = new ArrayList<>();

        for (Integer i : pile) {
            pileVerification.add(i);
        }

        assertEquals(1, pileVerification.get(0));
        assertEquals(2, pileVerification.get(1));
        assertEquals(3, pileVerification.get(2));

        // Vérifie qu'il n'y a pas plus de données dans le résultat que ce qu'il y a dans la pile
        assertThrows(IndexOutOfBoundsException.class, () -> pileVerification.get(3));
    }

    /**
     * Test la fonction toArray de la pile
     */
    @Test
    void assertToArrayWorks() {
        Integer[] tableau = pile.toArray(Integer.class);
        assertEquals(1, tableau[0]);
        assertEquals(2, tableau[1]);
        assertEquals(3, tableau[2]);

        // Vérifie qu'il n'y ait pas plus de données dans le résultat que ce qu'il y a dans la pile
        assertThrows(IndexOutOfBoundsException.class, () -> {
            int valInexistante = tableau[3];
        });
    }

    /**
     * Test la fonction .toString()
     */
    @Test
    void assertToStringWorksPileVide() {
        pile = new Pile<>();
        assertEquals("[]", pile.toString());
    }

    /**
     * Test la fonction string et son retour
     */
    @Test
    void assertToStringWorks() {
        assertEquals("[1, 2, 3]", pile.toString());
    }

}