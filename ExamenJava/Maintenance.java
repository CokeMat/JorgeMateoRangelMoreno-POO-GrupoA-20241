import java.util.Scanner;

public class Maintenance {
    private String action, date, observation, animalID;
    private Employee maintenanceEmployee;
    private String ID;
    Scanner sc = new Scanner(System.in);

    public Maintenance(Employee maintenanceEmployee, String date, String action, String animalID, String observation, String ID) {
        this.maintenanceEmployee = maintenanceEmployee;
        maintenanceEmployee.setActiveEmployee(true);
        this.action = action;
        this.date = date;
        this.observation = observation;
        this.animalID = animalID;
        this.ID = ID;
    }

    public String getAction() {
        return action;
    }
    public void setAction(String action) {
        this.action = action;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getObservation() {
        return observation;
    }
    public void setObservation(String observation) {
        this.observation = observation;
    }
    public String getAnimalID() {
        return animalID;
    }
    public Employee getMaintenanceEmployee() {
        return maintenanceEmployee;
    }
    public void setMaintenanceEmployee(Employee maintenanceEmployee) {
        this.maintenanceEmployee = maintenanceEmployee;
    }
    public String getID() {
        return ID;
    }
}