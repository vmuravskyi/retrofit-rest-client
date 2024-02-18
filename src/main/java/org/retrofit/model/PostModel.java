package org.retrofit.model;

import java.util.Random;
import java.util.StringJoiner;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PostModel {

	@SerializedName("userId")
	private Integer userId;

	@SerializedName("id")
	@Expose(serialize = false)
	private Integer id;

	@SerializedName("title")
	private String title;

	@SerializedName("body")
	private String body;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o)
			return true;

		if (o == null || getClass() != o.getClass())
			return false;

		final PostModel postModel = (PostModel) o;

		return new EqualsBuilder()
			.append(userId, postModel.userId)
			.append(id, postModel.id)
			.append(title, postModel.title)
			.append(body, postModel.body)
			.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37)
			.append(userId)
			.append(id)
			.append(title)
			.append(body)
			.toHashCode();
	}

	@Override
	public String toString() {
		return "PostModel{" +
			"userId=" + userId +
			", id=" + id +
			", title='" + title + '\'' +
			", body='" + body + '\'' +
			'}';
	}

	public static class Builder {
		private Integer userId;
		private String title;
		private String body;

		public Builder userId(Integer userId) {
			this.userId = userId;
			return this;
		}

		public Builder title(String title) {
			this.title = title;
			return this;
		}

		public Builder body(String body) {
			this.body = body;
			return this;
		}

		public PostModel build() {
			// Generating random ID
			Random random = new Random();
			PostModel postModel = new PostModel();
			postModel.userId = this.userId;
			postModel.title = this.title;
			postModel.body = this.body;
			return postModel;
		}
	}

	// Generate object with random data
	public static PostModel generateRandomPost(Integer userId) {
		Random random = new Random();
		return new Builder()
			.userId(userId)
			.title("Random Title " + random.nextInt(1000))
			.body("Random Body " + random.nextInt(1000))
			.build();
	}

}
