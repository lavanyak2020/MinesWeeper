public class Cell {
    private Mine mine;
    private char status;
    Cell(Mine mine){
        this.mine = mine;
        status = Constant.NOTEXPLORE;
    }
    public boolean checkStatus(char status){
        if(this.status == status){
            return true;
        }
        return false;
    }
    public boolean isMine(){
        if(mine != null){
            return true;
        }
        return false;
    }
    public char getStatus(){
        return status;
    }
    public void setStatus(char status){
        this.status = status;
    }
}
