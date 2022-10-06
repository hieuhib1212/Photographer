/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import dao.PhotoDAO;

/**
 *
 * @author Hiệu Bùi
 */
public class Gallery {

    private int id;
    private String title;
    private String description;
    private String image;
    private int view;

    public Gallery(int id, String title, String description, String image, int view) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.image = image;
        this.view = view;
    }

    public Gallery() {
    }

    public int getView() {
        return view;
    }

    public void setView(int view) {
        this.view = view;
    }


    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }





}
