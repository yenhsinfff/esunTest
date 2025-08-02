package com.post.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ApiResponse;
import com.post.model.PostDTO_insert;
import com.post.model.PostDTO_update;
import com.post.model.PostService;
import com.post.model.PostVO;

@RestController
@RequestMapping("/post")
public class PostController {

	@Autowired
	PostService postSvc;

	// 列出所有文章
	// http://localhost:8081/post/getAllPost
	@GetMapping("/getAllPost")
	public ResponseEntity<List<PostVO>> getAllPost() {
		List<PostVO> posts = postSvc.getAll();
		return ResponseEntity.ok(posts);
	}

	// 列出單一文章
	// http://localhost:8081/post/getPost/2001
	@GetMapping("/getPost/{postId}")
	public ResponseEntity<?> getPost(@PathVariable Integer postId) {
		PostVO post = postSvc.getByPostId(postId);
		return ResponseEntity.ok(post);
	}

	// 新增文章
	// http://localhost:8081/post/addPost
	@PostMapping("/addPost")
	public ResponseEntity<?> addPost(@ModelAttribute PostDTO_insert dto) throws IOException {
		PostVO saved = postSvc.addPost(dto);
		ApiResponse<PostVO> successResponse = new ApiResponse<>("success", saved, "儲存成功");
		return ResponseEntity.ok(successResponse);
	}

	// 編輯文章
	// http://localhost:8081/post/updatePost
	@PostMapping("/updatePost")
	public ResponseEntity<?> updatePost(@ModelAttribute PostDTO_update dto) throws IOException {
		PostVO saved = postSvc.updatePost(dto);
		ApiResponse<PostVO> successResponse = new ApiResponse<>("success", saved, "儲存成功");
		return ResponseEntity.ok(successResponse);
	}

	// 刪除文章
	// http://localhost:8081/post/deletePost/2003
	@DeleteMapping("/deletePost/{postId}")
	public ResponseEntity<?> deletePost(@PathVariable Integer postId) {
		postSvc.deletePost(postId);
		ApiResponse<PostVO> successResponse = new ApiResponse<>("success", null, "刪除成功");
		return ResponseEntity.ok(successResponse);
	}

}
