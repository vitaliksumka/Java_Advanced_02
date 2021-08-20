import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LibraryDAO {
    private static String READ_ALL = "select * from books ";
    private static String CREATE = "insert into books(nameBook, authorName, quentityPages, price) values (?,?,?,?)";
    private static String READ_BY_ID = "select * from books where id=?";
    private static String UPDATE_BY_ID = "update books set nameBook=?, authorName=?, quentityPages=?, price=? where id=?";
    private static String DELETE_BY_ID = "delete from books where id=?";

    private Connection connection = ConnectionUtils.openConnection();
    private PreparedStatement preparedStatement;

    public LibraryDAO(Connection connection) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        this.connection = connection;
    }

    public void insert(Library library) throws SQLException {
        preparedStatement = connection.prepareStatement(CREATE);
        preparedStatement.setString(1, library.getNameBook());
        preparedStatement.setString(2, library.getAuthorName());
        preparedStatement.setInt(3, library.getQuentityPages());
        preparedStatement.setDouble(4, library.getPrice());
        preparedStatement.executeUpdate();
    }

    public Library read(int id) throws SQLException {
        preparedStatement = connection.prepareStatement(READ_BY_ID);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        return BooksMapper.map(resultSet);
    }

    public void update(Library library) throws SQLException {
        preparedStatement = connection.prepareStatement(UPDATE_BY_ID);
        preparedStatement.setString(1, library.getNameBook());
        preparedStatement.setString(2, library.getAuthorName());
        preparedStatement.setInt(3, library.getQuentityPages());
        preparedStatement.setDouble(4, library.getPrice());
        preparedStatement.setInt(5, library.getId());
        preparedStatement.executeUpdate();
    }

    public void delete(int id) throws SQLException {
        preparedStatement = connection.prepareStatement(DELETE_BY_ID);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
    }

    public List<Library> readAll() throws SQLException {
        List<Library> listOfLibrary = new ArrayList<>();
        preparedStatement = connection.prepareStatement(READ_ALL);
        ResultSet result = preparedStatement.executeQuery();

        while (result.next()) {
            listOfLibrary.add(BooksMapper.map(result));
        }
        return listOfLibrary;
    }
}