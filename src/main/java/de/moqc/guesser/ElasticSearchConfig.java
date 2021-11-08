package de.moqc.guesser;

import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.nio.client.HttpAsyncClientBuilder;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.RestClientBuilder.HttpClientConfigCallback;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories
public class ElasticSearchConfig extends AbstractElasticsearchConfiguration {
	@Value("${spring.es.host}")
	private String host;

	@Value("${spring.es.port}")
	private Integer port;

	@Value("${spring.es.username}")
	private String username;
	@Value("${spring.es.password}")
	private String password;

	@Override
	@Bean
	public RestHighLevelClient elasticsearchClient() {
		System.out.println(username+"----"+password);
		final ClientConfiguration clientConfiguration = ClientConfiguration.builder()
				.connectedTo(host + ":" + port).withBasicAuth(username, password).build();
// final CredentialsProvider credentialsProvider =
//     new BasicCredentialsProvider();
// credentialsProvider.setCredentials(AuthScope.ANY,
//     new UsernamePasswordCredentials(username, password));

// RestClientBuilder builder = RestClient.builder(
//     new HttpHost(host, port))
//     .setHttpClientConfigCallback(new HttpClientConfigCallback() {
//         @Override
//         public HttpAsyncClientBuilder customizeHttpClient(
//                 HttpAsyncClientBuilder httpClientBuilder) {
//             return httpClientBuilder
//                 .setDefaultCredentialsProvider(credentialsProvider);
//         }
//     });
		return RestClients.create(clientConfiguration).rest();
	}
}
