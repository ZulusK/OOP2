package zulus.lab3.abstractFabric;

import zulus.lab3.abstractFabric.plants.IPlant;
import zulus.lab3.abstractFabric.plants.PlantA;
import zulus.lab3.abstractFabric.plants.PlantB;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zulus on 23.02.18
 */
public class Competition {
    ArrayList<IPlant> plants;
    private static final int DIPLOMAT_ID = 0;
    private static final int WINNER_ID = 1;
    private static final int LOOSER_ID = 2;

    public Competition() {
        plants = new ArrayList<>();
        plants.add(new PlantA());
        plants.add(new PlantB());
    }

    private long countParticipants(List<Participant> participants, Participant.Type type) {
        return participants
                .stream()
                .filter((x) -> type.equals(x.getType())).count();
    }

    private long[][] selectBestCompanies(long d, long w, long l) {
        long[][] prices = new long[plants.size()][3];
        int i = 0;
        for (IPlant plant : plants) {
            prices[i][DIPLOMAT_ID] = d * plant.getCostOfDiploma();
            prices[i][WINNER_ID] = w * plant.getCostOfAward();
            prices[i][LOOSER_ID] = l * plant.getCostOfCertificate();
            i++;
        }
        return prices;
    }

    private IPlant[] selectBestPlants(long[][] prices, long budget) {
        IPlant bestPlants[] = {plants.get(0), plants.get(0), plants.get(0)};
        long bestCost = prices[0][WINNER_ID] + prices[0][LOOSER_ID] + prices[0][DIPLOMAT_ID];

        // search best combination of cheapest printers
        for (int dID = 0; dID < prices.length; dID++) {
            for (int wID = 0; wID < prices.length; wID++) {
                //calculate sub sum
                long sum = prices[dID][DIPLOMAT_ID] + prices[wID][WINNER_ID];
                for (int lID = 0; lID < prices.length; lID++) {
                    if (sum + prices[lID][LOOSER_ID] <= bestCost) {
                        bestCost = sum + prices[lID][LOOSER_ID];
                        if (plants.get(wID).compareToByAward(bestPlants[WINNER_ID]) >= 0) {
                            bestPlants[WINNER_ID] = plants.get(wID);
                        }
                        if (plants.get(lID).compareToByCertificate(bestPlants[LOOSER_ID]) >= 0) {
                            bestPlants[LOOSER_ID] = plants.get(lID);
                        }
                        if (plants.get(dID).compareToByDiploma(bestPlants[DIPLOMAT_ID]) >= 0) {
                            bestPlants[DIPLOMAT_ID] = plants.get(dID);
                        }
                    }
                }
            }
        }
        if (bestCost > budget) throw new IllegalArgumentException("Cannot reward participants, too little money");
        System.out.printf("We spend %d$: diplomat %s, winner %s looser %s\n",
                bestCost,
                bestPlants[DIPLOMAT_ID].getClass().getSimpleName(),
                bestPlants[WINNER_ID].getClass().getSimpleName(),
                bestPlants[LOOSER_ID].getClass().getSimpleName());
        return bestPlants;
    }

    private ArrayList<IPrize> printPrizes(IPlant[] bestPlants, List<Participant> participants) {
        ArrayList<IPrize> prizes = new ArrayList<>(participants.size());
        for (Participant participant : participants) {
            switch (participant.getType()) {
                case LOOSER:
                    prizes.add(bestPlants[LOOSER_ID].printCertificate(participant));
                    break;
                case WINNER:
                    prizes.add(bestPlants[WINNER_ID].printAward(participant));
                    break;
                case DIPLOMAT:
                    prizes.add(bestPlants[DIPLOMAT_ID].printDiploma(participant));
                    break;
            }
        }
        return prizes;
    }

    public List<IPrize> reward(List<Participant> participants, long budget) {
        if (budget <= 0) throw new IllegalArgumentException("Argument budget must be positive real number");
        if (participants == null) throw new IllegalArgumentException("Argument participants must be non-null value");
        long diplomats = countParticipants(participants, Participant.Type.DIPLOMAT);
        long winner = countParticipants(participants, Participant.Type.WINNER);
        long looser = countParticipants(participants, Participant.Type.LOOSER);

        return printPrizes(selectBestPlants(selectBestCompanies(diplomats, winner, looser), budget), participants);
    }


}
