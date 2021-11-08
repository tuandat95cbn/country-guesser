package de.moqc.guesser;

import org.elasticsearch.common.inject.name.Named;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import lombok.Data;
@Data
@Document(indexName = "common_name")
public class CommonName {
	private String id;
	private double percent;
	private String name;
	@Field(name = "country_code")
	private String countryCode;
}
