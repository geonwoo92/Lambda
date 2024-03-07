package article;

import java.util.List;

public class ArticleServiceImpl implements ArticleService {

    private static ArticleService instance = new ArticleServiceImpl();
    private ArticleRepository articleRepository = ArticleRepository.getInstance();
    private ArticleServiceImpl(){

    }
    public static ArticleService getInstance() {
        return instance;

    }

    @Override
    public List<?> getArticleList() {
        return null;
    }
}
