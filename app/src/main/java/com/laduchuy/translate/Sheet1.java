package com.laduchuy.translate;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Sheet1 {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("word")
    @Expose
    private String word;
    @SerializedName("enligsh")
    @Expose
    private String enligsh;
    @SerializedName("vietnamese")
    @Expose
    private String vietnamese;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getEnligsh() {
        return enligsh;
    }

    public void setEnligsh(String enligsh) {
        this.enligsh = enligsh;
    }

    public String getVietnamese() {
        return vietnamese;
    }

    public void setVietnamese(String vietnamese) {
        this.vietnamese = vietnamese;
    }

}
