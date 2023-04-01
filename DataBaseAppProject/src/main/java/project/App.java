package project;

import org.springframework.context.annotation.ComponentScan;
import project.Services.Exceptions.LocaleNotSupportedException;
import project.Services.UserInterface;

import java.sql.SQLException;

@ComponentScan
public class App {
    public static void main(String[] args) throws SQLException, LocaleNotSupportedException {
        UserInterface userInterface = new UserInterface();
        userInterface.StartInterface();
    }
}