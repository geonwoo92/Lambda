package article;

import java.util.List;

public class ArticleServiceImpl implements ArticleService {

    private static ArticleService instance = new ArticleServiceImpl();
    private ArticleRepository articleRepository;
    private ArticleServiceImpl(){
        articleRepository = ArticleRepository.getInstance();
    }
    public static ArticleService getInstance() {
        return instance;
    }

    @Override
    public List<?> getArticleList() {
        return articleRepository.getArticleList();
    }
}
