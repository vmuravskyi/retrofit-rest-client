package org.retrofit.service;

import java.util.List;

import org.retrofit.model.PostModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface PostsService {

	@GET("/posts")
	Call<List<PostModel>> getPosts();

	@POST("/posts")
	Call<PostModel> postPosts(@Body PostModel model);

}
