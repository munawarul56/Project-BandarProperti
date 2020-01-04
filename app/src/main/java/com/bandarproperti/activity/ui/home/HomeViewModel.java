package com.bandarproperti.activity.ui.home;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Transformations;
import android.arch.lifecycle.ViewModel;
import android.arch.paging.LivePagedListBuilder;
import android.arch.paging.PagedList;

import com.bandarproperti.datasource.PropertyDataSource;
import com.bandarproperti.datasource.factory.PropertyDataSourceFactory;
import com.bandarproperti.helper.NetworkState;
import com.bandarproperti.models.Property;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class HomeViewModel extends ViewModel {

    private Executor executor;
    private LiveData<NetworkState> networkState;
    public LiveData<PagedList<Property>> propertyList;

    private Application application;
    private PropertyDataSourceFactory propertyDataSourceFactory;
    private int type;

    public HomeViewModel(Application application, int type)
    {
        this.application = application;
        this.type = type;

        propertyDataSourceFactory = new PropertyDataSourceFactory(application, type);

        executor = Executors.newFixedThreadPool(5);

        networkState = Transformations.switchMap(propertyDataSourceFactory.getMutableLiveData(), dataSource -> dataSource.getNetworkState());

        PagedList.Config pagedListConfig = (new PagedList.Config.Builder()).setEnablePlaceholders(false).setPageSize(PropertyDataSource.PAGE_SIZE).build();

        propertyList = (new LivePagedListBuilder<>(propertyDataSourceFactory, pagedListConfig)).setFetchExecutor(executor).build();
    }

    /*
     * Getter method for the network state
     */

    public LiveData<NetworkState> getNetworkState() {
        return networkState;
    }

    /*
     * Getter method for the pageList
     */

    public LiveData<PagedList<Property>> getPropertyList() {
        return propertyList;
    }

    public void refresh()
    {
        propertyDataSourceFactory.getMutableLiveData().getValue().invalidate();
    }
}