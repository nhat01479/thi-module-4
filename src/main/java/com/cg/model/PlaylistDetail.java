package com.cg.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "playlist_detail")
public class PlaylistDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name="video_id", referencedColumnName = "id", nullable = false)
    private Video video;
    @ManyToOne
    @JoinColumn(name="playlist_id", referencedColumnName = "id", nullable = false)
    private Playlist playlist;

}
