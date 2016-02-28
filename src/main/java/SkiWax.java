import java.util.Scanner;

/**
 * Created by michaelbathon on 1/29/16.
 */
public class SkiWax {

    public static void main(String[] args) {
        Wax wax = new Wax();

        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the the temperature: ");
        int temp = sc.nextInt();
        String nlineHolder = sc.nextLine();

        System.out.println("Please enter the snow conditions: ");
        String snow = sc.nextLine();

        wax.selectWax(temp, snow);


        System.out.println("We recommend you use the " + wax.getWaxGroup() + " for " + wax.getSnowConditions() + " snow conditions.");
    }


}

class Wax{

    private WaxColor waxGroup;
    private WaxVariety snowConditions;

    public WaxColor getWaxGroup() {
        return waxGroup;
    }

    public void setWaxGroup(WaxColor waxGroup) {
        this.waxGroup = waxGroup;
    }

    public WaxVariety getSnowConditions() {
        return snowConditions;
    }

    public void setSnowConditions(WaxVariety snowConditions) {
        this.snowConditions = snowConditions;
    }


    enum WaxColor{
        YELLOW, RED, VIOLET, BLUE, GREEN, WHITE

    }

    enum WaxVariety{
        SPECIAL, STANDARD, EXTRA
    }

    public void selectWax(int temp, String x){

        if(temp > 38){
            this.setWaxGroup(WaxColor.YELLOW);
            this.setSnowConditions(WaxVariety.STANDARD);
        }
        else if(31 < temp && temp <= 38){
            this.setWaxGroup(WaxColor.RED);
            selectWaxVariety(x);
        }
        else if(26 < temp  && temp <= 31){
            this.setWaxGroup(WaxColor.VIOLET);
            selectWaxVariety(x);
        }
        else if(18 < temp && temp <= 26){
            this.setWaxGroup(WaxColor.BLUE);
            selectWaxVariety(x);
        }
        else if(5 < temp && temp <= 18){
            this.setWaxGroup(WaxColor.GREEN);
            selectWaxVariety(x);
        }
        else if(temp <= 5){
            this.setWaxGroup(WaxColor.WHITE);
            this.setSnowConditions(WaxVariety.STANDARD);
        }


        }

    public void selectWaxVariety(String snowCondition){
        switch(snowCondition.toUpperCase()){
            case "POWDER":
                this.setSnowConditions(WaxVariety.SPECIAL);
                break;
            case "FIRM":
                this.setSnowConditions(WaxVariety.STANDARD);
                break;
            case "CRUSTY":
                this.setSnowConditions(WaxVariety.EXTRA);
                break;
            default:
                this.setSnowConditions(WaxVariety.STANDARD);
        }
    }

}

