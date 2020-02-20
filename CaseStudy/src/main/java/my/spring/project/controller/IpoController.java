package my.spring.project.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import my.spring.project.dao.CompanyRelatedRepository;
import my.spring.project.dao.IpoRepository;
//import my.spring.project.pojos.CompanyRelated;
import my.spring.project.pojos.Ipo;

@RestController
@RequestMapping("ipo")
public class IpoController {
	@Autowired
	private IpoRepository iporepository;
	@RequestMapping("/getAllipo")
	public Iterable<Ipo> getAllcompanies()
	{
		return iporepository.findAll();
	}
	@PostMapping("/saveipo")
	public Ipo saveIpo(@RequestBody Ipo ipo) {
		System.out.println(ipo);
		iporepository.save(ipo);
		return ipo;
	}
	@PutMapping("/updateipo/{companyname}")
	public Ipo updateIpo(@RequestBody Ipo ipo, @PathVariable("companyname") String companyname)
	{
		ipo.getCompanyName();
		System.out.println(ipo);
		iporepository.save(ipo);
		return ipo;
	}
	@GetMapping("/find/{id}")
	public Ipo find(@PathVariable("id")Integer id) {
		Optional<Ipo> ipo=iporepository.findById(id);
		return ipo.get();
	}
	@DeleteMapping("/delete/{id}")
	public boolean delete(@PathVariable("id")Integer id) {
		iporepository.deleteById(id);
		return true;
	}

}
