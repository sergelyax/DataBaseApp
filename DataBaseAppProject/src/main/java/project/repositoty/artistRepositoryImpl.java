package project.repositoty;


import org.springframework.stereotype.Repository;
import project.dao.artistDAO;
import project.Interfaces.artistRepository;
import project.Services.JDBConnect;
import project.dao.*;


import java.sql.*;
import java.sql.Date;
import java.util.*;


@Repository
public class artistRepositoryImpl implements artistRepository {

    JDBConnect jdbConnect = new JDBConnect();

    Connection connection = jdbConnect.getConnection();

    public artistRepositoryImpl() throws SQLException {
    }

    @Override
    public Collection<artistDAO> findOlderThenDate(Calendar date) throws SQLException {
        PreparedStatement prepareStatement = connection.prepareStatement("SELECT * FROM artist where date_of_birth>?");
        prepareStatement.setDate(1, new Date(date.getTime().getTime()));
        ResultSet resultSet =  prepareStatement.executeQuery();
        return getArtistDAOS(resultSet);
    }

    @Override
    public Collection<artistDAO> findAll() throws SQLException {
        ResultSet resultSet = connection.createStatement().executeQuery("SELECT * FROM artist");
        return getArtistDAOS(resultSet);
    }

    @Override
    public Collection<artistDAO> findAllByCountry(String country) throws SQLException {
        PreparedStatement prepareStatement = connection.prepareStatement("SELECT * FROM artist where country=?");
        prepareStatement.setString(1,country);
        ResultSet resultSet =  prepareStatement.executeQuery();
        return getArtistDAOS(resultSet);
    }

    private Collection<artistDAO> getArtistDAOS(ResultSet resultSet) throws SQLException {
        ArrayList<artistDAO> artists = new ArrayList<>();
        while (resultSet.next()){
            artistDAO artist = new artistDAO(
                    resultSet.getInt("id"),
                    resultSet.getString("firstname"),
                    resultSet.getString("lastname"),
                    resultSet.getString("family_name"),
                    resultSet.getDate("date_of_birth"),
                    resultSet.getString("country"),
                    resultSet.getDate("date_of_death"));
            artists.add(artist);
        }
        return artists;
    }

    @Override
    public Collection<artistDAO> findById(long id) throws SQLException {
        PreparedStatement prepareStatement = connection.prepareStatement("SELECT * FROM artist where id=?");
        prepareStatement.setLong(1,id);
        ResultSet resultSet =  prepareStatement.executeQuery();
        return getArtistDAOS(resultSet);
    }
}
