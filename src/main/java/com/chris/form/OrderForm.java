package com.chris.form;

import javax.validation.constraints.NotEmpty;

/**
 * Created by 廖师兄
 * 2017-06-18 23:31
 */

public class OrderForm {

    /**
     * 买家姓名
     */
	@NotEmpty
    private String name;

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getItems() {
		return items;
	}

	public void setItems(String items) {
		this.items = items;
	}

	/**
     * 买家手机号
     */
	@NotEmpty
    private String phone;

    /**
     * 买家地址
     */
	@NotEmpty
    private String address;

    /**
     * 买家微信openid
     */
	@NotEmpty
    private String openid;

    /**
     * 购物车
     */
	@NotEmpty
    private String items;
}
