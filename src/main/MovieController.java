import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {

    @Autowired
    MovieService mServ;
    
    @PostMapping("/movies/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody() Movie m){
        
        mServ.addMovietoDb(m);
        return new ResponseEntity("success",HttpStatus.CREATED);
    }

    @PostMapping("/movies/add-director")
    public ResponseEntity<String> addDirector(@RequestBody() Director d){

        mServ.addDirectortoDb(d);
        return new ResponseEntity("success",HttpStatus.CREATED);
    }

    @PutMapping("/movies/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam("movie") String m,@RequestParam("Director") String d){
        
        mServ.addPairstoDb(m,d);
        return new ResponseEntity("success",HttpStatus.CREATED);
    }

    @GetMapping("/movies/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable("name") String name){
        
        return new ResponseEntity(mServ.getMoviefromDb(name),HttpStatus.ACCEPTED);;
    }

    @GetMapping("/movies/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable("name") String name){

        return new ResponseEntity(mServ.getDirectorfromdb(name),HttpStatus.ACCEPTED);
    }

    @GetMapping("/movies/get-all-movies")
    public ResponseEntity<List<String>> findAllMovies(){

        return new ResponseEntity(mServ.getMoviesListfromdb(),HttpStatus.ACCEPTED);
    }

    @GetMapping("/movies/get-movies-by-director-name/{director}")
    public List<String> getMoviesByDirectorName(@PathVariable("director") String dname){

        return new ResponseEntity(mServ.getMoviesOfDirectorfromDb(dname),HttpStatus.ACCEPTED);

    }
    
    @DeleteMapping("/movies/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam("name") String name){

        return mServ.deleteDirectorfromDb(name);
        return new ResponseEntity("success",HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/movies/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors(){

        mServ.deleteAllDirectorfromDb();
        return new ResponseEntity("success",HttpStatus.ACCEPTED);
    }
}
