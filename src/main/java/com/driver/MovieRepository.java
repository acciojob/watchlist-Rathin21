package com.driver;
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
        Movies.put(m.getName(),m);
    }

    public Movie getMoviefromMap(String name){
        return Movies.get(name);
    }

    public void addDirectortoMap(Director d){
        directors.put(d.getName(),d);
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
            if(pairs.get(i).D.equals(dname))
                directorsMovie.add(pairs.get(i).M);
        }

        return directorsMovie;
    }

    public void deleteDirectorfromMap(String dname){

        for(int i=0;i<pairs.size();i++){
            if(pairs.get(i).D.equals(dname)){
                if(Movies.containsKey(pairs.get(i).M))
                    Movies.remove(pairs.get(i).M);
                if(directors.containsKey(dname))
                    directors.remove(pairs.get(i).D);
            }
        }
        
    }

    public void deleteAllDirector(){

        for(int i=0;i<pairs.size();i++){
            if(Movies.containsKey(pairs.get(i).M))
                    Movies.remove(pairs.get(i).M);
            
            if(directors.containsKey(pairs.get(i).D))
                    directors.remove(pairs.get(i).D);
            
                
        }
        pairs.clear();
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
