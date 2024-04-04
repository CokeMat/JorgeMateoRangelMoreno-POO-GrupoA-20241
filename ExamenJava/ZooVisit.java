import java.util.ArrayList;

public class ZooVisit {
    private Employee guide;
    private ArrayList<Visitant> visitantList;
    private String visitDate;
    private int numChild, numAdult;
    private double amount;
    private String ID;

    public ZooVisit(Employee guide, String visitDate, ArrayList<Visitant> visitantList, String ID) {
        this.guide = guide;
        guide.setActiveEmployee(true);
        this.visitDate = visitDate;
        this.visitantList = visitantList;
            for (Visitant visitant : visitantList) {
                visitant.setActiveVisitant(true);
            } 
        calculateNumAdult();
        calculateNumChild();
        calculateAmount();
        this.ID = ID;
    }

    //GETTERS AND SETTERS
    public Employee getGuide() {
        return guide;
    }
    public ArrayList<Visitant> getVisitantList() {
        return visitantList;
    }
    public double getAmount() {
        return amount;
    }
    public String getVisitDate() {
        return visitDate;
    }
    public int getNumChild() {
        return numChild;
    }
    public int getNumAdult() {
        return numAdult;
    }
    public String getID(){
        return this.ID;
    }

    public void activateVisitants(){
        for (Visitant visitant : this.visitantList) {
            visitant.setActiveVisitant(true);
        }
    }

    private void calculateNumAdult() {
        for (Visitant visitant : this.visitantList) {
            if (visitant.isAdult()) {
                this.numAdult++;
            }
        }
    }

    private void calculateNumChild() {
        this.numChild = this.visitantList.size() - numAdult;
    }

    private void calculateAmount() {
        for (Visitant visitant : this.visitantList) {
            visitant.addVisit();
                if(visitant.isAdult()){
                    if(visitant.getNumVisits() % 5 == 0){
                        this.amount += 80;
                    }
                    else{
                        this.amount += 100;
                    }
                }
                else{
                    this.amount += 50;
                }
        }
    }
}