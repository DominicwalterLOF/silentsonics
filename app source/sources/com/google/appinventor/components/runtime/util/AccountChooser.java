package com.google.appinventor.components.runtime.util;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import java.io.IOException;
import java.util.concurrent.SynchronousQueue;

public class AccountChooser {
    private Activity activity;
    private String dWv1HgRlVDHMM4U4qerIJIQWfNWwQ9IKsqdbo4GTv31QUUa72uwaY9lJJ42yxpKq;
    private String fYawfM9zby4GKauiBqb4ci1jAzhTnTs5rPk6pEfhgdCGlaj30ALyaese8PExemNE;
    private String h8Png9oaVDfYGvgWdHcn1DMBnn2tbT5MRZoUvXvvhLrY5O6ybby2QmTOJ6PZJucW;
    private AccountManager hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;

    public AccountChooser(Activity activity2, String str, String str2, String str3) {
        Activity activity3 = activity2;
        this.activity = activity3;
        this.h8Png9oaVDfYGvgWdHcn1DMBnn2tbT5MRZoUvXvvhLrY5O6ybby2QmTOJ6PZJucW = str;
        this.dWv1HgRlVDHMM4U4qerIJIQWfNWwQ9IKsqdbo4GTv31QUUa72uwaY9lJJ42yxpKq = str2;
        this.fYawfM9zby4GKauiBqb4ci1jAzhTnTs5rPk6pEfhgdCGlaj30ALyaese8PExemNE = str3;
        this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = AccountManager.get(activity3);
    }

    public Account findAccount() {
        Account[] accountsByType = this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.getAccountsByType("com.google");
        Account[] accountArr = accountsByType;
        if (accountsByType.length == 1) {
            vSp02fkBXgM8EI0gm0rKWXHQ6wdQINJBQuAtCR15YU8g4XNqVKV8r32SYxkQYxkq(accountArr[0].name);
            return accountArr[0];
        } else if (accountArr.length == 0) {
            String hR11jdqaRrvBRiBFd4KN6gI7d8MNQVP5Yc7fufDZjGGTeTxaualejjrhiR1Iz2xO = hR11jdqaRrvBRiBFd4KN6gI7d8MNQVP5Yc7fufDZjGGTeTxaualejjrhiR1Iz2xO();
            String str = hR11jdqaRrvBRiBFd4KN6gI7d8MNQVP5Yc7fufDZjGGTeTxaualejjrhiR1Iz2xO;
            if (hR11jdqaRrvBRiBFd4KN6gI7d8MNQVP5Yc7fufDZjGGTeTxaualejjrhiR1Iz2xO != null) {
                vSp02fkBXgM8EI0gm0rKWXHQ6wdQINJBQuAtCR15YU8g4XNqVKV8r32SYxkQYxkq(str);
                return this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.getAccountsByType("com.google")[0];
            }
            int i = Log.i("AccountChooser", "User failed to create a valid account");
            return null;
        } else {
            String string = B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T().getString("account", (String) null);
            String str2 = string;
            if (string != null) {
                Account hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME2 = hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(str2, accountArr);
                Account account = hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME2;
                if (hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME2 != null) {
                    return account;
                }
            }
            String hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME3 = hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(accountArr);
            String str3 = hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME3;
            if (hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME3 != null) {
                vSp02fkBXgM8EI0gm0rKWXHQ6wdQINJBQuAtCR15YU8g4XNqVKV8r32SYxkQYxkq(str3);
                return hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(str3, accountArr);
            }
            int i2 = Log.i("AccountChooser", "User failed to choose an account");
            return null;
        }
    }

    private static Account hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(String str, Account[] accountArr) {
        String str2 = str;
        Account[] accountArr2 = accountArr;
        int length = accountArr2.length;
        for (int i = 0; i < length; i++) {
            Account account = accountArr2[i];
            Account account2 = account;
            if (account.name.equals(str2)) {
                int i2 = Log.i("AccountChooser", "chose account: ".concat(String.valueOf(str2)));
                return account2;
            }
        }
        return null;
    }

    private String hR11jdqaRrvBRiBFd4KN6gI7d8MNQVP5Yc7fufDZjGGTeTxaualejjrhiR1Iz2xO() {
        int i = Log.i("AccountChooser", "Adding auth token account ...");
        try {
            String string = this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.addAccount("com.google", this.h8Png9oaVDfYGvgWdHcn1DMBnn2tbT5MRZoUvXvvhLrY5O6ybby2QmTOJ6PZJucW, (String[]) null, (Bundle) null, this.activity, (AccountManagerCallback) null, (Handler) null).getResult().getString("authAccount");
            int i2 = Log.i("AccountChooser", "created: ".concat(String.valueOf(string)));
            return string;
        } catch (OperationCanceledException e) {
            int e2 = Log.e("AccountChooser", String.valueOf(e));
            return null;
        } catch (AuthenticatorException e3) {
            int e4 = Log.e("AccountChooser", String.valueOf(e3));
            return null;
        } catch (IOException e5) {
            int e6 = Log.e("AccountChooser", String.valueOf(e5));
            return null;
        }
    }

    private String hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(Account[] accountArr) {
        SynchronousQueue synchronousQueue;
        a aVar;
        new SynchronousQueue();
        SynchronousQueue synchronousQueue2 = synchronousQueue;
        new a(this, accountArr, synchronousQueue2);
        aVar.start();
        int i = Log.i("AccountChooser", "Select: waiting for user...");
        String str = null;
        try {
            str = (String) synchronousQueue2.take();
        } catch (InterruptedException e) {
            int e2 = Log.e("AccountChooser", String.valueOf(e));
        }
        int i2 = Log.i("AccountChooser", "Selected: ".concat(String.valueOf(str)));
        if ("".equals(str)) {
            return null;
        }
        return str;
    }

    private SharedPreferences B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T() {
        return this.activity.getSharedPreferences(this.fYawfM9zby4GKauiBqb4ci1jAzhTnTs5rPk6pEfhgdCGlaj30ALyaese8PExemNE, 0);
    }

    private void vSp02fkBXgM8EI0gm0rKWXHQ6wdQINJBQuAtCR15YU8g4XNqVKV8r32SYxkQYxkq(String str) {
        String str2 = str;
        int i = Log.i("AccountChooser", "persisting account: ".concat(String.valueOf(str2)));
        boolean commit = B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T().edit().putString("account", str2).commit();
    }

    public void forgetAccountName() {
        boolean commit = B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T().edit().remove("account").commit();
    }

    class a extends Thread implements DialogInterface.OnCancelListener, DialogInterface.OnClickListener {
        /* access modifiers changed from: private */
        public String[] F0SK4gPRNmAI2jCyU6DpJpRxlfo5Y8j9ZujjeLuDeDzReJBeSNN2RZtCnkXv1dho;
        final /* synthetic */ AccountChooser hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;

        /* renamed from: hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME  reason: collision with other field name */
        private SynchronousQueue<String> f268hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;

        a(AccountChooser accountChooser, Account[] accountArr, SynchronousQueue<String> synchronousQueue) {
            Account[] accountArr2 = accountArr;
            this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = accountChooser;
            this.f268hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = synchronousQueue;
            this.F0SK4gPRNmAI2jCyU6DpJpRxlfo5Y8j9ZujjeLuDeDzReJBeSNN2RZtCnkXv1dho = new String[accountArr2.length];
            for (int i = 0; i < accountArr2.length; i++) {
                this.F0SK4gPRNmAI2jCyU6DpJpRxlfo5Y8j9ZujjeLuDeDzReJBeSNN2RZtCnkXv1dho[i] = accountArr2[i].name;
            }
        }

        public final void run() {
            Runnable runnable;
            new Runnable(this) {
                private /* synthetic */ a hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;

                {
                    this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = r5;
                }

                public final void run() {
                    AlertDialog.Builder builder;
                    new AlertDialog.Builder(AccountChooser.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME));
                    AlertDialog show = builder.setTitle(TextViewUtil.fromHtml(AccountChooser.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME))).setOnCancelListener(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME).setSingleChoiceItems(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.F0SK4gPRNmAI2jCyU6DpJpRxlfo5Y8j9ZujjeLuDeDzReJBeSNN2RZtCnkXv1dho, -1, this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME).show();
                    int i = Log.i("AccountChooser", "Dialog showing!");
                }
            };
            AccountChooser.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME).runOnUiThread(runnable);
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            DialogInterface dialogInterface2 = dialogInterface;
            int i2 = i;
            if (i2 >= 0) {
                try {
                    String str = this.F0SK4gPRNmAI2jCyU6DpJpRxlfo5Y8j9ZujjeLuDeDzReJBeSNN2RZtCnkXv1dho[i2];
                    int i3 = Log.i("AccountChooser", "Chose: ".concat(String.valueOf(str)));
                    this.f268hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.put(str);
                } catch (InterruptedException e) {
                }
            } else {
                this.f268hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.put("");
            }
            dialogInterface2.dismiss();
        }

        public final void onCancel(DialogInterface dialogInterface) {
            int i = Log.i("AccountChooser", "Chose: canceled");
            onClick(dialogInterface, -1);
        }
    }
}
