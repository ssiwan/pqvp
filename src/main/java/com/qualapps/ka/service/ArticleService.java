package com.qualapps.ka.service;

import com.qualapps.ka.common.PqvpException;
import com.qualapps.ka.data.ArticleData;
import com.qualapps.ka.data.CategoryData;
import com.qualapps.ka.data.PqvpDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ArticleService {
    private static final String CATEGORIES_NOT_FOUND_EXCEPTION = "CategoriesNotFoundException";
    private static final String ARTICLE_NOT_CREATED_EXCEPTION = "ArticleNotCreateException";

    @Autowired
    private PqvpDao pqvpdao;

    /**
     * Gets all categories
     * @return List of categories
     * @throws PqvpException Categories not found exception
     */
    public List<CategoryData> getCategories() throws PqvpException{
        List<CategoryData> cats;
        try {
            cats = pqvpdao.getCategory();
            if (cats.isEmpty()) {
                String[] params = new String[]{};
                throw new PqvpException(CATEGORIES_NOT_FOUND_EXCEPTION, params);
            }
        } catch (Exception e) {
            String[] params = new String[]{};
            throw new PqvpException(CATEGORIES_NOT_FOUND_EXCEPTION, params);
        }
        return cats;
    }

    /**
     * Servioe to create an article
     * @param article of type ArticleData
     * @return ArticleData
     * @throws PqvpException - Article not created
     */
    public ArticleData createArticle(ArticleData article) throws PqvpException{
        ArticleData art;
        try {
            art = pqvpdao.addArticle(article);
            if (art == null) {
                String[] params = new String[]{};
                throw new PqvpException(ARTICLE_NOT_CREATED_EXCEPTION, params);
            }
        } catch (Exception e) {
            String[] params = new String[]{};
            throw new PqvpException(ARTICLE_NOT_CREATED_EXCEPTION, params);
        }
        return art;
    }


}