package com.foodkart.model;

import java.util.List;
import java.util.Map;

public class Rating {
    final Integer id;
    private Map<Integer,RatingItem> ratingItemMap;

    public Rating(Integer id, Map<Integer, RatingItem> ratingItemMap) {
        this.id = id;
        this.ratingItemMap = ratingItemMap;
    }

    public Integer getId() {
        return id;
    }

    public Map<Integer, RatingItem> getRatingItemMap() {
        return ratingItemMap;
    }

    public void setRatingItemMap(Map<Integer, RatingItem> ratingItemMap) {
        this.ratingItemMap = ratingItemMap;
    }
}
