package org.retrofit;

import java.io.IOException;
import java.util.List;

import org.retrofit.client.RetrofitClient;
import org.retrofit.model.PostModel;
import org.retrofit.service.PostsService;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Response;

public class Main {

	public static void main(String[] args) throws IOException {

		// initialize service
		PostsService postsService = RetrofitClient.createService(PostsService.class);

		Response<List<PostModel>> posts = postsService.getPosts().execute();
		List<PostModel> listOfPosts = posts.body();

		// print json response
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		System.out.println(gson.toJson(listOfPosts));

		System.out.println("****************************************");

		// post method
		PostModel postModel = PostModel.generateRandomPost(1);
		List<PostModel> postPayload = List.of(postModel);
		PostModel createdPost = postsService.postPosts(postModel).execute().body();
		System.out.println(createdPost);

	}

}
