import java.util.ArrayList;

public class Animal {
    private String name, animalType, foodType, foodFrecuency;
    private String birthdate, registerDate;
    private double weight;
    private ArrayList<String> diseases = new ArrayList<>();
    private boolean isVaccinated = false, activeAnimal = false;
    private String ID;

    public Animal(String name, String animalType, String foodType, String foodFrequency, double weight, String birthdate, String registerDate, 
        boolean isVaccinated, ArrayList<String> diseases, String ID) {
        this.name = name;
        this.animalType = animalType;
        this.foodType = foodType;
        this.foodFrecuency = foodFrequency;
        this.weight = weight;
        this.birthdate = birthdate;
        this.registerDate = registerDate;
        this.isVaccinated = isVaccinated;
        this.diseases = diseases;
        this.ID = ID;
    }

    
    //GETTERS AND SETTERS
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAnimalType() {
        return animalType;
    }
    public void setAnimalType(String typeAnimal) {
        this.animalType = typeAnimal;
    }
    public String getFoodType() {
        return foodType;
    }
    public void setFoodType(String typeFood) {
        this.foodType = typeFood;
    }
    public String getFoodFrecuency() {
        return foodFrecuency;
    }
    public void setFoodFrecuency(String foodFrecuence) {
        this.foodFrecuency = foodFrecuence;
    }
    public String getBirthdate() {
        return birthdate;
    }
    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }
    public String getRegisterDate() {
        return registerDate;
    }
    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }
    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }
    public ArrayList<String> getDiseases() {
        return diseases;
    }
    public void setDiseases(ArrayList<String> diseases) {
        this.diseases = diseases;
    }
    public boolean isVaccinated() {
        return isVaccinated;
    }
    public void setVaccinated(boolean isVaccinated) {
        this.isVaccinated = isVaccinated;
    }
    public String getID() {
        return ID;
    }
    public boolean isActiveAnimal() {
        return activeAnimal;
    }
    public void setActiveAnimal(boolean activeAnimal) {
        this.activeAnimal = activeAnimal;
    }
    
    public void showDiseasesList(){
        if(diseases.isEmpty()){
            System.out.println("\nThis animal doesn't have any diseases");
        }
        else{
            int n = 1;
            System.out.println("\n-------------------DISEASES LIST-------------------");
            for (String disease : diseases) {
                System.out.printf("\n%d. %s",n , disease );
                n++;
            }
        } 
    }
}