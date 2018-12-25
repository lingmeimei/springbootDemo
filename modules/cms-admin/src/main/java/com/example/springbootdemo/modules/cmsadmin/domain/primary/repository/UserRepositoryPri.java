package com.example.springbootdemo.modules.cmsadmin.domain.primary.repository;

import com.example.springbootdemo.modules.cmsadmin.domain.primary.entity.UserPri;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepositoryPri extends BaseRepository<UserPri,Integer> {

    List<UserPri> findAll();

    //以下是含有各种参数的 几种sql语句表达方法：
    /*@Query("from UserPri at where u.id in (?1) and u.orgCode in(?2) and u.nickname like (?3) " +
            "order by u.id desc ")
    Page<UserPri> findByIdInByState(Collection<Integer> ids, Collection<String> orgCodes, String nickname, Pageable pageable);


    @Query("from UserPri at where at.state in (?1) and at.realFinishDate >= ?2 " +
            "and at.realFinishDate <= ?3 order by at.realFinishDate desc, at.finishDate desc")
    List<UserPri> findByIdInByState(Collection<Integer> state, Date startDate, Date endDate);


    @Query("from UserPri at where at.orgs.orgCode in (?1) " +
            "and date_format(at.startDate,'%Y-%m') = date_format(?2 ,'%Y-%m') " +
            "and at.state = 2 and at.taskType =0  order by at.startDate")
    List<UserPri> findAllTaskByOrgCodeAndMonth(Collection<String> orgCodes, Date queryMonth);


    @Query("from UserPri at where at.orgs.orgCode in (?1) " +
            "and date_format(at.startDate,'%Y-%m') >= date_format( ?2 ,'%Y-%m') " +
            "and date_format(at.startDate,'%Y-%m') <= date_format( ?3 ,'%Y-%m') " +
            "and at.taskType =0")
    Page<UserPri> findByOrgCodeAndMonthInfo(Collection<String> orgCodes, Date startDate, Date endDate, Pageable pageable);


    @Query("from UserPri at where at.id in (?3) and at.state = 2 " +
            "AND DATE_FORMAT(at.realFinishDate,'%Y-%m')<= DATE_FORMAT(at.finishDate,'%Y-%m') " +
            "and at.taskType = ?4 " +
            "AND DATE_FORMAT(at.startDate,'%Y-%m')>= ?1 " +
            "AND DATE_FORMAT(at.startDate,'%Y-%m')<= ?2 ")
    List<UserPri> findInPlanByIdAndStateAndTaskType(String startTime, String endTime, Collection<Integer> arrangeTaskIds, Integer taskType);


    @Query(value = "SELECT " +
            "CASE at.state WHEN 2 then 'done' " +
            "ELSE 'todo'  END as taskType," +
            "count(AT.id) as num " +
            "from v_arrangeTask at " +
            "where at.orgCode in (?1) " +
            "and date_format(at.startDate,'%Y-%m') = date_format( ?2 ,'%Y-%m') " +
            "group by " +
            "CASE at.state WHEN 2 then 'done' " +
            "ELSE 'todo'  END",nativeQuery = true)
    List<Object[]> getArrangeTaskCount(Collection<String> orgCodes,Date queryMonth);*/



}
