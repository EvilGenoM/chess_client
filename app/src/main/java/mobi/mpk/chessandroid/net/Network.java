package mobi.mpk.chessandroid.net;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Network {

    private Retrofit retrofit;

    public Network(String adressHTTP) {

        retrofit = new Retrofit.Builder().
                baseUrl(adressHTTP).
                addConverterFactory(GsonConverterFactory.create()).
                build();

    }

}
