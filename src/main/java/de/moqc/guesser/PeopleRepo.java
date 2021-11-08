package de.moqc.guesser;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface PeopleRepo extends ElasticsearchRepository<CommonName, String> {
	public List<CommonName> findByNameLike(String name);
}
