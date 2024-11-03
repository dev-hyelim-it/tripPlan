package com.teamProject.tripPlan.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.teamProject.tripPlan.entity.Keyword;
import com.teamProject.tripPlan.entity.Post;
import com.teamProject.tripPlan.entity.Travel;
import com.teamProject.tripPlan.entity.Users;
import lombok.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PostDTO {
    private Long postId;
    private String postTitle;
    private String postContent;
    private int likes;
    private Users users;
    private List<CommentDTO> comments = new ArrayList<>();
    private Travel travel;
    private Keyword keyword;
    private LocalDateTime insertedDate;
    private LocalDateTime updatedDate;

    private List<PlaceDTO> places = new ArrayList<>(); // 빈 리스트로 초기화

    public static PostDTO fromEntity(Post post) {
        return new PostDTO(
                post.getPostId(),
                post.getPostTitle(),
                post.getPostContent(),
                post.getLikes(),
                post.getUsers(),
                post.getComments().stream().map(CommentDTO::fromEntity).toList(),
                post.getTravel(),
                post.getKeyword(), // Keyword 객체 리스트를 그대로 사용
                post.getInsertedDate(),
                post.getUpdatedDate(),
                post.getPlaces() != null ? post.getPlaces().stream().map(PlaceDTO::fromEntity).toList() : new ArrayList<>()
        );
    }

    public static Post fromDTO(PostDTO dto) {
        Post post = new Post();
        post.setPostId(dto.getPostId());
        post.setPostTitle(dto.getPostTitle());
        post.setPostContent(dto.getPostContent());
        post.setLikes(dto.getLikes());

        // Keyword 객체 리스트 설정
        post.setKeyword(dto.getKeyword()); // 직접 설정

        // Travel 객체 설정
        Travel travel = new Travel();
        travel.setUsers(dto.getUsers()); // 사용자를 Travel에 설정
        post.setTravel(travel);

        return post;
        // Keyword 객체 리스트 설정
//        post.setKeyword(dto.getKeyword());

//        // Travel 객체 설정
//        Travel travel = new Travel();
//        travel.setUsers(dto.getUsers());
//        post.setTravel(travel);

//        List<Place> places = dto.getPlaces() != null ? dto.getPlaces().stream().map(PlaceDTO::fromDTO).toList() : new ArrayList<>();
//        post.setPlaces(places);
//
//
//        return post;
    }
}