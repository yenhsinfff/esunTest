package com.post.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Objects;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Id;

public class PostVO implements Serializable {
	
	@Id
	@Column(name = "post_id")
	private Integer postId; // 文章ID
	
	@Column(name = "user_id", nullable = false)
	private Integer userId; // 使用者ID
	
	@Column(name = "content", nullable = false)
	private String content; // 文章內容
	
	@Column(name = "image")
	private byte[] Img; // 發文圖片
	
	@Column(name = "created_at", nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime createdAt; // 發布時間

	public PostVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PostVO(Integer postId, Integer userId, String content, byte[] img, LocalDateTime createdAt) {
		super();
		this.postId = postId;
		this.userId = userId;
		this.content = content;
		Img = img;
		this.createdAt = createdAt;
	}

	public Integer getPostId() {
		return postId;
	}

	public void setPostId(Integer postId) {
		this.postId = postId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public byte[] getImg() {
		return Img;
	}

	public void setImg(byte[] img) {
		Img = img;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(Img);
		result = prime * result + Objects.hash(content, createdAt, postId, userId);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PostVO other = (PostVO) obj;
		return Arrays.equals(Img, other.Img) && Objects.equals(content, other.content)
				&& Objects.equals(createdAt, other.createdAt) && Objects.equals(postId, other.postId)
				&& Objects.equals(userId, other.userId);
	}

	@Override
	public String toString() {
		return "PostVO [postId=" + postId + ", userId=" + userId + ", content=" + content + ", Img="
				+ Arrays.toString(Img) + ", createdAt=" + createdAt + "]";
	}
	
	
	
}
