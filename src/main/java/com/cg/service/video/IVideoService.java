package com.cg.service.video;

import com.cg.model.Video;
import com.cg.model.dto.VideoDTO;
import com.cg.model.dto.VideoResDTO;
import com.cg.service.IGeneralService;

public interface IVideoService extends IGeneralService<Video, Long> {
    VideoResDTO create(VideoDTO videoDTO);
}
