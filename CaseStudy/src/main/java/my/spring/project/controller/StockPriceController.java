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

//import my.spring.project.dao.SectorsRepository;
import my.spring.project.dao.StockPriceRepository;
//import my.spring.project.pojos.Sectors;
import my.spring.project.pojos.StockPrice;

@RestController
@RequestMapping("/stockprice")
public class StockPriceController {
	@Autowired
	private StockPriceRepository stockpricerepository;
	@RequestMapping("/getAllstockprice")
	public Iterable<StockPrice> getAllstockprice()
	{
		return stockpricerepository.findAll();
	}
	@PostMapping("/savestockprice")
	public StockPrice saveStockPrice(@RequestBody StockPrice stockprice) {
		System.out.println(stockprice);
		stockpricerepository.save(stockprice);
		return stockprice;
	}
	@PutMapping("/updatestockprice/{stockexchange}")
	public StockPrice updateStockPrice(@RequestBody StockPrice stockprice, @PathVariable("stockexchange") String stockexchange)
	{
		stockprice.setStockExchange(stockexchange);
		System.out.println(stockprice);
		stockpricerepository.save(stockprice);
		return stockprice;
	}
	@GetMapping("/find/{companycode}")
	public StockPrice find(@PathVariable("companycode")String companycode) {
		Optional<StockPrice> stockprice=stockpricerepository.findById(companycode);
		return stockprice.get();
	}
	@DeleteMapping("/delete/{companycode}")
	public boolean delete(@PathVariable("companycode")String companycode) {
		stockpricerepository.deleteById(companycode);
		return true;
	}


}
