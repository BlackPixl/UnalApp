package course;

public class CourseGrade {
    public CourseGrade(float grade, byte percentage) {
        this.grade = grade;
        this.percentage = percentage;
    }

    String name = "testName";

    public CourseGrade(byte percentage){
        this.grade = 0;
        this.percentage = percentage;
    }

    private float grade;
    private byte percentage;

    public float getGrade() {
        return grade;
    }

    public byte getPercentage() {
        return percentage;
    }

    public float getWeighedGrade(){
        return ((this.grade*this.percentage)/100);
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }

    public void setPercentage(byte percentage) {
        this.percentage = percentage;
    }
}
