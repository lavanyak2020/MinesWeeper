public class MineField {
    private int size;
    private Cell[][] cells;

    MineField(String mineFieldLayout){
        String[] mineField = mineFieldLayout.split(",");
        this.size = mineField[0].length();
        cells = new Cell[size][size];
        initializeMine(mineField);
    }

    int getSize(){
        return size;
    }
    public boolean isAllFreeMinesExplored(){
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(!isMine(new Coordinate(i,j)) && !cells[i][j].getStatus().equals("f")){
                    return false;
                }
            }
        }
        return true;
    }
    private boolean isMine(Coordinate point){

        return cells[point.getX()][point.getY()].isMinePresent();
    }
    public boolean exploreCell(Coordinate point,char command){
        if(command == 'o' && isMine(point)){
            return false;
        }
        if(command == 'o'){
            cells[point.getX()][point.getY()].setStatus("0");
        }else{
            cells[point.getX()][point.getY()].setStatus("f");
        }

        return true;
    }
    public void printMineField(){
        for(int i = 0; i < size ; i++){
            for(int j = 0; j < size ; j++){
                if(cells[i][j].getStatus() == null){
                    System.out.print("X");
                }else{
                        System.out.print(cells[i][j].getStatus());
                }
            }
            System.out.println();
        }

    }
    public void printMineField(Coordinate point){
        for(int i = 0; i < size ; i++){
            for(int j = 0; j < size ; j++){
                if(point.equals(new Coordinate(i,j))){
                    System.out.print("m");
                }else {
                    if(cells[i][j].getStatus() == null){
                        System.out.print("X");
                    }else{
                        System.out.print(cells[i][j].getStatus());
                    }
                }
            }
            System.out.println();
        }
    }
    private void initializeMine(String[] mineField){
        int i=0;
        Cell cell;
        for(String field: mineField){
            for(int pos = 0,j=0; pos < size ; pos++){
                if(field.charAt(pos) == 'm'){
                    cell = new Cell(new Mine());
                }
                else {
                    cell = new Cell(null);
                }
                cells[i][j++] = cell;
            }
            i++;
        }
    }
}
