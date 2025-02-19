package com.fastporte.fastportewebservice.entities;

import java.sql.Time;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;



@Entity
@Table(name = "contracts")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contract implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*@Column(name = "client_id", nullable = false)
    private Long idClient;

    @Column(name = "driver_id", nullable = false)
    private Long idDriver;
     */

    @Column(name = "subject", nullable = false)
    private String subject;

    @Column(name = "service_from", nullable = false)
    private String from;

    @Column(name = "service_to", nullable = false)
    private String to;

    @Column(name = "date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date contractDate;

    @Column(name = "time_departure", nullable = false)
    //@Temporal(TemporalType.DATE)
    private String timeDeparture;

    @Column(name = "time_arrival", nullable = false)
    //@Temporal(TemporalType.DATE)
    private String timeArrival;

    @Column(name = "amount", nullable = false)
    private String amount;

    @Column(name = "quantity", nullable = false)
    private String quantity;

    @Column(name = "description", nullable = false, length = 100)
    private String description;

    @Column(name = "visible", nullable = true)
    private boolean visible;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    //@JsonIgnore
    private Client client;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "driver_id", nullable = true)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    //@JsonIgnore
    private Driver driver;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "status_contract_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private StatusContract status;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "notification_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Notification notification;

    /*
    @Transient
    private Driver driverTmp;

    @Transient
    private Client clientTmp;
     */

}
