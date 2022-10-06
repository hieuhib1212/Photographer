/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Hiệu Bùi
 */
public class Share {
    private String title;
    private String icon_source;
    private String link;

    public Share() {
    }

    public Share(String title, String icon_source, String link) {
        this.title = title;
        this.icon_source = icon_source;
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIcon_source() {
        return icon_source;
    }

    public void setIcon_source(String icon_source) {
        this.icon_source = icon_source;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
    
}
