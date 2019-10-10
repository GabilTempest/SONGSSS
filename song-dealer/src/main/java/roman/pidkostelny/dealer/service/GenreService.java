package roman.pidkostelny.dealer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import roman.pidkostelny.dealer.dto.request.GenreRequest;

import roman.pidkostelny.dealer.dto.respons.DataResponse;
import roman.pidkostelny.dealer.dto.respons.GenreRespons;

import roman.pidkostelny.dealer.entity.Genre;

import roman.pidkostelny.dealer.exception.WrongInp;
import roman.pidkostelny.dealer.repository.GenreRepository;
import roman.pidkostelny.dealer.specification.GenreSpecification;

import java.util.stream.Collectors;

@Service
public class GenreService {

    @Autowired
    private GenreRepository genreRepository;


    public Long save(GenreRequest genreRequest) {
        Genre genre = new Genre();
        genre.setName(genreRequest.getName());
//        genre.setUrl(genreRequest.getUrl());

        genre = genreRepository.save(genre);
        return genre.getId();
    }

    public GenreRespons update(Long id, GenreRequest genreRequest) throws WrongInp {
        return new GenreRespons(genreRequestToGenre(findOne(id), genreRequest));
    }

    public Genre findOne(Long id) throws WrongInp {
        return genreRepository.findById(id).orElseThrow(() -> new WrongInp("Genre with id " + id + " not exists"));
    }

    private Genre genreRequestToGenre(Genre genre, GenreRequest request) {
        if (genre == null) {
            genre = new Genre();
        }
        genre.setName(request.getName());
//        genre.setUrl(request.getUrl());
        return genreRepository.save(genre);
    }

    public void delete(Long id) throws WrongInp {
        genreRepository.delete(findOne(id));
    }


    public GenreRespons findOneById(Long id) throws WrongInp {
        return new GenreRespons(findOne(id));
    }

    public DataResponse<GenreRespons> findAll(String value, Integer page, Integer size, String fieldName, Sort.Direction direction) {
        Sort sort = Sort.by(direction, fieldName);
        PageRequest pageRequest = PageRequest.of(page, size, sort);
        Page<Genre> pageGenre;
        if (value != null && !value.equals("")) {
            GenreSpecification specification = new GenreSpecification(value);
            pageGenre = genreRepository.findAll((Specification<Genre>) specification, pageRequest);
        } else {
            pageGenre = genreRepository.findAll(pageRequest);
        }
        return new DataResponse<GenreRespons>(pageGenre.stream().map(GenreRespons::new).collect(Collectors.toList()), pageGenre);
    }
}
