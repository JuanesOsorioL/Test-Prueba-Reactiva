package co.com.sofka.demo.Controlador;

import co.com.sofka.demo.Modelo.Person;
import co.com.sofka.demo.Servicio.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping(value = "/person")
public class PersonController {

    @Autowired
    PersonService personService;

    @PostMapping
    public Mono<Void> post(@RequestBody Mono<Person> peronMono){
        return  peronMono.flatMap(personService::insert) ;
    }

    @GetMapping("/{id}")
    public Mono<Person> get(@PathVariable("id") String id){
        return Mono.just(new Person());
    }

    @GetMapping
    public Flux<Person> list(){
        return personService.listAll();
    }

    @PutMapping
    public Mono<Void> update(@RequestBody Mono<Person> personMono){
        return Mono.empty();
    }


    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable("id") String id){
        return Mono.empty();
    }

}
