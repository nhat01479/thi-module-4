package com.cg.service.video;

import com.cg.exception.DataInputException;
import com.cg.model.Playlist;
import com.cg.model.PlaylistDetail;
import com.cg.model.Video;
import com.cg.model.dto.VideoDTO;
import com.cg.model.dto.VideoResDTO;
import com.cg.repository.PlaylistDetailRepository;
import com.cg.repository.PlaylistRepository;
import com.cg.repository.VideoRepository;
import com.cg.service.playlist.IPlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class VideoServiceImpl implements IVideoService{
    @Autowired
    private VideoRepository videoRepository;
    @Autowired
    private PlaylistRepository playlistRepository;
    @Autowired
    private PlaylistDetailRepository playlistDetailRepository;
    @Autowired
    private IPlaylistService playlistService;
    @Override
    public List<Video> findAll() {
        return videoRepository.findAll();
    }

    @Override
    public VideoResDTO create(VideoDTO videoDTO) {

        Video video = videoRepository.save(videoDTO.toVideo());
        Long [] playlistDetails = videoDTO.getPlaylistId();
        List<Playlist> playlists = new ArrayList<>();

        for (int i = 0; i < playlistDetails.length; i++) {
            PlaylistDetail playlistDetail = new PlaylistDetail();
            Playlist playlist = playlistService.findById(playlistDetails[i]).orElseThrow(()-> {
                throw new DataInputException("Không tìm thấy Playlist Id");
            });
            playlistDetail.setPlaylist(playlist);
            playlists.add(playlist);
            playlistDetail.setVideo(video);
            playlistDetailRepository.save(playlistDetail);
        }

        VideoResDTO videoResDTO = video.toVideoResDTO(playlists);

        return videoResDTO;
    }

    @Override
    public Optional<Video> findById(Long id) {
        return videoRepository.findById(id);

    }

    @Override
    public Video save(Video video) {
        return null;
    }

    @Override
    public void delete(Video video) {
        videoRepository.delete(video);
    }

    @Override
    public void deleteById(Long id) {

    }
}
