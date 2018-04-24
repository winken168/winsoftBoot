package com.winsoft.api.biz.model;

import java.io.Serializable;

import java.util.Date;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author winken@peng
 * @since 2018-01-02
 */
@TableName("sys_GridConfig")
public class SysGridConfig extends Model<SysGridConfig> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
	private String Gid;
    /**
     * 所属表名
     */
	private String TableName;
    /**
     * 字段名称
     */
	private String ColCnName;
    /**
     * 字段中文名称
     */
	private String ColEnName;
    /**
     * 数据库字段类型
     */
	private String SqlType;
    /**
     * 是否自增
     */
	private String IsAutoIncrement;
    /**
     * 是否可以为空
     */
	private String IsCanNull;
    /**
     * 最大值
     */
	private Double MaxSize;
    /**
     * 小数点
     */
	private String Scale;
    /**
     * 是否主键
     */
	private Boolean IsPrimaryKey;
    /**
     * 默认值
     */
	private String DefaultValue;
    /**
     * 说明
     */
	private String Description;
    /**
     * 是否外键
     */
	private Boolean IsUniqueKey;
	private Boolean IsForeignKey;
    /**
     * 外健表名
     */
	private String FKTableName;
    /**
     * 创建人
     */
	private String Createdby;
    /**
     * 创建时间
     */
	private Date CreatedTime;
    /**
     * 修改人
     */
	private String Modifiedby;
    /**
     * 修改时间
     */
	private Date ModifiedTime;


	public String getGid() {
		return Gid;
	}

	public void setGid(String Gid) {
		this.Gid = Gid;
	}

	public String getTableName() {
		return TableName;
	}

	public void setTableName(String TableName) {
		this.TableName = TableName;
	}

	public String getColCnName() {
		return ColCnName;
	}

	public void setColCnName(String ColCnName) {
		this.ColCnName = ColCnName;
	}

	public String getColEnName() {
		return ColEnName;
	}

	public void setColEnName(String ColEnName) {
		this.ColEnName = ColEnName;
	}

	public String getSqlType() {
		return SqlType;
	}

	public void setSqlType(String SqlType) {
		this.SqlType = SqlType;
	}

	public String getIsAutoIncrement() {
		return IsAutoIncrement;
	}

	public void setIsAutoIncrement(String IsAutoIncrement) {
		this.IsAutoIncrement = IsAutoIncrement;
	}

	public String getIsCanNull() {
		return IsCanNull;
	}

	public void setIsCanNull(String IsCanNull) {
		this.IsCanNull = IsCanNull;
	}

	public Double getMaxSize() {
		return MaxSize;
	}

	public void setMaxSize(Double MaxSize) {
		this.MaxSize = MaxSize;
	}

	public String getScale() {
		return Scale;
	}

	public void setScale(String Scale) {
		this.Scale = Scale;
	}

	public Boolean getIsPrimaryKey() {
		return IsPrimaryKey;
	}

	public void setIsPrimaryKey(Boolean IsPrimaryKey) {
		this.IsPrimaryKey = IsPrimaryKey;
	}

	public String getDefaultValue() {
		return DefaultValue;
	}

	public void setDefaultValue(String DefaultValue) {
		this.DefaultValue = DefaultValue;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String Description) {
		this.Description = Description;
	}

	public Boolean getIsUniqueKey() {
		return IsUniqueKey;
	}

	public void setIsUniqueKey(Boolean IsUniqueKey) {
		this.IsUniqueKey = IsUniqueKey;
	}

	public Boolean getIsForeignKey() {
		return IsForeignKey;
	}

	public void setIsForeignKey(Boolean IsForeignKey) {
		this.IsForeignKey = IsForeignKey;
	}

	public String getFKTableName() {
		return FKTableName;
	}

	public void setFKTableName(String FKTableName) {
		this.FKTableName = FKTableName;
	}

	public String getCreatedby() {
		return Createdby;
	}

	public void setCreatedby(String Createdby) {
		this.Createdby = Createdby;
	}

	public Date getCreatedTime() {
		return CreatedTime;
	}

	public void setCreatedTime(Date CreatedTime) {
		this.CreatedTime = CreatedTime;
	}

	public String getModifiedby() {
		return Modifiedby;
	}

	public void setModifiedby(String Modifiedby) {
		this.Modifiedby = Modifiedby;
	}

	public Date getModifiedTime() {
		return ModifiedTime;
	}

	public void setModifiedTime(Date ModifiedTime) {
		this.ModifiedTime = ModifiedTime;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "SysGridConfig{" +
			"Gid=" + Gid +
			", TableName=" + TableName +
			", ColCnName=" + ColCnName +
			", ColEnName=" + ColEnName +
			", SqlType=" + SqlType +
			", IsAutoIncrement=" + IsAutoIncrement +
			", IsCanNull=" + IsCanNull +
			", MaxSize=" + MaxSize +
			", Scale=" + Scale +
			", IsPrimaryKey=" + IsPrimaryKey +
			", DefaultValue=" + DefaultValue +
			", Description=" + Description +
			", IsUniqueKey=" + IsUniqueKey +
			", IsForeignKey=" + IsForeignKey +
			", FKTableName=" + FKTableName +
			", Createdby=" + Createdby +
			", CreatedTime=" + CreatedTime +
			", Modifiedby=" + Modifiedby +
			", ModifiedTime=" + ModifiedTime +
			"}";
	}
}
