
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class menu {
    public static void main(String[] args) {
    	
    	Scanner scanner = new Scanner( System.in );
		System.out.println("Escoge el número 1 para consultar los jugadores inscritos en el torneo");
		System.out.println("Escoge el número 2 para ver las consultas realizadas por los visitantes de la página web");		
		int numA = scanner.nextInt();	
    	
		if (numA == 2)
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/oneshoot", "root", ""
            );
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from contacto");
            while (resultSet.next()) {
                System.out.println(resultSet.getString(2)+ " " + resultSet.getString(3));                
                System.out.println(resultSet.getString(4));
                System.out.println(resultSet.getString(5));
                ;
            }
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }
		else if (numA == 1)
		
			   try {
		            Class.forName("com.mysql.cj.jdbc.Driver");
		            Connection connection = DriverManager.getConnection(
		                    "jdbc:mysql://localhost:3306/oneshoot", "root", ""
		            );
		            Statement statement = connection.createStatement();
		            ResultSet resultSet = statement.executeQuery("select * from jugador");
		            while (resultSet.next()) {
		                System.out.println(resultSet.getString(2)+ " " + resultSet.getString(3) + " " + resultSet.getString(4));
		                ;

		            }
		            connection.close();
		        } catch (Exception e) {
		            System.out.println(e);
		        }    
	    
		else
			System.out.println("Error: escoge un número entre el 1 y el 2");

    }}
    