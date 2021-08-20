import java.sql.ResultSet;
import java.sql.SQLException;

public class BooksMapper {

    public static Library map(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String nameBook = rs.getString("nameBook");
        String authorName = rs.getString("authorName");
        int quentityPages = rs.getInt("quentityPages");
        int price = rs.getInt("price");

        return new Library(id, nameBook, authorName, quentityPages, price);
    }

}
