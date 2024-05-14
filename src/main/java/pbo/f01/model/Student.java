package pbo.f01.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
@Entity
public class Student implements Serializable {
    @Id
    private String id;
    private String name;
    private int entranceYear;
    private String gender;
    private Dorm dorm;

    public Student(String id, String name, int entranceYear, String gender) {
        this.id = id;
        this.name = name;
        this. entranceYear = entranceYear;
        this.gender = gender;
        
    }
     public String getid() {
        return id;
    }
    public String getname() {
        return name;
    }
    public int getYear() {
        return entranceYear;
    }

    public String getgender() {
        return gender;
    }

    public Dorm getdorm() {
        return dorm;
    }
    public void setDorm(Dorm dorm) {
        this.dorm = dorm;
    }
}
