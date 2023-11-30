package ma.baggar.bmsback.Dao.Implementation;


import java.math.BigDecimal;
import java.util.Optional;

import ma.baggar.bmsback.Dto.FactureDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import ma.baggar.bmsback.Dao.FactureDetailDao;
import ma.baggar.bmsback.Dto.FactureDetailDto;
import ma.baggar.bmsback.Dto.Shared.CalculePrixTtc;
import ma.baggar.bmsback.Entity.Article;
import ma.baggar.bmsback.Entity.Facture;
import ma.baggar.bmsback.Entity.FactureDetail;
import ma.baggar.bmsback.Repository.ArticleRepository;
import ma.baggar.bmsback.Repository.FactureDetailRepository;
import ma.baggar.bmsback.Repository.FactureRepository;
import org.springframework.stereotype.Repository;

@Repository
public class FactureDetailDaoImp implements FactureDetailDao  {
	@Autowired
FactureRepository factureRepository;
	@Autowired
	FactureDetailRepository factureDetailRepository;
	@Autowired 
	ArticleRepository articleRepository;
	@Autowired 
	CalculePrixTtc calculePrixTtc;
	@Autowired
	ModelMapper modelMapper;
	
	@Override
	public FactureDetailDto createFactureDetail(FactureDetailDto factureDetailDto) {
		/* ModelMapper modelMapper=new ModelMapper();
		if(factureDetailDto.getPrixHt()!=0) {
			Double prixTtc=calculePrixTtc.calcule(factureDetailDto.getPrixHt(),  factureDetailDto.getArticle().getTva().getValue(), factureDetailDto.getQuantity());
			FactureDetail  factureDetail=modelMapper.map(factureDetailDto, FactureDetail.class);
			factureDetail.setPrxiTtc(prixTtc);
			Optional<Article> article=articleRepository.findById(factureDetailDto.getArticle().getId());
			if(article.isPresent()) {
				Article article2=article.get();
				factureDetail.setArticle(article2);
			}
			Optional<Facture> facture=factureRepository.findById(factureDetailDto.getFactureDto().getId());
			if(facture.isPresent()) {
				Facture facture2=facture.get();
				factureDetail.setFacture(facture2);
			}
			FactureDetail factureDetailCreated=factureDetailRepository.save(factureDetail);
			return modelMapper.map(factureDetailCreated, FactureDetailDto.class);
		}
		else
		{
			FactureDetail  factureDetail=modelMapper.map(factureDetailDto, FactureDetail.class);
			double prixTtc=calculePrixTtc.calcule(factureDetailDto.getArticle().getSelling_price(), factureDetailDto.getArticle().getTva().getValue(), factureDetailDto.getQuantity());
			factureDetail.setPrxiTtc(prixTtc);
			factureDetail.setPrixHt(factureDetailDto.getArticle().getSelling_price());
			Optional<Article> article=articleRepository.findById(factureDetailDto.getArticle().getId());
			if(article.isPresent()) {
				Article article2=article.get();
				factureDetail.setArticle(article2);
			}
			Optional<Facture> facture=factureRepository.findById(factureDetailDto.getFactureDto().getId());
			if(facture.isPresent()) {
				Facture facture2=facture.get();
				factureDetail.setFacture(facture2);
			}
			FactureDetail factureDetailCreated=factureDetailRepository.save(factureDetail);
			return modelMapper.map(factureDetailCreated, FactureDetailDto.class);
		}*/
		return  null;
	}

	@Override
	public FactureDetailDto createFactureDetailForFacture(Facture Facture, FactureDetailDto factureDetailDto) {
		if(factureDetailDto.getQuantity()!=0.00 && factureDetailDto.getPrixHt()!=null){
		FactureDto factureDto=modelMapper.map(Facture,FactureDto.class);
		factureDetailDto.setFacture(factureDto);
		//calcule prixht et prix ttc
   factureDetailDto.setPrxiTtc(
		   calculePrixTtc.calcule(
		   factureDetailDto.getPrixHt(),
				   factureDetailDto.getTvaValue(),
				   factureDetailDto.getQuantity()
   ));
   FactureDetail factureDetail=modelMapper.map(factureDetailDto,FactureDetail.class);
   FactureDetail factureDetailCreated= factureDetailRepository.save(factureDetail);
return modelMapper.map(factureDetailCreated,FactureDetailDto.class);

		}

		else{
			throw new IllegalArgumentException("il faut précisé la quantité et la valeur de prix ht d'article");
		}

	}


}
