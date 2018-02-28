package com.example.mansopresk01.imageproject.Model;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by Shaik on 05-10-2017.
 */

public interface RestInterface {

    @GET("/mobileassignment/repository/doc_categories")

    void getDocReport(Callback<DocumentRspnc> callback);



    @GET("/mobileassignment/repository/docs_list/image")

   void getCardReport(Callback<PanCardRspnc> callback);




//  https://s3.ap-south-1.amazonaws.com/mobileassignment/repository/doc_categories
}
