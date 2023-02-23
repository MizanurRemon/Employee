package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@SpringBootApplication
public class Main {
    public static void main(String[] args) throws SQLException {
        SpringApplication.run(Main.class, args);

        System.out.println("run successfully");

        String url = "jdbc:mysql://localhost/employeeDB";
        String user = "root";
        String password = "";

        try {
            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("connection established");
            con.close();
            System.out.println("connection close");
        }catch (Exception e){
            System.out.println(e.getMessage().toString());
        }

    }
}

////@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })