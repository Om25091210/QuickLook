package com.mosio.quiclook;

public class ScreenItem {

    String Title,Description;
    String ScreenImg;

    public ScreenItem(String title, String description, String screenImg) {
        Title = title;
        Description = description;
        ScreenImg = screenImg;
    }

    public String getTitle() {
        return Title;
    }

    public String getDescription() {
        return Description;
    }

    public String getScreenImg() {
        return ScreenImg;
    }


}
