package de.moqc.guesser;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {
	@Autowired
	private PeopleRepo peopleRepo;
	@GetMapping("/country_guess")
	public ResponseEntity<Map> guess(@RequestParam String name) {
		long startTime = System.currentTimeMillis();
		List<CommonName> lCommonNames=peopleRepo.findByNameLike(name);
		List<String> lcountries= lCommonNames.stream().map(c -> c.getCountryCode()).collect(Collectors.toList());
		long stopTime = System.currentTimeMillis();
		long elapsedTime = stopTime - startTime;
		Map<String, Object> res = new HashMap<>();
		res.put("requested_name", name);
		res.put("guessed_country", lcountries);
		res.put("time_processed", elapsedTime + "");
		return ResponseEntity.ok().body(res);
	}
	@GetMapping("/")
	public ResponseEntity<String> greeting(Principal principal) {
		return ResponseEntity.ok().body(principal.getName());
	}
}
