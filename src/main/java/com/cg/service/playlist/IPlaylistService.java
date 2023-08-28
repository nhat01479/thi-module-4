package com.cg.service.playlist;

import com.cg.model.Playlist;
import com.cg.model.PlaylistDetail;
import com.cg.model.Video;
import com.cg.service.IGeneralService;

import java.util.List;

public interface IPlaylistService extends IGeneralService<Playlist, Long> {
    List<Playlist> findAllByVideo(Video video);
}
