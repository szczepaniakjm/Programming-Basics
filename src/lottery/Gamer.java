package lottery;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Gamer {
    private List<Integer> numbers;

    protected List<Integer> getNumbers() {
        return numbers;
    }

    protected void setNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }
    protected Gamer(){
        numbers = new ArrayList<>(6);
        Random r = new Random();
        while (numbers.size() != 6) {
            Integer a = r.nextInt(49) + 1;
            if (numbers.size() == 0) {
                numbers.add(a);
            } else if (numbers.stream().noneMatch(x -> x.equals(a))) {
                numbers.add(a);
            }
        }
    }
    protected Gamer(String filename) {
        try {
            FileReader fr = new FileReader(filename);
            Scanner sc = new Scanner(fr);
            numbers = new ArrayList<>(6);
            while (numbers.size() != 6 && sc.hasNext()) {
                Integer a = sc.nextInt();
                if (numbers.size() == 0) {
                    numbers.add(a);
                } else if (numbers.stream().noneMatch(x -> x.equals(a))) {
                    numbers.add(a);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    protected long commonAmount(List<Integer> numbers) {
        List<Integer> copy = new ArrayList<>(numbers);
        copy.retainAll(this.numbers);
        return copy.size();
    }

    @Override
    public String toString() {
        return "Gamer{" +
                "numbers=" + numbers +
                '}';
    }
}
