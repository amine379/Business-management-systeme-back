package ma.baggar.bmsback.Repository.UsingByArticle;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.baggar.bmsback.Entity.UsingByArticle.ArticlesSousFamilles;
@Repository
public interface ArticlesSousFamillesRepository extends JpaRepository<ArticlesSousFamilles, Integer> {

}
