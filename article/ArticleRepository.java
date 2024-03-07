package article;

import java.sql.Connection;
import java.util.List;

public class ArticleRepository {
    private static ArticleRepository instance = new ArticleRepository();

    private ArticleRepository(){}
    public static ArticleRepository getInstance() {
        return instance;
    }

    public List<?> getArticleList() {

    }
}
