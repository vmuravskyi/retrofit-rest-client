package org.retrofit.client;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

	private static final String BASE_URL = "https://jsonplaceholder.typicode.com";

	private static Retrofit retrofitInstance;

	private RetrofitClient() {
		// private constructor
	}

	private static synchronized Retrofit retrofitClient() {
		if (retrofitInstance == null) {
			retrofitInstance = new Retrofit.Builder()
				.baseUrl(BASE_URL)
				.addConverterFactory(GsonConverterFactory.create())
				.build();
		}
		return retrofitInstance;
	}

	public static <T> T createService(Class<T> serviceClass) {
		return retrofitClient().create(serviceClass);
	}

}
