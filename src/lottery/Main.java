package lottery;

public class Main {
    public static void main(String[] args) {
            Game game = Menu.start();
            System.out.println(game.toString());
            System.out.println(Menu.checkResults(game.getLottery(), game.getGamers()));}
}
