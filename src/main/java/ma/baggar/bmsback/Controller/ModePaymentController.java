package ma.baggar.bmsback.Controller;

import jakarta.validation.Valid;
import ma.baggar.bmsback.Entity.ModePayment;
import ma.baggar.bmsback.Repository.ModePaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("api/modepayment")
public class ModePaymentController {
    @Autowired
    ModePaymentRepository modePaymentRepository;
    @GetMapping
    public List<ModePayment> getAllModePayment(){
        return  this.modePaymentRepository.findAll();
    }
    @PostMapping
    public ModePayment createModePayment(@RequestBody @Valid ModePayment modePayment){
        return this.modePaymentRepository.save(modePayment) ;
    }
}
