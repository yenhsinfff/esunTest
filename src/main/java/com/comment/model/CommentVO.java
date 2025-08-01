package com.comment.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Id;

public class CommentVO implements Serializable{

	@Id
	@Column(name = "comment_id")
	private Integer commentId; // 留言ID
	
	@Column(name = "user_id", nullable = false)
	private Integer userId; // 使用者ID
	
	@Column(name = "post_id", nullable = false)
	private Integer postId; // 文章ID
	
	@Column(name = "content", nullable = false)
	private String content; // 留言內容
	
	@Column(name = "created_at", nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime createdAt; // 留言時間

	public CommentVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CommentVO(Integer commentId, Integer userId, Integer postId, String content, LocalDateTime createdAt) {
		super();
		this.commentId = commentId;
		this.userId = userId;
		this.postId = postId;
		this.content = content;
		this.createdAt = createdAt;
	}

	public Integer getCommentId() {
		return commentId;
	}

	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getPostId() {
		return postId;
	}

	public void setPostId(Integer postId) {
		this.postId = postId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public int hashCode() {
		return Objects.hash(commentId, content, createdAt, postId, userId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CommentVO other = (CommentVO) obj;
		return Objects.equals(commentId, other.commentId) && Objects.equals(content, other.content)
				&& Objects.equals(createdAt, other.createdAt) && Objects.equals(postId, other.postId)
				&& Objects.equals(userId, other.userId);
	}

	@Override
	public String toString() {
		return "CommentVO [commentId=" + commentId + ", userId=" + userId + ", postId=" + postId + ", content="
				+ content + ", createdAt=" + createdAt + "]";
	}
	
	
}
