package com.ihrm.social.dao;

import com.ihrm.domain.social_security.model.ArchiveDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * 自定义dao接口继承
 * JpaRepository<实体类，主键>
 * JpaSpecificationExecutor<实体类>
 */
public interface ArchiveDetailDao extends JpaRepository<ArchiveDetail, String>, JpaSpecificationExecutor<ArchiveDetail> {

    void deleteByArchiveId(String archiveId);

    List<ArchiveDetail> findByArchiveId(String archiveId);

    //根据用户id和年月查询用户归档明细
    ArchiveDetail findByUserIdAndYearsMonth(String userId, String yearMonth);
}
