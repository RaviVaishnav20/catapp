package com.example.finalcatdemo.services.gcp.domain;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import org.springframework.web.multipart.MultipartFile;

@JsonRootName(value = "cats")
public class Cat {
    private String cat_name;
    private String imageUrl="";
    private MultipartFile image;
    private long id;

    public static final String CAT_NAME = "cat_name";
   
    public static final String IMAGE_URL = "imageUrl";
  

    private Cat(Builder builder){
        this.cat_name = builder.cat_name;
        this.imageUrl = builder.imageUrl;
        this.id = builder.id;
    }

    public static class Builder {
        private String cat_name;
        private String imageUrl;
        private long id;

        public Builder withCatName(String cat_name){
            this.cat_name = cat_name;
            return this;
        }


        public Builder withImageUrl(String imageUrl){
            this.imageUrl = imageUrl;
            return this;
        }

        public Builder withId(long id){
            this.id = id;
            return this;
        }

        public Cat build(){
            return new Cat(this);
        }
    }

    public Cat(){

    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCat_name() {
		return cat_name;
	}



	public void setCat_name(String cat_name) {
		this.cat_name = cat_name;
	}

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "cat_name='" + cat_name + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", id=" + id +
                '}';
    }
}