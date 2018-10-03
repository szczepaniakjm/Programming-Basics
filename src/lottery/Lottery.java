package lottery;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Lottery {
    private List<Integer> list;
    protected List<Integer> getList() {
        return list;
    }
    protected void setList(List<Integer> list) {
        this.list = list;
    }
    protected Lottery(){
        list = draw();
    }

    private List<Integer> draw() {
        Random r = new Random();
        List<Integer> l = new ArrayList<>();
        while (l.size() != 6){
            Integer a = r.nextInt(49) + 1;
            if (l.isEmpty()) {
                l.add(a);
            } else if (l.stream().noneMatch(x -> x.equals(a))) {
                l.add(a);
            }
        }
        return l;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lottery lottery = (Lottery) o;
        return Objects.equals(list, lottery.list);
    }

    @Override
    public int hashCode() {

        return Objects.hash(list);
    }

    @Override
    public String toString() {
        return "Lottery numbers: " + list;
    }
}
