package com.cg.model.dto;

import com.cg.model.Playlist;
import com.cg.model.Video;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class VideoDTO {
    private Long id;
    private String title;
    private String description;
    private String url;
    private Long [] playlistId;
    public Video toVideo() {
        return new Video()
                .setId(null)
                .setTitle(title)
                .setDescription(description)
                .setUrl(url);
    }
}
