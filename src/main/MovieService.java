import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class MovieService {

    @Autowired
    MovieRepository mRepo;

    public void addMovietoDb(Movie m){
        
        mRepo.addMovietoMap(m);
    }

    public Movie getMoviefromDb(String name){
        
        return mRepo.getMoviefromMap(name);
    }

    public void addDirectortoDb(Director d){
        mRepo.addDirectortoMap(d);
    }

    public Director getDirectorfromDb(String name){

        return mRepo.getDirectorfromMap(name);
    }

    public void addPairstoDb(String m,String d){
        
        mRepo.addPairs(m,d);
    }

    public List<String> getMoviesListfromdb(){

        return mRepo.getMoviesListfromMap();
    }

    public List<String> getMoviesOfDirectorfromDb(String dname){

        return mRepo.getMoviesOfDirector(dname);

    }
    

    public void deleteDirectorfromDb(String name){

        return mRepo.deleteDirectorfromMap(name);
    }

    public void deleteAllDirectorfromDb(){

        mRepo.deleteAllDirector();
        
    }
    
}
