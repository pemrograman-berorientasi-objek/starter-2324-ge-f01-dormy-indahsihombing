package pbo.f01.model;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
@Entity
public class Dorm implements Serializable  {
    private String name;
    private int capacity;
    private  String gender;
    private List<Student> students;
   
    public Dorm(String name, int capacity, String gende) {
        this.name = name;
        this.capacity = capacity;
        this.gender = gender;
        
    }
    
    public String getname() {
        return name;
    }

    public int getcapacity() {
        return capacity;
    }

    public String getgender() {
        return gender;
    }
    public List<Student> getStudents(){
        return students;
    }
    public void setStudents(List<Student> students){
        this.students=students;
    }
}

