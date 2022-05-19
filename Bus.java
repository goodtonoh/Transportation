public class Bus {
    int busNum, passenger, gas, speed;
    String busState;

    public Bus(int busNum, int passenger, int gas, int speed, String busState) {
        this.busNum = busNum;
        this.passenger = passenger;
        this.gas = gas;
        this.speed = speed;
        this.busState = busState;

    }

    /*
    public Bus (int busNum, int passenger, int gas, int speed, String busState) {
        this(busNum, passenger, gas, speed, busState);
    }
    */

    enum Status {
        R("운행중"), P("차고지행");

        private final String name;

        Status(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }
    }

    public void checkGas(int gas) {

        this.gas = gas;
        if(gas >= 10) {
            this.busState = String.valueOf(Status.R);
            System.out.println("운행중");
            System.out.println("현재 주유량이 충분합니다.");
        }
        else {
            this.busState = String.valueOf(Status.P);
            System.out.println("차고지행");
            System.out.println("주유가 필요합니다.");
        }
    }

    public void getSpeed(int speed) {

        if (speed > 0) {
            this.speed += speed;
            System.out.println("속도 증가");
            System.out.println("현재 속도는 " + this.speed + " 입니다.");
        }
        else if (speed < 0) {
            this.speed += speed;
            System.out.println("속도 감소");
            System.out.println("현재 속도는 " + this.speed + " 입니다.");
        }
    }

    public void takeBus(int passenger) {

        // this.passenger++;

        if(passenger >= 11) {
            this.passenger += passenger;
            System.out.println("삐빅 - 정원을 초과 하였습니다.");
        }
        else {
            this.passenger += passenger;
            System.out.println("탑승완료 - " + "현재 탑승객은 " + this.passenger + " 명 입니다.");
        }
    }

    public int getBusNum() {
        return busNum;
    }

    public int getPassenger() {
        return passenger;
    }

    public void showInfo() {
        System.out.println("버스 " + this.getBusNum() + "는 " + this.getPassenger() + " 명의 승객을 태웠습니다.");
    }

}