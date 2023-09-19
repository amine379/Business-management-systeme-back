package ma.baggar.bmsback.Service.Implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.baggar.bmsback.Dao.ReceptionDao;
import ma.baggar.bmsback.Dto.ReceptionDto;
import ma.baggar.bmsback.Entity.Article;
import ma.baggar.bmsback.Entity.TvaEntity;
import ma.baggar.bmsback.Service.ReceptionService;
@Service
public class ReceptionServiceImp implements ReceptionService {
	@Autowired
ReceptionDao receptionDao;
	@Override
	public ReceptionDto saveReception(ReceptionDto receptionDto) {
		List<Article> articles=receptionDto.getArticles();
		List<Double> prixTtc=new ArrayList<>();
		
		for(Article article:articles) {
			TvaEntity tva=article.getTva();
			prixTtc.add(article.getPurchase_price()*tva.getValue());
		}
		receptionDto.setPrixTtc(prixTtc);
		return receptionDao.saveReception(receptionDto);
	}

}
