import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Application {


    public static void main(String[] args) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {

        LibraryDAO libraryDAO = new LibraryDAO(ConnectionUtils.openConnection());

        //READ_ALL
        libraryDAO.readAll().stream().forEach(System.out::println);
        System.out.println("--------------------------------------------------------\n");

        List<Library> listOfLibrary = new ArrayList<>();
        listOfLibrary.add(new Library("Твердиня", "Кідрук Максим Іванович", 126, 200.0));
        listOfLibrary.add(new Library("Бедный папа, богатый папа", "Роберт Кійосакі", 847, 600.99));
        listOfLibrary.add(new Library("Java.Полное руководство 6-е издание", "Герберд Шилд", 1353, 1999.00));


//        //INSERT
//        listOfLibrary.forEach(libary-> {
//            try {
//                libraryDAO.insert(libary);
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        });


        //READ-BY-ID
        Library library = libraryDAO.read(2);
        System.out.println(library);


        //UPDATE-BY-ID
        library.setAuthorName("Макс Корж");
        libraryDAO.update(library);

        //READ-BY-ID
        library = libraryDAO.read(2);
        System.out.println(library);

        //DELETE-BY-ID
        libraryDAO.delete(3);

        System.out.println();
        System.out.println("--------------------------------------------------------\n");

        //READ-ALL
        libraryDAO.readAll().forEach(System.out::println);

    }
}
