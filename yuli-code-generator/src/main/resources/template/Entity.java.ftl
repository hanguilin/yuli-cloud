package ${packageName}.${moduleName}.ref.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.time.LocalDateTime;

/**
 * @description: ${comment}实体类
 * @author: ${author}
 * @createDate: ${now}
 * @version: ${projectVersion}
 */
@TableName("${table}")
public class ${className} extends Model<${className}> {

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    private String id;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 创建人
     */
    @TableField(fill = FieldFill.INSERT)
    private String createBy;

    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    /**
     * 更新人
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String updateBy;

    /**
     * 备注
     */
    private String remark;

    /**
     * 逻辑删除
     */
    @TableLogic
    private String delFlag;

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id=id;
    }

    public LocalDateTime getCreateTime(){
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime){
        this.createTime=createTime;
    }

    public String getCreateBy(){
        return createBy;
    }

    public void setCreateBy(String createBy){
        this.createBy=createBy;
    }

    public LocalDateTime getUpdateTime(){
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime){
        this.updateTime=updateTime;
    }

    public String getUpdateBy(){
        return updateBy;
    }

    public void setUpdateBy(String updateBy){
        this.updateBy=updateBy;
    }

    public String getRemark(){
        return remark;
    }

    public void setRemark(String remark){
        this.remark=remark;
    }

    public String getDelFlag(){
        return delFlag;
    }

    public void setDelFlag(String delFlag){
        this.delFlag=delFlag;
    }

}
