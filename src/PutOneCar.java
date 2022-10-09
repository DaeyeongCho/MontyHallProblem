import java.util.Random;

public class PutOneCar { //3 중 하나의 true를 갖고 있는 객체 생성
    Random random = new Random();
    private boolean[] threeDoors = {false, false, false};
    public PutOneCar() {
        threeDoors[random.nextInt(3)] = true;
    }

    public boolean whatIsThis(int n) {
        return threeDoors[n];
    }
}
