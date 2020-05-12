
package user;

public class User {
    public User(String name) {
        this.name = name;
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
