import java.util.Scanner;

public class MontyHallProblem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean changeDoor;
        int trials;
        System.out.print("바꿀지 여부(0:바꾸지 않음, 1:바꿈) 및 시행횟수 :");
        changeDoor = (scanner.nextInt() != 0) ? true : false;
        trials = scanner.nextInt();

        Simulation sim = new Simulation(changeDoor, trials);
        sim.run();

        scanner.close();
    }
}
