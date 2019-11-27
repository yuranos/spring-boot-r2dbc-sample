package be.g00glen00b.apps.r2dbc;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/persons")
@RequiredArgsConstructor
public class PersonController {
    private final PersonRepository repository;

    @GetMapping("/{id}")
    public Mono<Person> findAll(@PathVariable long id) {
        Mono<Person> byId = repository.findById(id);
        return byId;
    }

    @PostMapping
    public Mono<Person> save() {
        return repository.save(new Person(null, "Yura", "Nosenko"));
    }
}
