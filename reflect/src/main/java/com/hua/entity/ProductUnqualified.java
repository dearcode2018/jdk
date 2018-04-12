package com.hua.entity;

import java.util.Date;

import com.hua.annotation.FieldCheck;

/**
 * 
 * ProductUnqualified
 * 描述: 不合格商品 - 实体
 * @author  tanjin
 */
public  class ProductUnqualified {

	private static final long serialVersionUID = 1L;

	/* 数据来源 */
	private String dataSrc;

	/* 状态 (有效：ON 无效：OFF) */
    private String status;

    @FieldCheck(nullable = false)
    /* 办案部门id */
    private String icOrgId;

    @FieldCheck(nullable = false)
    /* 上报单位 */
    private String reportUnit;

    @FieldCheck(nullable = false)
    /* 上报日期时间 */
    private Date reportDt;

    @FieldCheck(nullable = false)
    /* 检验报告号 */
    private String reportNo;

    /* 商品id */
    private String productId;

    @FieldCheck(nullable = false)
    /* 商品类别id */
    private String typeId;

    @FieldCheck(nullable = false)
    /* 查处对象/市场主体名称 */
    private String mctName;

    @FieldCheck(nullable = false)
    /* 营业执照号 */
    private String registerNo;

    /* 市场主体类型 */
    private String mctType;

    @FieldCheck(nullable = false)
    /* 所在地区 (编码) */
    private String regionId;

    @FieldCheck(nullable = false)
    /* 地址 */
    private String address;

    @FieldCheck(nullable = false)
    /* 联系人 */
    private String linkman;

    @FieldCheck(nullable = false)
    /* 手机号码 */
    private String tel;

    /* 固话(传真) */
    private String fax;

    /* 电子邮箱 */
    private String email;

    @FieldCheck(nullable = false)
    /* 上传行政处罚决定书 */
    private String punishNotice;

    /* 没收违法商品数量（件） */
    private String confiscateAmount;

    /* 没收商品价值(万元) */
    private String confiscateWorth;

    /* 罚款金额（万元) */
    private String amerce;

    /* 责令退市违法商品数（件） */
    private String offMarketAmount;

    /* 责令退市违法商品价值（万元） */
    private String offMarketWorth;

    /* 是否吊销营业执照 */
    private String ifRevokeRegister;

    /* 是否移送司法机关 */
    private String ifDeportToJustice;

    /* 是否停止生产 */
    private String ifStopProduce;

    /* 是否发布警示 */
    private String ifWarn;

    /* 召回商品数量 */
    private String recallAmount;

    /* 召回商品货值 */
    private String recallWorth;

    /* 无害化处理商品数量 */
    private String innocuityAmount;

    /* 无害化处理商品货值 */
    private String innocuityWorth;
    
    /* 销毁商品数量 */
    private String destroyAmount;
    
    /* 销毁商品货值 */
    private String destroyWorth;
    
    /* 下架商品数量 */
    private String offSellAmount;
    
    /* 下架商品货值 */
    private String offSellWorth;
    
    /* 退回厂家商品数量 */
    private String untreadAmount;
    
    /* 退回厂家商品货值 */
    private String untreadWorth;

    /* 备注 */
    private String remark;
    
    /**
	 * 构造方法
	 * 描述: 
	 * @author  qye.zheng
	 */
	public ProductUnqualified()
	{
	}

    public String getDataSrc() {
        return dataSrc;
    }

    public void setDataSrc(String dataSrc) {
        this.dataSrc = dataSrc == null ? null : dataSrc.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getIcOrgId() {
        return icOrgId;
    }

    public void setIcOrgId(String icOrgId) {
        this.icOrgId = icOrgId == null ? null : icOrgId.trim();
    }

    public String getReportUnit() {
        return reportUnit;
    }

    public void setReportUnit(String reportUnit) {
        this.reportUnit = reportUnit == null ? null : reportUnit.trim();
    }

    public Date getReportDt() {
        return reportDt;
    }

    public void setReportDt(Date reportDt) {
        this.reportDt = reportDt;
    }

    public String getReportNo() {
        return reportNo;
    }

    public void setReportNo(String reportNo) {
        this.reportNo = reportNo == null ? null : reportNo.trim();
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId == null ? null : productId.trim();
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId == null ? null : typeId.trim();
    }

    public String getMctName() {
        return mctName;
    }

    public void setMctName(String mctName) {
        this.mctName = mctName == null ? null : mctName.trim();
    }

    public String getRegisterNo() {
        return registerNo;
    }

    public void setRegisterNo(String registerNo) {
        this.registerNo = registerNo == null ? null : registerNo.trim();
    }

    public String getMctType() {
        return mctType;
    }

    public void setMctType(String mctType) {
        this.mctType = mctType == null ? null : mctType.trim();
    }

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId == null ? null : regionId.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman == null ? null : linkman.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax == null ? null : fax.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPunishNotice() {
        return punishNotice;
    }

    public void setPunishNotice(String punishNotice) {
        this.punishNotice = punishNotice == null ? null : punishNotice.trim();
    }

    public String getConfiscateAmount() {
        return confiscateAmount;
    }

    public void setConfiscateAmount(String confiscateAmount) {
        this.confiscateAmount = confiscateAmount == null ? null : confiscateAmount.trim();
    }

    public String getConfiscateWorth() {
        return confiscateWorth;
    }

    public void setConfiscateWorth(String confiscateWorth) {
        this.confiscateWorth = confiscateWorth == null ? null : confiscateWorth.trim();
    }

    public String getAmerce() {
        return amerce;
    }

    public void setAmerce(String amerce) {
        this.amerce = amerce == null ? null : amerce.trim();
    }

    public String getOffMarketAmount() {
        return offMarketAmount;
    }

    public void setOffMarketAmount(String offMarketAmount) {
        this.offMarketAmount = offMarketAmount == null ? null : offMarketAmount.trim();
    }

    public String getOffMarketWorth() {
        return offMarketWorth;
    }

    public void setOffMarketWorth(String offMarketWorth) {
        this.offMarketWorth = offMarketWorth == null ? null : offMarketWorth.trim();
    }

    public String getIfRevokeRegister() {
        return ifRevokeRegister;
    }

    public void setIfRevokeRegister(String ifRevokeRegister) {
        this.ifRevokeRegister = ifRevokeRegister == null ? null : ifRevokeRegister.trim();
    }

    public String getIfDeportToJustice() {
        return ifDeportToJustice;
    }

    public void setIfDeportToJustice(String ifDeportToJustice) {
        this.ifDeportToJustice = ifDeportToJustice == null ? null : ifDeportToJustice.trim();
    }

    public String getIfStopProduce() {
        return ifStopProduce;
    }

    public void setIfStopProduce(String ifStopProduce) {
        this.ifStopProduce = ifStopProduce == null ? null : ifStopProduce.trim();
    }

    public String getIfWarn() {
        return ifWarn;
    }

    public void setIfWarn(String ifWarn) {
        this.ifWarn = ifWarn == null ? null : ifWarn.trim();
    }

    public String getRecallAmount() {
        return recallAmount;
    }

    public void setRecallAmount(String recallAmount) {
        this.recallAmount = recallAmount == null ? null : recallAmount.trim();
    }

    public String getRecallWorth() {
        return recallWorth;
    }

    public void setRecallWorth(String recallWorth) {
        this.recallWorth = recallWorth == null ? null : recallWorth.trim();
    }

    public String getInnocuityAmount() {
        return innocuityAmount;
    }

    public void setInnocuityAmount(String innocuityAmount) {
        this.innocuityAmount = innocuityAmount == null ? null : innocuityAmount.trim();
    }

    public String getInnocuityWorth() {
        return innocuityWorth;
    }

    public void setInnocuityWorth(String innocuityWorth) {
        this.innocuityWorth = innocuityWorth == null ? null : innocuityWorth.trim();
    }

    public String getDestroyAmount() {
        return destroyAmount;
    }

    public void setDestroyAmount(String destroyAmount) {
        this.destroyAmount = destroyAmount == null ? null : destroyAmount.trim();
    }

    public String getDestroyWorth() {
        return destroyWorth;
    }

    public void setDestroyWorth(String destroyWorth) {
        this.destroyWorth = destroyWorth == null ? null : destroyWorth.trim();
    }

    public String getOffSellAmount() {
        return offSellAmount;
    }

    public void setOffSellAmount(String offSellAmount) {
        this.offSellAmount = offSellAmount == null ? null : offSellAmount.trim();
    }

    public String getOffSellWorth() {
        return offSellWorth;
    }

    public void setOffSellWorth(String offSellWorth) {
        this.offSellWorth = offSellWorth == null ? null : offSellWorth.trim();
    }

    public String getUntreadAmount() {
        return untreadAmount;
    }

    public void setUntreadAmount(String untreadAmount) {
        this.untreadAmount = untreadAmount == null ? null : untreadAmount.trim();
    }

    public String getUntreadWorth() {
        return untreadWorth;
    }

    public void setUntreadWorth(String untreadWorth) {
        this.untreadWorth = untreadWorth == null ? null : untreadWorth.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}