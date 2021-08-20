public class Library {
    private int id;
    private String nameBook;
    private String authorName;
    private int quentityPages;
    private double price;

    public Library(int id, String nameBook, String authorName, int quentityPages, double price) {
        this.id = id;
        this.nameBook = nameBook;
        this.authorName = authorName;
        this.quentityPages = quentityPages;
        this.price = price;
    }

    public Library(String nameBook, String authorName, int quentityPages, double price) {
        this.nameBook = nameBook;
        this.authorName = authorName;
        this.quentityPages = quentityPages;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getQuentityPages() {
        return quentityPages;
    }

    public void setQuentityPages(int quentityPages) {
        this.quentityPages = quentityPages;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Library{" +
                "id=" + id +
                ", nameBook='" + nameBook + '\'' +
                ", authorName='" + authorName + '\'' +
                ", quentityPages=" + quentityPages +
                ", price=" + price +
                '}';
    }
}
