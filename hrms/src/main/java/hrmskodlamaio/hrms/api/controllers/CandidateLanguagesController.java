package hrmskodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrmskodlamaio.hrms.business.abstracts.CandidateLanguageService;
import hrmskodlamaio.hrms.core.utilities.results.DataResult;
import hrmskodlamaio.hrms.core.utilities.results.Result;
import hrmskodlamaio.hrms.entities.concretes.CandidateLanguage;

@RestController
@RequestMapping("/api/candidatelanguages")
public class CandidateLanguagesController {
	
	private CandidateLanguageService candidateLanguageService;

	@Autowired
	public CandidateLanguagesController(CandidateLanguageService candidateLanguageService) {
		super();
		this.candidateLanguageService = candidateLanguageService;
	}
	
	@PostMapping("/add")
	Result add(@RequestBody CandidateLanguage candidateLanguage) {
		return this.candidateLanguageService.add(candidateLanguage);
	}
	
	@GetMapping("/getAll")
	DataResult<List<CandidateLanguage>> getAll(){
		return this.candidateLanguageService.getAll();
	}

}
