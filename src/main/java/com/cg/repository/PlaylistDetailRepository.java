package com.cg.repository;

import com.cg.model.PlaylistDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaylistDetailRepository extends JpaRepository<PlaylistDetail, Long> {
    List<PlaylistDetail> findAllByVideoId(Long id);
}
