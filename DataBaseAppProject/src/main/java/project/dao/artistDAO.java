package project.dao;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class artistDAO {
    private Integer id;
    String firstname;
    String lastname;
    String familyName;
    Date dateOfBirth;
    String country;
    Date dateOfDeath;
}
