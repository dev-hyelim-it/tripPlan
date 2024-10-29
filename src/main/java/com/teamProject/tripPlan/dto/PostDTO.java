package com.teamProject.tripPlan.dto;

import com.teamProject.tripPlan.entity.Keyword;
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
    // 추가: keywords 필드
    private List<Keyword> keywords = new ArrayList<>();

    public static PostDTO fromEntity(Post post) {
        return new PostDTO(
                post.getPostId(),
                post.getPostTitle(),
                post.getPostContent(),
                post.getPostDate(),
                post.getLikes(),
                post.getUsers(),
                post.getComments().stream().map(CommentDTO::fromEntity).toList(),
                post.getTravel(),
                post.getKeywords()  // 키워드 추가
        );
    }

    public static Post fromDTO(PostDTO dto) {
        Post post = new Post();
        post.setPostId(dto.getPostId());
        post.setPostTitle(dto.getPostTitle());
        post.setPostContent(dto.getPostContent());
        post.setPostDate(dto.getPostDate());
        post.setLikes(dto.getLikes());
        post.setKeywords(dto.getKeywords()); // 키워드 설정 추가
        return post;
    }
}