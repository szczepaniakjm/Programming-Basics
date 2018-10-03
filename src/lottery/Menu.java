package lottery;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Menu {
    public static Game start(){
        System.out.println("NEW GAME");
        Scanner sc = new Scanner(System.in);
        int amountOfPlayers;
        do {
            System.out.println("Give the amount of the players");
            amountOfPlayers = sc.nextInt();
        } while(amountOfPlayers <= 0);
        return new Game(amountOfPlayers);
    }
    public static Map<Long,Integer> checkResults(Lottery l, List<Gamer>gamers){
        Map<Long,Integer> results = new LinkedHashMap<>();
        for (Gamer g : gamers) {
            Long a = g.commonAmount(l.getList());
            if (results.containsKey(a)){
                results.put(a, results.get(a)+1);
            } else {
                results.put(a, 1);
            }
        }
        System.out.println("\nGame statistics:\n"+"Amount of gamers with the particular hits:\n" + "{Hits=Amount}");
        return results;
    }
}
