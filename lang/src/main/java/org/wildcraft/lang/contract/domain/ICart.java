package org.wildcraft.lang.contract.domain;

/**
 * Created by NSR on 1/25/2017.
 */
public interface ICart {

    private Long createCartId() {
        return 1L;
    }

    default Long getCartId() {
        return createCartId();
    }
}
