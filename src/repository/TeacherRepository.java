package repository;

import database.DatabaseConnection;
import models.Teacher;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TeacherRepository {

    // Bütün müəllimləri bazadan gətirir
    public List<Teacher> getTeachers() {
        List<Teacher> teachers = new ArrayList<>();

        String sql = "SELECT * FROM teachers";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                teachers.add(mapTeacher(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return teachers;
    }

    // Yeni müəllim əlavə edir
    public void addTeacher(Teacher teacher) {

        String sql = """
                INSERT INTO teachers
                (name, sur_name, fin, age, email, number, salary)
                VALUES (?, ?, ?, ?, ?, ?, ?)
                RETURNING id
                """;

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, teacher.getName());
            ps.setString(2, teacher.getSurName());
            ps.setString(3, teacher.getFin());
            ps.setInt(4, teacher.getAge());
            ps.setString(5, teacher.getEmail());
            ps.setString(6, teacher.getNumber());
            ps.setDouble(7, teacher.getSalary());

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    teacher.setId(rs.getLong("id"));
                }
            }

            System.out.println("The teacher was successfully added");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ID-yə görə müəllim tapır
    public Teacher getTeacherById(Long id) {

        String sql = "SELECT * FROM teachers WHERE id = ?";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setLong(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapTeacher(rs);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    // Müəllimi silir
    public void deleteTeacher(Long id) {

        String sql = "DELETE FROM teachers WHERE id = ?";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setLong(1, id);

            int rows = ps.executeUpdate();

            if (rows == 0) {
                System.out.println("Teacher not found");
            } else {
                System.out.println("Teacher deleted successfully");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Email-in mövcudluğunu yoxlayır
    public boolean existsByEmail(String email) {

        String sql = "SELECT EXISTS (SELECT 1 FROM teachers WHERE LOWER(email) = LOWER(?))";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, email);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    boolean exists = rs.getBoolean(1);

                    if (exists) {
                        System.out.println("Email already exists! Try another one.");
                    }

                    return exists;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // FIN-in mövcudluğunu yoxlayır
    public boolean existsByFin(String fin) {

        String sql = "SELECT EXISTS (SELECT 1 FROM teachers WHERE LOWER(fin) = LOWER(?))";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, fin);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    boolean exists = rs.getBoolean(1);

                    if (exists) {
                        System.out.println("FIN already exists! Try another one.");
                    }

                    return exists;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // FIN başqa ID-li müəllimdə varmı?
    public boolean existsByFinAndIdNot(String fin, Long id) {

        String sql = """
                SELECT EXISTS (
                    SELECT 1 FROM teachers
                    WHERE LOWER(fin) = LOWER(?) AND id <> ?
                )
                """;

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, fin);
            ps.setLong(2, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getBoolean(1);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // Email başqa ID-li müəllimdə varmı?
    public boolean existsByEmailAndIdNot(String email, Long id) {

        String sql = """
                SELECT EXISTS (
                    SELECT 1 FROM teachers
                    WHERE LOWER(email) = LOWER(?) AND id <> ?
                )
                """;

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, email);
            ps.setLong(2, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getBoolean(1);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // FIN-ə görə müəllim axtarır
    public Teacher searchTeacherByFin(String fin) {

        String sql = "SELECT * FROM teachers WHERE LOWER(fin) = LOWER(?)";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, fin);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapTeacher(rs);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    // Müəllimlərin sayını qaytarır
    public int countTeacher() {

        String sql = "SELECT COUNT(*) FROM teachers";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                return rs.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    // Yaşa görə sıralayır
    public List<Teacher> sortedTeachersByAge() {
        return getTeachersSorted("age ASC");
    }

    // Maaşa görə sıralayır
    public List<Teacher> sortedTeachersBySalary() {
        return getTeachersSorted("salary ASC");
    }

    private List<Teacher> getTeachersSorted(String order) {

        List<Teacher> teachers = new ArrayList<>();

        String sql = "SELECT * FROM teachers ORDER BY " + order;

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                teachers.add(mapTeacher(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return teachers;
    }

    // Orta maaşı hesablayır
    public double getAverageSalary() {

        String sql = "SELECT AVG(salary) FROM teachers";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                return rs.getDouble(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0.0;
    }

    // Ən yüksək maaş alan müəllimi tapır
    public Teacher getHighestPaidTeacher() {

        String sql = """
                SELECT * FROM teachers
                ORDER BY salary DESC NULLS LAST
                LIMIT 1
                """;

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                return mapTeacher(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    // Database məlumatlarını Teacher obyektinə çevirir
    private Teacher mapTeacher(ResultSet rs) throws SQLException {

        return new Teacher(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getString("sur_name"),
                rs.getString("fin"),
                rs.getInt("age"),
                rs.getString("email"),
                rs.getString("number"),
                rs.getDouble("salary")
        );
    }
    public boolean updateTeacher(Teacher teacher) {

        String sql = """
            UPDATE teachers
            SET name = ?,
                sur_name = ?,
                fin = ?,
                age = ?,
                email = ?,
                number = ?,
                salary = ?
            WHERE id = ?
            """;

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, teacher.getName());
            ps.setString(2, teacher.getSurName());
            ps.setString(3, teacher.getFin());
            ps.setInt(4, teacher.getAge());
            ps.setString(5, teacher.getEmail());
            ps.setString(6, teacher.getNumber());
            ps.setDouble(7, teacher.getSalary());
            ps.setLong(8, teacher.getId());

            int rows = ps.executeUpdate();

            return rows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}