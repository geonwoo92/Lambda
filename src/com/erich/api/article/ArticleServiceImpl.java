package com.erich.api.article;

import com.erich.api.common.AbstractService;
import com.erich.api.enums.Messenger;
import com.erich.api.user.User;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class ArticleServiceImpl extends AbstractService<Article> implements ArticleService {

    private final static ArticleServiceImpl instance = new ArticleServiceImpl();
    private ArticleRepository articleRepository;

    private ArticleServiceImpl() {
        articleRepository = ArticleRepository.getInstance();
    }

    public static ArticleServiceImpl getInstance() {
        return instance;
    }


    @Override
    public Messenger save(Article article) {
        return null;
    }

    @Override
    public List<Article> findAll() throws SQLException {
        return articleRepository.findAll();
    }


    @Override
    public Optional<Article> findById(long id) {
        return Optional.empty();
    }

    @Override
    public String count() {
        return null;
    }

    @Override
    public Optional<Article> getOne(String id) {
        return Optional.empty();
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<?> getUserList() {
        return null;
    }

    @Override
    public String delete(Article article) {
        return null;
    }

    @Override
    public Boolean existsById(long id) {
        return null;
    }
}
