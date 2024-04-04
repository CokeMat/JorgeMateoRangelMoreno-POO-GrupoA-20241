import java.util.Random;
public class Employee {
    private Random random = new Random();
    private String name, lastnameF, lastnameM, birthdate, registerDate, role, schedule, sex, RFC, curp, ID;
    private double salary;
    private boolean activeEmployee;


    public Employee(String name, String lastnameF, String lastnameM, String birthdate, String registerDate, String role, String sex, String ID) {
        this.name = name.toUpperCase();
        this.lastnameF = lastnameF.toUpperCase();
        this.lastnameM = lastnameM.toUpperCase();
        this.birthdate = birthdate;
        this.registerDate = registerDate;
        this.role = role;
        this.schedule = generateSchedule(role);
        this.salary = generateSalary(role);
        this.sex = sex;
        this.RFC = generateRFC();
        this.curp = generateCURP();
        this.ID = ID;
        this.activeEmployee = false;
    }


    public String getFullName(){
        return this.name + " " +  this.lastnameF + " " + this.lastnameM;
    }
    
    private String generateSchedule(String role){
        switch (role) {
            case "Veterinary":
                return "09:00-18:00";

            case "Guide":
                return "09:00-15:00";

            case "Maintenance":
                return "17:00-21:00";

            case "Administration":
                return "08:00-15:00";
        
            default:
                return "NULL";
        }
    }

    private double generateSalary(String role){
        switch (role) {
            case "Veterinary":
                return 14000;

            case "Guide":
                return 9000;

            case "Maintenance":
                return 5000;

            case "Administration":
                return 10000;
        
            default:
                return -1;
        }
    }

    public String generateCURP() {
        String lastnameF = this.lastnameF.substring(0, 2);
        String lastnameM = this.lastnameM.substring(0, 1);
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
            for (int i = 0; i < this.lastnameF.length(); i++) {
                char c = this.lastnameF.charAt(i);
                if (c != 'A' && c != 'E' && c != 'I' && c != 'O' && c != 'U') {
                    consonantes += String.valueOf(c);
                    break;
                }

            }
            for (int i = 0; i < this.lastnameM.length(); i++) {
                char c = this.lastnameM.charAt(i);
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
        int n1 = random.nextInt(10);
        int n2 = random.nextInt(10);
    return lastnameF + lastnameM + name + year + month + day + sex + "MIC" + consonantes + n1 + n2;
    }

    public String generateRFC() {
        String lastnameF = this.lastnameF.substring(0, 2);
        String lastnameM = this.lastnameF.substring(0, 1);
        String name = this.name.substring(0, 0);
        String year = this.birthdate.substring(8, 10);
        String month = this.birthdate.substring(0, 2);
        String day = this.birthdate.substring(3, 5);
        int n1 = random.nextInt(10);
        int n2 = random.nextInt(10);
        int codigoLetra = random.nextInt(26) + 65;
        char letraAleatoria = (char) codigoLetra;


    return lastnameF + lastnameM + name + year + month + day + n1 + String.valueOf(letraAleatoria) + n2;
    }

    // Getters y setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name.toUpperCase();
        this.curp = generateCURP();
        this.RFC = generateRFC();
    }

    public String getLastnameF() {
        return lastnameF;
    }

    public void setLastnameF(String lastnameF) {
        this.lastnameF = lastnameF.toUpperCase();
        this.curp = generateCURP();
        this.RFC = generateRFC();
    }

    public String getLastnameM() {
        return lastnameM;
    }

    public void setLastnameM(String lastnameM) {
        this.lastnameM = lastnameM.toUpperCase();
        this.curp = generateCURP();
        this.RFC = generateRFC();
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
        this.curp = generateCURP();
        this.RFC = generateRFC();
    }

    public String getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
        this.curp = generateCURP();
        this.RFC = generateRFC();
    }

    public String getRFC() {
        return RFC;
    }

    public void setRFC(String rFC) {
        RFC = rFC;
    }

    public String getCURP() {
        return curp;
    }

    public void setCURP(String cURP) {
        this.curp = cURP;
    }

    public String getID() {
        return ID;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public boolean isActiveEmployee() {
        return activeEmployee;
    }

    public void setActiveEmployee(boolean activeEmployee) {
        this.activeEmployee = activeEmployee;
    } 
}
