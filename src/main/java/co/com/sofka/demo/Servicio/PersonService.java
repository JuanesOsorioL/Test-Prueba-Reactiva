package co.com.sofka.demo.Servicio;

import co.com.sofka.demo.Modelo.Person;
import co.com.sofka.demo.Repositorio.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.function.BiFunction;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public Flux<Person> listAll(){
        return personRepository.findAll();
            }

    public Mono<Void> insert(Person person) {
        return validateBeforeInsert.apply(personRepository,person)
                .switchIfEmpty(Mono.defer(() -> personRepository.save(person)))
                .then();
    }

    private final BiFunction<PersonRepository, Person, Mono<Person>> validateBeforeInsert
            = (repo, person) -> repo.findByName(person.getName());

}
