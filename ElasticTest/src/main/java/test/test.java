/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._types.ElasticsearchException;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import java.io.IOException;
import java.util.List;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.nio.client.HttpAsyncClientBuilder;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;

/**
 *
 * @author Aldokler
 */
public class test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        List<Person> maes = findByName("Ingrid");
        maes.forEach(mae -> {
            System.out.println(mae);
        });
    }
    
    private static CredentialsProvider credentialsProvider(){
        final CredentialsProvider credentialsProvider =
            new BasicCredentialsProvider();
        credentialsProvider.setCredentials(AuthScope.ANY,
            new UsernamePasswordCredentials("elastic", "LIlCEld2NGrC6X6Fva4EFqud"));
        return credentialsProvider;
    };
    
    private static final RestClientBuilder builder = RestClient.builder(
        new HttpHost("investigacio-n-bdii.kb.us-central1.gcp.cloud.es.io", 9243, "https"))
        .setHttpClientConfigCallback((HttpAsyncClientBuilder httpClientBuilder) -> httpClientBuilder
                .setDefaultCredentialsProvider(credentialsProvider()));
    
    // Create the low-level client
    private static final RestClient restClient = builder.build();

    // Create the transport with a Jackson mapper
    private static final ElasticsearchTransport transport = new RestClientTransport(
        restClient, new JacksonJsonpMapper());

    // And create the API client
    private static final ElasticsearchClient client = new ElasticsearchClient(transport);
    
    public static List<Person> findByName (String name){
        try{
                SearchResponse<Person> search = client.search(b -> b
                .index("person")
                .query(q -> q
                    .term(t -> t
                        .field("name")
                        .value(name)
                    )
                ),
                Person.class
            );
                
            List<Person> results = null;

            List<Hit<Person>> hits = search.hits().hits();
            hits.stream().map(hit -> hit.source()).forEachOrdered(results::add);
            return results;  
        }catch (ElasticsearchException | IOException e){
            System.out.println(e.getMessage());
        }
        return null;
    }
    
    public static List<Person> findById (String id){
        try{
                SearchResponse<Person> search = client.search(b -> b
                .index("person")
                .query(q -> q
                    .term(t -> t
                        .field("id")
                        .value(id)
                    )
                ),
                Person.class
            );
                
            List<Person> results = null;

            List<Hit<Person>> hits = search.hits().hits();
            hits.stream().map(hit -> hit.source()).forEachOrdered(results::add);
            return results;  
        }catch (ElasticsearchException | IOException e){
            System.out.println(e.getMessage());
        }
        return null;
    }
   
}
