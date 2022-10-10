/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

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
import java.util.AbstractList;
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
import logic.Person;
import logic.UsuariosProvincia;

/**
 *
 * @author Sharon
 */
public class Elastic {
    
    //para calcular por cedula de un nombre en especifico la provincia, devuelve UsuarioProvincia
    //con la provincia y la cantidad de apariciones
    // ejemplo
    //Ingrid en San Jose hay 400 personas con ese nombre
    public static ArrayList getProvPorNombre(String nombre){
        List<Person> personas = findByName(nombre);
        ArrayList count = new ArrayList();
        int actual = 1;
        while(actual <10){
            int cantidadPersonas = 0;
            for(int i =0;i<personas.size();i++){
                if((personas.get(i).id)/100000000 == actual)
                    cantidadPersonas++;
            }
            UsuariosProvincia p = new UsuariosProvincia(cantidadPersonas, getProvincia(actual));
            count.add(p);
            actual++;
        }
        return count;
    }
    //para obtener la provincia segun la cedula, recibe el primer digito
    public static String getProvincia(int i){
        switch(i){
            case 1: return "San Jose";
            case 2: return "Alajuela";
            case 3: return "Cartago";
            case 4: return "Heredia";
            case 5: return "Guanacaste";
            case 6: return "Puntarenas";
            case 7: return "Limon";
            case 8: return "Nacionalizado";
            case 9: return "especial";
        }
        return "n";
    }
    //genera las n personas por decada
    public static ArrayList countPorEdad(String nombre){
    ArrayList conteo = new ArrayList();
    List<Person> persons = findByName(nombre);
    int decada = 1930;
    while(decada<2030){
        int cantidad =0;
        for(int i =0;i<persons.size();i++){
            int anio = persons.get(i).birthdate[2];
            if( anio <  decada && decada<(decada + 10)){
                cantidad++;
            }
        }
        if(cantidad>0){
            UsuariosProvincia p = new UsuariosProvincia(cantidad, String.valueOf(decada));
            conteo.add(p);
        }
        decada+=10;
        cantidad = 0;
    }
    
    
    return conteo;
    }
    
   
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
    
    
     //Funcion que retorna las personas con el id id
    public static List<Person> findByIdP (){
            List<Person> results = new ArrayList<>();
            try{
                SearchResponse<Person> response = client.search(s -> s
                    .index("person")
                    .size(101000)
                    ,
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
    
    public static int[] peoplePerP(){
        List<Person> people = findByIdP();
        int[] results = new int[] {0, 0, 0,0, 0, 0,0,0,0};
   
        for (Person person: people) {
            String id = String.valueOf(person.getId());
            char[] charArr = id.toCharArray();
            
            int i = Integer.parseInt(String.valueOf(charArr[0]))-1;
            results[i]++;
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
}
