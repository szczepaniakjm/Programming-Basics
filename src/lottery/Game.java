package lottery;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Lottery l;
    private List<Gamer> gamers;

    protected Game(){}
    protected Game(int gamersAmount){
        this.l = new Lottery();
        this.gamers = new ArrayList<>();
        for (int i = 0; i < gamersAmount; i++) {
            this.gamers.add(new Gamer());
        }
    }

    protected Lottery getLottery() {
        return l;
    }

    protected void setLottery(Lottery l) {
        this.l = l;
    }

    protected List<Gamer> getGamers() {
        return gamers;
    }

    protected void setGamers(List<Gamer> gamers) {
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
