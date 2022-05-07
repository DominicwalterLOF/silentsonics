package com.google.appinventor.components.runtime;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import com.google.appinventor.components.runtime.util.AnimationUtil;
import com.google.appinventor.components.runtime.util.KodularHelper;

public class ListPickerActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private static int Qws8UL0KACxj4AFwEq11K2awfkG72XuPUTZHhPLrlGlIXoxeK9stYQCrIWmabWcL;
    static int TQYS6YBjqkoWFaGULpL2H003Eu6rkiOxhECYAYl6g8NMleEVKHe9nH3AkWIoC5xt;
    private static int backgroundColor;
    private static int titleBarColor;
    private String YY8QFJ7NsKl2krKlLP4gKRTKnpLlHQvVopkx7p60xy1hzICdxizXFIQJXbKtydSp = "";
    private EditText hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;

    /* renamed from: hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME  reason: collision with other field name */
    private ListView f177hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;

    /* renamed from: hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME  reason: collision with other field name */
    a f178hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;

    public ListPickerActivity() {
    }

    public void onCreate(Bundle bundle) {
        LinearLayout linearLayout;
        ListView listView;
        a aVar;
        EditText editText;
        TextWatcher textWatcher;
        super.onCreate(bundle);
        new LinearLayout(this);
        LinearLayout linearLayout2 = linearLayout;
        LinearLayout linearLayout3 = linearLayout2;
        linearLayout2.setOrientation(1);
        Intent intent = getIntent();
        Intent intent2 = intent;
        if (intent.hasExtra(ListPicker.O8YFlD3Safgd5vkxHRoLznZm2if21MG0IxIn5jepRi6FBTeulibRFlvEXsnDANgS)) {
            this.YY8QFJ7NsKl2krKlLP4gKRTKnpLlHQvVopkx7p60xy1hzICdxizXFIQJXbKtydSp = intent2.getStringExtra(ListPicker.O8YFlD3Safgd5vkxHRoLznZm2if21MG0IxIn5jepRi6FBTeulibRFlvEXsnDANgS);
        }
        if (intent2.hasExtra(ListPicker.JTEvmldvMjbbtPPlVS4hmZghOoRNnXC0kZOUUAZdwkVNl1VM5pL0vCTYv5HQZ7AX)) {
            titleBarColor = intent2.getIntExtra(ListPicker.JTEvmldvMjbbtPPlVS4hmZghOoRNnXC0kZOUUAZdwkVNl1VM5pL0vCTYv5HQZ7AX, -16537101);
            ActionBar supportActionBar = getSupportActionBar();
            ColorDrawable colorDrawable = r9;
            ColorDrawable colorDrawable2 = new ColorDrawable(titleBarColor != 0 ? titleBarColor : -1);
            supportActionBar.setBackgroundDrawable(colorDrawable);
        }
        if (intent2.hasExtra(ListPicker.pFeTJgO2w7vELkZyStZDj0uZpMYRqdjcmMjC2zcPDquoynj4tIsgJjD3RDJtFf88)) {
            Qws8UL0KACxj4AFwEq11K2awfkG72XuPUTZHhPLrlGlIXoxeK9stYQCrIWmabWcL = intent2.getIntExtra(ListPicker.pFeTJgO2w7vELkZyStZDj0uZpMYRqdjcmMjC2zcPDquoynj4tIsgJjD3RDJtFf88, -14575886);
            KodularHelper.setStatusBarColor(this, Qws8UL0KACxj4AFwEq11K2awfkG72XuPUTZHhPLrlGlIXoxeK9stYQCrIWmabWcL);
        }
        if (intent2.hasExtra(ListPicker.MYUGxENNZgpsWEBTVSKDauXfXur6zyPKrPdlATl7m89YCcguzmIKP8wXNDkxMYaw)) {
            String lowerCase = intent2.getStringExtra(ListPicker.MYUGxENNZgpsWEBTVSKDauXfXur6zyPKrPdlATl7m89YCcguzmIKP8wXNDkxMYaw).toLowerCase();
            String str = lowerCase;
            if (lowerCase.equals("portrait")) {
                setRequestedOrientation(1);
            } else if (str.equals("landscape")) {
                setRequestedOrientation(0);
            }
        }
        if (intent2.hasExtra(ListPicker.gKFqoeV0mIepwKqPzQqyF42NDV4lXNBYlbBqvrWypn3hvG8Ace2UniGxwzdDn1SZ)) {
            setTitle(intent2.getStringExtra(ListPicker.gKFqoeV0mIepwKqPzQqyF42NDV4lXNBYlbBqvrWypn3hvG8Ace2UniGxwzdDn1SZ));
        }
        if (intent2.hasExtra(ListPicker.jKPsNUTq382ltO4Ct4VOTi9lUb0GK32zS6afcWmZUk1wuONzG2KH4rBMniXwxrgH)) {
            if (intent2.getBooleanExtra(ListPicker.jKPsNUTq382ltO4Ct4VOTi9lUb0GK32zS6afcWmZUk1wuONzG2KH4rBMniXwxrgH, true)) {
                getSupportActionBar().show();
            } else {
                getSupportActionBar().hide();
            }
        }
        if (intent2.hasExtra(ListPicker.AjvYp2jprm0xITJdrrGGtoOyEc1YvelLDxRNqR8p3eG4UJR1UusSlSmznC0GO8Nd)) {
            if (intent2.getBooleanExtra(ListPicker.AjvYp2jprm0xITJdrrGGtoOyEc1YvelLDxRNqR8p3eG4UJR1UusSlSmznC0GO8Nd, true)) {
                getWindow().addFlags(2048);
                getWindow().clearFlags(1024);
            } else {
                getWindow().addFlags(1024);
                getWindow().clearFlags(2048);
            }
        }
        if (intent2.hasExtra(ListPicker.q2q4oDuUajVwr2T7b6DILrrBhrCqmElgSd3ODKsAFi8uEX2COWatdRT7gov0FlS5)) {
            String[] stringArrayExtra = getIntent().getStringArrayExtra(ListPicker.q2q4oDuUajVwr2T7b6DILrrBhrCqmElgSd3ODKsAFi8uEX2COWatdRT7gov0FlS5);
            new ListView(this);
            this.f177hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = listView;
            this.f177hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.setOnItemClickListener(this);
            this.f177hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.setScrollingCacheEnabled(false);
            TQYS6YBjqkoWFaGULpL2H003Eu6rkiOxhECYAYl6g8NMleEVKHe9nH3AkWIoC5xt = intent2.getIntExtra(ListPicker.z819s2db3SwWOaVhKbPTp947sGRXlCsEqH9IfB6VLe6W07abBod2oRho8IvcelHj, -1);
            backgroundColor = intent2.getIntExtra(ListPicker.RC7PBJGdnqEffr8752ypFkbK8qZYkmQ3ci6maWfntRZXmeHa8bLhdKUgkXcpRo6T, -16777216);
            linearLayout3.setBackgroundColor(backgroundColor);
            new a(this, stringArrayExtra);
            this.f178hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = aVar;
            this.f177hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.setAdapter(this.f178hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME);
            String stringExtra = intent2.getStringExtra(ListPicker.OFXnSk7pjyu5TDlQcCs0Ee2Ss8ceD26gQ4XJfzIMtdlcKhGXQ2j7Mh9NsuvjNyC);
            new EditText(this);
            this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = editText;
            this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.setSingleLine(true);
            this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.setWidth(-2);
            this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.setPadding(10, 10, 10, 10);
            this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.setHint("Search list...");
            if (stringExtra == null || !stringExtra.equalsIgnoreCase("true")) {
                this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.setVisibility(8);
            }
            new TextWatcher(this) {
                private /* synthetic */ ListPickerActivity hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;

                {
                    this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = r5;
                }

                public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    int i4 = i;
                    int i5 = i2;
                    int i6 = i3;
                    this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.f178hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.getFilter().filter(charSequence);
                }

                public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public final void afterTextChanged(Editable editable) {
                }
            };
            this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.addTextChangedListener(textWatcher);
        } else {
            setResult(0);
            finish();
            AnimationUtil.ApplyCloseScreenAnimation((Activity) this, this.YY8QFJ7NsKl2krKlLP4gKRTKnpLlHQvVopkx7p60xy1hzICdxizXFIQJXbKtydSp);
        }
        linearLayout3.addView(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME);
        linearLayout3.addView(this.f177hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME);
        setContentView((View) linearLayout3);
        linearLayout3.requestLayout();
        boolean hideSoftInputFromWindow = ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
        getWindow().setSoftInputMode(3);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: android.widget.AdapterView<?>} */
    /* JADX WARNING: type inference failed for: r6v1, types: [android.widget.Adapter] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onItemClick(android.widget.AdapterView<?> r13, android.view.View r14, int r15, long r16) {
        /*
            r12 = this;
            r0 = r12
            r1 = r13
            r2 = r14
            r3 = r15
            r4 = r16
            r6 = r1
            android.widget.Adapter r6 = r6.getAdapter()
            r7 = r3
            java.lang.Object r6 = r6.getItem(r7)
            java.lang.String r6 = (java.lang.String) r6
            r1 = r6
            android.content.Intent r6 = new android.content.Intent
            r10 = r6
            r6 = r10
            r7 = r10
            r7.<init>()
            r10 = r6
            r6 = r10
            r7 = r10
            r2 = r7
            java.lang.String r7 = com.google.appinventor.components.runtime.ListPicker.LVnP8NaPYXRgwZHgDK7PHMVEgcKwsNvZv2AHicCDg6yGIfguFikZkwwgr0dhWzJE
            r8 = r1
            android.content.Intent r6 = r6.putExtra(r7, r8)
            r6 = r2
            java.lang.String r7 = com.google.appinventor.components.runtime.ListPicker.cOmDbOC978RubVhXjun4VkHg9OxeO5ZzRCTQEv8rZa8E7YdcVv7aSE4TjAXwfuwN
            r8 = r3
            r9 = 1
            int r8 = r8 + 1
            android.content.Intent r6 = r6.putExtra(r7, r8)
            r6 = r0
            r7 = r1
            r6.YY8QFJ7NsKl2krKlLP4gKRTKnpLlHQvVopkx7p60xy1hzICdxizXFIQJXbKtydSp = r7
            r6 = r0
            r7 = -1
            r8 = r2
            r6.setResult(r7, r8)
            r6 = r0
            r6.finish()
            r6 = r0
            r10 = r6
            r6 = r10
            r7 = r10
            java.lang.String r7 = r7.YY8QFJ7NsKl2krKlLP4gKRTKnpLlHQvVopkx7p60xy1hzICdxizXFIQJXbKtydSp
            com.google.appinventor.components.runtime.util.AnimationUtil.ApplyCloseScreenAnimation((android.app.Activity) r6, (java.lang.String) r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.appinventor.components.runtime.ListPickerActivity.onItemClick(android.widget.AdapterView, android.view.View, int, long):void");
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        int i2 = i;
        KeyEvent keyEvent2 = keyEvent;
        if (i2 != 4) {
            return super.onKeyDown(i2, keyEvent2);
        }
        boolean onKeyDown = super.onKeyDown(i2, keyEvent2);
        AnimationUtil.ApplyCloseScreenAnimation((Activity) this, this.YY8QFJ7NsKl2krKlLP4gKRTKnpLlHQvVopkx7p60xy1hzICdxizXFIQJXbKtydSp);
        return onKeyDown;
    }

    static class a extends ArrayAdapter<String> {
        private final Context hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public a(android.content.Context r8, java.lang.String[] r9) {
            /*
                r7 = this;
                r0 = r7
                r1 = r8
                r2 = r9
                r3 = r0
                r4 = r1
                r5 = 17367040(0x1090000, float:2.5162926E-38)
                r6 = r2
                r3.<init>(r4, r5, r6)
                r3 = r0
                r4 = r1
                r3.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = r4
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.appinventor.components.runtime.ListPickerActivity.a.<init>(android.content.Context, java.lang.String[]):void");
        }

        public final long getItemId(int i) {
            return (long) ((String) getItem(i)).hashCode();
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            int i2 = i;
            ViewGroup viewGroup2 = viewGroup;
            TextView textView = (TextView) view;
            TextView textView2 = textView;
            if (textView == null) {
                textView2 = (TextView) LayoutInflater.from(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME).inflate(17367043, viewGroup2, false);
            }
            textView2.setText((CharSequence) getItem(i2));
            textView2.setTextColor(ListPickerActivity.TQYS6YBjqkoWFaGULpL2H003Eu6rkiOxhECYAYl6g8NMleEVKHe9nH3AkWIoC5xt);
            return textView2;
        }
    }
}
