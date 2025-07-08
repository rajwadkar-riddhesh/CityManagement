package com.example.CityManagement.entity;

import jakarta.persistence.*;
import org.mapstruct.Mapper;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "state")
public class StateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "State_ID")
    private Long stateId;

    @Column(name = "State_Name")
    private String stateName;

    @ManyToOne
    @JoinColumn(name = "Country_ID")
    private CountryEntity country;

    @OneToMany(mappedBy = "state")
    private List<CityEntity> cities;

    @Column(name = "Created_At")
    private LocalDateTime createdAt;

    @Column(name = "Updated_At")
    private LocalDateTime updatedAt;

    @Column(name = "Deledted_At")
    private LocalDateTime deletedAt;

    public StateEntity() {
    }

    public StateEntity(Long stateId, String stateName, CountryEntity country, List<CityEntity> cities, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt) {
        this.stateId = stateId;
        this.stateName = stateName;
        this.country = country;
        this.cities = cities;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
    }

    public Long getStateId() {
        return stateId;
    }

    public void setStateId(Long stateId) {
        this.stateId = stateId;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public CountryEntity getCountry() {
        return country;
    }

    public void setCountry(CountryEntity country) {
        this.country = country;
    }

    public List<CityEntity> getCities() {
        return cities;
    }

    public void setCities(List<CityEntity> cities) {
        this.cities = cities;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }

    @Override
    public String toString() {
        return "StateEntity{" +
                "stateId=" + stateId +
                ", stateName='" + stateName + '\'' +
                ", country=" + country +
                ", cities=" + cities +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", deletedAt=" + deletedAt +
                '}';
    }
}
