public class Student implements Comparable<Student>{

    int id;
    int height;
    int grade;

    public Student(int id, int height, int grade, String name) {
        this.id = id;
        this.height = height;
        this.grade = grade;
        this.name = name;
    }

    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }



    public Student(int id)
    {
        this.id = id;
    }
    @Override
    public int compareTo(Student o) {
        return this.id-o.id;
    }
}
