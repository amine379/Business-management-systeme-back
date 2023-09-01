package ma.baggar.bmsback.Repository.UsingByArticle;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.baggar.bmsback.Entity.UsingByArticle.ArticlesFamille;
@Repository
public interface ArticlesFamilleRepository extends JpaRepository<ArticlesFamille, Integer>{

}
