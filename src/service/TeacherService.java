package service;

import models.Teacher;
import repository.TeacherRepository;
import utill.AppScanner;
import utill.ValidationUtil;

import java.util.List;


public class TeacherService {
    private final TeacherRepository teacherRepository;

    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public void addTeacher() {
        String name;

        while (true) {
            System.out.println("Enter name:");
            name = AppScanner.SCANNER.nextLine().trim();

            if (ValidationUtil.isValidName(name)) {
                break;
            }

            System.out.println("Invalid name! Try again.");
        }
        String surname;
        while (true) {
            System.out.println("Enter surname");
            surname = AppScanner.SCANNER.nextLine().trim();
            if (ValidationUtil.isValidName(surname)) {
                break;
            }
            System.out.println("Invalid surname! Try again.");

        }

        String fin;

        while (true) {
            System.out.println("Enter FIN:");
            fin = AppScanner.SCANNER.nextLine().trim();

            if (!ValidationUtil.isValidFin(fin)) {
                System.out.println("Invalid FIN! Try again.");
                continue;
            }

            if (teacherRepository.existsByFin(fin)) {
                System.out.println("FIN already exists! Try another one.");
                continue;
            }

            break;
        }


        String email;

        while (true) {
            System.out.println("Enter email:");
            email = AppScanner.SCANNER.nextLine().trim();

            if (!ValidationUtil.isValidEmail(email)) {

                System.out.println("Invalid email! Try again.");
                continue;
            }

            if (teacherRepository.existsByEmail(email)) {
                System.out.println("email already exists! Try another one.");
                continue;
            }
            break;

        }

        String number;

        while (true) {
            System.out.println("Enter number:");
            number = AppScanner.SCANNER.nextLine().trim();

            if (ValidationUtil.isValidNumber(number)) {
                break;
            }

            System.out.println("Invalid number! Try again.");
        }

        double salary;

        while (true) {
            System.out.println("Enter salary:");

            try {
                salary = Double.parseDouble(AppScanner.SCANNER.nextLine());

                if (ValidationUtil.isValidSalary(salary)) {
                    break;
                }

                System.out.println("Salary must be greater than 0!");

            } catch (NumberFormatException e) {
                System.out.println("Invalid salary! Enter a number.");
            }
        }

        int age;

        while (true) {
            System.out.println("Enter age:");

            try {
                age = Integer.parseInt(AppScanner.SCANNER.nextLine());

                if (ValidationUtil.isValidAge(age)) {
                    break;
                }

                System.out.println("Age must be between 18 and 70!");

            } catch (NumberFormatException e) {
                System.out.println("Invalid age! Enter a number.");
            }
        }


        Teacher teacher = new Teacher(
                name, surname, fin, age, email, number, salary
        );

        teacherRepository.addTeacher(teacher);
        System.out.println("Teacher added successfully!");
    }

    public void deleteTeacher(Long id) {
        Teacher teacher = teacherRepository.getTeacherById(id);
        if (teacher == null) {
            System.out.println("Teacher not found!");
            return;
        }
        teacherRepository.deleteTeacher(id);
        System.out.println("Teacher deleted successfully");
    }

    public void updateTeacher(Long id) {
        Teacher teacher = teacherRepository.getTeacherById(id);
        if (teacher == null) {
            System.out.println("Teacher not found!");
            return;
        }
        System.out.println("1.Update name \n 2.Update surname \n 3.Update fin \n 4.Update email");
        System.out.println("5.Update number \n 6.Update salary \n 7.Update age \n 8. Exit");
        int choice = AppScanner.SCANNER.nextInt();
        AppScanner.SCANNER.nextLine();
        switch (choice) {
            case 1:
                String name;

                while (true) {
                    System.out.println("Enter name");
                    name = AppScanner.SCANNER.nextLine().trim();
                    if (ValidationUtil.isValidName(name)) {

                        break;
                    }
                    System.out.println("Invalid name! Try again.");
                }
                teacher.setName(name);
                System.out.println("Name updated successfully!");
                break;
            case 2:
                String surname;
                while (true) {
                    System.out.println("Enter surname");
                    surname = AppScanner.SCANNER.nextLine().trim();
                    if (ValidationUtil.isValidName(surname)) {
                        break;
                    }
                    System.out.println("Invalid surname! Try again.");

                }
                teacher.setSurName(surname);
                System.out.println("Surname updated successfully!");
                break;
            case 3:
                String fin;

                while (true) {
                    System.out.println("Enter FIN:");
                    fin = AppScanner.SCANNER.nextLine().trim();

                    if (!ValidationUtil.isValidFin(fin)) {
                        System.out.println("Invalid FIN! Try again.");
                        continue;
                    }

                    if (teacherRepository.existsByFinAndIdNot(fin, id)) {
                        System.out.println("FIN already exists! Try again.");
                        continue;
                    }

                    break;
                }
                teacher.setFin(fin);
                System.out.println("FIN updated successfully!");
                break;
            case 4:
                String email;

                while (true) {
                    System.out.println("Enter email:");
                    email = AppScanner.SCANNER.nextLine().trim();

                    if (!ValidationUtil.isValidEmail(email)) {
                        System.out.println("Invalid email! Try again.");
                        continue;
                    }

                    if (teacherRepository.existsByEmailAndIdNot(email, id)) {
                        System.out.println("Email already exists! Try again.");
                        continue;
                    }

                    break;
                }
                teacher.setEmail(email);
                System.out.println("Email updated successfully!");
                break;


            case 5:
                String number;

                while (true) {
                    System.out.println("Enter number:");
                    number = AppScanner.SCANNER.nextLine().trim();

                    if (ValidationUtil.isValidNumber(number)) {
                        break;
                    }

                    System.out.println("Invalid number! Try again.");
                }

                teacher.setNumber(number);
                System.out.println("Number updated successfully!");
                break;
            case 6:
                double salary;

                while (true) {
                    System.out.println("Enter salary:");

                    try {
                        salary = Double.parseDouble(AppScanner.SCANNER.nextLine());

                        if (ValidationUtil.isValidSalary(salary)) {
                            break;
                        }

                        System.out.println("Salary must be greater than 0!");

                    } catch (NumberFormatException e) {
                        System.out.println("Invalid salary! Enter a number.");
                    }
                }

                teacher.setSalary(salary);
                System.out.println("Salary updated successfully!");
                break;
            case 7:
                int age;

                while (true) {
                    System.out.println("Enter age:");

                    try {
                        age = Integer.parseInt(AppScanner.SCANNER.nextLine());

                        if (ValidationUtil.isValidAge(age)) {
                            break;
                        }

                        System.out.println("Age must be between 18 and 70!");

                    } catch (NumberFormatException e) {
                        System.out.println("Invalid age! Enter a number.");
                    }
                }

                teacher.setAge(age);
                System.out.println("Age updated successfully!");
                break;
            case 8:
                return;
            default:
                System.out.println("Invalid choice");
                return;


        }
    }

    public void showTeachers() {
        if (teacherRepository.getTeachers().isEmpty()) {
            System.out.println("No teachers found!");
            return;
        }
        for (Teacher teacher : teacherRepository.getTeachers()) {
            System.out.println(teacher.toString());
        }
    }
    public Teacher searchTeacherById(Long id) {
        return teacherRepository.getTeacherById(id);
    }
    public  Teacher searchTeacherByFin(String fin)
    {
        return  teacherRepository.searchTeacherByFin(fin);
    }
    public void showTeacherCount() {
        System.out.println("Teacher count: " + teacherRepository.countTeacher());
    }
    public void sortTeachersByAge() {
        List<Teacher> teachers = teacherRepository.sortedTeachersByAge();

        teachers.forEach(System.out::println);
    }
    public void sortTeachersBySalary() {
        List<Teacher> teachers = teacherRepository.sortedTeachersBySalary();

        teachers.forEach(System.out::println);
    }
    public void showAverageSalary() {
        double average = teacherRepository.getAverageSalary();

        System.out.println("Average salary: " + average);
    }
    public void showHighestPaidTeacher() {
        Teacher teacher = teacherRepository.getHighestPaidTeacher();

        if (teacher == null) {
            System.out.println("Teacher list is empty!");
            return;
        }

        System.out.println("Highest paid teacher:");
        System.out.println(teacher);
    }

}

