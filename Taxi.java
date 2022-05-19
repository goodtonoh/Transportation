public class Taxi {

    int taxiNum;
    int passenger;
    int gas;
    int speed;
    String where;
    int givenDistance;
    int toWhere;
    int basicFare;
    int chargeFare;
    int totalFare;
    Status taxiState;

    public Taxi(int taxiNum, int passenger, int gas, int speed, String where, int givenDistance, int toWhere, int basicFare, int chargeFare, int totalFare) {
        this.taxiNum = taxiNum;
        this.passenger = passenger;
        this.gas = gas;
        this.speed = speed;
        this.where = where;
        this.givenDistance = givenDistance;
        this.toWhere = toWhere;
        this.basicFare = basicFare;
        this.chargeFare = chargeFare;
        this.totalFare = totalFare;
    }
    public Taxi(int taxiNum) {
        this(taxiNum,0,0,0,"",100,0,1200,20,0);
    }
    enum Status {
        W("일반"), R("운행중"), P("차고지행");

        private final String name;

        Status(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }
    }

    public int getTaxiNum() {
        return taxiNum;
    }

    public int getPassenger() {
        return passenger;
    }

    public Status moveCar(int gas) {
        if (gas >=10) {
            this.gas = gas;
            this.taxiState = Status.W;
            System.out.println(taxiState.getName());
            System.out.println("주행가능!! 출발~~~");
        }
        else {
            this.gas = gas;
            this.taxiState = Status.P;
            System.out.println(taxiState.getName());
            System.out.println("탑승 불가 : 연료가 부족합니다.");
        }
        return taxiState;
    }

    public void takeTaxi(int passenger) {

        if (passenger > 0) {
            this.taxiState = Status.R;
            System.out.println(taxiState.getName());
        }
        else {
            this.taxiState = Status.W;
            System.out.println(taxiState.getName());
        }
        this.passenger = passenger;
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

    public void calculateFare(int toWhere) {

        if (toWhere <= givenDistance) { // 기본 거리 : 100
            totalFare = this.basicFare; // 기본 요금 : 1200
            System.out.println("기본 요금 입니다.");
            System.out.println(basicFare + " won");
        }
        else {
            //기본 거리 이상일때, 추가 요금 계산
            totalFare = basicFare + (toWhere - givenDistance) * chargeFare;
            System.out.println("최종 요금은 " + totalFare + " won 입니다.");
        }
    }

    public void showInfo() {
        System.out.println(this.taxiNum + "번 택시는 " + this.passenger + "명의 승객이 타고 있습니다. "
        + "\n" + "Have a good day~ :) ");
    }







}
