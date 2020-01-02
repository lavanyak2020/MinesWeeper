import java.util.Scanner;

public class Minesweeper {
    private MineField mineField;
    Minesweeper(){
        initializeMineField();
    }

    public void startGame(){
        boolean win = true;
        while(!mineField.isAllFreeMinesExplored()){
            String input = getUserInput();
            char command = input.charAt(0);
            Coordinate point = new Coordinate(Integer.parseInt(input.substring(2,input.indexOf(","))),
                    Integer.parseInt(input.substring(input.indexOf(",")+1,input.indexOf(")"))));
            if(!mineField.exploreCell(point,command)){
                mineField.printMineField(point);
                win = false;
                break;
            }
            mineField.printMineField();
        }
        if(!win){
            System.out.println("Oops, you stepped on a mine ! Game over !");
        }else{
            System.out.println("Wow, you cleared the minefield ! Game Over !");
        }

    }

    private String getUserInput(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter option:");
        return scan.nextLine();
    }

    private void initializeMineField(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the minefield layout:");
        String layout = scan.nextLine();
        mineField = new MineField(layout);
    }
}
