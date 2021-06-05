package hrmskodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrmskodlamaio.hrms.business.abstracts.CandidateSchoolService;
import hrmskodlamaio.hrms.core.utilities.results.DataResult;
import hrmskodlamaio.hrms.core.utilities.results.Result;
import hrmskodlamaio.hrms.entities.concretes.CandidateSchool;

@RestController
@RequestMapping
public class CandidateSchoolsManager {
	
	private CandidateSchoolService candidateSchoolService;

	@Autowired
	public CandidateSchoolsManager(CandidateSchoolService candidateSchoolService) {
		super();
		this.candidateSchoolService = candidateSchoolService;
	}
	
	@PostMapping("/add")
	Result add(@RequestBody CandidateSchool candidateSchool) {
		return this.candidateSchoolService.add(candidateSchool);
	}
	
	@GetMapping("/findAllByCandidateCvIdOrderByGraduationYearDesc")
	DataResult<List<CandidateSchool>> findAllByCandidateCvIdOrderByGraduationYearDesc(int id){
		return this.candidateSchoolService.findAllByCandidateCvIdOrderByGraduationYearDesc(id);
	}

}
