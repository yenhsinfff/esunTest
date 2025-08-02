package com.comment.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.post.model.PostRepository;



@Service("commentService")
public class CommentService {

	@Autowired
	CommentRepository commentRepo;
	
	@Autowired
	PostRepository postRepo;
	
	@Transactional
	public CommentVO addComment(CommentDTO_insert dto){

		if(!postRepo.existsById(dto.getPostId())) {
			throw new RuntimeException("找不到發文");
		}

		CommentVO comment = new CommentVO();
		comment.setUserId(dto.getUserId());
		comment.setPostId(dto.getPostId());
		comment.setContent(dto.getContent());
		return commentRepo.save(comment);
	}
}
