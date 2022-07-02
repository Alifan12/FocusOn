package com.example.focuson.database;

public class RewardModel {

    private int photoReward;
    private String namaReward;

    public RewardModel(int photoReward, String namaReward){
        this.setPhotoReward(photoReward);
        this.setNamaReward(namaReward);
    }


    public int getPhotoReward() {
        return photoReward;
    }

    public void setPhotoReward(int photoReward) {
        this.photoReward = photoReward;
    }

    public String getNamaReward() {
        return namaReward;
    }

    public void setNamaReward(String namaReward) {
        this.namaReward = namaReward;
    }
}
