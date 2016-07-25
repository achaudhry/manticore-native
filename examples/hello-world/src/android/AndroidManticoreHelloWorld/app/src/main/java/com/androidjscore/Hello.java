package com.androidjscore;


import java.lang.reflect.Method;

import org.liquidplayer.webkit.javascriptcore.JSObject;
import org.liquidplayer.webkit.javascriptcore.JSValue;

public class Hello extends JSObj
{

  public Hello(final String stringProperty, final Integer intProperty) {
    this.instance = getEngine().property("construct").toObject()
        .callAsFunction(null, new JSValue[]{getJSClass("Hello")});
    this.instance.toObject().property("stringProperty", stringProperty);
    this.instance.toObject().property("intProperty", intProperty);
  }

  /**
   * A string
   */
  public String getStringProperty() {
    JSValue returnVal = this.instance.toObject().property("getStringProperty").toObject().callAsFunction(this.instance.toObject(), new JSValue[]{});
    return returnVal.toString();
  }

  /**
   * A string
   */
  public void setStringProperty(final String value) {
    this.instance.toObject().property("stringProperty", value);
  }

  /**
   * An int
   */
  public Integer getIntProperty() {
    JSValue val = instance.toObject().property("getIntProperty").toObject().callAsFunction(instance.toObject(), new JSValue[]{});
    return (int)Math.round(val.toNumber());
  }

  /**
   * An int
   */
  public void setIntProperty(final Integer value) {
    this.instance.toObject().property("intProperty", value);
  }

  public void testCallback(JSObject invoke, Method method)
  {
    JSObject obj = new JSObject(getEngine(), invoke, method);
    instance.toObject().property("testCallback").toObject().callAsFunction(this.instance.toObject(), new JSValue[]{obj});
  }


  public String toString() {
    return this.instance.toString();
  }

}
