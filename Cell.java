public class Cell {
    private Mine mine;
    private String status;
    Cell(Mine mine){
        this.mine = mine;
        status = "x";
    }
    public boolean isMinePresent(){
        if(mine != null){
            return true;
        }
        return false;
    }
    public String getStatus(){
        return status;
    }
    public void setStatus(String status){
        this.status = status;
    }
}
