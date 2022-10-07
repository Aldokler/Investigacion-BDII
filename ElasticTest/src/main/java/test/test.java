/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._types.ElasticsearchException;
import co.elastic.clients.elasticsearch._types.query_dsl.QueryBuilders;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;
import co.elastic.clients.elasticsearch.core.search.TotalHits;
import co.elastic.clients.elasticsearch.core.search.TotalHitsRelation;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import java.io.IOException;
import java.util.ArrayList;
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
    public static void main(String[] args) throws IOException, InterruptedException{
        System.out.println("Test");
        List<Person> maes = findByName("Ingrid");
        System.out.println("There are " + maes.size() + " results");
        maes.forEach(mae -> {
            System.out.println(mae);
        });
        System.out.println("Test");
    }
    
    //Carga el username y la password
    private static CredentialsProvider credentialsProvider(){
        final CredentialsProvider credentialsProvider =
            new BasicCredentialsProvider();
        credentialsProvider.setCredentials(AuthScope.ANY,
            new UsernamePasswordCredentials("elastic", "LIlCEld2NGrC6X6Fva4EFqud"));
        return credentialsProvider;
    };
    
    //Carga el link de la base http y el puerto
    private static final RestClientBuilder builder = RestClient.builder(
        new HttpHost("investigacio-n-bdii.es.us-central1.gcp.cloud.es.io", 9243, "https"))
        .setHttpClientConfigCallback((HttpAsyncClientBuilder httpClientBuilder) -> httpClientBuilder
                .setDefaultCredentialsProvider(credentialsProvider()));
    
    // Create the low-level client
    private static final RestClient restClient = builder.build();

    // Create the transport with a Jackson mapper
    private static final ElasticsearchTransport transport = new RestClientTransport(
        restClient, new JacksonJsonpMapper());

    // And create the API client
    private static final ElasticsearchClient client = new ElasticsearchClient(transport);
    
    //Funcion que retorna las personas con el nombre name
    public static List<Person> findByName (String name){
            List<Person> results = new ArrayList<>();
            try{
                SearchResponse<Person> response = client.search(s -> s
                    .index("person")
                    .size(101000)
                    .query(q -> q      
                        .match(t -> t   
                            .field("name")  
                            .query(name)
                        )
                    ),
                    Person.class      
                );
                List<Hit<Person>> hits = response.hits().hits();
                for (Hit<Person> hit: hits) {
                    results.add(hit.source());
                }
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
            return results;  
    }
    
    //Funcion que retorna las personas con el id id
    public static List<Person> findById (String id){
            List<Person> results = new ArrayList<>();
            try{
                SearchResponse<Person> response = client.search(s -> s
                    .index("person")
                    .size(101000)
                    .query(q -> q      
                        .match(t -> t   
                            .field("id")  
                            .query(id)
                        )
                    ),
                    Person.class      
                );
                List<Hit<Person>> hits = response.hits().hits();
                for (Hit<Person> hit: hits) {
                    results.add(hit.source());
                }
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
            return results;  
    }
   
    //1930 a 2020
    //Funcion que retorna las personas que nacieron en el año age
    public static List<Person> findByAge (String age){
            List<Person> results = new ArrayList<>();
            try{
                SearchResponse<Person> response = client.search(s -> s
                    .index("person")
                    .size(101000)
                    .query(q -> q      
                        .match(t -> t   
                            .field("birthdate")  
                            .query(age)
                        )
                    ),
                    Person.class      
                );
                List<Hit<Person>> hits = response.hits().hits();
                for (Hit<Person> hit: hits) {
                    results.add(hit.source());
                }
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
            return results;  
    }
}
