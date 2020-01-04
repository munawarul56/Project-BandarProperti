package com.bandarproperti.datasource;

import android.arch.lifecycle.MutableLiveData;
import android.arch.paging.PageKeyedDataSource;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.bandarproperti.helper.NetworkState;
import com.bandarproperti.models.Property;
import com.bandarproperti.request.ApiClient;
import com.bandarproperti.response.PropertyApiResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PropertyDataSource extends PageKeyedDataSource<Long, Property> {

    private static final String TAG = PropertyDataSource.class.getSimpleName();

    private Context context;
    private ApiClient apiClient;
    private MutableLiveData networkState;
    private MutableLiveData initialLoading;

    public static int PAGE_SIZE = 20;
    private static long FIRST_PAGE = 1;
    private static int TYPE;

    public PropertyDataSource(Context context, int type) {
        this.context = context;
        this.apiClient = new ApiClient(context);

        networkState = new MutableLiveData();
        initialLoading = new MutableLiveData();

        TYPE = type;
    }

    public MutableLiveData getNetworkState() {
        return networkState;
    }

    public MutableLiveData getInitialLoading() {
        return  initialLoading;
    }

    @Override
    public void loadInitial(@NonNull LoadInitialParams<Long> params, @NonNull final LoadInitialCallback<Long, Property> callback) {
        Log.i(TAG, "Initial Loading, Count " + params.requestedLoadSize);

        initialLoading.postValue(NetworkState.LOADING);
        networkState.postValue(NetworkState.LOADING);

        apiClient.getApi().getProperty(FIRST_PAGE, TYPE)
                .enqueue(new Callback<PropertyApiResponse>() {
                    @Override
                    public void onResponse(Call<PropertyApiResponse> call, Response<PropertyApiResponse> response) {
                        if(response.isSuccessful()) {
                            callback.onResult(response.body().property, null, 2l);
                            initialLoading.postValue(NetworkState.LOADED);
                            networkState.postValue(NetworkState.LOADED);

                        } else {
                            initialLoading.postValue(new NetworkState(NetworkState.Status.FAILED, response.message()));
                            networkState.postValue(new NetworkState(NetworkState.Status.FAILED, response.message()));
                        }
                    }

                    @Override
                    public void onFailure(Call<PropertyApiResponse> call, Throwable t) {
                        String errorMessage = t == null ? "unknown error" : t.getMessage();
                        networkState.postValue(new NetworkState(NetworkState.Status.FAILED, errorMessage));
                    }
                });
    }

    @Override
    public void loadBefore(@NonNull final LoadParams<Long> params, @NonNull final LoadCallback<Long, Property> callback) {

    }

    @Override
    public void loadAfter(@NonNull final LoadParams<Long> params, @NonNull final LoadCallback<Long, Property> callback) {
        Log.i(TAG, "Loading Rang " + params.key + " Count " + params.requestedLoadSize);

        apiClient.getApi().getProperty(params.key, TYPE)
                .enqueue(new Callback<PropertyApiResponse>() {
                    @Override
                    public void onResponse(Call<PropertyApiResponse> call, Response<PropertyApiResponse> response) {
                        if(response.isSuccessful()) {
                            Long key = (response.body().meta.pagination.current_page < response.body().meta.pagination.total_pages) ? params.key + 1 : null;
                            callback.onResult(response.body().property, key);
                            networkState.postValue(NetworkState.LOADED);

                            Log.i(TAG, "Loading PAGE " + response.body().meta.pagination.current_page + " TOTAL PAGE " + response.body().meta.pagination.total_pages);
                        } else {
                            networkState.postValue(new NetworkState(NetworkState.Status.FAILED, response.message()));
                        }
                    }

                    @Override
                    public void onFailure(Call<PropertyApiResponse> call, Throwable t) {
                        String errorMessage = t == null ? "unknown error" : t.getMessage();
                        networkState.postValue(new NetworkState(NetworkState.Status.FAILED, errorMessage));
                    }
                });
    }
}
