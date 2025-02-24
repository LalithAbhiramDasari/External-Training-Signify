package com.example.BuildathonDay6.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
public class Member {

    @Id
    @JsonProperty("memberId")
    private Long memberId; 

    @JsonProperty("name")
    private String name;

    @JsonProperty("membershipType")
    private String membershipType; 

    @JsonProperty("activeStatus")
    private boolean activeStatus; 

    @JsonProperty("workoutPlan")
    private String workoutPlan; 

    public Member() {
        super();
    }

    public Member(Long memberId, String name, String membershipType, boolean activeStatus, String workoutPlan) {
        super();
        this.memberId = memberId;
        this.name = name;
        this.membershipType = membershipType;
        this.activeStatus = activeStatus;
        this.workoutPlan = workoutPlan;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMembershipType() {
        return membershipType;
    }

    public void setMembershipType(String membershipType) {
        this.membershipType = membershipType;
    }

    public boolean isActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(boolean activeStatus) {
        this.activeStatus = activeStatus;
    }

    public String getWorkoutPlan() {
        return workoutPlan;
    }

    public void setWorkoutPlan(String workoutPlan) {
        this.workoutPlan = workoutPlan;
    }
}