package ma.baggar.bmsback.Dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.baggar.bmsback.Entity.Article;
import ma.baggar.bmsback.Entity.Reception;
@Data @AllArgsConstructor @NoArgsConstructor
public class ReceptionDetailDto {
public Long id;
private Article article;
private float quantite;
private float prixTtc;
private ReceptionDto reception;
}
