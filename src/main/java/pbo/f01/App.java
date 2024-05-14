package pbo.f01;
import java.util.*;
import pbo.f01.model.*;

import javax.persistence.*;
/**
 * 12S22041 - Indah Elisa Sihombing
 * 12s22043 - Katrina Arlyanti Tambunan
 */
public class App {
    private static StudentRepository studentrepo = new StudentRepository();
    private static DormRepository dormrepo = new DormRepository();

    public static void main(String[] _args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            if (input.equals("---")) {
                break;

            } else if (input.startsWith("student-add")) {
            handleStudentAdd(input);
            
           } else if (input.startsWith("dorm-add")) {
            handleDormAdd(input);

          } else if (input.startsWith("assign")) {
            handleAssign(input);

          } else if (input.startsWith("display-all")) {
            handleDisplayAll();
    }
}

scanner.close();

    }

    private static void handleStudentAdd(String input){
        String[] parts = input.split("#");
        String id = parts[1];
        String name = parts[2];
        int entranceYear = Integer.parseInt(parts[3]);
        String gender = parts[4];
    
        Student student = new Student(id, name, entranceYear, gender);
        studentrepo.addStudent(student);
    }

    private static void handleDormAdd(String input){
        String[] parts = input.split("#");
        String name = parts[1];
        int capacity = Integer.parseInt(parts[2]);
        String gender = parts[3];
        
    
        Dorm dorm = new Dorm(name, capacity, gender);
        dormrepo.addDorm(dorm);
    }
    private static void handleAssign(String input){
        String[] parts = input.split("#");
        String studentID = parts[1];
        String Dormname = parts[2];
        Student student =studentrepo.getStudent(studentID);
        Dorm dorm= dormrepo.getDorm(Dormname);
        if(student !=null && dorm!=null){
            if(dorm.getgender().equals(student.getgender())&& dorm.getStudents().size()<dorm.getcapacity()){
                student.setDorm(dorm);
                studentrepo.addStudent(student);
            }
        }
    }
    private static void handleDisplayAll(){
        List<Dorm> dorms= dormrepo.getAllDorms();
        for(Dorm dorm : dorms){
            List<Student> students=dorm.getStudents();
            students.sort((s1,s2)-> s1.getname().compareTo(s2.getname()));
            System.out.printf("%s|%s|%d|%d%n",dorm.getname(),dorm.getgender(),dorm.getcapacity(),students.size());
            for(Student student: students){
                System.out.printf("%s|%s|%d%n",student.getid(),student.getname(),student.getYear());
            }
        }
    }

}
