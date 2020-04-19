package com.example.wangluoqingqiu;

public class Page1 {
    private int id;
    private String link;
    private String name;
    private int order;
    private int visible;
    public Page1(int id,String link,String name,int order,int visible){
        this.id=id;
        this.link=link;
        this.name=name;
        this.order=order;
        this.visible=visible;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getVisible() {
        return visible;
    }

    public void setVisible(int visible) {
        this.visible = visible;
    }
}
