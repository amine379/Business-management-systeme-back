package ma.baggar.bmsback.Service;

import java.util.List;

import ma.baggar.bmsback.Dto.FournisseurDto;

public interface FournisseurService {
	FournisseurDto CreateFournisseur(FournisseurDto fournisseurDtos);
FournisseurDto addAgencesToFournisseur(int fournisseuId,List<Integer> agencesIds);
List<FournisseurDto> getAllFournisseurs();
}
