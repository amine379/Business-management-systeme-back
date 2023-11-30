package ma.baggar.bmsback.Dao.Implementation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ma.baggar.bmsback.Dto.ArticleDto;
import ma.baggar.bmsback.Dto.FournisseurDto;
import ma.baggar.bmsback.Entity.Article;
import ma.baggar.bmsback.Entity.Fournisseur;
import ma.baggar.bmsback.exception.Agence.AgenceNotFoundException;
import ma.baggar.bmsback.exception.Agence.EntityAlreadyExistsException;
import org.modelmapper.ModelMapper;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ma.baggar.bmsback.Dao.AgenceDao;
import ma.baggar.bmsback.Dto.AgenceDto;
import ma.baggar.bmsback.Entity.Agence;
import ma.baggar.bmsback.Repository.AgenceRepository;
@Repository
public class AgenceDaoImp implements AgenceDao {
	@Autowired
AgenceRepository agenceRepository;
	@Autowired
	ModelMapper modelMapper;
	@Override
	public AgenceDto createAgence(AgenceDto agenceDto) {
		Agence agence=modelMapper.map(agenceDto, Agence.class);
		if(!checkIfExist(agence)) {
		Agence agenceToSave=agenceRepository.save(agence);
		 return modelMapper.map(agenceToSave, AgenceDto.class);

		}
	
		throw new EntityAlreadyExistsException("L'Agence est deja Existe");
	}
	//il faut tester check
	@Override
	public boolean checkIfExist(Agence agence) {
		// TODO Auto-generated method stub
		Agence agenceToTestIfExist=agenceRepository.findByName(agence.getName());
		return (agenceToTestIfExist!=null);
	}
	@Override
	public List<AgenceDto> getAllAgences() {
		List<Agence> agences=agenceRepository.findAll();
			try {
				if (agences == null || agences.isEmpty()){
					throw  new IllegalStateException("la liste des agences est empty");
				}
				List<AgenceDto> agencesDto=new ArrayList<>();
				for(Agence agence:agences) {
					AgenceDto agenceDto=modelMapper.map(agence, AgenceDto.class);
					agencesDto.add(agenceDto);

				}
				return agencesDto;
			}
			catch (Exception e){
				return  Collections.emptyList();
			}

		}

	@Override
	public AgenceDto updateAgence(int id, AgenceDto agenceDto) {
		Agence agence=agenceRepository.findById(id);
		try{
		if(agence==null){
			throw new AgenceNotFoundException("Record with provided data is not found"+Agence.class.getName());
		}
		agence.setName(agenceDto.getName());
		if(!agenceDto.getArticle().isEmpty()){
			List<Article> articles=new ArrayList<>();

			for(ArticleDto articleDto:agenceDto.getArticle()){
				articles.add(modelMapper.map(articleDto,Article.class));
			}
			agence.setArticles(articles);
		}
		if(!agenceDto.getFournisseur().isEmpty()){
			List<Fournisseur> fournisseurs=new ArrayList<>();
			for (FournisseurDto fournisseurDto:agenceDto.getFournisseur()){
				fournisseurs.add(modelMapper.map(fournisseurDto, Fournisseur.class));
			}
			agence.setFournisseur(fournisseurs);
		}
		Agence updateAgence=agenceRepository.save(agence);
		return modelMapper.map(updateAgence,AgenceDto.class);
		}
		catch (Exception e){
			throw new RuntimeException("An error occurred while updating the Agence"+id+e);
		}
	}

	@Override
	public void deleteAgence(int id) {
		Agence agence=agenceRepository.findById(id);
		try {
			if (agence==null){throw new AgenceNotFoundException("Record with provided data is not found"+Agence.class.getName());}
			agenceRepository.delete(agence);
		}
		catch (Exception e){
throw  new RuntimeException("An error occurred while deleting Agence with ID " + id, e);
		}

	}


}
