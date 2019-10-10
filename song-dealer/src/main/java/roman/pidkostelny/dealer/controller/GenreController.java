package roman.pidkostelny.dealer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import roman.pidkostelny.dealer.dto.request.GenreRequest;
import roman.pidkostelny.dealer.dto.respons.DataResponse;
import roman.pidkostelny.dealer.dto.respons.GenreRespons;
import roman.pidkostelny.dealer.entity.Genre;
import roman.pidkostelny.dealer.exception.WrongInp;
import roman.pidkostelny.dealer.service.GenreService;

import javax.validation.Valid;

@RestController
@RequestMapping("/genre")
public class GenreController {
    @Autowired
    private GenreService genreService;

    @GetMapping
    public DataResponse<GenreRespons> getGenre(@RequestParam(required = false) String value,
                                               @RequestParam Integer page,
                                               @RequestParam Integer size,
                                               @RequestParam String sortFieldName,
                                               @RequestParam Sort.Direction direction) {
        System.out.println("GET ALL Genres");
        return genreService.findAll(value, page, size, sortFieldName, direction);
    }


    @PutMapping
    public GenreRespons Update(@RequestParam Long id, @RequestBody GenreRequest genreRequest) throws WrongInp {
        return genreService.update(id, genreRequest);
    }

    @GetMapping("/one")
    public GenreRespons findOne(@RequestParam Long id) throws WrongInp {
        return genreService.findOneById(id);
    }

    @PostMapping
    public Long save(@RequestBody @Valid GenreRequest genreRequest) {
        System.out.println("SAVE Genre IN DB with first name -> " + genreRequest.getName());
        return genreService.save(genreRequest);
    }

    @DeleteMapping("/{id}")
    public void search(@PathVariable Long id) throws WrongInp {
        System.out.println("Delete genres by id " + id);
        genreService.delete(id);
    }


}