package levandowski.primao.criptocon.service;

import java.util.List;
import levandowski.primao.criptocon.model.Coin;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface APIRetrofitService {
    String BASE_URL = "https://api.coinmarketcap.com/v1/ticker/";

    @GET("?convert=BRL")
    Call<List<Coin>> getCoin(@Query("limit") int limit);

//    @GET("{name}/{market_cap_brl}/{percent_change_24h}/{percent_change_1h}/json/")
//    Call<List<Coin>> getCoin(@Path("name") String name, @Path("market_cap_brl") String market_cap_brl, @Path("percent_change_24h") String percent_change_24h,
//                             @Path("percent_change_1h") String percent_change_1h);
}


