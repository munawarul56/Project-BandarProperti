package com.bandarproperti.config;

import com.bandarproperti.models.Customer;
import com.bandarproperti.models.Property;
import com.bandarproperti.response.CustomerResponse;
import com.bandarproperti.response.PropertyApiResponse;
import com.bandarproperti.response.PropertyApiSearchResponse;
import com.bandarproperti.response.PropertyResponse;
import com.bandarproperti.response.StatusResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by arief on 19-May-17.
 */

public interface RequestInterface {

    //Authentication com.example.wolfsoft2.food7.request
    //Customer Authentication com.example.wolfsoft2.food7.request
    @POST(Constants.USER_URL + Constants.OperationString.REGISTER_OPERATION)
    Call<CustomerResponse> register(@Body Customer customer);

    @POST(Constants.USER_URL + Constants.OperationString.LOGIN_OPERATION)
    Call<CustomerResponse> login(@Body Customer customer);

    @GET(Constants.BASE_URL + Constants.OperationString.STATUS_OPERATION)
    Call<StatusResponse> getStatus();

    @GET(Constants.BASE_URL + Constants.OperationString.PROPERTY_OPERATION)
    Call<PropertyApiResponse> getProperty(
            @Query("page") long page,
            @Query("type") int type
    );

    @GET(Constants.BASE_URL + Constants.OperationString.PROPERTY_DETAIL_OPERATION)
    Call<Property> getPropertyDetail(
            @Query("id") int id
    );

    @GET(Constants.BASE_URL + Constants.OperationString.PROPERTY_SEARCH_OPERATION)
    Call<PropertyApiSearchResponse> getPropertySearch(
            @Query("search") String query
    );

//    @POST("user/{operation}")
//    Call<UserResponse> authOperation(@Path("operation") String operation, @Body Owner user);
//
//    @POST("user/" + Constants.OperationString.LOGOUT_OPERATION + "/{id}")
//    Call<UserResponse> logout(@Path("id") String ownerId, @Body Owner owner);
}
