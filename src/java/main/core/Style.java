/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.core;

import java.util.ArrayList;
import main.core.content.ImageResource;

/**
 *
 * @author J-ANONIMO
 */
public class Style {
    private String name;
    private ArrayList<ImageResource> resources;
    private double averagePrice;
    private String description;

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the resources
     */
    public ArrayList<ImageResource> getResources() {
        return resources;
    }

    /**
     * @param resources
     */
    public void setResource(ArrayList<ImageResource> resources) {
        this.resources = resources;
    }

    /**
     * @return the averagePrice
     */
    public double getAveragePrice() {
        return averagePrice;
    }

    /**
     * @param averagePrice the averagePrice to set
     */
    public void setAveragePrice(double averagePrice) {
        this.averagePrice = averagePrice;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }
    
    
}
