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
    public boolean isGameEnd(){
        for(int cellXIndx = 0; cellXIndx < size; cellXIndx++){
            for(int cellYIndx = 0; cellYIndx < size; cellYIndx++){
                if(cells[cellXIndx][cellYIndx].isMine()){
                    if(!cells[cellXIndx][cellYIndx].checkStatus(Constant.FLAG)){
                        return false;
                    }
                }
                else{
                    if(!cells[cellXIndx][cellYIndx].checkStatus(Constant.OPEN)){
                        return false;
                    }
                }

            }
        }
        return true;
    }

    public boolean exploreCell(Coordinate point,char command){
        if(command == Constant.OPEN && cells[point.getX()][point.getY()].isMine()){
            return false;
        }
        cells[point.getX()][point.getY()].setStatus(command);
        return true;
    }
    public boolean isExplored(Coordinate point,char command){
        if(cells[point.getX()][point.getY()].checkStatus(Constant.FLAG) && command == Constant.FLAG){
                return true;
        }
        if(cells[point.getX()][point.getY()].checkStatus(Constant.OPEN) && command == Constant.OPEN){
                return true;
        }
        return false;
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
                    System.out.print(Constant.MINE);
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
                if(field.charAt(charIndx) == Constant.MINE){
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
