package movietickets;

public class Movie {

    private final String title;
    private final int length;
    private final String genre;
    private final String rating;
    private final double price;
    private final String description;

    public Movie(String title, int length, String genre, String rating, double price, String description) {
        this.title = title;
        this.length = length;
        this.genre = genre;
        this.rating = rating;
        this.price = price;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    public String getRating() {
        return rating;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public String getGenre() {
        return genre;
    }
}
