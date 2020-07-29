package challenge;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuoteController {

	protected QuoteService service;

	public QuoteController(QuoteService service) {
		this.service = service;
	}

	@GetMapping(value = "/v1/quote")
	public Quote getQuote() {
		return service.getQuote();
	}

	@GetMapping(value = "/v1/quote/{actor}")
	public Quote getQuoteByActor(@PathVariable String actor) {
		return service.getQuoteByActor(actor);
	}

}
