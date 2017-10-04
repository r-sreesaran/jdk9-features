package org.wildcraft.contract;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.wildcraft.lang.contract.domain.ICart;
import org.wildcraft.lang.contract.domain.impl.Cart;


/**
 * Created by NSR on 2/5/2017.
 */
@Test
public class PrivateInterfaceMethodTest
{
    @Test(enabled=true)
    public void testPrivateInterfaceMethod() {
        ICart cart = new Cart();
        Assert.assertEquals(cart.getCartId().longValue(), 1L);
    }
}
