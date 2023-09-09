package ma.baggar.bmsback.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.baggar.bmsback.Entity.Fournisseur;
@Repository
public interface FournisseurRepository extends JpaRepository<Fournisseur, Integer>{
Fournisseur findById(int id);
Fournisseur findByNom(String nom);
}
