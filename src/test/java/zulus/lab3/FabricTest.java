package zulus.lab3;

import org.junit.jupiter.api.Test;
import zulus.lab3.fabricMethod.*;

import java.util.LinkedList;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Created by zulus on 23.02.18
 */
public class FabricTest {
    CardFabric fabric;

    public FabricTest() {
        fabric = CardFabric.getInstance();
    }


    @Test
    void TestFabricSuitClovers() {
        Dignity dignity = Dignity.FIVE;
        String suit = "clovers";
        ICard card = (fabric.createCard(dignity, suit));
        assertNotNull(card);
        assertTrue(card instanceof CloversCard);
        assertEquals(card.getSuit().toLowerCase(), suit);
    }

    @Test
    void TestFabricSuitPikes() {
        Dignity dignity = Dignity.ONE;
        String suit = "pikes";
        ICard card = (fabric.createCard(dignity, suit));
        assertNotNull(card);
        assertTrue(card instanceof PikesСard);
        assertEquals(card.getSuit().toLowerCase(), suit);
    }

    @Test
    void TestFabricSuitTiles() {
        Dignity dignity = Dignity.QUEEN;
        String suit = "tiles";
        ICard card = (fabric.createCard(dignity, suit));
        System.out.println(card);
        assertNotNull(card);
        assertTrue(card instanceof TilesCard);
        assertEquals(card.getSuit().toLowerCase(), suit);
    }

    @Test
    void TestFabricSuitHearts() {
        Dignity dignity = Dignity.EIGHT;
        String suit = "hearts";
        ICard card = (fabric.createCard(dignity, suit));
        assertNotNull(card);
        assertTrue(card instanceof HeartsCard);
        assertEquals(card.getSuit().toLowerCase(), suit);
    }

    @Test
    void TestFabricNull() {
        assertThrows(IllegalArgumentException.class, () -> fabric.createCard(Dignity.JACK, "aaa"));
    }

    @Test
    void createAllCards() {
        String suits[] = {"hearts", "pikes", "tiles", "clovers"};
        LinkedList<ICard> cards = new LinkedList<>();
        for (String suit : suits) {
            for (Dignity dignity : Dignity.values()) {
                cards.add(fabric.createCard(dignity, suit));
            }
        }
        assertEquals(cards.size(), 56);
        cards.forEach((x) -> System.out.println(x));
    }
}
