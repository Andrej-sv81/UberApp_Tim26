package com.example.uberapp_tim26.model;



public class RideHistoryPlaceholder {
    private String comment;
    private String relation;
    private int rating;
    private String rideTime;

    public RideHistoryPlaceholder(){

    }

    public RideHistoryPlaceholder(String comment, String relation, String rideTime, int rating) {
        this.comment = comment;
        this.relation = relation;
        this.rating = rating;
        this.rideTime = rideTime;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getRideTime() {
        return rideTime;
    }

    public void setRideTime(String rideTime) {
        this.rideTime = rideTime;
    }


}
