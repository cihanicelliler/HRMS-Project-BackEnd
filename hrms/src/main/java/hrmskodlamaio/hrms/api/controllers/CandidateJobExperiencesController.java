package hrmskodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrmskodlamaio.hrms.business.abstracts.CandidateJobExperienceService;
import hrmskodlamaio.hrms.core.utilities.results.DataResult;
import hrmskodlamaio.hrms.core.utilities.results.Result;
import hrmskodlamaio.hrms.entities.concretes.CandidateJobExperience;

@RestController
@RequestMapping("/api/candidatejobexpreiences")
public class CandidateJobExperiencesController {
	
	private CandidateJobExperienceService candidateJobExperienceService;

	@Autowired
	public CandidateJobExperiencesController(CandidateJobExperienceService candidateJobExperienceService) {
		super();
		this.candidateJobExperienceService = candidateJobExperienceService;
	}
	
	@PostMapping("/add")
	Result add(@RequestBody CandidateJobExperience candidateJobExperience) {
		return this.candidateJobExperienceService.add(candidateJobExperience);
	}
	
	@GetMapping("/getall")
	DataResult<List<CandidateJobExperience>> getAll(){
		return this.candidateJobExperienceService.getAll();
	}
	
	@GetMapping("/findAllByCandidateCvIdOrderByYearOfLeavingDesc")
	DataResult<List<CandidateJobExperience>> findAllByCandidateCvIdOrderByYearOfLeavingDesc(int id){
		return this.candidateJobExperienceService.findAllByCandidateCvIdOrderByYearOfLeavingDesc(id);
	}

}
