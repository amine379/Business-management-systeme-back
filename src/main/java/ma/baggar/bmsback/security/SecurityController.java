package ma.baggar.bmsback.security;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.JwsHeader;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/*
@RestController
@RequestMapping("api/auth")
public class SecurityController {
	@Autowired
private AuthenticationManager authenticationManager;
	@Autowired
	private JwtEncoder jwtEncoder;
	//consulter le profil de user authentifier
	@GetMapping("/profile")
	public Authentication authentication(Authentication authentication) {
		return authentication;
	}
	//il va genere le tokken apres authentication de user
	@PostMapping("/login")
	public Map<String, String> Login(@RequestParam(name = "user") String username,@RequestParam(name = "pass") String password){
		//1-authentification recevoire requete http et verfier if user existe
		
		Authentication authentication= authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(username, password)
				);
		//recuperer les roles 
		String scope=authentication.getAuthorities().stream().map(a->a.getAuthority()).collect(Collectors.joining(" "));
		Instant instant=Instant.now();
		//generer le token
		JwtClaimsSet jwtClaimsSet=JwtClaimsSet.builder()
				.issuedAt(instant) //la date de token 
				.expiresAt(instant.plus(10, ChronoUnit.DAYS))//la date de l expirassion
				.subject(username)
				.claim("scope", scope) //les roles
				.build();
		//encoder 
		JwtEncoderParameters jwtEncoderParameters=
				JwtEncoderParameters.from(
						JwsHeader.with(MacAlgorithm.HS512).build(),
						jwtClaimsSet //les claims que j ai créé
);
String jwt=jwtEncoder.encode(jwtEncoderParameters).getTokenValue();	
return Map.of("le-token-d'acce",jwt);
				
	}
}*/
