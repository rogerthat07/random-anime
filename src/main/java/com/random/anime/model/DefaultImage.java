package com.random.anime.model;

public interface DefaultImage {
    String DEFAULT="https://kitsu.io/images/default_cover-22e5f56b17aeced6dc7f69c8d422a1ab.png";

    public void setTiny(String tiny);
    public void setLarge(String large);
    public void setSmall(String small);
    public void setOriginal(String original);
    
    public String getTiny();
    public String getLarge();
    public String getSmall();
    public String getOriginal();
}
