package com.cg.api;

import com.cg.exception.DataInputException;
import com.cg.model.Playlist;
import com.cg.model.PlaylistDetail;
import com.cg.model.Video;
import com.cg.model.dto.VideoDTO;
import com.cg.model.dto.VideoResDTO;
import com.cg.service.playlist.IPlaylistService;
import com.cg.service.playlistDetail.IPlaylistDetailService;
import com.cg.service.video.IVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/videos")
public class VideoAPI {
    @Autowired
    private IVideoService videoService;
    @Autowired
    private IPlaylistDetailService playlistDetailService;
    @Autowired
    private IPlaylistService playlistService;
    @GetMapping()
    public ResponseEntity<?> getAll() {
        List<Video> videos = videoService.findAll();

        List<VideoResDTO> videoResDTOS = new ArrayList<>();

        for (Video video: videos) {
            List<Playlist> playlists =  playlistService.findAllByVideo(video);
            videoResDTOS.add(video.toVideoResDTO(playlists));
        }

        return new ResponseEntity<>(videoResDTOS, HttpStatus.OK);
    }

    @GetMapping("/get-all-playlist")
    public ResponseEntity<?> getAllPlaylist() {
        List<Playlist> playlists = playlistService.findAll();

        return new ResponseEntity<>(playlists, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> create(@RequestBody VideoDTO videoDTO) {
        VideoResDTO videoResDTO = videoService.create(videoDTO);

        return new ResponseEntity<>(videoResDTO, HttpStatus.OK);
    }
    @DeleteMapping("/{videoId}")
    public ResponseEntity<?> delete(@PathVariable ("videoId") String videoId) {

        Video video = videoService.findById(Long.valueOf(videoId)).orElseThrow(() ->
                new DataInputException("Video không tồn tại"));

        List<PlaylistDetail> playlistDetails = playlistDetailService.findAllByVideoId(video.getId());
        for (PlaylistDetail p: playlistDetails) {
            playlistDetailService.delete(p);
        }
        videoService.delete(video);

        return new ResponseEntity<>(video, HttpStatus.OK);

    }


}
