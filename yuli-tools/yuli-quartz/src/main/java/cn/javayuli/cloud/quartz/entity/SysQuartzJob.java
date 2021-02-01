package cn.javayuli.cloud.quartz.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDateTime;

/**
 * @description: 定时任务实体类
 * @author: hanguilin
 * @createDate: 2021年01月28日
 * @version: 1.0
 */
@ApiModel("定时任务")
@TableName("sys_quartz_job")
public class SysQuartzJob extends Model<SysQuartzJob> {

    /**
     * 主键id
     */
    @TableId(type = IdType.ASSIGN_UUID)
    @ApiModelProperty("主键id")
    private String id;
    /**
     * 任务名称
     */
    @ApiModelProperty("任务名称")
    private String jobName;
    /**
     * 任务组名
     */
    @ApiModelProperty("任务组名")
    private String jobGroup;
    /**
     * 调用目标类
     */
    @ApiModelProperty("调用目标类")
    private String targetClass;
    /**
     * cron表达式
     */
    @ApiModelProperty("cron表达式")
    private String cron;
    /**
     * 是否启用
     */
    @ApiModelProperty("是否启用")
    private String enabled;
    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;
    /**
     * 创建人
     */
    @TableField(fill = FieldFill.INSERT)
    @ApiModelProperty("创建人")
    private String createBy;
    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    @ApiModelProperty("更新时间")
    private LocalDateTime updateTime;
    /**
     * 更新人
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    @ApiModelProperty("更新人")
    private String updateBy;
    /**
     * 备注
     */
    @ApiModelProperty("备注")
    private String remark;
    /**
     * 逻辑删除
     */
    @TableLogic
    @ApiModelProperty("逻辑删除")
    private String delFlag;

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobGroup() {
        return jobGroup;
    }

    public void setJobGroup(String jobGroup) {
        this.jobGroup = jobGroup;
    }

    public String getTargetClass(){
        return targetClass;
    }

    public void setTargetClass(String targetClass){
        this.targetClass = targetClass;
    }

    public String getCron(){
        return cron;
    }

    public void setCron(String cron){
        this.cron = cron;
    }

    public String getEnabled(){
        return enabled;
    }

    public void setEnabled(String enabled){
        this.enabled = enabled;
    }

    public LocalDateTime getCreateTime(){
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime){
        this.createTime = createTime;
    }

    public String getCreateBy(){
        return createBy;
    }

    public void setCreateBy(String createBy){
        this.createBy = createBy;
    }

    public LocalDateTime getUpdateTime(){
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime){
        this.updateTime = updateTime;
    }

    public String getUpdateBy(){
        return updateBy;
    }

    public void setUpdateBy(String updateBy){
        this.updateBy = updateBy;
    }

    public String getRemark(){
        return remark;
    }

    public void setRemark(String remark){
        this.remark = remark;
    }

    public String getDelFlag(){
        return delFlag;
    }

    public void setDelFlag(String delFlag){
        this.delFlag = delFlag;
    }

}
