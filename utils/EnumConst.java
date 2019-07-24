package com.boot.security.server.utils;

import java.util.EnumSet;

/**我的枚举类，系统中用到的枚举都定义在这里
 * Created by Administrator on 2018/10/6.
 */
public  class EnumConst {
    /**
     * 所有的枚举都要实现该接口，定义了一些常用的方法
     */
    public interface EnumBase {
        int getValue();//获取枚举值
        String getAlias();//获取枚举别名
    }
    /**
     * 包装方式
     */
    public enum PackingType implements EnumBase {
        woodBox(1,"木箱"),paperBox(2,"纸箱"),tray(3,"托盘"),bagged(4,"袋装"),drum(5,"桶装"),materialRack(6,"料架"),nakedAssembly(7,"裸装")
        ,wrappingFilm(8,"缠绕膜"),tonneBucket(9,"吨桶"),tonBag(10,"吨袋"),ironBox(11,"铁箱"),strapping(12,"捆扎"),bulk(13,"散装"),othe(14,"其它");
        private int _value;//枚举值
        private String _alias;//枚举别名
        PackingType(int value, String alias) {_value = value;_alias = alias;}
        public int getValue() {return _value;}
        public String getAlias() {return _alias;}
    }

    /**
     * 运输方式，枚举类型
     */
    public enum TransportType implements EnumBase {//公路零担=1/公路整车=2/危险品车运输=3/铁路运输=4/空运=5/水运=6/多式联运=7/其它=8
        highwayZeroLoad(1,"公路零担"),highwayVehicle(2,"公路整车"),dangerousGoodsVehicleTransportation(3,"危险品车运输")
        ,railwayTransportation(4,"铁路运输"),airTransport(5,"空运"),waterTransport(6,"水运"),multimodalTransport(7,"多式联运"),other(8,"其它");
        private int _value;//枚举值
        private String _alias;//枚举别名
        TransportType(int value, String alias) {_value = value;_alias = alias;}
        public int getValue() {return _value;}
        public String getAlias() {return _alias;}
    }

    /**
     * 运单状态
     */
    public enum WaybillStatus implements EnumBase {//待发车=10/在途中=15/待送货=20/正在配送中=25/二次配送=30/正常签收=35/异常签收=40/拒收再议=45/退货中=50/已退货=55/运单作废=60
        waitforStart(10,"待发车"),onTheWay(15,"在途中"),waitforDelivery(20,"待送货")
        ,inDistribution(25,"正在配送中"),twoDistribution(30,"二次配送"),normalSigning(35,"正常签收"),abnormalSigning(40,"异常签收"),reconsiderationAndReconsideration(45,"拒收再议")
        ,inReturn(50,"退货中"),returnedGoods(55,"已退货"),waybillToVoid(60,"运单作废");
        private int _value;//枚举值
        private String _alias;//枚举别名
        WaybillStatus(int value, String alias) {_value = value;_alias = alias;}
        public int getValue() {return _value;}
        public String getAlias() {return _alias;}
    }

    /**
     * 门店出库单状态
     */
    public enum SbStoreOut implements EnumBase {//待出库=10/部分出库=15/出库完成=20/
        waitforStart(10,"待出库"),onTheWay(15,"部分出库"),waitforDelivery(20,"出库完成");
        /*,inDistribution(25,"正在配送中"),twoDistribution(30,"二次配送")*/
        private int _value;//枚举值
        private String _alias;//枚举别名
        SbStoreOut(int value, String alias) {_value = value;_alias = alias;}
        public int getValue() {return _value;}
        public String getAlias() {return _alias;}
    }

    /**
     * 门店入库单状态
     */
    public enum SbStoreIn implements EnumBase {//待入库=10/部分入库=15/入库完成=20/
        waitforStart(10,"待入库"),onTheWay(15,"部分入库"),waitforDelivery(20,"入库完成");
        /*inReturn(50,"退货中"),returnedGoods(55,"已退货"),waybillToVoid(60,"运单作废")*/
        private int _value;//枚举值
        private String _alias;//枚举别名
        SbStoreIn(int value, String alias) {_value = value;_alias = alias;}
        public int getValue() {return _value;}
        public String getAlias() {return _alias;}
    }
    /**
     * 总仓出库单状态
     */
    public enum GwOut implements EnumBase {//待出库=10/部分出库=15/出库完成=20/
        waitforStart(10,"待出库"),onTheWay(15,"部分出库"),waitforDelivery(20,"出库完成");
        /*,inDistribution(25,"正在配送中"),twoDistribution(30,"二次配送")*/
        private int _value;//枚举值
        private String _alias;//枚举别名
        GwOut(int value, String alias) {_value = value;_alias = alias;}
        public int getValue() {return _value;}
        public String getAlias() {return _alias;}
    }

    /**
     * 总仓入库单状态
     */
    public enum GwIn implements EnumBase {//待出库=10/部分出库=15/出库完成=20/
        waitforStart(10,"待入库"),onTheWay(15,"部分入库"),waitforDelivery(20,"入库完成");
        /*,inDistribution(25,"正在配送中"),twoDistribution(30,"二次配送")*/
        private int _value;//枚举值
        private String _alias;//枚举别名
        GwIn(int value, String alias) {_value = value;_alias = alias;}
        public int getValue() {return _value;}
        public String getAlias() {return _alias;}
    }

    /**
     * 总仓采购单状态
     */
    public enum GwPurchaseOrder implements EnumBase {//待审批=10/已审批=15/部分出库=20/全部出库=25/
        waitforStart(10,"待审批"),onTheWay(15,"已审批"),waitforDelivery(20,"部分出库")
        ,inDistribution(25,"全部出库")/*,twoDistribution(30,"二次配送")*/;
        private int _value;//枚举值
        private String _alias;//枚举别名
        GwPurchaseOrder(int value, String alias) {_value = value;_alias = alias;}
        public int getValue() {return _value;}
        public String getAlias() {return _alias;}
    }

    /**
     * 供应商出库单状态
     */
    public enum SupplierOut implements EnumBase {//待出库=10/部分出库=15/全部出库=20/---=25/
        waitforStart(10,"待出库"),onTheWay(15,"部分出库"),waitforDelivery(20,"全部出库")
        /*,inDistribution(25,"全部出库")*//*,twoDistribution(30,"二次配送")*/;
        private int _value;//枚举值
        private String _alias;//枚举别名
        SupplierOut(int value, String alias) {_value = value;_alias = alias;}
        public int getValue() {return _value;}
        public String getAlias() {return _alias;}
    }

    /**
     * 门店采购单状态
     */
    public enum SbPurchaseOrder implements EnumBase {//待审批=10/已审批=15/部分出库=20/全部出库=25/
        waitforStart(10,"待审批"),onTheWay(15,"已审批"),waitforDelivery(20,"部分出库")
        ,inDistribution(25,"全部出库")/*,twoDistribution(30,"二次配送")*/;
        private int _value;//枚举值
        private String _alias;//枚举别名
        SbPurchaseOrder(int value, String alias) {_value = value;_alias = alias;}
        public int getValue() {return _value;}
        public String getAlias() {return _alias;}
    }


}
