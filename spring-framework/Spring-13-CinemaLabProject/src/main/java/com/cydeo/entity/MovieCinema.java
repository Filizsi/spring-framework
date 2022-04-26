package com.cydeo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.crypto.Cipher;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class MovieCinema extends BaseEntity{

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime dateTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id")
    private Movie movieList;

    @ManyToOne(fetch = FetchType.LAZY)
    private Cinema cinema;
}
