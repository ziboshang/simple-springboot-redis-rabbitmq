package com.dhu.springbootauto.mapper;


import com.dhu.springbootauto.entites.Record;

import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;


public interface RecordMapper {


    public Record getRecordById(@Param("id") Integer id);
    public int  deleteRecordById(@Param("id") Integer id);
    public int insertRecord(@Param("borrowtime") Date borrowtime,@Param("userid") Integer userid,@Param("bookname") String bookname);
    public int updateRecord(Record record);
    public List<Record> selectAll();
    public List<Record> un_users_Record(@Param("id") Integer id);

    public Record getRecordBy_user_and_book(@Param("userid") Integer userid,@Param("bookname") String bookname);

}
