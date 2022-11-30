import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public class MovieRepository {
    
    HashMap<String,Movie> Movies = new HashMap<>();
    HashMap<String,Director> directors = new HashMap<>();
    ArrayList<Pair> pairs = new ArrayList<>();

    public void addMovietoMap(Movie m){
        Movies.put(m.getName,m);
    }

    public Movie getMoviefromMap(String name){
        return movies.get(name);
    }

    public void addDirectortoMap(Director d){
        directors.put(d.getName,d);
    }

    public Director getDirectorfromMap(String name){

        return directors.get(name);
    }

    public void addPairs(String m,String d){
        
        pairs.add(new Pair(m,d));
    }

    public List<String> getMoviesListfromMap(){

        List<String> MoviesList = new ArrayList<>();
        for(String name:Movies.keySet())
            MoviesList.add(name);

        return MoviesList;
    }

    public List<String> getMoviesOfDirector(String dname){

        List<String> directorsMovie= new ArrayList<>();

        for(int i=0;i<pairs.size();i++){
            if(pairs.get(i).D==dname)
                directorsMovie.add(pairs.get(i).M);
        }

        return directorsMovie;
    }

    public void deleteDirectorfromMap(String name){

        for(int i=0;i<pairs.size();i++){
            if(pairs.get(i).D==dname){
                Movies.remove(pairs.get(i).M);
                pairs.remove(i);
            }
        }
    }

    public void deleteAllDirector(){

        for(int i=0;i<pairs.size();i++){
            Movies.remove(pairs.get(i).M);
            pairs.remove(i);
            
                
        }
    }
}

class Pair{
    String M;
    String D;
    Pair(String M,String D){
        this.M=M;
        this.D=D;
    }
}
