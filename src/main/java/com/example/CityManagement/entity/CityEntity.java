package com.example.CityManagement.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "city")
public class CityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "City_ID")
    private Long cityId;

    @Column(name = "City_Name")
    private String cityName;

    @Column(name = "City_Code")
    private String code;

    @ManyToOne
    @JoinColumn(name = "state_ID")
    private StateEntity state;

    @Column(name = "Create_At")
    private LocalDateTime createdAt;

    @Column(name = "Update_At")
    private LocalDateTime updatedAt;

    @Column(name = "Deleted_At")
    private LocalDateTime deleteAt;



    public CityEntity() {
    }

    public CityEntity(Long cityId, String cityName, String code, StateEntity state, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deleteAt) {
        this.cityId = cityId;
        this.cityName = cityName;
        this.code = code;
        this.state = state;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deleteAt = deleteAt;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public StateEntity getstate() {
        return state;
    }

    public void setState(StateEntity state) {
        this.state = state;
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

    public LocalDateTime getDeleteAt() {
        return deleteAt;
    }

    public void setDeleteAt(LocalDateTime deleteAt) {
        this.deleteAt = deleteAt;
    }

    @Override
    public String toString() {
        return "CityEntity{" +
                "cityId=" + cityId +
                ", cityName='" + cityName + '\'' +
                ", code='" + code + '\'' +
                ", state=" + state +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", deleteAt=" + deleteAt +
                '}';
    }
}
