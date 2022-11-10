package com.example.skrypt_do_koszykwki;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PunktyViewModel extends ViewModel  {
    private MutableLiveData<Integer> punkty;

    public MutableLiveData<Integer> getPunkty() {
        if (punkty==null)
        {
            punkty=new MutableLiveData<>();
            punkty.setValue(0);
        }
        return punkty;
    }

    public void setPunkty(int punkty) {
         this.punkty.setValue(punkty);
    }

    public void dodajPunkty(int i){
        if(punkty.getValue()!=null) {
         punkty.setValue(punkty.getValue()+i);

        }

    }
}
