package com.fec.xjoneproject.util;

import com.fec.xjoneproject.ui.supervise.TasksListFragment;
import java.util.ArrayList;
import java.util.List;
import me.nereo.multi_image_selector.MultiImageSelectorActivity;

public class SpinnerItem {
    public static final SpinnerItem[] CarColors = new SpinnerItem[]{new SpinnerItem(Integer.valueOf(1), "白色"), new SpinnerItem(Integer.valueOf(2), "银色"), new SpinnerItem(Integer.valueOf(3), "灰色"), new SpinnerItem(Integer.valueOf(4), "黑色"), new SpinnerItem(Integer.valueOf(5), "红色"), new SpinnerItem(Integer.valueOf(6), "深蓝"), new SpinnerItem(Integer.valueOf(7), "蓝色"), new SpinnerItem(Integer.valueOf(8), "黄色"), new SpinnerItem(Integer.valueOf(9), "绿色"), new SpinnerItem(Integer.valueOf(10), "棕色"), new SpinnerItem(Integer.valueOf(11), "粉色"), new SpinnerItem(Integer.valueOf(12), "紫色"), new SpinnerItem(Integer.valueOf(13), "深灰"), new SpinnerItem(Integer.valueOf(14), "青色"), new SpinnerItem(Integer.valueOf(15), "橙色")};
    public static final SpinnerItem[] CarTypes = new SpinnerItem[]{new SpinnerItem(Integer.valueOf(1), "大型客车"), new SpinnerItem(Integer.valueOf(2), "货车"), new SpinnerItem(Integer.valueOf(3), "轿车"), new SpinnerItem(Integer.valueOf(4), "面包车"), new SpinnerItem(Integer.valueOf(5), "小货车"), new SpinnerItem(Integer.valueOf(6), "行人"), new SpinnerItem(Integer.valueOf(7), "二轮车"), new SpinnerItem(Integer.valueOf(8), "三轮车"), new SpinnerItem(Integer.valueOf(9), "SUV/MPV"), new SpinnerItem(Integer.valueOf(10), "中型货车")};
    public static final SpinnerItem[] CollectionPersonTypeS = new SpinnerItem[]{new SpinnerItem(Integer.valueOf(1), "危安类刑满释放人员及其家属"), new SpinnerItem(Integer.valueOf(2), "野阿訇"), new SpinnerItem(Integer.valueOf(3), "野阿吉"), new SpinnerItem(Integer.valueOf(4), "涉“六条线”人员的徒子徒孙"), new SpinnerItem(Integer.valueOf(5), "本地持“瓦哈比”思想传承人员"), new SpinnerItem(Integer.valueOf(6), "曾被教育转化的人员"), new SpinnerItem(Integer.valueOf(7), "境外“回流”人员"), new SpinnerItem(Integer.valueOf(8), "被判处死刑、被击毙、自爆身亡人员的亲属"), new SpinnerItem(Integer.valueOf(9), "国保三、四、五类人员"), new SpinnerItem(Integer.valueOf(10), "长期外出务工突然返乡人员"), new SpinnerItem(Integer.valueOf(11), "严打以来曾被判处管制、拘役纳入社区矫治的人员"), new SpinnerItem(Integer.valueOf(12), "涉“7.5”“7.6”案件刑释解教、解脱人员及其家属"), new SpinnerItem(Integer.valueOf(13), "过去使用智能手机，现在突然不用手机或改用非智能手机的人员"), new SpinnerItem(Integer.valueOf(14), "不与左邻右舍来往，平时很少走正门、行为诡秘的人员"), new SpinnerItem(Integer.valueOf(15), "过去热衷于向清真寺捐钱捐物或替清真寺收钱收物的人员"), new SpinnerItem(Integer.valueOf(16), "无正当理由突然变卖家产外出特别是举家外出人员"), new SpinnerItem(Integer.valueOf(17), "家庭用电异常的人员"), new SpinnerItem(Integer.valueOf(18), "违反计划生育，超生的人员"), new SpinnerItem(Integer.valueOf(19), "懂电焊、制爆技术的人员"), new SpinnerItem(Integer.valueOf(20), "无正当理由不愿享受各类惠民政策、不参加基础组织安排的各类活动"), new SpinnerItem(Integer.valueOf(21), "出境人员报备"), new SpinnerItem(Integer.valueOf(22), "入户采集的数据中没有电表编号"), new SpinnerItem(Integer.valueOf(23), "入户采集的实有人数和户籍人数不一致"), new SpinnerItem(Integer.valueOf(24), "入户采集的数据中未登记已办理护照信息"), new SpinnerItem(Integer.valueOf(25), "入户采集的数据中没有登记该地区2016年1月1日以来没有活动轨迹的人员（2016年1月1日前曾有活动轨迹）"), new SpinnerItem(Integer.valueOf(26), TasksListFragment.TASK_TYPE_ELECAB_NORMAL), new SpinnerItem(Integer.valueOf(27), "流出人员"), new SpinnerItem(Integer.valueOf(28), "流入人员"), new SpinnerItem(Integer.valueOf(29), "人证不符"), new SpinnerItem(Integer.valueOf(30), "人机不符"), new SpinnerItem(Integer.valueOf(31), TasksListFragment.TASK_TYPE_CAR_PERSON), new SpinnerItem(Integer.valueOf(32), "关联案件线索"), new SpinnerItem(Integer.valueOf(33), "关联外逃人员"), new SpinnerItem(Integer.valueOf(34), "关联境外人员"), new SpinnerItem(Integer.valueOf(35), "关联关注人员"), new SpinnerItem(Integer.valueOf(MultiImageSelectorActivity.REQUEST_PREVIEW), "其他")};
    public static final SpinnerItem[] PlateColorArray = new SpinnerItem[]{new SpinnerItem(Integer.valueOf(0), "白色"), new SpinnerItem(Integer.valueOf(1), "黄色"), new SpinnerItem(Integer.valueOf(2), "蓝色"), new SpinnerItem(Integer.valueOf(3), "黑色"), new SpinnerItem(Integer.valueOf(4), "其他颜色")};
    public static final SpinnerItem[] PlateTypeArray = new SpinnerItem[]{new SpinnerItem(Integer.valueOf(0), "未知"), new SpinnerItem(Integer.valueOf(1), "92式民用车"), new SpinnerItem(Integer.valueOf(2), "警车"), new SpinnerItem(Integer.valueOf(3), "上下军车"), new SpinnerItem(Integer.valueOf(4), "92式武警车"), new SpinnerItem(Integer.valueOf(5), "左右军车"), new SpinnerItem(Integer.valueOf(7), "02式个性化车"), new SpinnerItem(Integer.valueOf(8), "黄色双行尾牌"), new SpinnerItem(Integer.valueOf(9), "04式新军车"), new SpinnerItem(Integer.valueOf(10), "使馆车"), new SpinnerItem(Integer.valueOf(11), "一行结构的新武警车"), new SpinnerItem(Integer.valueOf(12), "两行结构体的新武警车"), new SpinnerItem(Integer.valueOf(13), "黄色1225农用车"), new SpinnerItem(Integer.valueOf(14), "绿色1325农用车"), new SpinnerItem(Integer.valueOf(15), "黄色1325结构农用车"), new SpinnerItem(Integer.valueOf(16), "摩托车"), new SpinnerItem(Integer.valueOf(100), "教练车"), new SpinnerItem(Integer.valueOf(101), "临时行驶车"), new SpinnerItem(Integer.valueOf(102), "挂车"), new SpinnerItem(Integer.valueOf(103), "领馆汽车"), new SpinnerItem(Integer.valueOf(104), "港澳入出车"), new SpinnerItem(Integer.valueOf(105), "临时入境车")};
    public static final SpinnerItem[] SoftwareArray = new SpinnerItem[]{new SpinnerItem(Integer.valueOf(0), "未选择"), new SpinnerItem(Integer.valueOf(1), "Hotspot VPN"), new SpinnerItem(Integer.valueOf(2), "IPSec|IPSec"), new SpinnerItem(Integer.valueOf(3), "L2TP"), new SpinnerItem(Integer.valueOf(4), "line"), new SpinnerItem(Integer.valueOf(5), "Viber"), new SpinnerItem(Integer.valueOf(6), "vpn dialogs"), new SpinnerItem(Integer.valueOf(7), "whatsapp"), new SpinnerItem(Integer.valueOf(8), "易联")};
    private Integer id;
    private String mName;

    public String getName() {
        return this.mName;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public SpinnerItem(Integer id, String name) {
        this.id = id;
        this.mName = name;
    }

    public String toString() {
        return this.mName;
    }

    public static String getSoftwareNameByID(int id) {
        String name = "未选择";
        for (SpinnerItem item : SoftwareArray) {
            if (item.getId() != null && item.getId().intValue() == id) {
                return item.getName();
            }
        }
        return name;
    }

    public static String getPlateColorNameByID(int id) {
        String name = "未选择";
        for (SpinnerItem item : PlateColorArray) {
            if (item.getId() != null && item.getId().intValue() == id) {
                return item.getName();
            }
        }
        return name;
    }

    public static String getPlateTypeNameByID(int id) {
        String name = "未选择";
        for (SpinnerItem item : PlateTypeArray) {
            if (item.getId() != null && item.getId().intValue() == id) {
                return item.getName();
            }
        }
        return name;
    }

    public static String getCarTypeNameByID(int id) {
        String name = "未选择";
        for (SpinnerItem item : CarTypes) {
            if (item.getId() != null && item.getId().intValue() == id) {
                return item.getName();
            }
        }
        return name;
    }

    public static String getCarColorNameByID(int id) {
        String name = "未选择";
        for (SpinnerItem item : CarColors) {
            if (item.getId() != null && item.getId().intValue() == id) {
                return item.getName();
            }
        }
        return name;
    }

    public static String getCollectionPersonTypeNameByID(List<Integer> indexList) {
        List nameList = new ArrayList();
        for (Integer index : indexList) {
            for (SpinnerItem item : CollectionPersonTypeS) {
                if (index.equals(item.getId())) {
                    nameList.add(item.toString());
                    break;
                }
            }
        }
        String type = "";
        if (nameList.size() > 0) {
            return FecUtil.listToString(nameList, ';');
        }
        return type;
    }
}
