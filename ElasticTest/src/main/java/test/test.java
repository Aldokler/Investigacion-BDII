/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._types.query_dsl.QueryBuilders;
import co.elastic.clients.elasticsearch._types.query_dsl.TermQuery;
import co.elastic.clients.elasticsearch.core.SearchRequest;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;

/**
 *
 * @author Aldokler
 */
public class test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        ArrayList<Person> personas = findById("210031569");
        for(Person person: personas){
            System.out.println(person);
        }
    }
    
    // Create the low-level client
    private static final RestClient restClient = RestClient.builder(
        new HttpHost("investigacio-n-bdii.kb.us-central1.gcp.cloud.es.io", 9243, "https")).build();

    // Create the transport with a Jackson mapper
    private static final ElasticsearchTransport transport = new RestClientTransport(
        restClient, new JacksonJsonpMapper());

    // And create the API client
    private static final ElasticsearchClient client = new ElasticsearchClient(transport);
    
    public static Person findByName (String name) throws IOException{
        SearchResponse<Person> search = client.search(b -> b
            .index("person")
            .query(q -> q
                .match(t -> t
                    .field("name")
                    .query(name)
                )
            ),
            Person.class
        );
        return search.hits().hits().get(0).source();
    }
    
    public static ArrayList<Person> findById (String id) throws IOException{
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
        
        ArrayList<Person> results = null;
        
        List<Hit<Person>> hits = search.hits().hits();
        for (Hit<Person> hit: hits) {
            Person person = hit.source();
            results.add(person);
        }
        return results;
    }
   
}
