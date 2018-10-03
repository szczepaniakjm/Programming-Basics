package lottery;

import java.util.ArrayList;
import java.util.List;


public class Game {
    private Lottery l;
    private List<Gamer> gamers;

    public Game(){}
    public Game(int gamersAmount){
        this.l = new Lottery();
        this.gamers = new ArrayList<>();
        for (int i = 0; i < gamersAmount; i++) {
            this.gamers.add(new Gamer());
        }
    }

    public Lottery getLottery() {
        return l;
    }

    public void setLottery(Lottery l) {
        this.l = l;
    }

    public List<Gamer> getGamers() {
        return gamers;
    }

    public void setGamers(List<Gamer> gamers) {
        this.gamers = gamers;
    }

    @Override
    public String toString() {
        return "Game:" + '\n' +
                l + '\n' + //lottery
                "Gamers:" + gamers +
                '}';
    }
}
