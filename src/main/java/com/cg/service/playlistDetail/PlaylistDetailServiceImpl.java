package com.cg.service.playlistDetail;

import com.cg.model.PlaylistDetail;
import com.cg.repository.PlaylistDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class PlaylistDetailServiceImpl implements IPlaylistDetailService{
    @Autowired
    private PlaylistDetailRepository playlistDetailRepository;
    @Override
    public List<PlaylistDetail> findAll() {
        return null;
    }

    @Override
    public List<PlaylistDetail> findAllByVideoId(Long id) {
        return playlistDetailRepository.findAllByVideoId(id);
    }

    @Override
    public Optional<PlaylistDetail> findById(Long id) {
        return playlistDetailRepository.findById(id);
    }

    @Override
    public PlaylistDetail save(PlaylistDetail playlistDetail) {
        return null;
    }

    @Override
    public void delete(PlaylistDetail playlistDetail) {
        playlistDetailRepository.delete(playlistDetail);
    }

    @Override
    public void deleteById(Long id) {

    }
}
