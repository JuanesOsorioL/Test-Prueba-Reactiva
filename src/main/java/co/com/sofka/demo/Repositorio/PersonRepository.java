package co.com.sofka.demo.Repositorio;

import co.com.sofka.demo.Modelo.Person;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface PersonRepository extends ReactiveMongoRepository<Person,String> {
    Mono<Person> findByName(String name);
}

