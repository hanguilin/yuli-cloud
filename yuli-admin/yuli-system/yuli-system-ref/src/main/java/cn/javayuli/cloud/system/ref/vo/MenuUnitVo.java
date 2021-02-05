package cn.javayuli.cloud.system.ref.vo;

import cn.javayuli.cloud.system.ref.entity.SysMenu;

import java.util.List;

/**
 * @description: 菜单单元
 * @author: hanguilin
 * @createDate: 2021/2/3
 * @version: 1.0
 */
public class MenuUnitVo {

    /**
     * 目录
     */
    private SysMenu directory;

    /**
     * 按钮
     */
    private List<SysMenu> buttonList;

    public SysMenu getDirectory() {
        return directory;
    }

    public void setDirectory(SysMenu directory) {
        this.directory = directory;
    }

    public List<SysMenu> getButtonList() {
        return buttonList;
    }

    public void setButtonList(List<SysMenu> buttonList) {
        this.buttonList = buttonList;
    }
}
