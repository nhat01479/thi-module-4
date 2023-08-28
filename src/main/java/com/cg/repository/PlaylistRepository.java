package com.cg.repository;

import com.cg.model.Playlist;
import com.cg.model.PlaylistDetail;
import com.cg.model.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaylistRepository extends JpaRepository<Playlist, Long> {
    @Query("select new com.cg.model.Playlist (p.id, p.name) " +
            "from Playlist as p " +
            "left join PlaylistDetail as pd " +
            "on pd.playlist.id = p.id " +
            "where  pd.video = :video")
    List<Playlist> findAllByVideo(Video video);

}
