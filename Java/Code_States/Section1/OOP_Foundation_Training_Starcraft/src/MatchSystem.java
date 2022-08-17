import java.util.*;

public class MatchSystem {
    public static void main(String[] args){

        //입력 메서드 객체 호출
        Scanner scan = new Scanner(System.in);

        // 내 유닛 스텟 설정
        System.out.print("내 유닛의 이름을 지어주세요: ");
        String unitName = scan.next();
        System.out.print("내 유닛의 STR을 입력해주세요: ");
        int unitSTR = scan.nextInt();
        System.out.print("내 유닛의 DEF를 입력해주세요: ");
        int unitDEF = scan.nextInt();
        System.out.print("내 유닛의 명중률을 입력해주세요(0~100): ");
        int unitCri = scan.nextInt();
        System.out.print("내 유닛의 HP를 입력해주세요: ");
        int unitHP = scan.nextInt();

        // 나의 유닛 객체 생성 및 스텟 출력
        Unit myUnit = new Unit(unitName, unitSTR, unitDEF, unitCri, unitHP);
        myUnit.printMyStat();

        System.out.println("-------------------------------");

        // 적 유닛 스텟 설정
        System.out.print("상대 유닛의 이름을 지어주세요: ");
        unitName = scan.next();
        System.out.print("상대 유닛의 STR을 입력해주세요: ");
        unitSTR = scan.nextInt();
        System.out.print("상대 유닛의 DEF를 입력해주세요: ");
        unitDEF = scan.nextInt();
        System.out.print("상대 유닛의 명중률을 입력해주세요: ");
        unitCri = scan.nextInt();
        System.out.print("상대 유닛의 HP를 입력해주세요: ");
        unitHP = scan.nextInt();

        // 상대의 유닛 객체 생성 및 스텟 출력
        Unit enemyUnit = new Unit(unitName,unitSTR, unitDEF, unitCri, unitHP);
        enemyUnit.printMyStat();

        System.out.println("===============================================");
        // while문 돌리면서 턴 진행, 둘 중 하나가 죽으면 빠져나오기
        int cnt = 1;
        while(true){
            System.out.println("\n====== " + cnt++ + "번째 round 시작 ======");
            myUnit.attack(enemyUnit);
            if(enemyUnit.isGameOver()) {
                System.out.println(myUnit.name + "이(가) 이겼습니다!");
                break;
            }
            System.out.println("---------------------");
            enemyUnit.attack(myUnit);
            if(myUnit.isGameOver()) {
                System.out.println(enemyUnit.name + "이(가) 이겼습니다!");
                break;
            }
        }

    }
}

// 객체 생성 클래스
class Unit{
    public String name;
    public int str;
    public int def;
    public int cri;
    public int healthPoint;

    // 입력된 스텟에 따른 유닛 생성 생성자
    Unit (String name, int str, int def, int cri, int healthPoint){
        this.name = name;
        if(str <= 0) this.str = 1;
        else this.str = str;

        if(def < 0) this.def = 0;
        else this.def = def;

        if(cri >= 0 && cri <= 100) this.cri = cri;
        else this.cri = 0;

        if(healthPoint <= 0) this.healthPoint = 1;
        else this.healthPoint = healthPoint;
    }
    // 유닛 스텟 출력 메서드
    public void printMyStat(){
        System.out.println(this.name + "의 STR은 " + this.str + "입니다");
        System.out.println(this.name + "의 DEF는 " + this.def + "입니다");
        System.out.println(this.name + "의 명중률은 " + this.cri + "입니다");
        System.out.println(this.name + "의 HP는 " + this.healthPoint + "입니다");
    }
    
    // 상대유닛 공격 메서드
    public void attack(Unit enemy){
        String damagedPoint = "";
        int thisRoundStr = this.str;
        System.out.println(this.name + "이(가) "+ enemy.name + "을(를) 공격합니다");
        if(Math.random()*100 > (100 - this.cri)) {
            System.out.println(this.name+ "의 명중 공격!");
            thisRoundStr = this.str*2;
        }
        if(enemy.def > thisRoundStr) damagedPoint = "없음";
        else {
            enemy.healthPoint = enemy.healthPoint - (thisRoundStr - enemy.def);
            damagedPoint = Integer.toString(thisRoundStr - enemy.def);
        }
        System.out.println(enemy.name +"의 피해: " + damagedPoint);
        if(enemy.isGameOver()){
            System.out.println(enemy.name + "의 HP가 0이 되었습니다");
        }
        if(!enemy.isGameOver()) System.out.println(enemy.name + "의 남은 HP는 "+ enemy.healthPoint + "입니다");
    }
    
    // 매치 결판 여부 확인 메서드
    public boolean isGameOver(){
        if(this.healthPoint <= 0) return true;
        else return false;
    }
}