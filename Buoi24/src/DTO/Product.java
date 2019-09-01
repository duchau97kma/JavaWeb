package DTO;

import java.util.Date;

public class Product {
    private int id;
    private String name;
    private String description;
    private int authorId;
    private String images;
    private int actived;
    private Date createAt;
    private Date updateAt;

    public Product() {
    }

    public Product(String name, String description, int authorId, String images, int actived, Date createAt, Date updateAt) {
        this.name = name;
        this.description = description;
        this.authorId = authorId;
        this.images = images;
        this.actived = actived;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    public Product(int id, String name, String description, int authorId, String images, int actived, Date createAt, Date updateAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.authorId = authorId;
        this.images = images;
        this.actived = actived;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public int getActived() {
        return actived;
    }

    public void setActived(int actived) {
        this.actived = actived;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", authorId=" + authorId +
                ", images='" + images + '\'' +
                ", actived=" + actived +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                '}';
    }
}
