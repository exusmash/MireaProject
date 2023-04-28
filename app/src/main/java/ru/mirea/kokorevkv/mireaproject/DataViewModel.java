package ru.mirea.kokorevkv.mireaproject;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DataViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public DataViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("мобильная разработка");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
