package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.qameta.allure.Attachment;
import pages.StcTvPlanPage;

public class StcTvPlanTests extends TestBase{
	
	@Attachment
	@Test(enabled = true ,description="checking each plan price for country" , dataProvider = "Countries")
    public void checkStcTvPlanPrice(String index)
    {
		StcTvPlanPage stctvplanpage = new StcTvPlanPage();
		stctvplanpage.OpenCountryList();
		stctvplanpage.ChooseCountryFlow(index);
        Assert.assertEquals(stctvplanpage.getActualPrices(index),stctvplanpage.getExpectedPrices(index));
    }
	
	@Attachment
	@Test(enabled = true ,description="checking each plan in country" , dataProvider = "Countries")
    public void checkStcTvPlanType(String index)
    {
		StcTvPlanPage stctvplanpage = new StcTvPlanPage();
		stctvplanpage.OpenCountryList();
		stctvplanpage.ChooseCountryFlow(index);
        Assert.assertEquals(stctvplanpage.getActualPlans(index),stctvplanpage.getExpectedPlans(index));
    }
	
	@Attachment
	@Test(enabled = true ,description="checking each plan in country" , dataProvider = "Countries")
    public void checkStcTvPlanCurrency(String index)
    {
		StcTvPlanPage stctvplanpage = new StcTvPlanPage();
		stctvplanpage.OpenCountryList();
		stctvplanpage.ChooseCountryFlow(index);
        Assert.assertEquals(stctvplanpage.getActualCurrency(index),stctvplanpage.getExpectedCurrency(index));
    }
	
	@DataProvider(name="Countries")
    public static Object[][] Countries()
    {
        return new Object[][] {
                {"KSA"},{"Bahrain"},{"Kuwait"}
        };
    }
}
