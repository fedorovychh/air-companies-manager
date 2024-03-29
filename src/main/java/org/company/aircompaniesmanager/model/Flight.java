package org.company.aircompaniesmanager.model;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Data
@Entity
@Table(name = "flights")
@SQLDelete(sql = "UPDATE flights SET is_deleted = true WHERE id=?")
@Where(clause = "is_deleted=false")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JoinColumn(name = "air_company_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private AirCompany airCompany;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JoinColumn(name = "airplane_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Airplane airplane;

    @Column(nullable = false)
    private String departureCountry;

    @Column(nullable = false)
    private String destinationCountry;

    @Column(nullable = false)
    private double distance;

    @Column(nullable = false)
    private double estimatedTime;

    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private LocalDateTime delayStartTime;
    private LocalDateTime creationDate;

    @Column(name = "is_deleted", nullable = false, columnDefinition = "boolean default false")
    private boolean isDeleted = false;

    public enum Status {
        ACTIVE,
        COMPLETED,
        DELAYED,
        PENDING
    }
}
