import java.util.Scanner;

public class Minesweeper {
    private MineField mineField;
    Minesweeper(){
        initializeMineField();
    }

    public void startGame(){
        boolean win = true;
        while(!mineField.isGameEnd()){
            String input = getUserInput();
            char command = input.charAt(0);
            Coordinate point = parseInput(input);
            if(isAlreadyDone(point,command)){
                continue;
            }
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

    private boolean isAlreadyDone(Coordinate point, char command) {
        if(mineField.isExplored(point,command)){
            if(command == Constant.OPEN){
                System.out.println("You have already opened the cell");
            }else{
                System.out.println("You have already flagged the cell");
            }
            return true;
        }
        return false;

    }

    private String getUserInput(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter option:");
        return scan.nextLine();
    }
    private Coordinate parseInput(String string){
        return new Coordinate(Integer.parseInt(string.substring(2,string.indexOf(","))),
                Integer.parseInt(string.substring(string.indexOf(",")+1,string.indexOf(")"))));
    }

    private void initializeMineField(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the minefield layout:");
        String layout = scan.nextLine();
        mineField = new MineField(layout);
    }
}
