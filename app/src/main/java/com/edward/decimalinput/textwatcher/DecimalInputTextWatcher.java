package com.edward.decimalinput.textwatcher;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.EditText;

import java.util.regex.Pattern;

/**
 * 功能描述：小数输入文本观察类
 *
 * @author (作者) edward（冯丰枫）
 * @link http://www.jianshu.com/u/f7176d6d53d2
 * 创建时间： 2018/3/12
 */

public class DecimalInputTextWatcher implements TextWatcher {
    private Pattern mPattern;

    /**
     * 不限制整数位数和小数位数
     */
    public DecimalInputTextWatcher() {
    }

    /**
     * 限制整数位数或着限制小数位数
     *
     * @param type   限制类型
     * @param number 限制位数
     */
    public DecimalInputTextWatcher(Type type, int number) {
        if (type == Type.decimal) {
            mPattern = Pattern.compile("^[0-9]+(\\.[0-9]{0," + number + "})?$");
        } else if (type == Type.integer) {
            mPattern = Pattern.compile("^[0-9]{0," + number + "}+(\\.[0-9]{0,})?$");
        }
    }

    /**
     * 既限制整数位数又限制小数位数
     *
     * @param integers 整数位数
     * @param decimals 小数位数
     */

    public DecimalInputTextWatcher(int integers, int decimals) {
        mPattern = Pattern.compile("^[0-9]{0," + integers + "}+(\\.[0-9]{0," + decimals + "})?$");
    }


    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable editable) {
        String text = editable.toString();
        if (TextUtils.isEmpty(text)) return;
        if ((editable.length() > 1) && (editable.charAt(0) == '0') && editable.charAt(1) != '.') {   //删除整数首位的“0”
            editable.delete(0, 1);
            return;
        }
        if (text.equals(".")) {                                    //首位是“.”自动补“0”
            editable.insert(0, "0");
            return;
        }
        if (mPattern != null && !mPattern.matcher(text).matches() && editable.length() > 0) {
            editable.delete(editable.length() - 1, editable.length());
            return;
        }
        //TODO：可在此处额外添加代码
    }

    public enum Type {
        integer, decimal
    }
}
