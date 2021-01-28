package ${packageName!}.${moduleName!}.${referencePackage!}.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModelProperty;
<#if importClassList?? && (importClassList?size>0)>
    <#list importClassList as importClass>
import ${importClass};
    </#list>
</#if>

/**
 * @description: ${comment!}实体类
 * @author: ${author!}
 * @createDate: ${now!}
 * @version: ${projectVersion!}
 */
@ApiModel(${comment!})
@TableName("${tableName!}")
public class ${className!} extends Model<${className!}> {

<#list fieldList as field>
    /**
     * ${field.comment}
     */
    <#if field.primary>
    @TableId<#if field.autoincrement>(type = IdType.AUTO)<#else>(type = IdType.ASSIGN_UUID)</#if>
    </#if>
    <#if field.nameLower=="createTime">
    @TableField(fill = FieldFill.INSERT)
    <#elseif field.nameLower=="createBy">
    @TableField(fill = FieldFill.INSERT)
    <#elseif field.nameLower=="updateTime">
    @TableField(fill = FieldFill.INSERT_UPDATE)
    <#elseif field.nameLower=="updateBy">
    @TableField(fill = FieldFill.INSERT_UPDATE)
    <#elseif field.nameLower=="delFlag">
    @TableLogic
    </#if>
    @ApiModelProperty(${field.comment})
    private ${field.type} ${field.nameLower};
</#list>

<#list fieldList as field>
    public ${field.type} get${field.name}(){
        return ${field.nameLower};
    }

    public void ${(field.type == 'Boolean') ? string('is','set')}${field.name}(${field.type} ${field.nameLower}){
        this.${field.nameLower} = ${field.nameLower};
    }

</#list>
}
