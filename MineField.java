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
        for(int cellXIndx = 0; cellXIndx < size; cellXIndx++){
            for(int cellYIndx = 0; cellYIndx < size; cellYIndx++){
                if(!isMine(new Coordinate(cellXIndx,cellYIndx)) && !cells[cellXIndx][cellYIndx].checkStatus(Constant.open)){
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
        if(command == Constant.open && isMine(point)){
            return false;
        }
        cells[point.getX()][point.getY()].setStatus(command);
        return true;
    }
    public void printMineField(){
        for(int cellXIndx = 0; cellXIndx < size ; cellXIndx++){
            for(int cellYIndx = 0; cellYIndx < size ; cellYIndx++){

                System.out.print(cells[cellXIndx][cellYIndx].getStatus());

            }
            System.out.println();
        }

    }
    public void printMineField(Coordinate point){
        for(int cellXIndx = 0; cellXIndx < size ; cellXIndx++){
            for(int cellYIndx = 0; cellYIndx < size ; cellYIndx++){
                if(point.equals(new Coordinate(cellXIndx,cellYIndx))){
                    System.out.print(Constant.mine);
                }else {
                        System.out.print(cells[cellXIndx][cellYIndx].getStatus());
                }
            }
            System.out.println();
        }
    }
    private void initializeMine(String[] mineField){
        int cellXIndx=0;
        Cell cell;
        for(String field: mineField){
            for(int charIndx = 0,cellYIndx=0; charIndx < size ; charIndx++){
                if(field.charAt(charIndx) == Constant.mine){
                    cell = new Cell(new Mine());
                }
                else {
                    cell = new Cell(null);
                }
                cells[cellXIndx][cellYIndx++] = cell;
            }
            cellXIndx++;
        }
    }
}
