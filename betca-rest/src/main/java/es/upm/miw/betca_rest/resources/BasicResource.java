package es.upm.miw.betca_rest.resources;

import org.apache.logging.log4j.LogManager;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.stream.Stream;

@RestController
@RequestMapping(BasicResource.BASIC)
public class BasicResource {
    public static final String BASIC = "/basic";
    public static final String ID_ID = "/{id}";
    public static final String SEARCH = "/search";

    @PostMapping
    public Dto create(@RequestBody Dto dto) {
        LogManager.getLogger(this.getClass()).info("===>>> create: " + dto);
        return dto;
    }

    @GetMapping(ID_ID)
    public Dto read(@PathVariable(value = "id") int id) {
        return new Dto(id, "daemon", Gender.FEMALE, LocalDateTime.now());
    }

    @PutMapping(ID_ID)
    public Dto update(@PathVariable(value = "id") int id, @RequestBody Dto dto) {
        LogManager.getLogger(this.getClass()).info("===>>> update: " + id + ", " + dto);
        return dto;
    }

    @DeleteMapping(ID_ID)
    public void delete(@PathVariable(value = "id") int id) {
        LogManager.getLogger(this.getClass()).info("===>>> delete: " + id);
    }

    @GetMapping(SEARCH)
    public Stream<Dto> findByName(@RequestParam String name) {
        return Stream.of(
                new Dto(1, name, Gender.MALE, LocalDateTime.now()),
                new Dto(2, name, Gender.FEMALE, LocalDateTime.now()),
                new Dto(3, name, Gender.MALE, LocalDateTime.now())
        );
    }
}
