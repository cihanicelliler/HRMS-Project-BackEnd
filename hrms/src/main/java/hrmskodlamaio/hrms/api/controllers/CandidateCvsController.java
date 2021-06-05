package hrmskodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrmskodlamaio.hrms.business.abstracts.CandidateCvService;
import hrmskodlamaio.hrms.core.utilities.results.DataResult;
import hrmskodlamaio.hrms.core.utilities.results.Result;
import hrmskodlamaio.hrms.entities.concretes.CandidateCv;

@RestController
@RequestMapping("/api/candidatecvs")
public class CandidateCvsController {

	private CandidateCvService candidateCvService;

	@Autowired
	public CandidateCvsController(CandidateCvService candidateCvService) {
		super();
		this.candidateCvService = candidateCvService;
	}
	
	@GetMapping("/getall")
	DataResult<List<CandidateCv>> getAll(){
		return this.candidateCvService.getAll();
	}
	
	@PostMapping("/add")
	Result add(@RequestBody CandidateCv candidateCv) {
		return this.candidateCvService.add(candidateCv);
	}
	
	@GetMapping("/findAllByCandidateId")
	DataResult<List<CandidateCv>> findAllByCandidateId(int id){
		
		return this.candidateCvService.findAllByCandidateUserId(id);
	}
	
}
