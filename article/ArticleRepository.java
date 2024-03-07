package article;

public class ArticleRepository {
    private static ArticleRepository instance = new ArticleRepository();
    public static ArticleRepository getInstance() {
        return instance;
    }
}
