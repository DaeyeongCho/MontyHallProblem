import java.util.Random;

public class Simulation {
    Random random = new Random();
    boolean changeDoor;
    int trials;
    public Simulation(boolean changeDoor, int trials) {
        this.changeDoor = changeDoor;
        this.trials = trials;
    }

    public void run() {
        boolean success;
        int successCount = 0;
        for(int i = 0; i < trials; i++) { //시행 횟수만큼 oneTry 반복
            success = oneTry();
            System.out.println(success);
            if(success == true) {
                successCount++;
            }
        }
        System.out.println(successCount + "/" + trials);
    }

    private boolean oneTry() { //한번 시행해주는 메소드
        PutOneCar doors = new PutOneCar(); //3개의 문 중 하나의 문에 슈퍼카를 숨기도록 하는 메소드
        int choice = random.nextInt(3); //3개 문 중 하나를 선택하는 메소드
        int openOne = -1; //사회자가 추가로 연 문

        for(int i = 0; i < 3; i++) { //실험자가 선택하지 않았고 슈퍼카가 들어있지 않은 문을 선택하는 메소드. (사회자가 추가로 여는 문 선택)
            if((i != choice) && (doors.whatIsThis(i) == false)) {
                openOne = i;
            }
        }

        if(changeDoor == true) { //선택을 바꾸는지 여부에 따라 다르게 분기하도록 함.
            for(int i = 0; i < 3; i++) {
                if(i != choice && i != openOne) {
                    return doors.whatIsThis(i);
                }
            }
            return false;
        } else {
            return doors.whatIsThis(choice);
        }
    }
}
