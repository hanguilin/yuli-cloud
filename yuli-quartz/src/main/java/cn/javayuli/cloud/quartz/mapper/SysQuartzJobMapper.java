package cn.javayuli.cloud.quartz.mapper;

import cn.javayuli.cloud.quartz.entity.SysQuartzJob;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @description: 定时任务数据接口
 * @author: hanguilin
 * @createDate: 2021年01月28日
 * @version: 1.0
 */
@Mapper
public interface SysQuartzJobMapper extends BaseMapper<SysQuartzJob> {

}
