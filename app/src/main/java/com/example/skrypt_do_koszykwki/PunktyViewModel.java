package com.example.skrypt_do_koszykwki;

import androidx.lifecycle.ViewModel;

public class PunktyViewModel extends ViewModel {
    private int punkty;

    public int getPunkty() {
        return punkty;
    }

    public void setPunkty(int punkty) {
        this.punkty = punkty;
    }

    public void dodajPunkty(int i){
        punkty+=i;

    }
}
