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
@TableName("sys_SQLCommand")
public class SysSQLCommand extends Model<SysSQLCommand> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
	private String Gid;
    /**
     * 命令主健
     */
	private String SqlComandText;
    /**
     * 命令健值
     */
	private String SqlKey;
    /**
     * 备注说明
     */
	private String Remark;
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

	public String getSqlComandText() {
		return SqlComandText;
	}

	public void setSqlComandText(String SqlComandText) {
		this.SqlComandText = SqlComandText;
	}

	public String getSqlKey() {
		return SqlKey;
	}

	public void setSqlKey(String SqlKey) {
		this.SqlKey = SqlKey;
	}

	public String getRemark() {
		return Remark;
	}

	public void setRemark(String Remark) {
		this.Remark = Remark;
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
		return "SysSQLCommand{" +
			"Gid=" + Gid +
			", SqlComandText=" + SqlComandText +
			", SqlKey=" + SqlKey +
			", Remark=" + Remark +
			", Createdby=" + Createdby +
			", CreatedTime=" + CreatedTime +
			", Modifiedby=" + Modifiedby +
			", ModifiedTime=" + ModifiedTime +
			"}";
	}
}
