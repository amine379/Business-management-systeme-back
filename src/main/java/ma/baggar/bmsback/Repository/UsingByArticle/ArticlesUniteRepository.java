package ma.baggar.bmsback.Repository.UsingByArticle;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.baggar.bmsback.Entity.UsingByArticle.ArticlesUnite;

@Repository
public interface ArticlesUniteRepository extends JpaRepository<ArticlesUnite, Integer> {
ArticlesUnite findById(int id);
}
