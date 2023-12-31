package com.cg.model.dto;

import com.cg.model.Playlist;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
public class VideoResDTO {
    private Long id;
    private String title;
    private String description;
    private String url;
    private List<Playlist> playlists;
}
