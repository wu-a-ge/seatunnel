package org.apache.seatunnel;

import org.junit.jupiter.api.Test;

import com.google.common.collect.Lists;

class FilterHtmlTagTest {

    @Test
    void evaluate() {
        FilterHtmlTag filterHtmlTag = new FilterHtmlTag();
        Object result =
                filterHtmlTag.evaluate(
                        Lists.newArrayList(
                                "\\n\\n\\n \\n  \\n   \\n乌鲁木齐市达坂城区西沟乡关于订书机的网上超市采购项目&nbsp;（项目编号:1878427000019949100&nbsp;）采购已经结束，现将采购结果公示如下：\\n\\n \\n  \\n   \\n\\n \\n  \\n   \\n\\n 一、项目信息\\n 项目名称:乌鲁木齐市达坂城区西沟乡关于订书机的网上超市采购项目采购项目\\n 项目编号:1878427000019949100&nbsp;\\n 项目联系人:赵婕&nbsp;\\n 项目联系电话:0991-5942489&nbsp;\\n 采购计划文号:&nbsp;\\n 采购计划金额（元）:&nbsp;\\n 项目所在行政区划编码:650107&nbsp;\\n 项目所在行政区划名称:新疆维吾尔自治区乌鲁木齐市达坂城区&nbsp;\\n 报价起止时间:&nbsp;-&nbsp;&nbsp;\\n 二、采购单位信息\\n 采购单位名称:乌鲁木齐市达坂城区西沟乡&nbsp;\\n 采购单位地址:乌鲁木齐市达坂城区西沟乡集镇&nbsp;\\n 采购单位联系人和联系方式::&nbsp;\\n 采购单位社会统一信用代码或组织机构代码:010211688&nbsp;\\n 采购单位预算编码:803001&nbsp;\\n 三、成交信息\\n 成交日期:2022年12月8日&nbsp;\\n 总成交金额（元）:25131&nbsp;（人民币）\\n 成交供应商名称、联系地址及成交金额:\\n &nbsp;\\n   \\n\\n 序号\\n 成交供应商名称\\n 成交供应商地址\\n 成交金额（元）\\n\\n\\n 1\\n 达坂城区达坂城镇金诺彩绘工作室\\n 新疆维吾尔自治区乌鲁木齐市达坂城街149号+2号\\n 25131.0\\n\\n   &nbsp;\\n 四、项目用途、简要技术要求及合同履行日期:\\n &nbsp;&nbsp;\\n 五、成交标的名称、规格型号、数量、单价、成交金额:\\n &nbsp;\\n   \\n\\n 序号\\n 标的名称\\n 品牌\\n 规格型号\\n 数量\\n 单价(元)\\n 成交金额（元）\\n 报价明细\\n\\n\\n 1\\n 得力 0828 得力/deli 0828 旋转式 订书机\\n 得力/deli\\n 0828\\n 10\\n 20.0\\n 200.0\\n \\n\\n\\n 2\\n 18C 亿兴华 拉杆夹 2.5小杆-18C\\n 亿兴华\\n 18C\\n 20\\n 35.0\\n 700.0\\n \\n\\n\\n 3\\n 樱花 橡皮\\n 樱花\\n XRFW-60\\n 29\\n 3.0\\n 87.0\\n \\n\\n\\n 4\\n 齐心 B3635 齐心/Comix B3635 长尾票夹\\n 齐心/Comix\\n B3635\\n 42\\n 12.0\\n 504.0\\n \\n\\n\\n 5\\n 得力 DLH-CF350A 激光碳粉盒黑(单位：支)（适用Color LaserJet Pro MFP M176n, M177fw）DDL\\n 得力/deli\\n DLH-CF350A\\n 15\\n 120.0\\n 1800.0\\n \\n\\n\\n 6\\n 得力 3724 光盘\\n 得力/deli\\n 3724\\n 8\\n 150.0\\n 1200.0\\n \\n\\n\\n 7\\n 先锋 DVR-XU01 刻录机\\n 先锋/pioneer\\n DVR-XU01\\n 8\\n 320.0\\n 2560.0\\n \\n\\n\\n 8\\n 得力 5623 得力/deli 5623 50mm档案盒(蓝)\\n 得力/deli\\n 5623\\n 90\\n 180.0\\n 16200.0\\n \\n\\n\\n 9\\n 东芝 2309C 东芝（TOSHIBA）原装碳粉 墨粉盒T-2309C墨盒 适用于2303A/2523/2323/T2507系列 T-2309C（大）黑\\n 东芝/TOSHIBA\\n 2309C\\n 1\\n 120.0\\n 120.0\\n \\n\\n\\n 10\\n 得力 7442 得力7442多瑙河复印纸(A4-70g-8包)(包)\\n 得力/deli\\n 7442\\n 8\\n 220.0\\n 1760.0\\n \\n\\n\\n 11\\n 【运费】\\n \\n \\n 1\\n \\n 0.0\\n \\n\\n   &nbsp;\\n 六、其他补充事宜:\\n &nbsp;&nbsp;\\n\\n   \\n  \\n \\n\\n   \\n  \\n \\n\\n   \\n  \\n \\n"));
        System.out.println(result);
    }
}
