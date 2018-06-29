package com.zhuye.machine.engineer.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

/**
 * SharedPreferences存储数据方式工具类
 */
public class SharedPreferencesUtil {

	private SharedPreferences sp;
	private Context context;

	public SharedPreferencesUtil(Context c, String name) {
		context = c;
		sp = context.getSharedPreferences(name, Context.MODE_PRIVATE);
	}

	/*** 存Int型数据 ***/
	public void putValue(String key, int value) {
		Editor editor = sp.edit();
		editor.putInt(key, value);
		editor.commit();
	}

	/*** 存Boolean型数据 ***/
	public void putValue(String key, boolean value) {
		Editor editor = sp.edit();
		editor.putBoolean(key, value);
		editor.commit();
	}

	/*** 存String型数据 ***/
	public void putValue(String key, String value) {
		Editor editor = sp.edit();
		editor.putString(key, value);
		editor.commit();
	}

	/*** 取Int型数据 ***/
	public int getValue(String key, int defValue) {

		return sp.getInt(key, defValue);
	}

	/*** 取Boolean型数据 ***/
	public boolean getValue(String key, boolean defValue) {

		return sp.getBoolean(key, defValue);
	}

	/*** 取String型数据 ***/
	public String getValue(String key, String defValue) {

		return sp.getString(key, defValue);
	}

	public void clear(){
		Editor editor = sp.edit();
		editor.clear();
		editor.commit();
	}
}