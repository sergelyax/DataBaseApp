package project.dao;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class artistDAO {
    private Integer id;
    String firstname;
    String secondname;
    String familyname;
    Date dateofbirth;
    String country;
    Date dateofdeath;
}
