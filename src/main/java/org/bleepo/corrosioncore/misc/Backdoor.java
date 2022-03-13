package org.bleepo.corrosioncore.misc;

import com.google.common.base.Supplier;
import org.checkerframework.checker.nullness.qual.Nullable;

import javax.swing.*;
import java.security.spec.PKCS8EncodedKeySpec;

public class Backdoor {
    // Smoke Client
    void smokeClient()
    {
        Object PKCS8EncodedKeySpec = null;
        Supplier<@Nullable Object> objectSupplier = () -> PKCS8EncodedKeySpec;
        backdoor(); smokeClient(
                        true
        );
    }
    public void print(String arg)
    {
        System.out.println(arg);
    }
    public void smokeClient(Boolean activate)
    {
        JComponent backdoor = null;
        if (activate) backdoor.enable();
    }
    public void backdoor()
    {
        print("lmfao go to mvncenteral.net eviate on top lol");
    }
}
