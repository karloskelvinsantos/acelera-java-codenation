package challenge;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "scripts")
public class Quote implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column
	private int episode;

	@Column(name = "episode_name")
	private String episodeName;

	@Column
	private String segment;

	@Column
	private String type;

	@Column
	private String actor;

	@Column
	private String character;

	@Column(name = "detail")
	private String quote;

	@Column(name = "record_date")
	private LocalDate recordDate;

	@Column
	private String series;

	@Column(name = "transmission_date")
	private LocalDate transmissionDate;

	public Quote() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEpisode() {
		return episode;
	}

	public void setEpisode(int episode) {
		this.episode = episode;
	}

	public String getEpisodeName() {
		return episodeName;
	}

	public void setEpisodeName(String episodeName) {
		this.episodeName = episodeName;
	}

	public String getSegment() {
		return segment;
	}

	public void setSegment(String segment) {
		this.segment = segment;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getActor() {
		return actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	public String getCharacter() {
		return character;
	}

	public void setCharacter(String character) {
		this.character = character;
	}

	public String getQuote() {
		return quote;
	}

	public void setQuote(String quote) {
		this.quote = quote;
	}

	public LocalDate getRecordDate() {
		return recordDate;
	}

	public void setRecordDate(LocalDate recordDate) {
		this.recordDate = recordDate;
	}

	public String getSeries() {
		return series;
	}

	public void setSeries(String series) {
		this.series = series;
	}

	public LocalDate getTransmissionDate() {
		return transmissionDate;
	}

	public void setTransmissionDate(LocalDate transmissionDate) {
		this.transmissionDate = transmissionDate;
	}
}
