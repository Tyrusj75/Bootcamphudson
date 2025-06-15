package org.example;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Program {

    public static void main(String[] args)throws SQLException {
        UserInterface uI = new UserInterface();
        uI.display();
    }
}
