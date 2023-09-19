package ma.baggar.bmsback.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.baggar.bmsback.Entity.Article;
@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
Article findByName(String name);
Optional<Article> findById(Long id);
}
