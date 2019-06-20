package com.sample.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class TCIDGroups implements Serializable {

	ArrayList<String> group1 = new ArrayList<String>();

	public ArrayList<String> getTCIDList() {
		return group1;
	}

	public void setTCIDList(ArrayList<String> tCIDList) {
		group1 = tCIDList;
	}

}
