package cn.javayuli.cloud.system.api.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import cn.javayuli.cloud.common.core.entity.Rest;
import cn.javayuli.cloud.system.api.service.SysOfficeService;
import cn.javayuli.cloud.system.api.mapper.SysOfficeMapper;
import cn.javayuli.cloud.system.ref.entity.SysOffice;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Splitter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 机构实现类
 *
 * @author hanguilin
 */
@Service
public class SysOfficeServiceImpl extends ServiceImpl<SysOfficeMapper, SysOffice> implements SysOfficeService {

    /**
     * 获取机构树
     *
     * @param topId 上级id
     * @param excludeId 排除的id
     * @param type menu类型
     * @return
     */
    @Override
    public List<SysOffice> findOfficeTree(String topId, String excludeId, String type) {
        List<SysOffice> list = list(Wrappers.lambdaQuery(SysOffice.class)
                .ne(StrUtil.isNotBlank(excludeId), SysOffice::getId, excludeId)
                .eq(StrUtil.isNotBlank(type), SysOffice::getType, type)
                .orderByAsc(SysOffice::getSort));
        return setDeepTreeMenuChildren(list, topId);
    }

    /**
     * 设置递归子机构
     *
     * @param sysOfficeList 源数据
     * @param topId 上级id
     * @return
     */
    private List<SysOffice> setDeepTreeMenuChildren(List<SysOffice> sysOfficeList, String topId) {

        // 顶级机构，从上往下设值
        return sysOfficeList.stream().filter(o -> {
            // 根据顶级id过滤
            if (StrUtil.isNotBlank(topId)) {
                return Objects.equals(topId, o.getParentId());
            }
            return StrUtil.isBlank(o.getParentId());
        }).map(o -> {
            deepTreeOfficeChildren(o, sysOfficeList);
            return o;
        }).sorted(Comparator.comparing(SysOffice::getSort)).collect(Collectors.toList());
    }

    /**
     * 为当前菜单项设置子机构
     *
     * @param sysOfficeList 机构数据
     */
    private void deepTreeOfficeChildren (SysOffice current, List<SysOffice> sysOfficeList) {
        if (current != null) {
            // 寻找当前节点的子节点
            List<SysOffice> children = sysOfficeList.stream().filter(o -> current.getId().equals(o.getParentId())).collect(Collectors.toList());
            if (CollUtil.isNotEmpty(children)) {
                // 将子节点依赖于当前节点
                current.setChildren(children);
                // 子节点寻找自己的子节点
                children.forEach(o -> deepTreeOfficeChildren(o, sysOfficeList));
                // 子节点按照sort字段升序排序
                children.sort(Comparator.comparing(SysOffice::getSort));
            }
        }
    }

    /**
     * 更新数据
     * @param sysOffice 机构数据
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public Rest<Boolean> updateOffice(SysOffice sysOffice) {
        boolean res = updateById(sysOffice);
        if (!res) {
            return Rest.fail("更新失败");
        }
        String enabled = sysOffice.getEnabled();
        // 联动更新子菜单得到显示状态
        if (StrUtil.isNotBlank(enabled)) {
            List<SysOffice> deepMenuChildren = getDeepOfficeChildren(CollUtil.newArrayList(sysOffice.getId()));
            if (CollUtil.isNotEmpty(deepMenuChildren)) {
                // 给子菜单设置与父菜单相同的显示状态
                deepMenuChildren.forEach(o -> o.setEnabled(enabled));
                saveOrUpdateBatch(deepMenuChildren);
            }
        }
        return Rest.success();
    }


    /**
     * 获取机构的所有机构子项
     *
     * @param ids 目标id
     */
    private List<SysOffice> getDeepOfficeChildren (List<String> ids) {
        List<SysOffice> source = list();
        List<SysOffice> target = CollUtil.newArrayList();
        ids.forEach(o -> deepOfficeChildren(source, target, o));
        return target;
    }

    /**
     * 递归设置机构的所有机构子项
     *
     * @param source 源数据
     * @param target 目标数据
     * @param id 目标id
     */
    private void deepOfficeChildren (List<SysOffice> source, List<SysOffice> target, String id) {
        if (CollUtil.isNotEmpty(source)) {
            List<SysOffice> children = source.stream().filter(o -> Objects.equals(o.getParentId(), id)).collect(Collectors.toList());
            if (CollUtil.isNotEmpty(children)) {
                target.addAll(children);
                children.forEach(o -> deepOfficeChildren(source, target, o.getId()));
            }
        }
    }

    /**
     * 删除数据
     *
     * @param ids 主键id
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public Rest<Boolean> deleteOffice(String ids) {
        List<String> idList = Splitter.on(",").splitToList(ids);
        removeByIds(idList);
        // 查找删除id集的子机构
        List<SysOffice> deepOfficeChildren = getDeepOfficeChildren(idList);
        if (CollUtil.isNotEmpty(deepOfficeChildren)) {
            List<String> delIdList = deepOfficeChildren.stream().map(SysOffice::getId).collect(Collectors.toList());
            // 逻辑删除所有相关子机构
            removeByIds(delIdList);
        }
        return Rest.success();
    }
}
