package hrmskodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrmskodlamaio.hrms.business.abstracts.CandidateTechnologyService;
import hrmskodlamaio.hrms.core.utilities.results.DataResult;
import hrmskodlamaio.hrms.core.utilities.results.Result;
import hrmskodlamaio.hrms.entities.concretes.CandidateTechnology;

@RestController
@RequestMapping("/api/candidatetechnologies")
public class CandidateTechnologiesManager {

	private CandidateTechnologyService candidateTechnologyService;

	@Autowired
	public CandidateTechnologiesManager(CandidateTechnologyService candidateTechnologyService) {
		super();
		this.candidateTechnologyService = candidateTechnologyService;
	}

	@PostMapping("/add")
	Result add(@RequestBody CandidateTechnology candidateLanguage) {
		return this.candidateTechnologyService.add(candidateLanguage);
	}

	@GetMapping("/getall")
	DataResult<List<CandidateTechnology>> getAll(){
		return this.candidateTechnologyService.getAll();
	}
}
