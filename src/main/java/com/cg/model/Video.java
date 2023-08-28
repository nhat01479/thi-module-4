package com.cg.model;
import com.cg.model.dto.VideoResDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "videos")
@Accessors(chain = true)
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String title;
    private String description;
    @Column(nullable = false)
    private String url;
    public VideoResDTO toVideoResDTO(List<Playlist> playlists) {
        return new VideoResDTO()
                .setId(id)
                .setTitle(title)
                .setDescription(description)
                .setUrl(url)
                .setPlaylists(playlists)
                ;
    }

}
