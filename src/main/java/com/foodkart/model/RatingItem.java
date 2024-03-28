package com.foodkart.model;

public class RatingItem {
    final Integer id;
    final Integer userId;
    private String comment;
    private Integer ratingNo;

    public RatingItem(Integer id, Integer userId, String comment, Integer ratingNo) {
        this.id = id;
        this.userId = userId;
        this.comment = comment;
        this.ratingNo = ratingNo;
    }

    public Integer getId() {
        return id;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getRatingNo() {
        return ratingNo;
    }

    public void setRatingNo(Integer ratingNo) {
        this.ratingNo = ratingNo;
    }
}
