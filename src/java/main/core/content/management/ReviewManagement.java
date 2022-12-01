/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.core.content.management;

import java.util.ArrayList;
import java.util.HashMap;
import main.core.content.Review;
import sun.util.calendar.LocalGregorianCalendar.Date;

/**
 *
 * @author J-ANONIMO
 */
public class ReviewManagement {
    private HashMap<Integer, Review> reviewsHashMap;
    private HashMap<Date, Review> reviewsDateHashMap;
    private ArrayList<Review> reviewsAL;
    private EReviewListRequest request;
    
    /**
     * 
     * @param request 
     */
    public ReviewManagement(EReviewListRequest request){
        if(request == null){
            reviewsAL = new ArrayList<>();
        }else{
            //validate the request so to create specific list
            switch(request){
                case ARRAY_LIST:
                    reviewsAL = new ArrayList<>();
                    break;
                case ID:
                    reviewsHashMap = new HashMap<>();
                    break;
                case DATE:
                    reviewsDateHashMap = new HashMap<>();
                    break;
            }
            this.request = request;
        }
    }
    
    /**
     * 
     * @param review
     * @return 
     */
    public boolean addReview(Review review){
        if(review != null){
            //Allocate memory if map is null
            if(reviewsAL == null){
                reviewsAL = new ArrayList<>();
                reviewsAL.add(review);
            }else{
                reviewsAL.add(review);
            }
            return true;
        }
        return false;
    }

    /**
     * Puts review to container using date key
     * @param date
     * @param review
     * @return 
     */
    public boolean addReview(Date date, Review review){
        if(review != null && date != null){
            //Allocate memory if map is null
            if(reviewsDateHashMap == null){
                reviewsDateHashMap = new HashMap<>();
                reviewsDateHashMap.put(date, review);
            }else{
                reviewsDateHashMap.put(date, review);
            }
            return true;
        }
        return false;
    }
    
    /**
     * Adds review to container using ID key
     * @param id
     * @param review
     * @return 
     */
    public boolean addReview(Integer id, Review review){
         if(review != null && id != null){
            //Allocate memory if map is null
            if(reviewsHashMap == null){
                reviewsHashMap = new HashMap<>();
                reviewsHashMap.put(id, review);
            }else{
                reviewsHashMap.put(id, review);
            }
        }
        return false;
        
    }
    
    
    /**
     * @return the reviewsHashMap
     */
    public HashMap<Integer, Review> getReviewsHashMap() {
        return reviewsHashMap;
    }

    /**
     * @param reviewsHashMap the reviewsHashMap to set
     */
    public void setReviewsHashMap(HashMap<Integer, Review> reviewsHashMap) {
        this.reviewsHashMap = reviewsHashMap;
    }

    /**
     * @return the reviewsDateHashMap
     */
    public HashMap<Date, Review> getReviewsDateHashMap() {
        return reviewsDateHashMap;
    }

    /**
     * @param reviewsDateHashMap the reviewsDateHashMap to set
     */
    public void setReviewsDateHashMap(HashMap<Date, Review> reviewsDateHashMap) {
        this.reviewsDateHashMap = reviewsDateHashMap;
    }

    /**
     * @return the reviewsAL
     */
    public ArrayList<Review> getReviewsAL() {
        return reviewsAL;
    }

    /**
     * @param reviewsAL the reviewsAL to set
     */
    public void setReviewsAL(ArrayList<Review> reviewsAL) {
        this.reviewsAL = reviewsAL;
    }

    /**
     * @return the request
     */
    public EReviewListRequest getRequest() {
        return request;
    }

    /**
     * @param request the request to set
     */
    public void setRequest(EReviewListRequest request) {
        this.request = request;
    }
    
}
