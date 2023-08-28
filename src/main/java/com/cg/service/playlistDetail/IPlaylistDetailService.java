package com.cg.service.playlistDetail;

import com.cg.model.PlaylistDetail;
import com.cg.service.IGeneralService;

import java.util.List;

public interface IPlaylistDetailService extends IGeneralService<PlaylistDetail, Long> {
    List<PlaylistDetail> findAllByVideoId(Long id);
}
