package ma.baggar.bmsback.Dao;

import java.util.List;

import ma.baggar.bmsback.Dto.FournisseurDto;
import ma.baggar.bmsback.Entity.Fournisseur;

public interface FournisseurDao {
FournisseurDto CreateFournisseur(FournisseurDto fournisseurDto);
FournisseurDto addAgencesToFournisseur(int FournisseurId,List<Integer> agenceIds);
List<FournisseurDto> getAllFournisseur();
FournisseurDto getFournisseurByName(String name);
FournisseurDto getFournisseurByStatus(boolean status);
boolean checkifFournisseurExist(Fournisseur fournisseur);
} 
