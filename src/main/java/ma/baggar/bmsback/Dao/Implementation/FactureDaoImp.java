package ma.baggar.bmsback.Dao.Implementation;

import ma.baggar.bmsback.Dao.FactureDetailDao;
import ma.baggar.bmsback.Dto.FactureDetailDto;
import ma.baggar.bmsback.Entity.Facture;
import ma.baggar.bmsback.Repository.ClientRepository;
import ma.baggar.bmsback.exception.Facture.FactureNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import ma.baggar.bmsback.Dao.FactureDao;
import ma.baggar.bmsback.Dto.FactureDto;
import ma.baggar.bmsback.Repository.FactureRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class FactureDaoImp implements FactureDao {
    @Autowired
FactureRepository factureRepository;
    @Autowired
    FactureDetailDao factureDetailDao;
    @Autowired
    ClientRepository clientRepository;
    @Autowired
ModelMapper modelMapper;
    @Override
    public FactureDto createFacture(FactureDto factureDto) {
        //
        List<FactureDetailDto> factureDetailDtos=new ArrayList<>();
        if (factureDto.getFactureDetails()== null || factureDto.getFactureDetails().isEmpty()) {

            throw new IllegalArgumentException("Facture must have at least one facture detail.");
        }
        factureDetailDtos = factureDto.getFactureDetails();
        FactureDto factureDtoToCreate = new FactureDto(
                factureDto.getClient(),
                factureDto.getReferance(),
                factureDto.getDateFacture(),
                factureDto.getModePayment(),
                factureDto.getRemise()
                ,factureDto.getRemarque());
        Facture facture = modelMapper.map(factureDtoToCreate, Facture.class);
        Facture factureCreated = factureRepository.save(facture);
        BigDecimal totalHtFacture = BigDecimal.ZERO;
        BigDecimal totalTtcFacture = BigDecimal.ZERO;
        for (FactureDetailDto factureDetailDto : factureDto.getFactureDetails()){
           FactureDetailDto factureDetailDto1 = factureDetailDao.createFactureDetailForFacture(factureCreated,factureDetailDto);
           totalHtFacture=totalHtFacture.add(factureDetailDto1.getPrixHt());
           totalTtcFacture=totalTtcFacture.add(factureDetailDto1.getPrxiTtc());
        }

   return CalculeFacture(factureCreated.getId(),totalHtFacture,totalTtcFacture);


    }

    @Override
    public FactureDto CalculeFacture(Long factureId,BigDecimal prixHt,BigDecimal prixttc) {
        if(!factureRepository.findById(factureId).isEmpty()){
Facture facture=factureRepository.findById(factureId).get();
facture.setTotalHt(prixHt);
if(facture.getRemise()== null ||facture.getRemise().compareTo(BigDecimal.ZERO) == 0){
    facture.setTotalTtc(prixttc);
    facture.setTva(prixttc.subtract(prixHt));
}
else {
    facture.setTotalTtc(prixttc.subtract(facture.getRemise()));
    BigDecimal prixTtcFacture=prixttc.subtract(facture.getRemise());
    facture.setTva(prixTtcFacture.subtract(prixHt));
}
Facture factureCalculed= factureRepository.save(facture);
return  modelMapper.map(factureCalculed,FactureDto.class);

        }
else throw  new FactureNotFoundException("la facture n'existe pas ");
    }

    @Override
    public List<FactureDto> getAllFacture() {
        List<FactureDto> factureDtos=new ArrayList<>();
        List<Facture> allFacture=factureRepository.findAll();
        if(allFacture==null || allFacture.isEmpty()){
            throw new FactureNotFoundException("la liste des facture est vide");
        }
        for(Facture facture:allFacture){
            factureDtos.add(modelMapper.map(facture,FactureDto.class));
        }
        return factureDtos;
    }



    @Override
    public List<FactureDto> getFactureByClient(int clientId) {
        List<Facture> factueByClient=factureRepository.findByClient(clientRepository.findById(clientId));
        List<FactureDto> factureByClientDto=new ArrayList<>();
        if(factueByClient==null||factueByClient.isEmpty()){
            throw  new FactureNotFoundException("la liste des factures qui contient client with id"+clientId);
        }
       else {
           for(Facture facture:factueByClient){
               factureByClientDto.add(modelMapper.map(facture,FactureDto.class));
           }
           return  factureByClientDto;
        }
    }

    @Override
    public FactureDto getFactureByReferance(String refetence) {
 Facture facture=factureRepository.findByReferance(refetence);
 if(facture!=null){
     return modelMapper.map(facture,FactureDto.class);
 }
  throw  new FactureNotFoundException("il n'existe pas une facture qui a reference suivant:"+refetence);
    }

    @Override
    public List<FactureDto> getFactureByDate(Date dateFacture) {
        List<Facture> factures=factureRepository.findByDateFacture(dateFacture);
        List<FactureDto> factureDtos=new ArrayList<>();
        if(factures!=null && !factures.isEmpty()){
          for (Facture facture:factures){
              factureDtos.add(modelMapper.map(facture,FactureDto.class));
          }
          return factureDtos;
        }
        throw new FactureNotFoundException("il n'existe pas une facture dans la date suivante"+dateFacture);
    }

    @Override
    public void deleteFacture(int id) {
        if(factureRepository.findById(id)!=null){
            factureRepository.delete(factureRepository.findById(id));
        }
        throw new FactureNotFoundException("facture Not Found Exception");
    }
}

