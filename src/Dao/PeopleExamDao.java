package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.*;  

import Model.PeopleExamTHPT;

public class PeopleExamDao {
	private static String DB_NAME = "managementthpt";
    private static String DB_URL = "jdbc:mysql://localhost:3306/";
    private static String USER_NAME = "root";
    private static String PASSWORD = "215487467hg";
	 
	public static Connection getConnection() throws Throwable {
	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	            Connection connection = (Connection) DriverManager.getConnection(DB_URL + DB_NAME, USER_NAME, PASSWORD);
	            return connection;
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	            throw new Throwable("Can't create connection");
	        }
	}
	public static List<PeopleExamTHPT> getData(String optionSort) {
		List<PeopleExamTHPT> listPeopleExams = new ArrayList<PeopleExamTHPT>(); 
		PeopleExamTHPT peopleExam ;
		String query = " SELECT * FROM managementthpt.people_examthpt ;";
		if(optionSort.equals("Sắp xếp theo giới tính")) {
			query = " SELECT * FROM managementthpt.people_examthpt ORDER BY gioitinh ASC ;"; 
		}
		if (optionSort.equals("Sắp xếp theo khu vực")) {
			query = " SELECT * FROM managementthpt.people_examthpt ORDER BY khuvuc ASC;"; 
		} 
		if(optionSort.equals("Sắp xếp theo đối tượng")){
			query = " SELECT * FROM managementthpt.people_examthpt ORDER BY doituong ASC ;"; 
		}
		if (optionSort.equals("Sắp xếp theo điểm tổng")) {
			query = " SELECT * FROM managementthpt.people_examthpt ORDER BY diemtong ASC ;"; 
		}
		try {
			Connection connection = getConnection();
			Statement statement = ((java.sql.Connection) connection).createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
               int id = resultSet.getInt("id"); 
               System.out.println(id);
               String hoten = resultSet.getString("hoten"); 
               String gioitinh = resultSet.getString("gioitinh"); 
               String ngaysinh = resultSet.getString("ngaysinh"); 
               String diachi = resultSet.getString("diachi"); 
               int khuvuc = resultSet.getInt("khuvuc"); 
               String doituong = resultSet.getString("doituong"); 
               String truong = resultSet.getString("truong"); 
               String khoithi = resultSet.getString("khoithi"); 
               float diemtong = resultSet.getFloat("diemtong"); 
               peopleExam = new PeopleExamTHPT(id, hoten, gioitinh, ngaysinh, diachi, khuvuc, doituong, truong, khoithi, diemtong);  
               listPeopleExams.add(peopleExam); 
            }
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return listPeopleExams; 
	}
	public static int insertData(PeopleExamTHPT peopleExam) {
		int result = 0; 
		 try {
	            Connection connection = getConnection();
	            String query = "insert into managementthpt.people_examthpt(hoten, gioitinh, ngaysinh, diachi, khuvuc, doituong,khoithi,  truong,diemtong) values( ?, ?, ?, ?, ?, ?, ?, ?, ? );";
	            PreparedStatement preparedStatement = connection.prepareStatement(query);
	            preparedStatement.setString(1, peopleExam.getmHoten());
	            preparedStatement.setString(2, peopleExam.getmGioitinh());
	            preparedStatement.setString(3,  peopleExam.getmNgaysinh());
	            preparedStatement.setString(4, peopleExam.getmDiachi());
	            preparedStatement.setInt(5, peopleExam.getmKhuvuc());
	            preparedStatement.setString(6, peopleExam.getmDoituong());
	            preparedStatement.setString(7, peopleExam.getmKhoithi());
	            preparedStatement.setString(8, peopleExam.getmTruong());
	            preparedStatement.setFloat(9, peopleExam.getmDiemtong());
	            result = preparedStatement.executeUpdate();
	            System.out.println(result);
	        } catch (Throwable throwable) {
	            throwable.printStackTrace();
	        }
		 return result;
	}
	public static int delete(int id) {
		int result = 0; 
		 try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            String query = "delete from managementthpt.people_examthpt where id=" + id + ";";
            result = statement.executeUpdate(query);
            
        }catch (Throwable e){
            e.printStackTrace();
        }
        return result;
	}
	public static int update(PeopleExamTHPT peopleExam) {
		int result = 0; 
		 try {
	            Connection connection = getConnection();
	            String query = "update  managementthpt.people_examthpt set hoten = ?, gioitinh =?, ngaysinh =?, diachi = ?, khuvuc= ?, doituong= ?, khoithi =?,"
	            		+ "truong =? , diemtong =? where id = ?;";
	            PreparedStatement preparedStatement = connection.prepareStatement(query);
	            preparedStatement.setString(1, peopleExam.getmHoten());
	            preparedStatement.setString(2, peopleExam.getmGioitinh());
	            preparedStatement.setString(3,  peopleExam.getmNgaysinh());
	            preparedStatement.setString(4, peopleExam.getmDiachi());
	            preparedStatement.setInt(5, peopleExam.getmKhuvuc());
	            preparedStatement.setString(6, peopleExam.getmDoituong());
	            preparedStatement.setString(7, peopleExam.getmKhoithi());
	            preparedStatement.setString(8, peopleExam.getmTruong());
	            preparedStatement.setFloat(9, peopleExam.getmDiemtong());
	            preparedStatement.setInt(10, peopleExam.getId());
	            result = preparedStatement.executeUpdate();
	            System.out.println(result);
	        } catch (Throwable throwable) {
	            throwable.printStackTrace();
	        }
		 return result;
	}
}
