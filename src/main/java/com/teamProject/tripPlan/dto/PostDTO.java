package com.teamProject.tripPlan.dto;

import com.teamProject.tripPlan.entity.Post;
import com.teamProject.tripPlan.entity.Travel;
import com.teamProject.tripPlan.entity.Users;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {
    private Long postId;
    private String postTitle;
    private String postContent;
    private LocalDateTime postDate;
    private int likes;
    private Users users;
    private List<CommentDTO> comments = new ArrayList<>();
    private Travel travel;

    public static PostDTO fromEntity(Post post) {
        return new PostDTO(
                post.getPostId(),
                post.getPostTitle(),
                post.getPostContent(),
                post.getPostDate(),
                post.getLikes(),
                post.getUsers(),
                post.getComments().stream().map(x->CommentDTO.fromEntity(x)).toList(),
                post.getTravel());
    }

    public static Post fromDTO(PostDTO dto) {
        Post post = new Post();
        post.setPostId(dto.getPostId());
        post.setPostTitle(dto.getPostTitle());
        post.setPostContent(dto.getPostContent());
        post.setPostDate(dto.getPostDate());
        post.setLikes(dto.getLikes());
        return post;
    }

}
