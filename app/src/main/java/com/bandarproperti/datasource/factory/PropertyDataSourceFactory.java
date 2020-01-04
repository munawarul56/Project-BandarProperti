package com.bandarproperti.datasource.factory;

import android.app.Application;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.paging.DataSource;
import android.support.annotation.NonNull;

import com.bandarproperti.activity.ui.home.HomeViewModel;
import com.bandarproperti.datasource.PropertyDataSource;

public class PropertyDataSourceFactory extends DataSource.Factory {

    private Application application;
    private int type;

    private MutableLiveData<PropertyDataSource> mutableLiveData;

    public PropertyDataSourceFactory(Application application, int type) {
        this.application = application;
        this.type = type;
        this.mutableLiveData = new MutableLiveData<PropertyDataSource>();
    }

//    private MutableLiveData<PageKeyedDataSource<Integer, Property>> mutableLiveData = new MutableLiveData<>();

    @Override
    public DataSource create() {
        PropertyDataSource propertyDataSource = new PropertyDataSource(application, type);

        mutableLiveData.postValue(propertyDataSource);

        return propertyDataSource;
    }

    public MutableLiveData<PropertyDataSource> getMutableLiveData() {
        return mutableLiveData;
    }

//    @NonNull
//    @Override
//    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
//        return (T) new HomeViewModel(application, type);
//    }
}
