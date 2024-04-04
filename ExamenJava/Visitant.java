import java.util.Random;

public class Visitant {
    private String name, lastNameF, lastNameM, curp, sex;
    private String birthdate, registerDate;
    private String ID;
    private int numVisits, age;
    private boolean activeVisitant;
    private Random ran = new Random();

    public Visitant(String name, String lastNameF, String lastNameM, String birthdate, String registerDate, String sex, String ID) {
        this.name = name.toUpperCase();
        this.lastNameF = lastNameF.toUpperCase();
        this.lastNameM = lastNameM.toUpperCase();
        this.birthdate = birthdate;
        this.registerDate = registerDate;
        this.numVisits = 0;
        this.sex = sex;
        this.age = calculateAge();
        this.activeVisitant = false;
        this.curp = generateCURP();
        this.ID = ID;
    }

    //GETTERS AND SETTERS
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name.toUpperCase();
        this.curp = generateCURP();
    }
    public String getCurp() {
        return curp;
    }
    public void setCurp(String curp){
        this.curp = curp;
    }
    public String getBirthdate() {
        return birthdate;
    }
    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
        this.curp = generateCURP();
        this.age = calculateAge();
    }
    public String getRegisterDate() {
        return registerDate;
    }
    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }
    public int getNumVisits() {
        return numVisits;
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public int getAge() {
        return age;
    } 
    public String getLastNameF() {
        return lastNameF;
    }
    public void setLastNameF(String lastNameF) {
        this.lastNameF = lastNameF.toUpperCase();
        this.curp = generateCURP();
    }
    public String getLastNameM() {
        return lastNameM;
    }
    public void setLastNameM(String lastNameM) {
        this.lastNameM = lastNameM.toUpperCase();
        this.curp = generateCURP();
    }
    public String getID(){
        return this.ID;
    }
    public boolean isActiveVisitant() {
        return activeVisitant;
    }
    public void setActiveVisitant(boolean activeVisitant) {
        this.activeVisitant = activeVisitant;
    }
    
    //MÉTODOS AUXILIARES
    public String getFullName(){
        return this.name + " " + this.lastNameF + " " + this.lastNameM;
    }

    public int calculateAge(){
        String year = this.birthdate.substring(6, 10);
        int age = 2024 - Integer.parseInt(year);
        return age;
    }

    public boolean isAdult(){
        if(this.age > 18){
            return true;
        }
        else{
            return false;
        }
    }

    public void addVisit(){
        this.numVisits++;
    }
    
    public String generateCURP() {
        String lastnameF = this.lastNameF.substring(0, 2);
        String lastnameM = this.lastNameM.substring(0, 1);
        String name = String.valueOf(this.name.charAt(0));
        String year = this.birthdate.substring(8, 10);
        String month = this.birthdate.substring(0, 2);
        String day = this.birthdate.substring(3, 5);
        String sex = "";
            if (this.sex.equals("M")) {
                sex = "H";
            }
            else{
                sex = "M";
            }
        String consonantes = "";
            for (int i = 0; i < this.lastNameF.length(); i++) {
                char c = this.lastNameF.charAt(i);
                if (c != 'A' && c != 'E' && c != 'I' && c != 'O' && c != 'U') {
                    consonantes += String.valueOf(c);
                    break;
                }

            }
            for (int i = 0; i < this.lastNameM.length(); i++) {
                char c = this.lastNameM.charAt(i);
                if (c != 'A' && c != 'E' && c != 'I' && c != 'O' && c != 'U') {
                    consonantes += String.valueOf(c);
                    break;
                }
            }
            for (int i = 0; i < this.name.length(); i++) {
            char c = this.name.charAt(i);
            if (c != 'A' && c != 'E' && c != 'I' && c != 'O' && c != 'U') {
                consonantes += String.valueOf(c);
                break;
            }
        }   
        int n1 = ran.nextInt(10);
        int n2 = ran.nextInt(10);
    return lastnameF + lastnameM + name + year + month + day + sex + "MIC" + consonantes + n1 + n2;
    }


}