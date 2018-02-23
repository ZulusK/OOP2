package zulus.lab3;

import org.junit.jupiter.api.Test;
import zulus.lab3.abstractFabric.Competition;
import zulus.lab3.abstractFabric.IPrize;
import zulus.lab3.abstractFabric.ParticipantsLoader;

import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Created by zulus on 23.02.18
 */
/*
Організувати виробництво грамот для лауреатів міжшкільного
конкурсу, дипломів для дипломантів та грамот для всіх інших учасників на
основі використання шаблону «Абстрактна фабрика». Список учасників
конкурсу містить такі дані: школа та клас учня, а також місце яке він посів
(або примітка про присудження диплому конкурсу). Всі створені грамоти
повинні бути незалежними об’єктами. Поліграфічні фірми, які займаються
виготовленням продукції такого типу, відрізняються кількістю кольорів,
що використовуються при друці, якістю паперу та відповідно ціною на
послуги. Забезпечити у програмі вибір фірми з виготовлення грамот у
залежності від наявної суми грошей.
 */
public class AbstractFabricTest {

    Competition competition;
    ParticipantsLoader loader;

    public AbstractFabricTest() {
        competition = new Competition();
        loader = ParticipantsLoader.getInstance();
    }

    @Test
    void printPrizes() {
        int count = 10;
        int budget = 1_000_000;
        List<IPrize> prizeList = competition.reward(Arrays.asList(loader.getParticipants(count)), budget);
        assertNotNull(prizeList);
        assertEquals(prizeList.size(), count);
        prizeList.forEach(x -> System.out.println(x));
    }


    @Test
    void printPrizesTooLittleBudget() {
        int count = 10;
        int budget = 1;
        assertThrows(IllegalArgumentException.class, () -> competition.reward(Arrays.asList(loader.getParticipants(count)), budget));
    }

    @Test
    void printPrizesNullPointer() {
        int count = 10;
        int budget = 1;
        assertThrows(IllegalArgumentException.class, () -> competition.reward(null, budget));
    }
}
