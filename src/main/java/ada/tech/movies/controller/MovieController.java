package ada.tech.movies.controller;

import ada.tech.movies.dto.FilterDTO;
import ada.tech.movies.model.Movie;
import ada.tech.movies.repository.MovieRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieRepository movieRepository;

    public MovieController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @GetMapping
    public List<Movie> getMovies(@ModelAttribute FilterDTO filterDTO) {
        return movieRepository.findByFilters(filterDTO);
    }

    @PostMapping
    public void create(@RequestBody Movie movie) {
        movieRepository.save(movie);
    }


}

