import models.Teacher;
import repository.TeacherRepository;
import service.TeacherService;
import utill.AppScanner;

public class Main {

    public static void main(String[] args) {

        TeacherRepository teacherRepository = new TeacherRepository();
        TeacherService teacherService = new TeacherService(teacherRepository);

        while (true) {

            System.out.println("\n========== TEACHER ADMINISTRATION SYSTEM ==========");
            System.out.println("1. Add Teacher");
            System.out.println("2. Show All Teachers");
            System.out.println("3. Update Teacher");
            System.out.println("4. Delete Teacher");
            System.out.println("5. Search Teacher By ID");
            System.out.println("6. Search Teacher By FIN");
            System.out.println("7. Show Teacher Count");
            System.out.println("8. Sort Teachers By Age");
            System.out.println("9. Sort Teachers By Salary");
            System.out.println("10. Show Average Salary");
            System.out.println("11. Show Highest Paid Teacher");
            System.out.println("0. Exit");
            System.out.println("===================================================");
            System.out.print("Enter your choice: ");

            int choice;

            try {
                choice = Integer.parseInt(
                        AppScanner.SCANNER.nextLine().trim()
                );
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Enter a number.");
                continue;
            }

            switch (choice) {

                case 1:
                    teacherService.addTeacher();
                    break;

                case 2:
                    teacherService.showTeachers();
                    break;

                case 3:
                    Long updateId = readId();
                    teacherService.updateTeacher(updateId);
                    break;

                case 4:
                    Long deleteId = readId();
                    teacherService.deleteTeacher(deleteId);
                    break;

                case 5:
                    Long searchId = readId();

                    Teacher teacherById =
                            teacherService.searchTeacherById(searchId);

                    if (teacherById != null) {
                        System.out.println(teacherById);
                    }
                    break;

                case 6:
                    System.out.print("Enter FIN: ");
                    String fin = AppScanner.SCANNER.nextLine().trim();

                    Teacher teacherByFin =
                            teacherService.searchTeacherByFin(fin);

                    if (teacherByFin != null) {
                        System.out.println(teacherByFin);
                    } else {
                        System.out.println("Teacher not found!");
                    }
                    break;

                case 7:
                    teacherService.showTeacherCount();
                    break;

                case 8:
                    teacherService.sortTeachersByAge();
                    break;

                case 9:
                    teacherService.sortTeachersBySalary();
                    break;

                case 10:
                    teacherService.showAverageSalary();
                    break;

                case 11:
                    teacherService.showHighestPaidTeacher();
                    break;

                case 0:
                    System.out.println("Thank you for using Teacher Administration System!");
                    return;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }

    private static Long readId() {

        while (true) {
            System.out.print("Enter Teacher ID: ");

            try {
                Long id = Long.parseLong(
                        AppScanner.SCANNER.nextLine().trim()
                );

                if (id <= 0) {
                    System.out.println("ID must be greater than 0!");
                    continue;
                }

                return id;

            } catch (NumberFormatException e) {
                System.out.println("Invalid ID! Enter a number.");
            }
        }
    }
}