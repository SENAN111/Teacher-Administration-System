package repository;

import models.Teacher;
import utill.AppScanner;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TeacherRepository {
    private List<Teacher> teachers = new ArrayList<>();

    public List<Teacher> getTeachers() {
        return new ArrayList<>(teachers);
    }

    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
        System.out.println("The teacher was successfully added");
    }


    public Teacher getTeacherById(Long id) {
        for (Teacher teacher : teachers) {
            if (teacher.getId().equals(id)) {
                return teacher;
            }

        }

        return null;

    }

    public void deleteTeacher(Long id) {
        boolean removed = teachers.removeIf(teacher -> teacher.getId().equals(id));
        if (!removed) {
            System.out.println("Teacher not found");
        }
    }


    public boolean existsByEmail(String email) {
        for (Teacher teacher : teachers) {
            if (teacher.getEmail().equalsIgnoreCase(email)) {
                System.out.println("Email already exists! Try another one.");
                return true;
            }
        }

        return false;
    }

    public boolean existsByFin(String fin) {
        for (Teacher teacher : teachers) {
            if (teacher.getFin().equalsIgnoreCase(fin)) {
                System.out.println("FIN already exists! Try another one.");
                return true;
            }
        }

        return false;
    }

    public boolean existsByFinAndIdNot(String fin, Long id) {
        for (Teacher teacher : teachers) {
            if (teacher.getFin().equalsIgnoreCase(fin) && !teacher.getId().equals(id)) {
                return true;

            }
        }


        return false;
    }

    public boolean existsByEmailAndIdNot(String email, Long id) {
        for (Teacher teacher : teachers) {
            if (teacher.getEmail().equalsIgnoreCase(email) && !teacher.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    public Teacher searchTeacherByFin(String fin) {
        for (Teacher teacher : teachers) {
            if (teacher.getFin().equalsIgnoreCase(fin)) {
                return teacher;
            }
        }
        return null;
    }

    public int countTeacher() {

        return teachers.size();
    }

    public  List<Teacher> sortedTeachersByAge() {
        List<Teacher> filtiretTeacherbyAge = teachers.stream().sorted(Comparator.comparing(Teacher::getAge)).collect(Collectors.toList());
        return filtiretTeacherbyAge;
    }
    public  List<Teacher>  sortedTeachersBySalary(){
        List<Teacher>sortedTeachersbySalary=teachers.stream().sorted(Comparator.comparing(Teacher::getSalary)).collect(Collectors.toList());
        return sortedTeachersbySalary;
    }
    public double getAverageSalary()
    {
        return teachers.stream().mapToDouble(Teacher::getSalary).average().orElse(0.0);
    }
    public Teacher getHighestPaidTeacher()
    {

        return teachers.stream().max(Comparator.comparing(Teacher::getSalary)).orElse(null);
    }
}
