package com.aceplus.rxjavasearchmvp.network;
import com.aceplus.rxjavasearchmvp.data.vo.Contact;

import java.util.List;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;


/**
 * Created by kkk on 7/9/2018.
 */

public interface ApiService {

    @GET("contacts.php")
    Single<List<Contact>> getContacts(@Query("source") String source, @Query("search") String query);
}
