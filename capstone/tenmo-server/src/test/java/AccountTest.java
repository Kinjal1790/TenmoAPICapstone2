import com.techelevator.tenmo.dao.JdbcAccountDao;
import com.techelevator.tenmo.dao.UserDao;
import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.Transfer;
import com.techelevator.tenmo.model.User;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

public class AccountTest {


    private JdbcAccountDao DAO;


    @Test
    public void test_account_Id() {
        Account account = new Account(2005, 1005, new BigDecimal(500));
        Assert.assertEquals("Account Id does not match", account.getAccountId(), 1005);

    }


    @Test
    public void test_user_Id() {

        Account account = new Account(2005, 1005, new BigDecimal(500));

        Assert.assertEquals("User Id does not match", account.getUserId(), 2005);

    }


    @Test
    public void test_balance() {
        Account account = new Account(2005, 1005, new BigDecimal(500));

        Assert.assertEquals("account balance does not match", account.getBalance(), new BigDecimal("500"));

    }

    @Test
    public void test_userName() {

        User user = new User();
        user.setUsername("Mary");
        Assert.assertEquals("userName not match", user.getUsername(), "Mary");


    }

    @Test
    public void test_password() {

        User user = new User();
        user.setPassword("MaryPassword");
        Assert.assertEquals("userName not match", user.getPassword(), "MaryPassword");


    }

    @Test
    public void test_activated_equals_true() {

        User user = new User();
        user.setActivated(true);
        Assert.assertTrue("activated should be true", true);

    }


    @Test
    public void test_activated_equals_false() {

        User user = new User();
        user.setActivated(false);
        Assert.assertFalse("activated should be false", false);

    }

    @Test
    public void test_transfer_fromUserId() {
        Transfer transfer = new Transfer();
        transfer.setFromUserId(2004);
        Assert.assertEquals("FromUserId does not match", transfer.getFromUserId(), 2004);

    }


    @Test
    public void test_transfer_toUserId() {
        Transfer transfer = new Transfer();
        transfer.setToUserId(3007);
        Assert.assertEquals("ToUserID does not match", transfer.getToUserId(), 3007);

    }




    @Test
    public void test_transfer_transfer_id() {
        Transfer transfer = new Transfer();
        transfer.setTransfer_id(545);
        Assert.assertEquals("Transfer id does not match", transfer.getTransfer_id(), 545);

    }



    @Test
    public void test_transfer_transfer_status_desc_approved() {
        Transfer transfer = new Transfer();
        transfer.setTransfer_status_desc("approved");
        Assert.assertEquals("Transfer status does not equal approved", transfer.getTransfer_status_desc(),"approved");

    }

    @Test
    public void test_transfer_transfer_status_desc_pending() {
        Transfer transfer = new Transfer();
        transfer.setTransfer_status_desc("pending");
        Assert.assertEquals("Transfer status does not equal pending", transfer.getTransfer_status_desc(),"pending");

    }



    @Test
    public void test_transfer_usernameFrom() {
        Transfer transfer = new Transfer();
        transfer.setUsernameFrom("Bryan");
        Assert.assertEquals("User Name from does not match", transfer.getUsernameFrom(), "Bryan");

    }

    @Test
    public void test_transfer_usernameTo() {
        Transfer transfer = new Transfer();
        transfer.setUsernameTo("Angel");
        Assert.assertEquals("User Name to does not match", transfer.getUsernameTo(), "Angel");

    }


}
