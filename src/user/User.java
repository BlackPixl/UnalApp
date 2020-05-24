package user;

public class User {
    public User(String name) {
        this.name = name;
    }
    public User(String name, AcademicHistory ah){
        this.name = name;
        this.academicHistory = ah;
    }


    private String name;
    private AcademicHistory academicHistory;

    public String getName(){
        return this.name;
    }

    public AcademicHistory getAcademicHistory(){
        return this.academicHistory;
    }

}
