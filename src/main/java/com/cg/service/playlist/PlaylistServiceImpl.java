package com.cg.service.playlist;

import com.cg.model.Playlist;
import com.cg.model.PlaylistDetail;
import com.cg.model.Video;
import com.cg.repository.PlaylistDetailRepository;
import com.cg.repository.PlaylistRepository;
import com.cg.service.playlistDetail.IPlaylistDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PlaylistServiceImpl implements IPlaylistService {
    @Autowired
    private PlaylistRepository playlistRepository;

    @Override
    public List<Playlist> findAll() {
        return playlistRepository.findAll();
    }

    @Override
    public List<Playlist> findAllByVideo(Video video) {
        return playlistRepository.findAllByVideo(video);
    }

    @Override
    public Optional<Playlist> findById(Long id) {

        return playlistRepository.findById(id);
    }

    @Override
    public Playlist save(Playlist playlist) {

        return playlistRepository.save(playlist);
    }

    @Override
    public void delete(Playlist playlist) {

    }

    @Override
    public void deleteById(Long id) {

    }
}
