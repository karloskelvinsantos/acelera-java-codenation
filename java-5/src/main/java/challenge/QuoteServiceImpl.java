package challenge;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class QuoteServiceImpl implements QuoteService {

	protected QuoteRepository repository;

	public QuoteServiceImpl(QuoteRepository repository) {
		this.repository = repository;
	}

	@Override
	public Quote getQuote() {
		List<Quote> quotes = repository.findAll();

		return quotes.get(new Random().nextInt(quotes.size()) + 1);
	}

	@Override
	public Quote getQuoteByActor(String actor) {
		List<Quote> quotes = repository.findByActor(actor);

		return quotes.get(new Random().nextInt(quotes.size()) + 1);
	}

}
