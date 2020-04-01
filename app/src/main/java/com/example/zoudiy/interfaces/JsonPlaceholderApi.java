package com.example.zoudiy.interfaces;

import com.example.zoudiy.models.AddressLatLng;
import com.example.zoudiy.models.OtpResponse;
import com.example.zoudiy.models.ProfUpdateResponse;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface JsonPlaceholderApi {

    @FormUrlEncoded
    @POST("auth/send-otp")
    Call<ResponseBody> Sendotp
            (
                    @Field("phone") String mobileno
            );
    @FormUrlEncoded
    @POST("auth/verify-otp")
    Call<OtpResponse> Verifyotp
            (
                    @Field("phone") String mobileno,
                    @Field("otp") String Otp
            );

    @FormUrlEncoded
    @POST("profile/update-profile")
    Call<ProfUpdateResponse> Updateprof
            (
                    @Field("token") String token,
                    @Field("name") String name,
                    @Field("email") String email
            );

    @FormUrlEncoded
    @POST("profile/add-kid")
    Call<ProfUpdateResponse> Addkid
            (
                    @Field("token") String token,
                    @Field("name") String name,
                    @Field("dob") String dob,
                    @Field("class") String standard,
                    @Field("school") String school,
                    @Field("coaching") String coaching
            );

    @FormUrlEncoded
    @POST("profile/add-address")
    Call<ProfUpdateResponse> Addaddress
            (
                    @Field("token") String token,
                    @Field("fullAddress") String fullAddress,
                    @Field("coordinates") AddressLatLng addressLatLng,
                    @Field("postalCode") String postalCode,
                    @Field("tag") String tag,
                    @Field("landmark") String landmark,
                    @Field("city") String city,
                    @Field("type") String type

            );

    @FormUrlEncoded
    @POST("profile/update-address")
    Call<ProfUpdateResponse> Updateaddress
            (
                    @Field("token") String token,
                    @Field("postalCode") String postalCode,
                    @Field("addressId") String addressId
            );

    @FormUrlEncoded
    @POST("profile/delete-kid")
    Call<ProfUpdateResponse> Deletekid
            (
                    @Field("token") String token,
                    @Field("kidId") String kidId
            );

    @FormUrlEncoded
    @POST("profile/delete-address")
    Call<ProfUpdateResponse> Deleteaddress
            (
                    @Field("token") String token,
                    @Field("addressId") String addressId
            );

    @FormUrlEncoded
    @POST("profile/get-kids")
    Call<ProfUpdateResponse> Getkids
            (
                    @Field("token") String token
            );

    @FormUrlEncoded
    @POST("profile/get-addresses")
    Call<ProfUpdateResponse> GetAddresses
            (
                    @Field("token") String token
            );

}
