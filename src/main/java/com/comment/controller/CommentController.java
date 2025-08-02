package com.comment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ApiResponse;
import com.comment.model.CommentDTO_insert;
import com.comment.model.CommentService;
import com.comment.model.CommentVO;

@RestController
@RequestMapping("/comment")
public class CommentController {

	@Autowired
	CommentService commentSvc;

	// 新增留言
	// http://localhost:8081/comment/addComment/2001
	@PostMapping("/addComment/{postId}")
	public ResponseEntity<?> addComment(@RequestBody CommentDTO_insert dto, @PathVariable Integer postId){
		CommentVO saved = commentSvc.addComment(dto);
		ApiResponse<CommentVO> successResponse = new ApiResponse<>("success", saved, "儲存成功");
		return ResponseEntity.ok(successResponse);
	}

}
