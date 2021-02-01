package ${packageName!}.${moduleName!}.${apiPackage!}.service.impl;

import ${packageName!}.${moduleName!}.${apiPackage!}.mapper.${className!}Mapper;
import ${packageName!}.${moduleName!}.${apiPackage!}.service.${className!}Service;
import ${packageName!}.${moduleName!}.${referencePackage!}.entity.${className!};
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @description: ${comment!}业务接口实现类
 * @author: ${author!}
 * @createDate: ${now!}
 * @version: ${projectVersion!}
 */
@Service
public class ${className!}ServiceImpl extends ServiceImpl<${className!}Mapper, ${className!}> implements ${className!}Service {

}
