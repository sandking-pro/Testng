package org.starter;

import java.io.IOException;

import org.base.BaseClass;
import org.pojo.BookHotel;
import org.pojo.LoginPage;
import org.pojo.SearchHotel;
import org.pojo.SelectHotel;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Adactin extends BaseClass {

	public String ordid;
	
	@Parameters({ "url" })
	@BeforeClass
	private void browserLaunch0(String s) {
		getDriver();
		launchUrl(s);
	}

	@Parameters({ "username", "password" })
	@Test
	public void tc1Login1(String usrnm, String pass) {
		LoginPage lp = new LoginPage();
		enterText(lp.getTxtUsername(), usrnm);
		enterText(lp.getTxtpassword(), pass);
		btnClick(lp.getBtnLogin());

	}

	@Parameters({ "location", "hotel", "roomtype", "noofroom", "checkin", "checkout", "apo", "cpo" })
	@Test
	public void tc2SearchHotel2(String loc, String htl, String rt, String nor, String chkin, String chkout, String apr,
			String cpr) {
		SearchHotel sh = new SearchHotel();
		selectDropdown(sh.getLocation(), loc, "vt");
		selectDropdown(sh.getHotels(), htl, "vt");
		selectDropdown(sh.getRt(), rt, "vt");
		selectDropdown(sh.getNor(), nor, "val");
		enterText(sh.getCheckin(), chkin);
		enterText(sh.getCheckout(), chkout);
		selectDropdown(sh.getApr(), apr, "val");
		selectDropdown(sh.getCpr(), cpr, "val");
		btnClick(sh.getSubmitSearch());
	}

	@Test
	public void tc3SelectHotel3() {
		SelectHotel selh = new SelectHotel();
		btnClick(selh.getSelectHotel());
		btnClick(selh.getContinueBtn());
	}

	@Parameters({ "fname", "lname", "address", "cc", "cct", "ccm", "ccy", "cvv" })
	@Test
	public void tc4BookHotel4(String fname,String lname,String address,String cc, String cct, String ccm, String ccy, String cvv) throws InterruptedException, IOException {
		BookHotel bh = new BookHotel();
		enterText(bh.getFname(), fname);
		enterText(bh.getLname(), lname);
		enterText(bh.getAddress(), address);
		enterText(bh.getCcnum(), cc);
		enterText(bh.getCc_cvv(), cvv);
		selectDropdown(bh.getCctype(), cct,"val");
		selectDropdown(bh.getCc_exp_month(), ccm,"val");
		selectDropdown(bh.getCc_exp_year(), ccy,"val");
		btnClick(bh.getBook_now());
		
		Thread.sleep(7000);
		ordid = getAttributeText(bh.getOrderno());
		System.out.println(ordid);
		screenShot("final");
		putExcelData("C:\\Users\\veera-pc\\Desktop\\book.xlsx", "Sheet1", 0, 0,ordid);

	}

}
