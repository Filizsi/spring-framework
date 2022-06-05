package com.cydeo.repository;

import com.cydeo.entity.Movie;
import com.cydeo.entity.MovieCinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface MovieCinemaRepository extends JpaRepository<MovieCinema,Long> {
    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to read movie cinema with id
    //overriting the JPARepository
    Optional<MovieCinema> findById(Long id);

    //Write a derived query to count all movie cinemas with a specific cinema id
    Integer countAllByCinemaId(Long cinemaId);


    //Write a derived query to count all movie cinemas with a specific movie id
    Integer countAllByMovieId(Long movieId);

    //Write a derived query to list all movie cinemas with higher than a specific date
    List<MovieCinema> findByDateTimeIsGreaterThan(LocalDate date);

    //Write a derived query to find the top 3 expensive movies
    List<MovieCinema> findTop3ByOrderByMovie_PriceDesc();


    //Write a derived query to list all movie cinemas that contain a specific movie name
    List<MovieCinema> findByMovieNameContaining(String name);

    //Write a derived query to list all movie cinemas in a specific location name
    List<MovieCinema> findByCinemaLocationName(String location);

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query to list all movie cinemas with higher than a specific date
    @Query("SELECT mc from MovieCinema mc where mc.dateTime > ?1")
    List<Movie> fetchAllWithHigher(@Param("date") LocalDate date);

    // ------------------- Native QUERIES ------------------- //

    //Write a native query to count all movie cinemas by cinema id
    @Query(value = "select count(*) from movie_cinema when cinema_id= ?1;",nativeQuery = true)
    Integer countByCinemaId(@Param("id") Long cinemaId);

    //Write a native query that returns all movie cinemas by location name
    @Query(value = "Select * from movie_cinema mc JOIN cinema c ON c.id=mc.cinema_id"+
            "JOIN location l ON l.id=c.loctaion_id when l.name=?1",nativeQuery = true)
    List<MovieCinema> retrieveAllCinemaByLocationName(String name);
}
