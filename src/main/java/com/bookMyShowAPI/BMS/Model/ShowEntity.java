package com.bookMyShowAPI.BMS.Model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@Entity
@EntityListeners(value = { AuditingEntityListener.class })
@Table(name = "shows")
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class ShowEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "show_date", columnDefinition = "DATE", nullable = false)
    private LocalDate showDate;

    @Column(name = "show_time", columnDefinition = "TIME", nullable = false)
    private LocalTime showTime;


    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    @Column(name = "created_at")
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    @Column(name = "updated_at")
    private Date updatedAt;

    //Must required in DTO
    @ManyToOne
    @JsonIgnore
    private MovieEntity movie;


    //Must be required ?
    @ManyToOne
    @JsonIgnore
    private TheaterEntity theater;

    @OneToMany(mappedBy = "show", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<TicketEntity> tickets;

    @OneToMany(mappedBy = "show", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<ShowSeatsEntity> seats;

}
