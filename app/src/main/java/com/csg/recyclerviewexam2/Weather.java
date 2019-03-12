package com.csg.recyclerviewexam2;

public class Weather {
    private int imageResource;
    private String cityName;
    private String team;

    public Weather(int imageResource, String cityName, String team) {
        this.imageResource = imageResource;
        this.cityName = cityName;
        this.team = team;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Weather{");
        sb.append("imageResource=").append(imageResource);
        sb.append(", cityName='").append(cityName).append('\'');
        sb.append(", team='").append(team).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
